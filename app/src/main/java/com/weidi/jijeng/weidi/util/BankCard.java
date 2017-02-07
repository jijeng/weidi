package com.weidi.jijeng.weidi.util;


public class BankCard {
	private String cardNumber;
	private String bankName;
	
	public BankCard(String bankName, String cardNumber){
		this.bankName = bankName;
		this.cardNumber = cardNumber;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
