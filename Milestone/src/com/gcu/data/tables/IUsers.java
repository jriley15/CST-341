package com.gcu.data.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gcu.data.dto.LoginRequest;
import com.gcu.data.entity.Message;
import com.gcu.data.entity.User;

public interface IUsers extends ITable {
	

	public boolean create(User u);

	public User validate(LoginRequest request);
	
	public boolean emailExists(String email);
	
	
}
