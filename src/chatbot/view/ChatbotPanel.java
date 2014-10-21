package chatbot.view;

import java.awt.Color;

import javax.swing.JPanel;

import chatbot.controller.ChatbotAppController;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;

public class ChatbotPanel extends JPanel
{

	private ChatbotAppController baseController;
	
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	
	
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		
		firstButton = new JButton("Click me!");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		
	}
	
}
