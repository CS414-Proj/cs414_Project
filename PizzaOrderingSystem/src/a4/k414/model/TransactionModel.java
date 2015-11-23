package a4.k414.model;

public class TransactionModel {

	private String transNumber;
	private float totalAmount;
	private StoreOrderModel order;
	private PaymentModel payment;
	
	private String user;
	private float subTotal;
	private float tax;
	private String action;
	RegisterModel register = RegisterModel.getInstance();


	public TransactionModel(String user,StoreOrderModel order,String action){
		this.order=order;
		transNumber = register.getNextTransactionNumber();
		
		//calculate total,tax,balancedue
		this.subTotal = subtotal();
		this.tax = tax(subTotal);
		this.totalAmount = subTotal+tax;
		this.transNumber = register.getNextTransactionNumber();
		this.user = user;
		this.action = action;
		
		
	}
	public PaymentModel createPayment(){
		this.payment=new PaymentModel(this,user,subTotal,tax,totalAmount,order.getOrderNumber()+"",action);
		return payment;		
	}

	public void addtoReg(){
		register.addTrans(this);
		register.addOrder(order);
	}
	
	public float subtotal(){
		float subtotal=0;
		for(PizzaModel pizza: order.getPizzaList()){
			subtotal=subtotal+(pizza.getCost()*pizza.getQuantity());
		}
		for(Sides side: order.getSideList()){
			subtotal=subtotal+(side.getCost()*side.getQuantity());
		}
		for(DrinksModel drinks: order.getDrinksList()){
			subtotal=subtotal+(drinks.getCost()*drinks.getQuantity());
		}
		if(order.isSpecialOrder()){
			subtotal=subtotal+FullMenuModel.getInstance().getSpecialCost();
		}
		return subtotal;
	}


	public String getTransNumber() {
		return transNumber;
	}
	
	public StoreOrderModel getOrder() {
		return order;
	}

	public PaymentModel getPayment() {
		return payment;
	}

	public String getAction() {
		return action;
	}

	public RegisterModel getRegister() {
		return register;
	}
	
	public float tax(float subtotal){
		float tax = (subtotal*register.getTax())/100;
		return tax;
	}
	
	public String getUser() {
		return user;
	}
}
