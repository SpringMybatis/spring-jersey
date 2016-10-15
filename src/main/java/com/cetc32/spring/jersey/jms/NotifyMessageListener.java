package com.cetc32.spring.jersey.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc32.spring.jersey.service.MessageService;

/**
 * 消息接收者
 * 
 * @author zhongjun
 */
public class NotifyMessageListener implements MessageListener {

	protected static Logger logger = LoggerFactory.getLogger(NotifyMessageListener.class);
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * MessageListener回调函数.
	 */
	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("---------onMessage----------");
			messageService.putMessage(message);
		} catch (Exception e) {
			logger.error("处理消息时发生异常.", e);
		}
	}
}
