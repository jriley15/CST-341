package com.gcu.data.tables;

import java.util.ArrayList;
import java.sql.*;


//generic table abstract class (contains crud functions and connection object)

public abstract class Table<T> {

	
	protected Connection connection;

	public Table(Connection c) {
		this.connection = c;
	}
	
	public abstract boolean create(T e);
	
	public abstract ArrayList<T> getAll();
	
	public abstract T getOne(int id);
	
	public abstract boolean update(T e);
	
	public abstract boolean delete(int id);
	
	
}
