package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dto.BankDto;


public class BankDao {
	public Connection makeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/Motive_Bank?createDatabaseIfNotExist=true","root","Mani");
	}
	
	
	public void createCustomerTable() throws ClassNotFoundException, SQLException
	{
		Connection con=makeConnection(); 
		Statement s=con.createStatement();
		s.execute("create table if not exists bank(accountnumber bigint(12) primary key,ifsccode varchar(10),accounttype varchar(45),branch varchar(45),pin bigint(6),balance double,phone bigint(10) not null unique,email varchar(45) not null unique)");	
	}
	
	
	public int saveBank(BankDto b) throws ClassNotFoundException, SQLException
	{
		createCustomerTable();
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("insert into bank(accountnumber,ifsccode,accounttype,branch,pin,balance,phone,email) values(?,?,?,?,?,?,?,?)");
		ps.setLong(1, b.getAccountNumber());
		ps.setString(2, b.getIFSCCode());
		ps.setString(3, b.getAccountType());
		ps.setString(4, b.getBranch());
		ps.setLong(5,b.getPin());
		ps.setDouble(6, b.getBalance());  
		ps.setLong(7, b.getPhone());
		ps.setString(8, b.getEmail());
		return ps.executeUpdate();	
	}
	
	
	public double balance(long phone, long pin) throws SQLException, ClassNotFoundException
	{
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select balance from bank where phone=? and pin=?");
		ps.setLong(1, phone);
		ps.setLong(2, pin);
		ResultSet r =  ps.executeQuery();
		r.next();
		return r.getDouble("balance");
	}
	
	public BankDto getBankDetails(String email) throws SQLException, ClassNotFoundException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select * from bank where email=?");
		ps.setString(1, email);
		ResultSet r = ps.executeQuery();
		r.next();
		return new BankDto(r.getLong("accountnumber"), r.getString("ifsccode"), r.getString("accounttype"), r.getString("branch"), r.getDouble("balance"), r.getLong("pin"));
	}
	
	public void deleteBank(String email) throws ClassNotFoundException, SQLException {
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("delete from bank where email=?");
		ps.setString(1, email);
		ps.execute();
	}
}
