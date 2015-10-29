package a4.e414.model;

public class TransactionModel {

	private String saleNumber;
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
		saleNumber = register.getNextSaleNumber();
		
		//calculate total,tax,balancedue
		this.subTotal = subtotal();
		this.tax = tax(subTotal);
		this.totalAmount = subTotal+tax;
		this.saleNumber = register.getNextSaleNumber();
		this.user = user;
		this.action = action;
		
		
	}
	public void createPayment(){
		this.payment=new PaymentModel(this,user,subTotal,tax,totalAmount,order.getOrderNumber()+"",action);
	}

	public void addtoReg(){
		// Save to register after payment successful
		register.addSale(this);
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

	public float tax(float subtotal){
		float tax = (subtotal*register.getTax())/100;
		return tax;
	}
}
