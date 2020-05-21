package sn.esp.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import sn.esp.server.RoomService;

/**
 * 
 * @author papihack
 * @since 21/05/2020
 * @version 0.1.0
 *
 */
public class Client
{
	
	private RoomService room;
	private Service roomService;
	
	public Client() throws MalformedURLException
	{
		URL wsdlURL = new URL("http://localhost:8080/ChatRoom-Soap/RoomServiceImplService?wsdl");
		QName qname = new QName("http://server.esp.sn/", "RoomServiceImplService");
		roomService = Service.create(wsdlURL, qname);
		this.room = roomService.getPort(RoomService.class);
	}
	
	public boolean inscription(String pseudo)
	{
		return this.room.subscribe(pseudo);
	}
	
	public boolean desinscription(String pseudo)
	{
		return this.room.unsubscribe(pseudo);
	}
	
	public String getMessage(String pseudo)
	{
		return this.room.getMessageUser(pseudo);
	}
	
	public void postMsg(String pseudo, String msg)
	{
		this.room.postMsg(pseudo, msg);
	}
	
	public RoomService getRoom()
	{
		return room;
	}
	
	public void setRoom(RoomService room)
	{
		this.room = room;
	}
	
}
