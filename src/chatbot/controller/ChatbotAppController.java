package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	/**
	 * The instance of the Chatbot View, the View of the application.
	 */
	private ChatbotView applicationView;
	/**
	 * The instance of the Chatbot, the Model of this application.
	 */
	private Chatbot mySillyChatbot;
	/**
	 * The message used when starting the application.
	 */
	private String startMessage;
	/**
	 * The message provided when the user quits the application.
	 */
	private String quitMessage;
	/**
	 * Reference to the GUI JFrame object for the application.
	 */
	private ChatbotFrame appFrame;
	
	/**
	 * Constructor for the AppController. Initializes the Model and View components.
	 */
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		mySillyChatbot = new Chatbot("Derp");
		appFrame = new ChatbotFrame(this);
		startMessage = "Welcome to the " + mySillyChatbot.getName() + " chatbot. What is your name?";
		quitMessage = "Goodbye cruel user!";
	}
	
	/**
	 * Getter method for the applications Chatbot.
	 * @return The Chatbot.
	 */
	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}
	
	/**
	 * Starts the application.
	 */
	public void start()
	{
	
		((ChatbotPanel) appFrame.getContentPane()).showTextMessage(startMessage);
		
		//ChatbotPanel testPanel = (ChatbotPanel) appFrame.getContentPane();
		// testPanel.showTextMessage(startMessage);
	}
	
	/**
	 * Gets the dialog from the Chatbot.
	 * @param input Input from the user.
	 * @return Chatbot dialog.
	 */
	public String getChatbotDialog(String input)
	{
		String result = "";
		if(mySillyChatbot.quitChecker(input))
		{
			quit();
		}
		
		result = mySillyChatbot.processText(input);
		
		return result;
	}
	
	/**
	 * Stops the application.
	 */
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
		
	}
	
}
