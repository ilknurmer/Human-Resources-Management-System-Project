package com.intern.interface_operations;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.intern.database_operations.AllDatabaseOperations;

public class UpdatePageInterface {
	private MainDraft m;
	
	private JPanel allPanels;
	private JPanel tablePanel;
	private JPanel passwordPanel;
	private JPanel telNoPanel;
	private JPanel emailPanel;
	
	private JButton updatePasswordButton; // to update password
	private JButton updateTelNoButton; // to update tel no
	private JButton updateEmailButton; // to update e-mail

	private String newPasswordText;
	private String newTelNoText;
	private String newEmailText;
	
	public UpdatePageInterface(final int idNum){
		m = new MainDraft(idNum);
		
		allPanels = new JPanel();
		allPanels.setLayout(new BoxLayout(allPanels,BoxLayout.PAGE_AXIS));
		allPanels.setBounds(125, 125, 475, 160);
		allPanels.setBackground(new Color(255,255,255));
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel,BoxLayout.PAGE_AXIS));
		tablePanel.setBounds(125,125,475,45);
		tablePanel.setBackground(new Color(255,255,255));
		
		AllDatabaseOperations.getCurrentPersonalInfo(idNum);
		// This code piece displays personnal's current info on a table chart.
// ------------------------------------------------------------------------------------------------	
		TableModel tableModel = new DefaultTableModel(AllDatabaseOperations.getCellData(), AllDatabaseOperations.getcolumns());
        JTable currentInfotable = new JTable(tableModel){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row,int column)
        	{
				return false; 
        	};
        };    
        currentInfotable.setShowHorizontalLines(false);
        currentInfotable.setRowSelectionAllowed(true);
        currentInfotable.setColumnSelectionAllowed(true);
         
        JScrollPane tableScrollPane = new JScrollPane(currentInfotable);
        Rectangle tableLocation = new Rectangle(125,125,550,40);
        tableScrollPane.setBounds(tableLocation);
        tableScrollPane.setPreferredSize(new Dimension(550,40));
        
        currentInfotable.setSelectionForeground(Color.gray);
        currentInfotable.setSelectionBackground(Color.white);
        
        tablePanel.add(tableScrollPane);
        allPanels.add(tablePanel); 
// --------------------------------------------------------------------------------------------		
        passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.LINE_AXIS));
        passwordPanel.add(Box.createHorizontalGlue());
        passwordPanel.setBounds(125,165,475,25);
        passwordPanel.setBackground(new Color(255,255,255));
        
        JLabel passwordLabel = new JLabel("New Password: ");
		passwordLabel.setBounds(50,50,80,25);
		passwordPanel.add(passwordLabel);

		final JTextField newPassword = new JTextField(20);
		passwordLabel.setBounds(150,50,200,25);
		passwordPanel.add(newPassword);
		
		updatePasswordButton = new JButton("UPDATE");
		passwordPanel.add(updatePasswordButton);
		passwordPanel.setBorder(BorderFactory.createEmptyBorder(2, 10, 10, 10));
		allPanels.add(passwordPanel);	
		
		ActionListener updateListener = new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				newPasswordText = newPassword.getText();
				AllDatabaseOperations.updatePersonalInfo(1,idNum,newPasswordText);
				new UpdatePageInterface(idNum);
				m.outline.setVisible(false);
			}	
		};
		updatePasswordButton.addActionListener(updateListener);
		
// --------------------------------------------------------------------------------------	
		telNoPanel = new JPanel();
		telNoPanel.setLayout(new BoxLayout(telNoPanel, BoxLayout.LINE_AXIS));
		telNoPanel.add(Box.createHorizontalGlue());
		telNoPanel.setBounds(125,205,475,25);
		telNoPanel.setBackground(new Color(255,255,255)); 
	    
	    JLabel telNoLabel = new JLabel("New Tel No: ");
	    telNoLabel.setBounds(50,205,80,25);
	    telNoPanel.add(telNoLabel);

		final JTextField newTelNo = new JTextField(20);
		newTelNo.setBounds(150,205,100,25);
		telNoPanel.add(newTelNo);
			
		updateTelNoButton = new JButton("UPDATE");
		
		telNoPanel.add(updateTelNoButton);
		telNoPanel.setBorder(BorderFactory.createEmptyBorder(2, 10, 10, 10));
		allPanels.add(telNoPanel);
		
		ActionListener updateListener2 = new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				newTelNoText = newTelNo.getText();
				AllDatabaseOperations.updatePersonalInfo(2,idNum, newTelNoText);
				new UpdatePageInterface(idNum);
				m.outline.setVisible(false);
			}	
		};
		updateTelNoButton.addActionListener(updateListener2);
//----------------------------------------------------------------------------------	     
		emailPanel = new JPanel();
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.LINE_AXIS));
		emailPanel.add(Box.createHorizontalGlue());
		emailPanel.setBounds(125,245,475,25);
		emailPanel.setBackground(new Color(255,255,255)); 
	    
	    JLabel emailLabel = new JLabel("New E-mail: ");
	    emailLabel.setBounds(50,245,80,25);
	    emailPanel.add(emailLabel);

		final JTextField newEmail = new JTextField(20);
		newEmail.setBounds(150,245,100,25);
		emailPanel.add(newEmail);
			
		updateEmailButton = new JButton("UPDATE");
	
		emailPanel.add(updateEmailButton);
		emailPanel.setBorder(BorderFactory.createEmptyBorder(2, 10, 10, 10));
		allPanels.add(emailPanel);	
		
		ActionListener updateListener3 = new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				newEmailText = newEmail.getText();
				AllDatabaseOperations.updatePersonalInfo(3,idNum, newEmailText);
				new UpdatePageInterface(idNum);
				m.outline.setVisible(false);
			}	
		};
		updateEmailButton.addActionListener(updateListener3);

		m.dataPanel.add(allPanels);
		m.outline.add(m.dataPanel);
		m.outline.setVisible(true);
	}
	
}
