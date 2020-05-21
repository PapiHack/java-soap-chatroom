package sn.esp.server;

import java.util.ArrayList;

import javax.jws.WebService;

import sn.esp.bean.Message;
import sn.esp.bean.User;

/**
 * 
 * @author papihack
 * @since 21/05/2020
 * @version 0.1.0
 *
 */
@WebService(endpointInterface = "sn.esp.server.RoomService")
public class RoomServiceImpl implements RoomService
{
	
	private final ArrayList<User> userList;
	
	public RoomServiceImpl()
	{
		this.userList = new ArrayList<User>();
	}
	
	@Override
	public boolean subscribe(String pseudo)
	{
		User user = this.getUser(pseudo);
		synchronized (userList)
		{
			if (user != null)
			{
				return false;
			}
			userList.add(new User(pseudo));
			System.out.println(pseudo);
			return true;
		}
	}
	
	@Override
	public boolean unsubscribe(String pseudo)
	{
		User user = this.getUser(pseudo);
		synchronized (userList)
		{
			if (user == null)
			{
				return false;
			}
			userList.remove(user);
			return true;
		}
	}
	
	@Override
	public String getMessageUser(String pseudo)
	{
		User user = this.getUser(pseudo);
		synchronized (userList)
		{
			if (user == null)
			{
				return "Pas de message";
			}
			String message = user.getListMsg().toString();
			user.getListMsg().clear();
			return message;
		}
	}
	
	@Override
	public void postMsg(String pseudo, String Message)
	{
		Message message = new Message(pseudo, Message);
		synchronized (userList)
		{
			for (User user : userList)
			{
				if (!user.getPseudo().equals(pseudo))
				{
					user.getListMsg().add(message);
				}
			}
		}
		
	}
	
	private User getUser(String pseudo)
	{
		for (User user : userList)
		{
			if (user.getPseudo().equals(pseudo))
			{
				return user;
			}
		}
		return null;
	}
	
}
