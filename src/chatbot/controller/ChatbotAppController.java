package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot mySillyChatbot;
	
	
	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		mySillyChatbot = new Chatbot("Cortana");
	}
	
	public void start()
	{
		String result = applicationView.showChatbotDialog(startMessage);
		
		while(!mySillyChatbot.quitChecker(result))
		{
			result = mySillyChatbot.processText(result);
			result = applicationView.showChatbotDialog(result);
		}
		quit();
	}
	
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
		
	}
	
}
