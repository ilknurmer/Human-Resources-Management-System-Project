package com.intern.interface_operations;

import java.awt.Font;

import javax.swing.JLabel;

import com.intern.database_operations.AllDatabaseOperations;


public class PersonalPageInterface {
	private MainDraft m;
	private JLabel name;
	private JLabel surname;
	private JLabel birthDate;
	private JLabel position;
	private JLabel telNo;
	private JLabel email;
	private JLabel leave;
	private JLabel salary;
	
	public PersonalPageInterface(int idNum)
	{
		m = new MainDraft(idNum); // forms main page structure
		AllDatabaseOperations.displayPersonalInfo(idNum);
		
		// This page shows employee's personal information
		
		JLabel personalInfoText = new JLabel("Personal Information");
		personalInfoText.setFont(new Font("DejaVuSans",Font.BOLD,16));
		personalInfoText.setBounds(300, 100, 300, 100);
		m.dataPanel.add(personalInfoText);
// ---------------------------------------------------------------------------		
		name = new JLabel("First Name: ");
		name.setBounds(150, 170, 100, 40);
		m.dataPanel.add(name);
		
		JLabel nameText = new JLabel(AllDatabaseOperations.getEmployee().getName());
		nameText.setBounds(250, 170, 200, 40);
		m.dataPanel.add(nameText);
// ----------------------------------------------------------------------------		
		surname = new JLabel("Last Name: ");
		surname.setBounds(150, 200, 100, 40);
		m.dataPanel.add(surname);
		
		JLabel surnameText = new JLabel(AllDatabaseOperations.getEmployee().getSurname());
		surnameText.setBounds(250, 200, 200, 40);
		m.dataPanel.add(surnameText);
// ----------------------------------------------------------------------------		
		birthDate = new JLabel("Date of Birth: ");
		birthDate.setBounds(150, 230, 100, 40);
		m.dataPanel.add(birthDate);
		
		JLabel birthDateText = new JLabel(AllDatabaseOperations.getEmployee().getBirth());
		birthDateText.setBounds(250, 230, 200, 40);
		m.dataPanel.add(birthDateText);
// ----------------------------------------------------------------------------		
		position = new JLabel("Position: ");
		position.setBounds(150, 260, 100, 40);
		m.dataPanel.add(position);
		
		JLabel positionText = new JLabel(AllDatabaseOperations.getEmployee().getPositionName());
		positionText.setBounds(250, 260, 200, 40);
		m.dataPanel.add(positionText);
// ----------------------------------------------------------------------------
		telNo = new JLabel("Tel No: ");
		telNo.setBounds(150, 290, 100, 40);
		m.dataPanel.add(telNo);
		
		JLabel telNoText = new JLabel(String.valueOf(AllDatabaseOperations.getEmployee().getTelNo()));
		telNoText.setBounds(250, 290, 200, 40);
		m.dataPanel.add(telNoText);
// ----------------------------------------------------------------------------
		email = new JLabel("E-mail: ");
		email.setBounds(150, 320, 100, 40);
		m.dataPanel.add(email);
		
		JLabel emailText = new JLabel(AllDatabaseOperations.getEmployee().getEmail());
		emailText.setBounds(250, 320, 200, 40);
		m.dataPanel.add(emailText);
// ----------------------------------------------------------------------------
		leave = new JLabel("Annual Leave: ");
		leave.setBounds(150, 350, 100, 40);
		m.dataPanel.add(leave);
		
		JLabel leaveText = new JLabel(String.valueOf(AllDatabaseOperations.getEmployee().getAnnualLeave()));
		leaveText.setBounds(250, 350, 200, 40);
		m.dataPanel.add(leaveText);
// ----------------------------------------------------------------------------
		salary = new JLabel("Salary: ");
		salary.setBounds(150, 380, 100, 40);
		m.dataPanel.add(salary);
		
		JLabel salaryText = new JLabel(String.valueOf(AllDatabaseOperations.getEmployee().getSalary()));
		salaryText.setBounds(250, 380, 200, 40);
		m.dataPanel.add(salaryText);
// ---------------------------------------------------------------------------	
	}
}

