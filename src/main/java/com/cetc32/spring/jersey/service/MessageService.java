package com.cetc32.spring.jersey.service;

import java.util.Map;

import javax.jms.Message;

/**
 * 消息服务接口
 * 
 * @author zhongjun
 *
 */
public interface MessageService {

	/**
	 * 存入消息
	 * 
	 * @param message
	 */
	public void putMessage(Message message);
	
	/**
	 * 获取消息
	 * 
	 * @return
	 */
	public Message getMessage();
	
	/**
	 * 
	 * 
	 * @param mapMessage
	 */
	public void send(Map<String,Object> mapMessage);
	
}
