package com.intern.interface_operations;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.intern.database_operations.AllDatabaseOperations;

public class MainDraft extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JFrame outline;
	JPanel imagePanel;
	JPanel infoPanel;
	JPanel menuPanel;
	JPanel dataPanel;
	private JButton personalInfoButton;
	private JButton announcementButton;
	private JButton employeeInfoButton;
	private JButton updateInfoButton;
	private JButton addEmployeeButton;
	private JButton logoutButton;
	
	public MainDraft(final int idNum)
	{
		AllDatabaseOperations.displayPersonalInfo(idNum);
		
		// There must be a JFrame which includes all panels.
		outline = new JFrame();
		outline.setSize(700, 600);
		outline.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// imagePanel includes Human Resources logo. It lays out the upper left corner of the frame.
		imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 125, 125);
		imagePanel.setBackground(new Color(51,102,204));
		outline.add(imagePanel);

		JLabel photo = new JLabel(new ImageIcon("C:/Users/ACER/workspace/HumanResourcesManagementSystemProject/src/com/intern/humanResourcesImage.png"));
		photo.setLayout(null);
		photo.setBounds(0, 0, 125, 125);
		imagePanel.add(photo);
		
		// infoPanel contains personnel's name, surname, position and recruitment date. It lays out top of the frame.
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(125, 0, 575, 125);
		infoPanel.setBackground(new Color(204,204,255));
		JLabel infoText = new JLabel("<html>| Name Surname: " + AllDatabaseOperations.getEmployee().getName()+" "+AllDatabaseOperations.getEmployee().getSurname()+"<br>| Date of Recruitment: "+AllDatabaseOperations.getEmployee().getJobStart()+"<br>| Position: "+AllDatabaseOperations.getEmployee().getPositionName()+"</html>");
		infoText.setFont(new Font("DejaVuSans",Font.BOLD,13));
		infoText.setBounds(25, 13, 300, 100);
		infoPanel.add(infoText);
		outline.add(infoPanel);
		
		// menuPanel includes operation buttons. It lays out left side of the frame.
		menuPanel = new JPanel();
		menuPanel.setBounds(0, 125, 125, 475);
		menuPanel.setBackground(new Color(204,204,255));
		outline.add(menuPanel);
		
		// dataPanel includes consequences of buttons' actions.
		dataPanel = new JPanel();
		dataPanel.setLayout(null);
		dataPanel.setBounds(125, 125, 575, 475);
		dataPanel.setBackground(new Color(255,255,255));
		getContentPane().add(dataPanel,null);
		outline.add(dataPanel);
		
		// To list employee's personal info
		personalInfoButton = new JButton("Personal Information");
		personalInfoButton.setBounds(30,175,125,30);
		menuPanel.add(personalInfoButton);
		ActionListener personalInfoButtonListener = new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				new PersonalPageInterface(idNum);
				outline.setVisible(false);			
			}	
		};
		personalInfoButton.addActionListener(personalInfoButtonListener);
		
		// To list announcements.
		announcementButton = new JButton("Announcements");
		announcementButton.setBounds(30,215,125,30);
		menuPanel.add(announcementButton);
		ActionListener announcementButtonListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				new AnnouncementPageInterface(idNum);
				outline.setVisible(false);
			}	
		};
		announcementButton.addActionListener(announcementButtonListener);
		
		// To show employee's general info
		employeeInfoButton = new JButton("Employee Information");
		employeeInfoButton.setBounds(30,255,125,30);
		menuPanel.add(employeeInfoButton);
		ActionListener employeeInfoButtonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new EmployeePageInterface(idNum);
				outline.setVisible(false);
			}
		};
		employeeInfoButton.addActionListener(employeeInfoButtonListener);
		
		// To update employee's registered info 
		updateInfoButton = new JButton("Update Information");
		updateInfoButton.setBounds(30, 295, 125, 30);
		menuPanel.add(updateInfoButton);
		ActionListener updateInfoButtonListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new UpdatePageInterface(idNum);
				outline.setVisible(false);
			}
		};
		updateInfoButton.addActionListener(updateInfoButtonListener);
			
		if(AllDatabaseOperations.getIsManager())
		{
			// To add new employee to database
			addEmployeeButton = new JButton("Add Employee");
			addEmployeeButton.setBounds(30,335,125,30);
			menuPanel.add(addEmployeeButton);
			ActionListener addEmployeeButtonListener = new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					new AddEmployeePageInterface(idNum);
					outline.setVisible(false);
				}	
			};
			addEmployeeButton.addActionListener(addEmployeeButtonListener);
			
			logoutButton = new JButton("Logout");
			logoutButton.setBounds(30,375,125,30);
			menuPanel.add(logoutButton);
			ActionListener logoutButtonListener = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					new LogoutPageInterface(idNum);
					outline.setVisible(false);
				}
			};
			logoutButton.addActionListener(logoutButtonListener);
					
		}
		else
		{
			// To log out from system
			logoutButton = new JButton("Logout");
			logoutButton.setBounds(30,335,125,30);			
			menuPanel.add(logoutButton);
			ActionListener logoutButtonListener = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					new LogoutPageInterface(idNum);
					outline.setVisible(false);
				}
			};
			logoutButton.addActionListener(logoutButtonListener);
			
		}		
		outline.setVisible(true);
	}
}	
