package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import dto.UserDto;

public class UserDao {
	
	public Connection makeConnection() throws SQLException
	{
		DriverManager.registerDriver(new Driver());
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/Motive_Bank?createDatabaseIfNotExist=true","root","Mani");
	}
	public void createCustomerTable() throws  SQLException
	{
		Connection con=makeConnection(); 
		Statement s=con.createStatement();
		s.execute("create table if not exists users(firstname varchar(45),lastname varchar(45),email varchar(45) primary key,phone bigint(10),password varchar(45),dateofbirth varchar(45),gender varchar(45),address varchar(45))");
	}
	public void saveUser(UserDto u) throws SQLException
	{
		Connection con=makeConnection();
		createCustomerTable();
		PreparedStatement ps=con.prepareStatement("insert into users(firstname,lastname,email,phone,password,dateofbirth,gender,address) values(?,?,?,?,?,?,?,?)");
		ps.setString(1, u.getfName());
		ps.setString(2, u.getlName());
		ps.setString(3, u.getEmail());
		ps.setLong(4, u.getPhNo());
		ps.setString(5, u.getPassword());
		ps.setString(6, u.getDOB());
		ps.setString(7, u.getGender());
		ps.setString(8, u.getAddress());
		ps.execute();
		con.close();
		ps.close();
	}
	
	public String login(String email, String password) throws SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select password from users where email=?");
		ps.setString(1,email);
		ResultSet r=ps.executeQuery();
		if(r.next())
		{
			if(r.getString("password").equals(password))
			{
				return "success";
			}
			else
			{
				return "passwordWrong";
			}
		}
		else
		{
			return "emailWrong";	
		}	
	}
	
	public boolean forgotPaaword(String email,String password) throws SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("update users set password=? where email=?");
		ps.setString(1, password);
		ps.setString(2, email);
		return ps.execute();
	}
	
	public int deleteUser(String email) throws SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("delete from users where email=?");
		ps.setString(1,email);
		return ps.executeUpdate();
	}
	
	public int updateUser(UserDto u) throws SQLException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("update users set firstname=?,lastname=?,phone=?,dateofbirth=?,gender=?,address=? where email=?");
		ps.setString(1, u.getfName());
		ps.setString(2, u.getlName());
		ps.setLong(3, u.getPhNo());
		ps.setString(4, u.getDOB());
		ps.setString(5, u.getGender());
		ps.setString(6, u.getAddress());
		ps.setString(7, u.getEmail());
		return ps.executeUpdate();
	}
	
	public UserDto getUserData(String email) throws SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select * from users where email=?");
		ps.setString(1, email);
		ResultSet r = ps.executeQuery();
		r.next();
		return new UserDto(r.getString("firstname"),r.getString("lastname"),r.getString("email"),r.getLong("phone"),r.getString("password"),r.getString("dateofbirth"),r.getString("gender"),r.getString("address"));
	}

	

}
