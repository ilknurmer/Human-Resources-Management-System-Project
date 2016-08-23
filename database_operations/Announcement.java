package com.intern.database_operations;

public class Announcement {

	private String a_announcementContent;
	private String a_announcementDate;
	
	// getter and setter methods for announcement content
	public String getAnnounceContent()
	{
		return a_announcementContent;
	}
	public void setAnnounceContent(String a_content)
	{
		a_announcementContent = a_content;
	}
	
	// getter and setter methods for announcement date
	public String getAnnounceDate()
	{
		return a_announcementDate;
	}
	public void setAnnounceDate(String a_date)
	{
		a_announcementDate = a_date;
	}
		
}
