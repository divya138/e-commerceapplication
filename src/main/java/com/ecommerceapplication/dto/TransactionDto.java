package com.ecommerceapplication.dto;

public class TransactionDto {
	
	private int transactionId;
	private long userAccountNumber;
	private long ecommerseAccountNumber;
	private double  price;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public long getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(long userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public long getEcommerseAccountNumber() {
		return ecommerseAccountNumber;
	}
	public void setEcommerseAccountNumber(long ecommerseAccountNumber) {
		this.ecommerseAccountNumber = ecommerseAccountNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public TransactionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionDto(int transactionId, long userAccountNumber, long ecommerseAccountNumber, double price) {
		super();
		this.transactionId = transactionId;
		this.userAccountNumber = userAccountNumber;
		this.ecommerseAccountNumber = ecommerseAccountNumber;
		this.price = price;
	}
	@Override
	public String toString() {
		return "TransactionDto [transactionId=" + transactionId + ", userAccountNumber=" + userAccountNumber
				+ ", ecommerseAccountNumber=" + ecommerseAccountNumber + ", price=" + price + "]";
	}
	

}
