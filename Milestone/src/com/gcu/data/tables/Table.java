package com.gcu.data.tables;

import java.util.ArrayList;

import com.gcu.data.entity.Entity;
import java.sql.*;


public abstract class Table<T> {

	
	protected Connection connection;

	protected String name;

	public Table(Connection c) {
		this.connection = c;
	}
	
	public abstract boolean create(T e);
	
	public abstract ArrayList<T> getAll();
	
	public abstract T getOne(int id);
	
	public abstract boolean update(T e);
	
	public abstract boolean delete(int id);
	
	
}
