package framework.businessobjects;

public class Message
{
	private String fromWhom;
	private String toWhom;
	private String subject;
	private String text;
	private String path; // path to the attachement
	
	public Message(String sender)
	{
		this.fromWhom = sender;
	}
	
	public Message(String sender, String recipient)
	{
		this.fromWhom = sender;
		this.toWhom = recipient;
	}
	
	public Message(String recipient, String subject, String text)
	{
		this.toWhom = recipient;
		this.subject = subject;
		this.text = text;
	}
	
	// getters
	
	public String getSender()
	{
		return this.fromWhom;
	}
	
	public String getRecipient()
	{
		return this.toWhom;
	}
	
	public String getSubject()
	{
		return this.subject;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	// setters
	
	public void setSender(String sender)
	{
		this.fromWhom = sender;
	}
	
	public void setRecipient(String recipient)
	{
		this.toWhom = recipient;
	}
	
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
}
