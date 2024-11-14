package dto;

public class ProfileDto {
	private String name;
	private long accountNumber;
	private String ifscCode;
	private long phone;
	private String branch;
	private String address;
	public ProfileDto(String name, long accountNumber, String ifscCode, long phone, String branch, String address) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.phone = phone;
		this.branch = branch;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
