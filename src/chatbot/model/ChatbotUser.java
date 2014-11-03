package chatbot.model;

public class ChatbotUser
{
// four data members
	//at least two different types (String, int, boolean, double....)
	
	private String userName;
	private int age;
	private boolean hasBrownHair;
	private boolean needsCorrectiveLenses;
	
	public ChatbotUser()
	{
		this.userName = "";
		this.age = -999;
		this.hasBrownHair = false;
		this.needsCorrectiveLenses = false;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isHasBrownHair()
	{
		return hasBrownHair;
	}

	public void setHasBrownHair(boolean hasBrownHair)
	{
		this.hasBrownHair = hasBrownHair;
	}

	public boolean isNeedsCorrectiveLenses()
	{
		return needsCorrectiveLenses;
	}

	public void setNeedsCorrectiveLenses(boolean needsCorrectiveLenses)
	{
		this.needsCorrectiveLenses = needsCorrectiveLenses;
	}
}
