package com.intern.database_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllDatabaseOperations {
		private static Connection conn; // to set up a database connection
		private static ResultSet rs; // to provide a JDBC cursor mechanism
		private static PreparedStatement ps; // // to define a dynamic SQL statement
		
		private static boolean isUser; // detects person logged in is an employee or not. If isUser is true, this means that the person logged in is an employee.
		private static boolean isManager; // detects person logged in is manager or not. If isManager is true, this means that the person logged in is a manager.
		private static boolean isOnVacation; // detects employee is on vacation or not. If isOnVacation is true, this means that the employee is on vacation.
		
		private static Employee e; // employee object which includes employee's personal information.
		private static AnnualLeave aL; // annual leave object which includes employee's annual leave information.
        private static Announcement a; // announcement object which includes announcements made by human resource manager.
        private static String [] columns; // holds column names of table which contains general employee information.
        private static List<Announcement> a_values; //  holds Announcement objects in a list.
        private static List<Employee> values; // holds Employee objects in a list.
        private static String [][] data; // holds cell content of table which includes general employee information.
        private static int totalEmployeeNumber; // to detect number of employees
        private static Date currentDate; // to find login date
       
        // getter method for isUser variable
        public static boolean getIsUser()
        {
        	return isUser;
        }
        // getter method for isManager variable
        public static boolean getIsManager()
        {
        	return isManager;
        }
        // getter method for Employee object
        public static Employee getEmployee()
        {
        	return e;
        }
        // getter method for List of Announcement objects
        public static List<Announcement> getAnnouncementList()
        {
        	return a_values;
        }
        // getter method for table's column names
        public static String [] getcolumns()
        {
        	return columns;
        }
        // getter method for table's cell content
        public static String [][] getCellData()
        {
        	return data;
        }
        // getter method for totalEmployeeNumber which is used to find number of employee in database
        public static int getTotalEmployeeNumber()
        {
        	return totalEmployeeNumber;
        }
        // setter method for current date
        public static void setCurrentDate(Date takenDate)
        {
        	currentDate = takenDate;
        }
        
		// Method which provides connection to MySQL Server Database
		public static void openDBconnection()
		{
			try // we setup a try catch block to handle possible exceptions while connecting to database
			{
				String myDriver = "com.mysql.jdbc.Driver"; // JDBC driver name
		        String db = "jdbc:mysql://localhost/human_resources_management_system"; // Database URL
		        Class.forName(myDriver);
		        conn = DriverManager.getConnection(db, "root", ""); // connection is established, this will be used to create prepareStatement objects
		        conn.createStatement();
			}
			catch(Exception exc){ 
				exc.printStackTrace();
				System.out.println("Error! " + exc.toString());
				System.out.println(exc.getMessage());
			}
		}
	
		// Method to close the MySQL Server Database connection
		public static void closeDBconnection()
		{
			try
			{
				conn.close(); // closes database connection
			}
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}
		}
		
		// Method to get employee's current personal information
		public static void getCurrentPersonalInfo(int id)
		{
			columns = new String[3]; // holds personal info table's column names. There are three column in table.
			columns[0] = "password";
			columns[1] = "tel no";
			columns[2] = "e-mail";	
			// query which gets employee's password, telephone number and e-mail using employee and contact_info tables in database.
			String sql = "SELECT employee.password,contact_info.tel_no,contact_info.email from employee inner join contact_info on employee.employee_id=contact_info.employee_id where employee.employee_id=?";
		    try{
		    	ps = conn.prepareStatement(sql); // 
				ps.setInt(1, id); // put id instead of first question mark in the sql query   
				rs = ps.executeQuery(); // executeQuery() method is applied with prepareStatement instance.
				values = new ArrayList<>(); 
				Employee e = new Employee();
				while(rs.next()) // while rs.next() returns true,
				{
					e.setPassword(rs.getString("password"));  // take employee password from result set object and send it to employee object's password variable
					e.setTelNo(Integer.valueOf(rs.getString("tel_no"))); // take employee tel no from result set object and send it to employee object's tel no variable
					e.setEmail(rs.getString("email")); // take employee e-mail and send it to employee object's e-mail variable
					values.add(e); // add employee object to values list
				}		
				data = new String[1][3]; // create a 2D array to hold personal info
				data[0][0] = e.getPassword(); // first column contains password
				data[0][1] = String.valueOf(e.getTelNo()); // second column contains tel no
				data[0][2] = e.getEmail(); // third column contains e-mail		
		    	}
		    	 catch(SQLException exc)
				{
					System.out.println(exc.toString());
				}		
		}

		// Method which updates employee's information
		public static void updatePersonalInfo(int whichInfo,int id,String newInfo)
		{
			// function takes 3 parameters:
			// whichInfo provides us to find which personal info will be updated
			// id is used to find which employee's info will be updated
			// newInfo is new information of employee
			switch(whichInfo)
			{
				case 1: // if whichInfo is 1, password info will be updated
				String sql = "update employee set employee.password=? where employee.employee_id=?";
				try{
					ps = conn.prepareStatement(sql);
					ps.setString(1, newInfo);
					ps.setInt(2, id);
					ps.executeUpdate();
			    	}
			    	 catch(SQLException exc)
					{
						System.out.println(exc.toString());
					}
				break;
				case 2: // // if whichInfo is 2, tel no info will be updated
				String sql2 = "update contact_info set contact_info.tel_no=? where contact_info.employee_id=?";
				try{
				    ps = conn.prepareStatement(sql2);
					ps.setString(1, newInfo);
					ps.setInt(2, id);
					ps.executeUpdate();			
			    	}
			    	 catch(SQLException exc)
					{
						System.out.println(exc.toString());
					}
				break;
				case 3: // if whichInfo is 3, e-mail info will be updated
				String sql3 = "update contact_info set contact_info.email=? where contact_info.employee_id=?";
				try{  
					ps = conn.prepareStatement(sql3);
					ps.setString(1, newInfo);
					ps.setInt(2, id);
					ps.executeUpdate();			
			    	}
			    	 catch(SQLException exc)
					{
						System.out.println(exc.toString());
					}
				break;
			}
		}
		
		// Method to display personal information
		public static void displayPersonalInfo(int id_num)
		{
			// sql query gets employee's all personal information which is known by only employee and the human resources
			String sql = "SELECT * from employee inner join position on employee.position_id=position.position_id inner join salary on employee.employee_id=salary.salary_id inner join annual_leave on employee.employee_id=annual_leave.annual_leave_id inner join contact_info on employee.employee_id=contact_info.contact_info_id where employee.employee_id=?";
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id_num);
				rs = ps.executeQuery();
				values = new ArrayList<>();
				e = new Employee();
				while(rs.next())
				{
					e.setPositionID(rs.getInt("employee_id"));
					e.setName(rs.getString("first_name"));
					e.setSurname(rs.getString("last_name"));
					e.setGender(rs.getString("gender"));
					e.setBirth(rs.getString("date_of_birth"));
					e.setJobStart(rs.getInt("job_start"));
					e.setPositionName(rs.getString("position_name"));
					e.setSalary(rs.getInt("salary_amount"));
					e.setAnnualLeave(rs.getInt("remaining_annual_leave"));
					e.setTelNo(rs.getInt("tel_no"));
					e.setEmail(rs.getString("email"));
					values.add(e);
				}			
			}
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}
		}

		// Method to display other employees' information
		public static  void displayEmployeesInfo()
		{
			columns = new String[7]; // holds column names of employee information table
			columns[0] = "ID";
			columns[1] = "First name";
			columns[2] = "Last name";
			columns[3] = "Position";
			columns[4] = "Tel no";
			columns[5] = "E-mail";	
			columns[6] = "Vacation";
			// sql query gets all employee's general information like name,surname, position and contact info
			String sql = "SELECT employee.employee_id,employee.first_name,employee.last_name,position.position_name,contact_info.tel_no,contact_info.email from employee inner join position on employee.position_id=position.position_id inner join contact_info on employee.employee_id=contact_info.contact_info_id";
			try
			{
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				values = new ArrayList<>();
				while(rs.next())
				{
					Employee e = new Employee();
					e.setID(rs.getInt("employee_id"));
					e.setName(rs.getString("first_name"));
					e.setSurname(rs.getString("last_name"));
					e.setPositionName(rs.getString("position_name"));
					e.setTelNo(Integer.valueOf(rs.getString("tel_no")));
					e.setEmail(rs.getString("email"));
					values.add(e);
				}	
				
				data = new String[values.size()][7]; // create a 2D array to hold employee info
				
				for(int i = 0; i < values.size(); i++)
				{
					for(int j = 0; j < 7; j++)
					{
						switch(j)
						{
						case 0:data[i][j] = String.valueOf(values.get(i).getID()); // first column contains employee id
						break;
						case 1:data[i][j] = values.get(i).getName(); // second column contains name
						break;
						case 2:data[i][j] = values.get(i).getSurname(); // third column contains surname
						break;
						case 3:data[i][j] = values.get(i).getPositionName(); // forth column contains position
						break;
						case 4:data[i][j] = String.valueOf(values.get(i).getTelNo()); // fifth column includes tel no
						break;
						case 5:data[i][j] = values.get(i).getEmail(); // sixth column includes e-mail
						break;
						case 6: // seventh column includes information of which employee is on vacation or at work. 
							findWhoIsOnLeave(values.get(i).getID()); // function to determine which employee in on leave or at work
							if(isOnVacation)
							{
								data[i][j] = "On Vacation";
							}
							else
							{
								data[i][j] = "At Work";
							}
							isOnVacation = false;
						break;
						}	
					}	
				}
		    	}
		    	 catch(SQLException exc)
				{
					System.out.println(exc.toString());
				}
		}
		
		// Method which displays announcements
		public static void displayAnnouncement()
		{
			// sql query gets all announcements from database
			String sql = "select announcement_content,announcement_date from announcement";
			try
			{
				ps = conn.prepareStatement(sql);
		        rs = ps.executeQuery();
		        a_values = new ArrayList<>();  	
		        while(rs.next())
		        {
		        	a = new Announcement();
		        	a.setAnnounceContent(rs.getString("announcement_content"));
					a.setAnnounceDate(rs.getString("announcement_date"));
					a_values.add(a);
			    }
		    }
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}
		}
	
		// Method to detect whether the person who login the system is manager or not
		public static void isManagerOrNot(int id)
		{
			String sql = "select position_id from employee where employee_id=?";
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();	
				while(rs.next())
				{
					if(rs.getInt("position_id") == 3) // if position id is 3, it means user's position is human resources, so user have privileges to change or display employee info
					{
						isManager = true;
					}
					else
					{
						isManager = false;
					}
				}
			}
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}	
		}
		
		// Method which controls the compatibility of user id and password
		public static void isUserOrNot(int id, String passwrd)
		{
			String sql = "select password from employee where employee_id=?";
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();	
				while(rs.next())
				{
					if(rs.getString("password").equals(passwrd))
					{
						isUser = true;
						isManagerOrNot(id);
					}
					else
					{
						isUser = false;
					}
				}
			
			}
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}
		}
		
		// Method which adds new employee's information to database
		public static void addNewEmployeeInfo(int totalEmployeeNum,String name,String surname,String gender,String birthDate,String jobStart, int position, String password, int salary, String telNo, String email,String positionName, int defaultHoliday, int remainingHoliday, String holidayStart, String holidayFinish)
		{
			// new information of new employee taken by this function will be add to database with queries into the related table. 
			int positionId = Integer.valueOf(position);
			String sql = "insert into employee(first_name,last_name,gender,date_of_birth,job_start,position_id,password) values(?,?,?,?,?,?,?)";
			String sql1 = "insert into salary(employee_id,salary_amount) values(?,?)";
			String sql2 = "insert into contact_info(employee_id,tel_no,email) values(?,?,?)";
			String sql3 = "insert into annual_leave(employee_id,remaining_annual_leave,annual_leave_start, annual_leave_finish,default_annual_leave) values(?,?,?,?,?)";
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, surname);
				ps.setString(3, gender);
				ps.setString(4, birthDate);
				ps.setString(5, jobStart);
				ps.setInt(6, positionId);
				ps.setString(7, password);
				ps.executeUpdate();	// executeUpdate() method is used in insert and delete operations
			
				ps = conn.prepareStatement(sql1);
				ps.setInt(1, totalEmployeeNum+1);
				ps.setInt(2, salary);
				ps.executeUpdate();	
			
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, totalEmployeeNum+1);
				ps.setString(2, telNo);
				ps.setString(3, email);
				ps.executeUpdate();	
				
				ps = conn.prepareStatement(sql3);
				ps.setInt(1, totalEmployeeNum+1);
				ps.setInt(2, remainingHoliday);
				ps.setString(3, holidayStart);
				ps.setString(4, holidayFinish);
				ps.setInt(5, defaultHoliday);
				ps.executeUpdate();
			
			}
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}	
		}
	
		// Method which deletes employee's related information from database 
		public static void deletePersonalInfo(int id)
		{
			String sql = "delete from employee where employee.employee_id=?";
			String sql1 = "delete from contact_info where contact_info.employee_id=?";
			String sql2 = "delete from salary where salary.employee_id=?";
			String sql3 = "delete from annual_leave where annual_leave.employee_id=?";
			String sql4 = "delete from announcement where announcement.employee_id=?";
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();	// executeUpdate() method is used in insert and delete operations
				
				ps = conn.prepareStatement(sql1);
				ps.setInt(1, id);
				ps.executeUpdate();
				
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, id);
				ps.executeUpdate();
				
				ps = conn.prepareStatement(sql3);
				ps.setInt(1, id);
				ps.executeUpdate();
				
				ps = conn.prepareStatement(sql4);
				ps.setInt(1, id);
				ps.executeUpdate();
			}
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}	
		}
		
		// Method which finds added employee's id
		public static void findEmployeeNumber()
		{
			String sql = "select employee_id from employee";
			try
			{
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();	
				while(rs.next())
				{
					totalEmployeeNumber = rs.getInt("employee_id");
				}
			}
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}	
		}
		
		// Method to detect which employee is in her/his annual leave.
		public static void findWhoIsOnLeave(int id)
		{
			String sql = "select annual_leave.annual_leave_start,annual_leave.annual_leave_finish from annual_leave where annual_leave.employee_id=?";
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				aL = new AnnualLeave();
				while(rs.next())
				{
					aL.setAnnualLeaveStart(rs.getDate("annual_leave_start"));
					aL.setAnnualLeaveFinish(rs.getDate("annual_leave_finish"));
					
					if(currentDate.before(aL.getAnnualLeaveFinish()))
					{
						isOnVacation = true;
					}
					else
					{
						isOnVacation = false;
					}
					
					
				}			
			}
			catch(SQLException exc)
			{
				System.out.println(exc.toString());
			}
		}

}

