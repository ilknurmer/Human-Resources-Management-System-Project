package com.intern.database_operations;

public class Position {
	private String p_positionName; 
	private int p_positionID;
	
	// setter and getter methods for position info
	public void setPositionID(int pid)
	{
		p_positionID = pid;
	}
	public int getPositionID()
	{
		return p_positionID;
	}
	
	public String getPositionName()
	{
		return p_positionName;
	}
	public void setPositionName(String pname)
	{
		p_positionName = pname;
	}
	
}

