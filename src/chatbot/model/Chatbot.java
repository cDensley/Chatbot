package chatbot.model;

import java.util.ArrayList;

/**
 * The Chatbot model class. Used for checking and manipulating strings.
 * 
 * @author Chandler Densley
 * @version 1.4 11/11/14
 */
public class Chatbot
{

	/**
	 * The list for the meme checker.
	 */
	private ArrayList<String> memeList;
	/**
	 * The name of the Chatbot.
	 */
	private String name;
	/**
	 * The checker for the content area.
	 */
	private String contentArea;
	/**
	 * Counts the number of times that the Chatbot has chatted with the user.
	 */
	private int chatCount;
	public String currentInput;
	private String currentText;
	private ArrayList<String> userInputList;
	
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
		userInputList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		myUser = new ChatbotUser();
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
		
		if(getChatCount() < 5)
		{
			//Ask questions about all data members here
			//you will need ifs or a switch
			//assign via myUser.set...
			if(getChatCount() == 0)
			{
				myUser.setUserName(currentInput);
				result = "Good name " + myUser.getUserName() + " how old are you?";
			}
			else if(getChatCount() == 1)
			{
				int userAge = Integer.parseInt(currentInput);
				myUser.setAge(userAge);
			}
			//continue for other user info fields
		}

		int randomPosition = (int) (Math.random() * 6);
		
		if (currentInput != null && currentInput.length() > 0)
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
			else if( randomPosition == 2)
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
			else if(randomPosition == 3)
			{
				//Talk about the user here :D
			}
			else if(randomPosition == 4)
			{
				//add to our list
				userInputList.add(currentInput);
				result = "Thank you for the comment";
			}
			else
			{
				if(userInputChecker(currentInput))
				{
					
				}
				else
				{
					
				}
			}
			
		}
		else
		{
			result = "Use words!!";
		}
		updateChatCount();
		return result;
	}
	
	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;
		
		for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if(userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}
		}
		return matchesInput;
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
	 * @return The current name of the Chatbot.
	 */
	public String getName()
	{
		return name;
	}

	public ArrayList<String> getMemeList()
	{
		return memeList;
	}



	public void setMemeList(ArrayList<String> memeList)
	{
		this.memeList = memeList;
	}



	public String getContentArea()
	{
		return contentArea;
	}



	public void setContentArea(String contentArea)
	{
		this.contentArea = contentArea;
	}



	public String getCurrentInput()
	{
		return currentInput;
	}



	public void setCurrentInput(String currentInput)
	{
		this.currentInput = currentInput;
	}



	public String getCurrentText()
	{
		return currentText;
	}



	public void setCurrentText(String currentText)
	{
		this.currentText = currentText;
	}



	public ChatbotUser getMyUser()
	{
		return myUser;
	}



	public void setMyUser(ChatbotUser myUser)
	{
		this.myUser = myUser;
	}



	public void setChatCount(int chatCount)
	{
		this.chatCount = chatCount;
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
	
	private ChatbotUser myUser;

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
