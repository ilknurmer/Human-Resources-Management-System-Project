package com.intern.interface_operations;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.intern.database_operations.AllDatabaseOperations;

public class EmployeePageInterface {
	private MainDraft m;
	
	public EmployeePageInterface(final int idNum)
	{
		m = new MainDraft(idNum); // forms main page structure
		AllDatabaseOperations.displayEmployeesInfo(); // gets all employees' general info 

		// In this part, there are a table chart which shows employees' general information and this table chart is placed into a little panel then this panel is places into an enormous panel.
		// Furthermore, when user's position is human resources, another little panel is formed for deletion operation and is placed into enormous panel.
		
		JPanel allPanels = new JPanel();
		allPanels.setLayout(new BoxLayout(allPanels,BoxLayout.PAGE_AXIS));
		allPanels.setBounds(125, 125, 550, 150);
		
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new BoxLayout(tempPanel,BoxLayout.PAGE_AXIS));
		tempPanel.setBounds(125, 125, 550, 130);
		
		TableModel tableModel = new DefaultTableModel(AllDatabaseOperations.getCellData(), AllDatabaseOperations.getcolumns());
        JTable table = new JTable(tableModel){
			private static final long serialVersionUID = 1L;
			  
        	   public boolean isCellEditable(int row,int column)
        	   {
        		   return false; 
        	   };
        };
   
        table.setShowHorizontalLines(false);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
         
        JScrollPane tableScrollPane = new JScrollPane(table);
        Rectangle tableLocation = new Rectangle(125,125,550,475);
        tableScrollPane.setBounds(tableLocation);
        tableScrollPane.setPreferredSize(new Dimension(550,150));
                
        // This part provides us to see which employee is on leave with a red line.
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
			private static final long serialVersionUID = 1L;

			@Override
        	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row,int col){
        		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,  row, col);
        		String status = (String)table.getModel().getValueAt(row, 6);
        		if("On Vacation".equals(status)){
        			setBackground(Color.RED);
        			setForeground(Color.WHITE);
        		}
        		else
        		{
        			setBackground(table.getBackground());
        			setForeground(table.getForeground());
        		}
        		return this;
        	}
        });
         
        tempPanel.add(tableScrollPane);
        allPanels.add(tempPanel); 
// -----------------------------------------------------------------------------------------------
		if(AllDatabaseOperations.getIsManager()) // If user is one of a human resources personnel, needs for deletion operation will be added.
		{			
			JPanel tempPanel2 = new JPanel();
			tempPanel2.setLayout(new BoxLayout(tempPanel2, BoxLayout.LINE_AXIS));
			tempPanel2.add(Box.createHorizontalGlue());
			tempPanel2.setBounds(125,165,550,25);
			tempPanel2.setBackground(new Color(255,255,255));
		
        
			JLabel deleteLabel = new JLabel("Enter employee ID to remove employee from list: ");
			deleteLabel.setBounds(50,50,80,25);
			tempPanel2.add(deleteLabel);

			final JTextField deleteThisEmployee = new JTextField(20);
			deleteLabel.setBounds(150,50,200,25);
			tempPanel2.add(deleteThisEmployee);
		
			JButton deleteButton = new JButton(" DELETE ");
			tempPanel2.add(deleteButton);
			tempPanel2.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
			allPanels.add(tempPanel2);
			
			ActionListener deleteListener = new ActionListener(){ // when user clicks the delete button, these actions will be performed.
				public void actionPerformed(ActionEvent e)
				{
					int deleteID = Integer.valueOf(deleteThisEmployee.getText()); // gets deleted personnel's id
					AllDatabaseOperations.deletePersonalInfo(deleteID); // function to delete employee form database
					new EmployeePageInterface(idNum);
					m.outline.setVisible(false);
				}	
			};
			deleteButton.addActionListener(deleteListener);
		}
	
		m.dataPanel.add(allPanels);
		m.outline.add(m.dataPanel);
		m.outline.setVisible(true);
       
	}
	
}
