package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chatbot.controller.ChatbotAppController;


import chatbot.controller.ChatbotAppController;

public class ChatbotPanel extends JPanel
{

	private ChatbotAppController baseController;
	
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		
		firstButton = new JButton("Click me!");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(5, 20);
		chatPane = new JScrollPane(chatArea);
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * Sets up what our panel will look like including background color, size, buttons/textfields, etc.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
	}
	
	/**
	 * The settings created automatically by the Window Builder for the placement of the items in the window.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 20, SpringLayout.WEST, this);
		
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
				String result = baseController.getChatbotDialog(currentInput);
				showTextMessage(currentInput);
				showTextMessage(result);
				firstTextField.setText("");
			}
		});
		
	}
	
	public void showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);
	}
}
