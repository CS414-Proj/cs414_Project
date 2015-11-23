package a5.k414.serverControllers;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import a4.k414.model.CSUPizzaStore;


public class MainControllerForAndroid implements HttpHandler{


	public void handle(HttpExchange exchange) throws IOException {
		System.out.println("I have an error 34");

		Headers h = exchange.getRequestHeaders();
		java.net.URI uri = exchange.getRequestURI();
//		System.out.println(uri);
		String query = h.getFirst("data");
		String response = null;
		try {
			System.out.println("I have an error 35");

			response = parseQuery(query);
		} catch (ParserConfigurationException | SAXException e) {
			System.out.println("I have an error 36");

			e.printStackTrace();
		}

		//200 means the request was successful 
		exchange.sendResponseHeaders(200, response.length());
		System.out.println("I have an error 37");


		//output the information
		OutputStream os = exchange.getResponseBody();
		System.out.println("I have an error 38");

		os.write(response.getBytes());
		os.close();
	}

	private String parseQuery(String query) throws ParserConfigurationException, SAXException, IOException {
		System.out.println("I have an error 39");

		//Parse the query and send request to appropriate controller
		String[] subs = query.split("&");
		String response = null;
		String[] values = subs[0].split("=");
		System.out.println("I have an error 40");

		if (values[0].equals("query") && values[1].equals("Menu"))
		{
			System.out.println("I have an error 41");

			MenuControllerForAndroid	menuController= new MenuControllerForAndroid();
			response = menuController.getMenuXml();
		}
		else if(values[0].equals("query") && values[1].equals("Login")){
			System.out.println("I have an error 42");

			LoginControllerForAndroid logincontrollerapp = new LoginControllerForAndroid();
			String userid = null,pwd = null;
			String[] useridvalues = subs[1].split("=");
			userid = useridvalues[1];
			String[] pwdvalues = subs[2].split("=");
			pwd=pwdvalues[1];
			response = logincontrollerapp.authenticateCustomer(userid, pwd);
		}
		else if(values[0].equals("query") && values[1].equals("Register")){
			System.out.println("I have an error 43");

			System.out.println("I have an error 44");

			String[] xml = subs[1].split("=");
			RegisterControllerForAndroid rca = new RegisterControllerForAndroid();
			response=rca.registerCustomer(xml[1]);
		}
		else if(values[0].equals("query") && values[1].equals("NewOrder")){
			System.out.println("I have an error 45");

			OrderControllerForAndroid ordercontrol = new OrderControllerForAndroid();
			String stringXml = null,userId=null;
			String[] xmlValues = subs[1].split("=");
			stringXml = xmlValues[1];
			String[] useridvalues = subs[2].split("=");
			userId = useridvalues[1];
			response = ordercontrol.addNewOrder(userId,stringXml);
		}
		else if(values[0].equals("query") && values[1].equals("Payment")){
			System.out.println("I have an error 46");

			String saleNumber = null,cardDetails = null;
			String[] saleNumbervalues = subs[1].split("=");
			saleNumber = saleNumbervalues[1];
			String[] cardDetailsvalues = subs[2].split("=");
			cardDetails=cardDetailsvalues[1];
			PaymentControllerForAndroid pca = new PaymentControllerForAndroid();
			response=pca.receivePaymentDetails(saleNumber,cardDetails);
		}
		else{
			System.out.println("I have an error 47");

			response=invalidInput();
		}
		return response;
	}


	private String invalidInput() {
		System.out.println("I have an error 48");

		return "Something went wrong!!Did IT?";
	}


	public  static void main(String args[]) throws IOException{
		System.out.println("I have an error 49");

		HttpServer server = HttpServer.create(new InetSocketAddress(9000), 9000);
		MainControllerForAndroid mc = new MainControllerForAndroid();
		server.createContext("/pizzas", mc);
		server.start();
		CSUPizzaStore.getBranchInstance().startPos();
	}


}
