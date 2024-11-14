package dto;

import java.util.Random;

public class BankDto {
	private String accountType;
	private long accountNumber;
	private String ifscCode;
	private String branch;
	private double balance;
	private long pin;
	private long phone;
	private String email;
	Random r = new Random();
	private long ifsc = r.nextLong(100000,999999);
	public BankDto(String accountType, String branch, double balance,long pin, long phone,String email) {
		this.accountType = accountType;
		this.accountNumber = r.nextLong(100000000000l,999999999999l);
		this.ifscCode = branch.substring(0,4)+ifsc;
		this.branch = branch;
		this.balance = balance;
		this.pin = pin;
		this.phone = phone;
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public BankDto( long accountNumber, String ifscCode,String accountType, String branch, double balance, long pin) {
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.balance = balance;
		this.pin = pin;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setIFSCCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public String getIFSCCode() {
		return ifscCode;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
