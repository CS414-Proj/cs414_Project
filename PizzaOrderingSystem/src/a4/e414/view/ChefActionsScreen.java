package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import a4.e414.model.FullMenuModel;
import a4.e414.model.PizzaModel;
import a4.e414.model.DrinksModel;
import a4.e414.model.RegisterModel;
import a4.e414.model.Sides;
import a4.e414.model.StoreOrderModel;
import a4.e414.model.PizzaToppings;

@SuppressWarnings("serial")
public class ChefActionsScreen extends JFrame {

	private JLabel welcomeLabelChefView;
	private JLabel currentOrder;
	private JLabel nextOrder; //My Edit
	private JButton orderCompleteButton = new JButton("Order Complete");
	private JButton managerButton = new JButton("Manager overide");
	private JButton logoutButton = new JButton("Log Out");
	private JPanel panel = new JPanel();
	private String errorMsg = "Invalid Login Details...";
	private JButton backButton = new JButton("Refresh");	//My Edit
	
	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFont = myTFont.deriveFont(30F);
		Font newFFont = myFFont.deriveFont(20F);
		welcomeLabelChefView.setFont(newFont);
		welcomeLabelChefView.setForeground(Color.RED);
		currentOrder.setFont(newFFont);
		currentOrder.setForeground(Color.BLUE);
		orderCompleteButton.setFont(newFFont);
		managerButton.setFont(newFFont);
		logoutButton.setFont(newFFont);
		backButton.setFont(newFFont);
	}
	
	public ChefActionsScreen(String user){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		this.add(panel);
		welcomeLabelChefView = new JLabel("Welcome "+user);
		panel.setLayout(null);
		setView();
		this.setVisible(true);
		setFonts();
	}

	public void setView(){
		RegisterModel register = RegisterModel.getInstance();
		if(register.getOrderList().size()==0){
			currentOrder = new JLabel("No Orders");
		}
		else{
			currentOrder = new JLabel("Current Order:");
			StoreOrderModel order = register.getOrderList().get(0);
			String tops="";
			int yPosition = 100; 
			JLabel orderNum = new JLabel("Order Number : "+order.getOrderNumber());
			Font myFFont = new Font("Serif", Font.PLAIN, 1);
			Font newFFont = myFFont.deriveFont(20F);
			orderNum.setFont(newFFont);
			orderNum.setBounds(100, yPosition, 200, 25);
			yPosition = yPosition+80;
			panel.add(orderNum);
			for(PizzaModel pizza: order.getPizzaList()){
				for(PizzaToppings topping : pizza.getToppingList() ){
					tops = tops+" "+topping.getName();
				}
				String subOrder = "Pizza- "+pizza.getSize()+" "+pizza.getCrust()+" "+tops+" Qty:"+pizza.getQuantity();
				JCheckBox item = new JCheckBox(subOrder);
				item.setBounds(100, yPosition, 400, 25);
				yPosition = yPosition+30;
				panel.add(item);

			}
			for(Sides bs : order.getSideList()){
				String subOrder = "Side- "+bs.getSize()+" "+bs.getType()+" Qty:"+bs.getQuantity();
				JCheckBox item = new JCheckBox(subOrder);
				item.setBounds(100, yPosition, 400, 25);
				yPosition = yPosition+30;
				panel.add(item);
			}
			for(DrinksModel drinks : order.getDrinksList()){
				String subOrder = "Drinks- "+drinks.getSize()+" "+drinks.getType()+" Qty:"+drinks.getQuantity();
				JCheckBox item = new JCheckBox(subOrder);
				item.setBounds(100, yPosition, 400, 25);
				yPosition = yPosition+30;
				panel.add(item);
			}
			if(order.isSpecialOrder()==true){
				FullMenuModel menu= FullMenuModel.getInstance();
				String spLOrder = "Special- "+menu.getSpecialName()+" "+menu.getSpecialCost();
				JCheckBox item = new JCheckBox(spLOrder);
				item.setBounds(100, yPosition, 400, 25);
				yPosition = yPosition+30;
				panel.add(item);
			}
			orderCompleteButton.setBounds(100, yPosition+80, 200,85);
			managerButton.setBounds(400, yPosition+80, 200,85);
			panel.add(orderCompleteButton);
			panel.add(managerButton);
		}
		//My Edit
				int count = 0;
				for(int i=1;i<register.getOrderList().size();i++){
					nextOrder = new JLabel("Next Orders:");
					StoreOrderModel order = register.getOrderList().get(i);
					String tops="";
					int yPosition = 500+((count+1)*30); 
					JLabel orderNum = new JLabel("Order Number : "+order.getOrderNumber());
					count++;
					Font myFFont = new Font("Serif", Font.PLAIN, 1);
					Font newFFont = myFFont.deriveFont(20F);
					orderNum.setFont(newFFont);
					orderNum.setBounds(100, yPosition, 200, 25);
					yPosition = yPosition+30;
					panel.add(orderNum);
					for(PizzaModel pizza: order.getPizzaList()){
						count++;
						for(PizzaToppings topping : pizza.getToppingList() ){
							tops = tops+" "+topping.getName();
						}
						String subOrder = "Pizza- "+pizza.getSize()+" "+pizza.getCrust()+" "+tops+" Qty:"+pizza.getQuantity();
						JLabel item = new JLabel(subOrder);
						item.setBounds(100, yPosition, 400, 25);
						yPosition = yPosition+30;
						panel.add(item);

					}
					for(Sides bs : order.getSideList()){
						count++;
						String subOrder = "Side- "+bs.getSize()+" "+bs.getType()+" Qty:"+bs.getQuantity();
						JLabel item = new JLabel(subOrder);
						item.setBounds(100, yPosition, 400, 25);
						yPosition = yPosition+30;
						panel.add(item);
					}
					for(DrinksModel drinks : order.getDrinksList()){
						count++;
						String subOrder = "Drinks- "+drinks.getSize()+" "+drinks.getType()+" Qty:"+drinks.getQuantity();
						JLabel item = new JLabel(subOrder);
						item.setBounds(100, yPosition, 400, 25);
						yPosition = yPosition+30;
						panel.add(item);
					}
					if(order.isSpecialOrder()==true){
						count++;
						FullMenuModel menu= FullMenuModel.getInstance();
						String spLOrder = "Special- "+menu.getSpecialName()+" "+menu.getSpecialCost();
						JLabel item = new JLabel(spLOrder);
						item.setBounds(100, yPosition, 400, 25);
						yPosition = yPosition+30;
						panel.add(item);
					}			
				}
		welcomeLabelChefView.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabelChefView.setVerticalAlignment(SwingConstants.CENTER);
		welcomeLabelChefView.setBounds(350,20, 300,85);
		currentOrder.setBounds(100, 60, 200,25);
		logoutButton.setBounds(400, 830, 200,85);
		backButton.setBounds(100,830,150,85);	//My Edit
		panel.add(welcomeLabelChefView);
		panel.add(currentOrder);
		panel.add(backButton);	//My Edit
		panel.add(logoutButton);
	}
	
	public void setWelcomeLabel(JLabel welcomeLabel) {
		this.welcomeLabelChefView = welcomeLabel;
	}

	public void setCurrentOrder(JLabel currentOrder) {
		this.currentOrder = currentOrder;
	}

	public void setOrderCompleteButton(JButton orderCompleteButton) {
		this.orderCompleteButton = orderCompleteButton;
	}

	public void setManagerButton(JButton managerButton) {
		this.managerButton = managerButton;
	}

	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public JLabel getWelcomeLabel() {
		return welcomeLabelChefView;
	}

	public JLabel getCurrentOrder() {
		return currentOrder;
	}

	public JButton getOrderCompleteButton() {
		return orderCompleteButton;
	}

	public JButton getManagerButton() {
		return managerButton;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}

	public JPanel getPanel() {
		return panel;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	//My Edit
	public JButton getBackButton() {
		return backButton;
	}

	public void ButtonListner(ActionListener l){
		logoutButton.addActionListener(l);
		managerButton.addActionListener(l);
		orderCompleteButton.addActionListener(l);
		backButton.addActionListener(l);	//My Edit
	}

	public void errorMsg(){
		JOptionPane.showMessageDialog(this,errorMsg);
	}

}
