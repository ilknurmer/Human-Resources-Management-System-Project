package com.intern.database_operations;

public class Employee {

	private int e_id;
	private String e_name;
	private String e_surname;
	private String e_password;
	private String e_gender;
	private String e_birth;
	private int e_jobStart;
	private int e_positionID;
	private String e_positionName;
	private int e_salary;
	private int e_annualLeave;
	private int e_telno;
	private String e_email;
	
	// getter and setter methods of employee info
	
	public void setID(int id)
	{
		e_id = id;
	}
	public int getID()
	{
		return e_id;
	}
	
	public String getName()
	{
		return e_name;
	}
	public void setName(String name)
	{
		e_name = name;
	}
	
	public String getPassword()
	{
		return e_password;
	}
	public void setPassword(String password){
		e_password = password;
	}
	
	public String getSurname()
	{
		return e_surname;
	}
	public void setSurname(String sname)
	{
		e_surname = sname;
	}
	
	public void setGender(String gendr)
	{
		e_gender = gendr;
	}
	public String getGender()
	{
		return e_gender;
	}
	
	public void setBirth(String birth)
	{
		e_birth = birth;
	}
	public String getBirth()
	{
		return e_birth;
	}

	public void setJobStart(int jstart)
	{
		e_jobStart = jstart;
	}
	public int getJobStart()
	{
		return e_jobStart;
	}

	public void setPositionID(int pid)
	{
		e_positionID = pid;
	}
	public int getPositionID()
	{
		return e_positionID;
	}


	public String getPositionName()
	{
		return e_positionName;
	}
	public void setPositionName(String pname)
	{
		e_positionName = pname;
	}
	
	public void setSalary(int salaryData)
	{
		e_salary = salaryData;
	}
	public int getSalary()
	{
		return e_salary;
	}
	
	public void setAnnualLeave(int aleave)
	{
		e_annualLeave = aleave;
	}
	public int getAnnualLeave()
	{
		return e_annualLeave;
	}
	
	public void setTelNo(int tno)
	{
		e_telno = tno;
	}
	public int getTelNo()
	{
		return e_telno;
	}
	
	public void setEmail(String eml)
	{
		e_email = eml;
	}
	public String getEmail()
	{
		return e_email;
	}
	
}

