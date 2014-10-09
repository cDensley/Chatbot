package chatbot.model;
/**
 * The Chatbot model class. Used for checking and manipulating strings.
 * @author Chandler Densley
 *@version 1.1 9/26/14
 */
public class Chatbot
{

	private String name;
	private int chatCount;
	
	
	/**
	 * Creates a Chatbot object with the supplied name and initializes the current number of chats to zero.
	 * @param name The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		this.name = name;
		chatCount = 0;
	}
	
	/**
	 * Returns the name of the Chatbot object.
	 * @return The current name of the Chatbot.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the number of times Chatbot has chatted.
	 * @return Number of times Chatbot has chatted.
	 */
	public int getChatCount()
	{
		return chatCount;
	}
	
	/**
	 * Sets the name.
	 * @param name Name of Chatbot.
	 */
	public void setName(String name)
	{
		this.name =name;
	}
	
	/**
	 * Updates the number of times Chatbot has chatted.
	 */
	private void updateChatCount()
	{
		chatCount++;
	}
	
	/**
	 * Decides if it's okay to quit based on the user input.
	 * @param input The input of the user.
	 * @return Quits.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input.equalsIgnoreCase("Goodbye"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
}
