package a5.serverControllers;



import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import a4.k414.model.CSUPizzaStore;
import a4.k414.model.CustomerModel;




public class RegisterControllerForAndroid{

	public String registerCustomer(String registerXml) throws ParserConfigurationException, SAXException, IOException{
		CustomerModel customer = parseRegisterXml(registerXml);
		XmlCreator xc = new XmlCreator();
		CSUPizzaStore ps = CSUPizzaStore.getBranchInstance();
		ps.addCustomertoList(customer);
		String splOrder =xc.splOrderXml();
		return customer.getUserId()+" "+customer.getFirstname()+" "+splOrder;
	}

	private CustomerModel parseRegisterXml(String stringXml) throws ParserConfigurationException, SAXException, IOException{

		InputSource source = new InputSource(new StringReader(stringXml));

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(source);

		NodeList register = doc.getElementsByTagName("register");
		Element registerElement = (Element) register.item(0);

		NodeList nameList = registerElement.getElementsByTagName("name");
		String name=nameList.item(0).getTextContent();

		NodeList phoneNumList = registerElement.getElementsByTagName("phoneNum");
		String phoneNum=phoneNumList.item(0).getTextContent();

		NodeList userIdList = registerElement.getElementsByTagName("userId");
		String userId=userIdList.item(0).getTextContent();

		NodeList pwdList = registerElement.getElementsByTagName("pwd");
		String pwd=pwdList.item(0).getTextContent();
		
		CustomerModel c = new CustomerModel();
		c.setFirstname(name);
		c.setPhoneNum(phoneNum);
		c.setPassword(pwd);
		c.setUserId(userId);
		
		return c;
	}

}
