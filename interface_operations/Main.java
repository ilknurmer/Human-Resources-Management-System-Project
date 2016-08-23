package com.intern.interface_operations;

import javax.swing.SwingUtilities;
import com.intern.database_operations.AllDatabaseOperations;

public class Main {
	
	public static void main(String[] args) {	
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				new LoginPageInterface(); 
				AllDatabaseOperations.openDBconnection(); // to establish database connection
			}
		});
		
	}
	
}
