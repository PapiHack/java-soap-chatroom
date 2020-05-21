package sn.esp.bean;

import java.util.ArrayList;

public class User
{
	
	private String pseudo;
	private ArrayList<Message> listMsg;
	
	public User()
	{
		this.pseudo = "";
		this.listMsg = new ArrayList<Message>();
	}
	
	public User(String pseudo)
	{
		this.pseudo = pseudo;
		this.listMsg = new ArrayList<Message>();
	}
	
	public String getPseudo()
	{
		return pseudo;
	}
	
	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
	}
	
	public ArrayList<Message> getListMsg()
	{
		return listMsg;
	}
	
	public void setListMsg(ArrayList<Message> listMsg)
	{
		this.listMsg = listMsg;
	}
	
}
