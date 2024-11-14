package dto;

public class UserDto 
{
	private String fName,lName,address,email,DOB,gender,password;
	private long phNo;
	
	public UserDto(String fName, String lName, String email, long phNo, String password, String DOB, String gender, String address) {
	
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.email = email;
		this.DOB = DOB;
		this.gender = gender;
		this.password = password;
		this.phNo = phNo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		this.DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	@Override
	public String toString() {
		return "UserDto [fName=" + fName + ", lName=" + lName + ", Address=" + address + ", email=" + email + ", DOB="
				+ DOB + ", gender=" + gender + ", password=" + password + " phNo=" + phNo + "]";
	}	
}