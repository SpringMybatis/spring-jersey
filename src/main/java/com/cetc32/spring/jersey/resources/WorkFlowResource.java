package com.cetc32.spring.jersey.resources;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc32.spring.jersey.service.MessageService;

@Path("/workflow")
public class WorkFlowResource {
	
	@Autowired
	private MessageService messageService;
	
	@GET
	@Consumes({ MediaType.TEXT_PLAIN })
	@Produces({ MediaType.APPLICATION_JSON })
	public String sayOk(@QueryParam("username") String username, @QueryParam("password") String password) {
		System.out.println(username + ":" + password);
		Map<String,Object> messgage = new HashMap<String,Object>();
		messgage.put("username", username);
		messgage.put("password", password);
		
		messageService.send(messgage);
		
		return username + ":" + password;
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Map<String,Object> processTaskMessage(Map<String,Object> map){
		MapMessage mapMessage = new ActiveMQMapMessage();
		try {
			mapMessage.setObject("username", map.get("username"));
			mapMessage.setObject("password", map.get("password"));
			messageService.putMessage(mapMessage);
		} catch (JMSException e) {
			// do nothing
		}
		return new HashMap<String, Object>();
	}
	
	
}
