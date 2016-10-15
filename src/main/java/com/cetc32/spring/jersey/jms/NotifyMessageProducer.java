package com.cetc32.spring.jersey.jms;

import java.util.Map;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

/**
 * 消息发送者
 * 
 * @author zhongjun
 *
 */
public class NotifyMessageProducer {
	
	/**
	 * jms模板
	 */
	private JmsTemplate jmsTemplate;
	
	/**
	 * 目的地
	 */
	private Destination notifyTopic;
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Destination getNotifyTopic() {
		return notifyTopic;
	}

	public void setNotifyTopic(Destination notifyTopic) {
		this.notifyTopic = notifyTopic;
	}

	/**
	 * 发送Map类型的消息
	 * 
	 * @param map
	 */
	public void sendTopic(Map map) {
		sendMessage(map, this.notifyTopic);
	}

	/**
	 * jmsTemplate.convertAndSend()发送Map类型的消息
	 * 
	 * @param map
	 * @param destination
	 */
	private void sendMessage(Map map, Destination destination) {
		jmsTemplate.convertAndSend(destination, map);
	}
	
}
