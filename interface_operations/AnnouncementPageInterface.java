package com.intern.interface_operations;

import java.awt.Font;

import javax.swing.JLabel;

import com.intern.database_operations.AllDatabaseOperations;

public class AnnouncementPageInterface {
	private MainDraft m;
	
	public AnnouncementPageInterface(int idNum)
	{
		m = new MainDraft(idNum); // forms main page structure
		AllDatabaseOperations.displayAnnouncement(); // gets announcements from database

		JLabel dataText = new JLabel("Announcements");
		dataText.setFont(new Font("DejaVuSans",Font.BOLD,16));
		dataText.setBounds(300, 100, 300, 100);
		m.dataPanel.add(dataText);
		
		for(int i = 0; i < AllDatabaseOperations.getAnnouncementList().size(); i++)
		{
			JLabel announceDate = new JLabel(AllDatabaseOperations.getAnnouncementList().get(i).getAnnounceDate());
			announceDate.setBounds(150, 170+(30*i), 100, 40);
			m.dataPanel.add(announceDate);
		
			JLabel announceContent = new JLabel(AllDatabaseOperations.getAnnouncementList().get(i).getAnnounceContent());
			announceContent.setBounds(250, 170+(30*i), 200, 40);
			m.dataPanel.add(announceContent);
		}		
	}
	
}

