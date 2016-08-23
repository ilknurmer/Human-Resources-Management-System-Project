package com.intern.interface_operations;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.intern.database_operations.AllDatabaseOperations;

public class AddEmployeePageInterface {

	private MainDraft m;
	private String name;
	private String surname;
	private String gender;
	private String birthDate;
	private String jobStart;
	private String position;
	private String password;
	private String telNo;
	private String email;
	private int salary;
	private int defaultHoliday;
	private int remainingHoliday;
	private String holidayStart;
	private String holidayFinish;
	
	public AddEmployeePageInterface(final int idNum)
	{
		m = new MainDraft(idNum); // forms main page structure
		// In this part of the program, there are different panels for every information piece of new employee and every panel will be add to one unique general panel. 
		// Then this general panel will be add to main page structure. Different panels is placed along page axis onto general panel. 
		// Additionally, different panels are placed in themselves according to line axis.
// ------------------------------------------------------------------------------------------
		JPanel allPanels = new JPanel();
		allPanels.setLayout(new BoxLayout(allPanels,BoxLayout.PAGE_AXIS));
		allPanels.setBounds(125, 125, 475, 340);
        allPanels.setBackground(new Color(255,255,255));
// ------------------------------------------------------------------------------------------		
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        namePanel.add(Box.createHorizontalGlue());
        namePanel.setBounds(125,165,475,25);
        namePanel.setBackground(new Color(255,255,255));
        
        JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(50, 50, 80, 25);
		namePanel.add(nameLabel);
		
		final JTextField nameText = new JTextField(20); 				
		nameText.setBounds(140, 50, 160, 25);
		namePanel.add(nameText);

		namePanel.setBorder(BorderFactory.createEmptyBorder(3, 10, 10, 10));
		allPanels.add(namePanel);		
// -----------------------------------------------------------------	
		JPanel surnamePanel = new JPanel();
		surnamePanel.setLayout(new BoxLayout(surnamePanel, BoxLayout.LINE_AXIS));
		surnamePanel.add(Box.createHorizontalGlue());
		surnamePanel.setBounds(125,205,475,25);
		surnamePanel.setBackground(new Color(255,255,255));
	    
	    JLabel surnameLabel = new JLabel("Surname");
		surnameLabel.setBounds(50, 100, 80, 25);
		surnamePanel.add(surnameLabel);
	     
		final JTextField surnameText = new JTextField(20); 				
		surnameText.setBounds(140, 100, 160, 25);
		surnamePanel.add(surnameText);
	    
		surnamePanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(surnamePanel);
// --------------------------------------------------------------------------------------   
		JPanel genderPanel = new JPanel();
		genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.LINE_AXIS));
		genderPanel.add(Box.createHorizontalGlue());
		genderPanel.setBounds(125,245,475,25);
		genderPanel.setBackground(new Color(255,255,255));
	     
	    JLabel genderLabel = new JLabel("Gender: ");
	    genderLabel.setBounds(50,245,80,25);
	    genderPanel.add(genderLabel);

		final JTextField genderText = new JTextField(20); 				
		genderText.setBounds(140, 245, 160, 25);
		genderPanel.add(genderText);
		
		genderPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(genderPanel);
// ---------------------------------------------------------------------------------------	     
		JPanel birthDatePanel = new JPanel();
		birthDatePanel.setLayout(new BoxLayout(birthDatePanel, BoxLayout.LINE_AXIS));
		birthDatePanel.add(Box.createHorizontalGlue());
	    birthDatePanel.setBounds(125,285,475,25);
	    birthDatePanel.setBackground(new Color(255,255,255));
	     
	    JLabel birthDateLabel = new JLabel("Date of Birth: ");
	    birthDateLabel.setBounds(50,285,80,25);
	    birthDatePanel.add(birthDateLabel);
        final JTextField birthDateText = new JTextField(20); 				
		birthDateText.setBounds(140, 285, 160, 25);
		birthDatePanel.add(birthDateText);
		 
		birthDatePanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(birthDatePanel);
// --------------------------------------------------------------------------------------
		JPanel jobStartPanel = new JPanel();
		jobStartPanel.setLayout(new BoxLayout(jobStartPanel, BoxLayout.LINE_AXIS));
		jobStartPanel.add(Box.createHorizontalGlue());
		jobStartPanel.setBounds(125,325,475,25);
		jobStartPanel.setBackground(new Color(255,255,255));
	     
	    JLabel jobStartLabel = new JLabel("Job Start Date: ");
	    birthDateLabel.setBounds(50,325,80,25);
	    jobStartPanel.add(jobStartLabel);

		final JTextField jobStartText = new JTextField(20); 				
		jobStartText.setBounds(140, 325, 160, 25);
		jobStartPanel.add(jobStartText);
		 
		jobStartPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(jobStartPanel);
