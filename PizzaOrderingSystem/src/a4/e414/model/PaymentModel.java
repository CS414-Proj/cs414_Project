package a4.e414.model;

import a4.e414.controller.PaymentProcessingController;

public  class PaymentModel {
	
	private float subtotal;
	private float tax;
	private float amountToPay;

	public PaymentModel(TransactionModel sale,String user,float subtotal,float tax,float amountToPay,String orderNumValue,String action){
		this.subtotal = subtotal;
		this.tax=tax;
		this.amountToPay = amountToPay;
		new PaymentProcessingController(sale,user,subtotal+"",tax+"",amountToPay+"",orderNumValue,action);
	}
	
}
