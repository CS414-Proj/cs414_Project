package a4.k414.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import a4.k414.model.CardPaymentModel;
import a4.k414.model.CashPaymentModel;
import a4.k414.model.TransactionModel;
import a4.k414.view.PaymentProcessingScreen;

public class PaymentProcessingController {
	NumberFormat formatter = new DecimalFormat("#.00");   //My Edit
	private String user;
	private PaymentProcessingScreen payView;
	private TransactionModel sale;
	private String paymentMode="none";
	private String action;

	public PaymentProcessingController(TransactionModel sale,String user,String subTotalVal,String taxVal,String totalVal,String orderNumValue,String action){
		this.user=user;
		this.sale=sale;
		this.action = action;
		payView = new PaymentProcessingScreen(subTotalVal, taxVal, totalVal,orderNumValue,action);
		this.payView.ButtonListner(new PaymentListner());
	}


	class PaymentListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==payView.getCashButton()){
				paymentMode="cash";
				payView.getCashGiven().setVisible(true);
				payView.getCashGivenField().setVisible(true);
				payView.getReturnCash().setVisible(true);
				payView.getReturnCashField().setVisible(true);
				payView.getChangeButton().setVisible(true);

				payView.getCardHolderName().setVisible(false);
				payView.getCardHolderNameField().setVisible(false);
				payView.getCardNum().setVisible(false);
				payView.getCardNumField().setVisible(false);
				payView.getValidthrough().setVisible(false);
				payView.getValidthroughField().setVisible(false);
				payView.getCcNum().setVisible(false);
				payView.getCcNumField().setVisible(false);

				payView.getCancelButton().setVisible(true);
				payView.getOkButton().setVisible(true);

			}
			else if(e.getSource()==payView.getCardButton()){
				paymentMode="card";
				payView.getCashGiven().setVisible(false);
				payView.getCashGivenField().setVisible(false);
				payView.getReturnCash().setVisible(false);
				payView.getReturnCashField().setVisible(false);
				payView.getChangeButton().setVisible(false);

				payView.getCardHolderName().setVisible(true);
				payView.getCardHolderNameField().setVisible(true);
				payView.getCardNum().setVisible(true);
				payView.getCardNumField().setVisible(true);
				payView.getValidthrough().setVisible(true);
				payView.getValidthroughField().setVisible(true);
				payView.getCcNum().setVisible(true);
				payView.getCcNumField().setVisible(true);

				payView.getCancelButton().setVisible(true);
				payView.getOkButton().setVisible(true);

			}
			else if(e.getSource()==payView.getChangeButton()){
				float balanceDue=Float.parseFloat(payView.getBalanceDueField().getText());
				float cashGiven = Float.parseFloat(payView.getCashGivenField().getText());
				if(cashGiven >= balanceDue)
					payView.getReturnCashField().setText((formatter.format(cashGiven-balanceDue))+"");		 //My Edit
				else
					JOptionPane.showMessageDialog(null,"Balance due not paid");
			}
			else if(e.getSource()==payView.getOkButton()){
				// save payment details	
				if(paymentMode.equals("cash")){
					float cashGiven = Float.parseFloat(payView.getCashGivenField().getText());
					float cashReturned = Float.parseFloat(payView.getReturnCashField().getText());
					float balanceDue = Float.parseFloat(payView.getBalanceDueField().getText());
					if(cashGiven >= balanceDue){
						new CashPaymentModel(cashGiven,cashReturned);
						sale.addtoReg(); // add order to list in Register and save sale
						new CashierActionsController(user);
						payView.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null,"BalanceDue not paid");

				}
				else if(paymentMode.equals("card")){
					String name = payView.getCardHolderNameField().getText();
					String cardNum = payView.getCardNumField().getText();
					int flag = 0;
					if(cardNum.length()!= 16){
						JOptionPane.showMessageDialog(null,"Enter Valid Credit card number");
						flag++;
					}
					String expiry = payView.getValidthroughField().getText();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
					simpleDateFormat.setLenient(false);
					Date expiryDate = null;
					try {
						expiryDate = simpleDateFormat.parse(expiry);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					boolean expired = expiryDate.before(new Date());
					if(expired){
						JOptionPane.showMessageDialog(null,"Enter Valid Expiry date");
						flag++;
					}
					String ccNum = payView.getCcNumField().getText();
					if(ccNum.length()!=3){
						JOptionPane.showMessageDialog(null,"Invalid cc number");
						flag++;
					}
					if(flag==0){
					CardPaymentModel paybyCard= new CardPaymentModel(name,cardNum,expiry,ccNum);
					boolean authorized = paybyCard.authorize();
					if(authorized){
						sale.addtoReg();
						if(action.equals("kiosk")){
							new AutomatedKioskController();
						}
						else {
							new CashierActionsController(user);
						}
						payView.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null,"Card Declined");
				}
				}

			}
			else if(e.getSource()==payView.getCancelButton()){
				if(action.equals("kiosk")){
					new AutomatedKioskController();
				}
				else{
					new CashierActionsController(user);
				}
				payView.setVisible(false);
			}

		}
	}

}
