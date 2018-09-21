package com.gcu.data.tables;

import java.sql.Connection;
import java.util.ArrayList;

import com.gcu.data.entity.Entity;
import com.gcu.data.entity.User;

public class Users extends Table<User> {



	public Users(Connection c) {
		super(c);
		name = this.getClass().getName();
	}

	@Override
	public boolean create(User e) {
		
		//insert user to db
		
		
		return false;
	}

	@Override
	public ArrayList<User> getAll() {


		//return list of all users
		
		return null;
	}

	@Override
	public User getOne(int id) {

		
		
		return null;
	}

	@Override
	public boolean update(User e) {

		
		
		return false;
	}

	@Override
	public boolean delete(int id) {

		
		
		
		return false;
	}



	
	
	
}
