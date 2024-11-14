package dto;

public class TransactionDto {
	private Long receiverAccount;
	private String IFSCcode;
	private int amount;
	private long pin;
	private String email;
	public TransactionDto(Long receiverAccount, String iFSCcode, int amount, long pin,String email) {
		this.receiverAccount = receiverAccount;
		this.IFSCcode = iFSCcode;
		this.amount = amount;
		this.pin = pin;
		this.email = email;
	}
	public Long getReceiverAccount() {
		return receiverAccount;
	}
	public void setReceiverAccount(Long receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
