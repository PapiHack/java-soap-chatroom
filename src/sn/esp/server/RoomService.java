package sn.esp.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * 
 * @author papihack
 * @since 21/05/2020
 * @version 0.1.0
 *
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RoomService
{
	
	@javax.jws.WebMethod
	public boolean subscribe(String pseudo);
	
	@WebMethod
	public boolean unsubscribe(String pseudo);
	
	@WebMethod
	public void postMsg(String pseudo, String message);
	
	@WebMethod
	public String getMessageUser(String pseudo);
}
