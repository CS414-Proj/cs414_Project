package a5.k414.serverControllers;

import java.util.StringTokenizer;

import a4.k414.model.CSUPizzaStore;
import a4.k414.model.CardPaymentModel;
import a4.k414.model.CustomerModel;
import a4.k414.model.RegisterModel;
import a4.k414.model.TransactionModel;




public class PaymentControllerForAndroid{

	public String receivePaymentDetails(String saleNum,String cardDetails ){

		String nameOnCard = null,cardNum = null,cardExpiry = null,ccNum = null;
		StringTokenizer st = new StringTokenizer(cardDetails,"-");
		if(st.hasMoreTokens())
			nameOnCard = st.nextToken();
		if(st.hasMoreTokens())
			cardNum = st.nextToken();
		if(st.hasMoreTokens())
			cardExpiry= st.nextToken();
		if(st.hasMoreTokens())
			ccNum = st.nextToken();

		CardPaymentModel paybyCard= new CardPaymentModel(nameOnCard,cardNum,cardExpiry,ccNum);
		boolean authorized = paybyCard.authorize();
		if(authorized){
			TransactionModel trans = RegisterModel.getInstance().getTrans(saleNum);
			trans.addtoReg();
			return "success";
		}
		return "Fail";
	}
}
