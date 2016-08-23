package com.intern.database_operations;

import java.sql.Date;

public class AnnualLeave {
	private Date a_leaveStart; // annual leave start date
	private Date a_leaveFinish; // annual leave finish date

	// setter and getter methods for annual leave start date
	public void setAnnualLeaveStart(Date aLeaveStart)
	{
		a_leaveStart = aLeaveStart;
	}
	public Date getAnnualLeaveStart()
	{
		return a_leaveStart;
	}
	// setter and getter methods for annual leave finish date	
	public void setAnnualLeaveFinish(Date aLeaveFinish)
	{
		a_leaveFinish = aLeaveFinish;
	}
	public Date getAnnualLeaveFinish()
	{
		return a_leaveFinish;
	}
		
}

