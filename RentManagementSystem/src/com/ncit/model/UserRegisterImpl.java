package com.ncit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ncit.dbconnection.DatabaseConnection;
import com.ncit.dbconnection.DatabaseConnectionImpl;
import com.ncit.userservice.User;
import com.ncit.userservice.UserService;

public class UserRegisterImpl implements UserService {

	@Override
	public boolean isUserValid(User user) {
		// TODO Auto-generated method stub
		
		DatabaseConnection dbConn = new DatabaseConnectionImpl();
		Statement statement =  dbConn.doConnection();
		
		String query = "insert into users (fullname,address,email,mobile)" + "values('"+ user.getFullname() +"','"+user.getAddress() +",'"+user.getEmail() +"','"+ user.getMobile() +"');";
		
		
		try {
			ResultSet result = statement.executeQuery(query);
			if(result.next()){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
