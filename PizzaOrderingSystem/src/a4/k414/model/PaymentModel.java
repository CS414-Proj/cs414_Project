package a4.k414.model;

import a4.k414.controller.PaymentProcessingController;

public  class PaymentModel {
	
	private float subtotal;
	private float tax;
	private float amountToPay;

	public PaymentModel(TransactionModel trans,String user,float subtotal,float tax,float amountToPay,String orderNumValue,String action){
		this.subtotal = subtotal;
		this.tax=tax;
		this.amountToPay = amountToPay;
		new PaymentProcessingController(trans,user,subtotal+"",tax+"",amountToPay+"",orderNumValue,action);
	}
	public String getPaymentDetails() {
		String payment = subtotal+" "+tax+" "+amountToPay;
		return payment;
	}
}
