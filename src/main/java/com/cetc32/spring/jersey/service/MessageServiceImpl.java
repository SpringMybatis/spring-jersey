package com.cetc32.spring.jersey.service;

import java.util.Map;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc32.spring.jersey.jms.NotifyMessageProducer;
import com.cetc32.spring.jersey.message.MessagePool;

/**
 * 消息服务类
 * 
 * @author zhongjun
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	MessagePool<Message> pool = new MessagePool<Message>();
	
	@Autowired
	private NotifyMessageProducer notifyMessageProducer;
	
	@Override
	public void putMessage(Message message) {
		try {
			pool.put(message);
		} catch (Exception e) {
			// do nothing
		}
	}

	@Override
	public Message getMessage() {
		Message message = null;
		try {
			message = pool.takeLast();
		} catch (Exception e) {
			// do nothing
		}
		return message;
	}

	@Override
	public void send(Map<String, Object> mapMessage) {
		notifyMessageProducer.sendTopic(mapMessage);
	}

}
