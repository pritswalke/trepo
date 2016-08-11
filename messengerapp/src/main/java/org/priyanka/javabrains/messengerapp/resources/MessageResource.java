package org.priyanka.javabrains.messengerapp.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.priyanka.javabrains.messengerapp.model.Message;
import org.priyanka.javabrains.messengerapp.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String Test(){
		return "Test";
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Long id){
		return messageService.getMessage(id);
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageService.addMessage(message);
		
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") Long id, Message message  ){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	
}
