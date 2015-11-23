package a5.k414.serverControllers;

import a4.k414.model.CustomerModel;
import a4.k414.model.UserLoginModel;

public class LoginControllerForAndroid{

	public String authenticateCustomer(String userid,String pwd){
		UserLoginModel lm = new UserLoginModel();
		XmlCreator xc = new XmlCreator();
		Object obj = lm.authenticate(userid,pwd);
		if(obj instanceof CustomerModel){
			CustomerModel customer = (CustomerModel) obj;
			String splOrder =xc.splOrderXml();
			return customer.getUserId()+" "+customer.getFirstname()+" "+splOrder;
		}
		return "Invalid";
	}
}