// -------------------------------------------------------------------------------------
		JPanel positionPanel = new JPanel();
		positionPanel.setLayout(new BoxLayout(positionPanel, BoxLayout.LINE_AXIS));
		positionPanel.add(Box.createHorizontalGlue());
	    positionPanel.setBounds(125,365,475,25);
	    positionPanel.setBackground(new Color(255,255,255));
	     
	    JLabel positionLabel = new JLabel("Position: ");
	    positionLabel.setBounds(50,365,80,25);
	    positionPanel.add(positionLabel);

		final JTextField positionText = new JTextField(20); 				
		positionText.setBounds(140, 365, 160, 25);
		positionPanel.add(positionText);
		
		positionPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(positionPanel);
// -------------------------------------------------------------------------------------
		JPanel telNoPanel = new JPanel();
		telNoPanel.setLayout(new BoxLayout(telNoPanel, BoxLayout.LINE_AXIS));
		telNoPanel.add(Box.createHorizontalGlue());
		telNoPanel.setBounds(125,405,475,25);
		telNoPanel.setBackground(new Color(255,255,255));
	     
	    JLabel telNoLabel = new JLabel("Tel No: ");
	    telNoLabel.setBounds(50,405,80,25);
	    telNoPanel.add(telNoLabel);

		final JTextField telNoText = new JTextField(20); 				
		telNoText.setBounds(140, 405, 160, 25);
		telNoPanel.add(telNoText);
		 
		telNoPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(telNoPanel);
// -------------------------------------------------------------------------------------
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.LINE_AXIS));
		emailPanel.add(Box.createHorizontalGlue());
		emailPanel.setBounds(125,405,475,25);
		emailPanel.setBackground(new Color(255,255,255));
	     
	    JLabel emailLabel = new JLabel("E-mail: ");
	    emailLabel.setBounds(50,405,80,25);
	    emailPanel.add(emailLabel);

		final JTextField emailText = new JTextField(20); 				
		emailText.setBounds(140, 405, 160, 25);
		emailPanel.add(emailText);
		 
		emailPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(emailPanel);
// -------------------------------------------------------------------------------------
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.LINE_AXIS));
		passwordPanel.add(Box.createHorizontalGlue());
	    passwordPanel.setBounds(125,445,475,25);
	    passwordPanel.setBackground(new Color(255,255,255));
	     
	    JLabel passwordLabel = new JLabel("Password: ");
	    passwordLabel.setBounds(50,445,80,25);
	    passwordPanel.add(passwordLabel);

		final JTextField passwordText = new JTextField(20); 				
		passwordText.setBounds(140, 445, 160, 25);
		passwordPanel.add(passwordText);
		 
		passwordPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(passwordPanel);
// -------------------------------------------------------------------------------------
		JPanel salaryPanel = new JPanel();
		salaryPanel.setLayout(new BoxLayout(salaryPanel, BoxLayout.LINE_AXIS));
		salaryPanel.add(Box.createHorizontalGlue());
		salaryPanel.setBounds(125,485,475,25);
		salaryPanel.setBackground(new Color(255,255,255));
	     
	    JLabel salaryLabel = new JLabel("Salary Amount: ");
	    salaryLabel.setBounds(50,485,80,25);
	    salaryPanel.add(salaryLabel);

		final JTextField salaryText = new JTextField(20); 				
		salaryText.setBounds(140, 485, 160, 25);
		salaryPanel.add(salaryText);
		 
		salaryPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		allPanels.add(salaryPanel);
// -------------------------------------------------------------------------------------
		JButton addEmployeeButton = new JButton(" ADD EMPLOYEE ");
		addEmployeeButton.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		allPanels.add(addEmployeeButton);
		 
		ActionListener addListener = new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				name = nameText.getText();
				surname = surnameText.getText();
				gender = genderText.getText();
				birthDate = birthDateText.getText();
				jobStart = jobStartText.getText();
				position = positionText.getText();
				password = passwordText.getText();
				int findPosition = 0;
				if(position.equals("program")) findPosition = 1;
				else if(position.equals("test")) findPosition = 2;
				else if(position.equals("ik")) findPosition = 3;
				else if(position.equals("stajyer")) findPosition = 4;
/*				else
				{
					JOptionPane.showMessageDialog(null, "Warning! Please enter an existing position(program,test,ik,stajyer)");
				}
*/
				telNo = telNoText.getText();
				email = emailText.getText();
				salary = Integer.valueOf(salaryText.getText());
				remainingHoliday = 20;
				defaultHoliday = 20;
				holidayStart = "1970-01-01";
				holidayFinish = "1970-01-02";
								
				AllDatabaseOperations.findEmployeeNumber();
				AllDatabaseOperations.addNewEmployeeInfo(AllDatabaseOperations.getTotalEmployeeNumber(), name, surname, gender, birthDate, jobStart, findPosition, password, salary, telNo, email, position, defaultHoliday, remainingHoliday, holidayStart, holidayFinish);
				new AddEmployeePageInterface(idNum);
				m.outline.setVisible(false);
			}	
		};
		addEmployeeButton.addActionListener(addListener);
		
		m.dataPanel.add(allPanels);
		m.outline.add(m.dataPanel);
		m.outline.setVisible(true);
	}
}

