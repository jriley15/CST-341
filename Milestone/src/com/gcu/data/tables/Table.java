package com.gcu.data.tables;

import java.util.ArrayList;
import java.sql.*;


//generic table abstract class (contains crud functions and connection object)

public class Table {

	
	protected Connection connection;

	public Table() {

	}
	
	
	public void setConnection(Connection c) {
		this.connection = c;
		
	}
	
}
