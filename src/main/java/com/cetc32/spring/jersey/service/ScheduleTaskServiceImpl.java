package com.cetc32.spring.jersey.service;

import javax.jms.MapMessage;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTaskServiceImpl implements ScheduleTaskService {

	@Autowired
	private MessageService messageService;
	
	@Override
	public void processMessage(){
		try {
			Message message = messageService.getMessage();
			if(message!=null){
				System.out.println("---------processMessage----------");
				MapMessage mapMessage = (MapMessage) message;
				System.out.println(mapMessage.getString("username")+" : "+mapMessage.getString("password"));
			}
		} catch (Exception e) {
			// do nothing
		}
	}

}
