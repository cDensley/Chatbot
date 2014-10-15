package chatbot.model;

import java.util.ArrayList;

/**
 * The Chatbot model class. Used for checking and manipulating strings.
 * 
 * @author Chandler Densley
 * @version 1.1 9/26/14
 */
public class Chatbot
{

	/**
	 * Sets various things regarding the chatbot and user input.
	 */
	private ArrayList<String> memeList;
	private String name;
	private String contentArea;
	private int chatCount;
	public String currentInput;
	private String currentText;

	/**
	 * Creates a Chatbot object with the supplied name and initializes the
	 * current number of chats to zero.
	 * 
	 * @param name
	 *            The supplied name for the Chatbot.
	 */
	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		fillTheMemeList();
		contentArea = "music";
	}
	
	

	/**
	 * Sets the list of memes for the meme checker.
	 */
	private void fillTheMemeList()
	{
		memeList.add("kitties");
		memeList.add("one does not simply");
		memeList.add("doge");
		memeList.add("doh!");
		memeList.add("toddler fist");
		memeList.add("y u no");
	}

	/**
	 * Selects one of the three checkers randomly and runs it.
	 * @param currentInput Depending on what the user types.
	 * @return Based on user input.
	 */
	public String processText(String currentInput)
	{
		String result = "";

		int randomPosition = (int) (Math.random() * 3);
		if (currentInput != null)
		{
			if (randomPosition == 0)
			{
				if (stringLengthChecker(currentInput))
				{
					result = "too long";
				}
				else
				{
					result = "short words";
				}
			}
			else if (randomPosition == 1)
			{
				if (contentChecker(currentInput))
				{
					result = "yup you know the secret";
				}
				else
				{
					result = "try again another time";
				}
			}
			else
			{
				if (memeChecker(currentInput))
				{
					result = "Wow, " + currentInput + " is a meme. Wahoo!";
				}
				else
				{
					result = "Not a meme, try again!";
				}
			}
			
		}
		else
		{
			result = "Use words!!";
		}

		return result;
	}

	/**
	 * Checker for contentArea.
	 * @param currentInput User input.
	 * @return Based on whether or not the user input is the contentArea.
	 */
	private boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if (currentInput.contains(contentArea))
		{
			hasContent = true;
		}
		return hasContent;
	}

	/**
	 * Checks to see how long the users input is; measured in characters.
	 * @param input What the user inputs.
	 * @return Based on whether or not the user input is less than 20 characters.
	 */
	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;
		
		if (input.length() >= 20)
		{
			isTooLong = true;
		}
		
		return isTooLong;
	}

	/**
	 * Checks, using the fillTheMemeList, whether or not the user types in a meme.
	 * @param input What the user inputs.
	 * @return Based on whether or not the user types in a meme.
	 */
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		for (int loopCount = 0; loopCount < memeList.size(); loopCount++)
		{
			if (memeList.get(loopCount).equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		for (int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if (input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	/**
	 * Returns the name of the Chatbot object.
	 * 
	 * @return The current name of the Chatbot.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the number of times Chatbot has chatted.
	 * 
	 * @return Number of times Chatbot has chatted.
	 */
	public int getChatCount()
	{
		return chatCount;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            Name of Chatbot.
	 */
	public void setName(String name)
	{
		this.name = name;
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
	 * 
	 * @param input
	 *            The input of the user.
	 * @return Quits.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input !=null && input.equalsIgnoreCase("Goodbye"))
		{
			
			okToQuit = true;
		}

		return okToQuit;
	}
}
