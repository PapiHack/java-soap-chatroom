package sn.esp.server;

import javax.xml.ws.Endpoint;

/**
 * 
 * @author papihack
 * @since 21/05/2020
 * @version 0.1.0
 *
 */
public class Server
{
	public static void main(String[] args)
	{
		Endpoint.publish("http://localhost:8090/ws/roomService", new RoomServiceImpl());
		System.out.println("Service SOAP déployé...");
	}
}
