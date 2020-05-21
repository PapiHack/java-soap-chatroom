package sn.esp.bean;

public class Message
{
	
	private final static String BROADCAST = "BROADCAST";
	private String sender;
	private String receiver;
	private String message;
	
	public Message()
	{
		this.sender = "";
		this.receiver = BROADCAST;
		this.message = "";
	}
	
	public Message(String sender, String message)
	{
		super();
		this.sender = sender;
		this.receiver = BROADCAST;
		this.message = message;
	}
	
	public Message(String sender, String receiver, String message)
	{
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}
	
	public String getSender()
	{
		return sender;
	}
	
	public void setSender(String sender)
	{
		this.sender = sender;
	}
	
	public String getReceiver()
	{
		return receiver;
	}
	
	public void setReceiver(String receiver)
	{
		this.receiver = receiver;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	@Override
	public String toString()
	{
		return getMessage() + "\n";
	}
	
}
