package com.intern.interface_operations;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.intern.database_operations.AllDatabaseOperations;

public class LoginPageInterface {
	private JFrame frame;
	private JTextField userText;
	private JLabel passwordLabel;	
	private int user_id;
	private char[] password;
	private String pass;
	
	public LoginPageInterface(){
		// In this page, user enters user id and password. 
		// There must be a JFrame and JFrame includes JPanels. JLabels, JTextField, JPasswordField and JButton is placed into the panel.
		frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(700, 600);
    				
    	JPanel panel = new JPanel();
    	panel.setSize(600, 700);
    	panel.setBackground(new Color(204,204,255));
    	frame.add(panel);
    	
    	panel.setLayout(null);

    	JLabel userLabel = new JLabel("User ID");
    	userLabel.setBounds(50, 50, 80, 25);
    	panel.add(userLabel);

    	userText = new JTextField(20);
    	userText.setLayout(null);   				
    	userText.setBounds(180, 50, 160, 25);
    	panel.add(userText);
  
    	passwordLabel = new JLabel("Password");
    	passwordLabel.setBounds(50, 100, 80, 25);
    	panel.add(passwordLabel);
    				
    	final JPasswordField passwordText = new JPasswordField();
    	passwordText.setLayout(null);
    	passwordText.setBounds(180, 100, 160, 25);
    	panel.add(passwordText);
    				
    	JButton loginButton = new JButton("LOGIN");
    	loginButton.setBounds(260, 150, 80, 25);
    	panel.add(loginButton);

    	JLabel loginPhoto = new JLabel(new ImageIcon("C:/Users/ACER/workspace/HumanResourcesManagementSystemProject/src/com/peopleImage.png"));
    	loginPhoto.setLayout(null);
    	loginPhoto.setBounds(170, 270, 400, 240);
		panel.add(loginPhoto);
    	
    	frame.setVisible(true);	
    				
    	ActionListener loginButtonListener = new ActionListener(){ 
    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			user_id = Integer.parseInt(userText.getText());
    			password = passwordText.getPassword();
    	    	pass = new String(password);
    	    				
    	    	AllDatabaseOperations.isUserOrNot(user_id,pass);
    						
    	    	if(AllDatabaseOperations.getIsUser())
    			{
    	    		// gets current date information when login button is clicked 
    	    		Calendar today = Calendar.getInstance();
    	    		AllDatabaseOperations.setCurrentDate(today.getTime());
    	    		 	    		
    	    		new AnnouncementPageInterface(user_id);
    				frame.setVisible(false);	
    			}
    			else
    			{
    				new LoginPageInterface();
    			}	
    		}
    		};
    		loginButton.addActionListener(loginButtonListener);					
    		}		
	}
