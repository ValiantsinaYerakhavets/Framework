package framework.businessobjects;

public class User 
{
	private String email;
	private String name;
	private String password;
	
	public User(String email, String name, String password)
	{
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	public User(String email, String password)
	{
		this.email = email;
		this.password = password;
	}
	
	// getters
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	// setters
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}
