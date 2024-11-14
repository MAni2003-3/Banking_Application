package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.TransactionDto;

public class TransactionDao {
	public Connection makeConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/Motive_Bank?createDatabaseIfNotExist=true","root","Mani");
	}
	public double trasferAmount(TransactionDto t) throws ClassNotFoundException, SQLException {
		double sendBalance=0;
		double receiverBalance=0;
		long senderAccount;
		Connection con=makeConnection();
		PreparedStatement ps=con.prepareStatement("select accountnumber,balance from Bank where email=?");
		ps.setString(1, t.getEmail());
		ResultSet r =  ps.executeQuery();
		if(r.next()) {
			senderAccount = r.getLong("accountnumber");
			sendBalance = r.getDouble("balance");
		}
		else {
			con.close();
			ps.close();
			System.out.println("user does not have a account");
			return 0;
		}
		PreparedStatement ps1=con.prepareStatement("select balance from Bank where accountnumber=?");
		ps1.setLong(1, t.getReceiverAccount());
		ResultSet r1 =  ps1.executeQuery();
		if(r1.next()) {
			receiverBalance = r1.getDouble("balance");
		}else {
			System.out.println(t.getReceiverAccount());
			con.close();
			ps.close();
			ps1.close();
			return 0;
		}
		if(sendBalance<=t.getAmount() || receiverBalance==0) {
			System.out.println("transfer amount greater than balance");
			con.close();
			ps.close();
			ps1.close();
			return 0;
		}
		else {
			PreparedStatement ps2=con.prepareStatement("update Bank set balance=? where accountnumber=?");
			ps2.setDouble(1, sendBalance-t.getAmount());
			ps2.setLong(2, senderAccount);
			PreparedStatement ps3=con.prepareStatement("update Bank set balance=? where accountnumber=?");
			ps3.setDouble(1, receiverBalance+t.getAmount());
			ps3.setLong(2, t.getReceiverAccount());
			ps2.execute();
			ps3.execute();
			con.close();
			ps.close();
			ps1.close();
			ps2.close();
			ps3.close();
			return sendBalance-t.getAmount();
		}
	}
}
