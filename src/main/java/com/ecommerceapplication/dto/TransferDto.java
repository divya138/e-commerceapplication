package com.ecommerceapplication.dto;

public class TransferDto {
	
	private long userAccountNumber;
	private long ecommerceAccountNumber;
	private double price;
	public long getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(long userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public long getEcommerceAccountNumber() {
		return ecommerceAccountNumber;
	}
	public void setEcommerceAccountNumber(long ecommerceAccountNumber) {
		this.ecommerceAccountNumber = ecommerceAccountNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public TransferDto(long userAccountNumber, long ecommerceAccountNumber, double price) {
		super();
		this.userAccountNumber = userAccountNumber;
		this.ecommerceAccountNumber = ecommerceAccountNumber;
		this.price = price;
	}
	public TransferDto() {
		super();
	}
	@Override
	public String toString() {
		return "Transfer [userAccountNumber=" + userAccountNumber + ", ecommerceAccountNumber=" + ecommerceAccountNumber
				+ ", price=" + price + "]";
	}
	

}
