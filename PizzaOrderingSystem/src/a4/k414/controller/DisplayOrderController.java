package a4.k414.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import a4.k414.model.CSUPizzaStore;
import a4.k414.model.DrinksModel;
import a4.k414.model.FullMenuModel;
import a4.k414.model.PizzaModel;
import a4.k414.model.PizzaToppings;
import a4.k414.model.RegisterModel;
import a4.k414.model.Sides;
import a4.k414.model.StaffDetails;
import a4.k414.model.StoreOrderModel;
import a4.k414.model.UserLoginModel;
import a4.k414.view.DisplayOrderScreen;

public class DisplayOrderController {

	private DisplayOrderScreen orderview;
	private JPanel panel;
	private StoreOrderModel searchOrder;
	private String user;
	
	public DisplayOrderController(String user){
		this.user= user;
		this.orderview = new DisplayOrderScreen();
		this.panel = orderview.getPanel();
		this.orderview.ButtonListner(new ViewOrderListner());
	}

	class ViewOrderListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(orderview.getHomeButton())){
				String role = CSUPizzaStore.getBranchInstance().identifyStaffRole(user);
				if(role.equals("manager")){
					new ManagerActionsController(user);
				}
				else if(role.equals("cashier")){
					new CashierActionsController(user);
				}
				else if(role.equals("chef")){
					new ChefActionsController(user);
				}
				else if(user.equals("Customer")){
					new AutomatedKioskController();
				}
				orderview.setVisible(false);
			}
			else if(e.getSource().equals(orderview.getManagerCancelButton())){
				clearLabels();
				managerView();
			}
			else if(e.getSource().equals(orderview.getGetOrderButton())){
				orderview.getManagerCancelButton().setVisible(false);
				clearLabels();
				getOrder();
			}
			else if(e.getSource().equals(orderview.getCancelButton())){
				UserLoginModel lmodel = new UserLoginModel();
				StaffDetails employeeDetails=lmodel.checkCredentials(orderview.getManagerIdField().getText(), orderview.getPwdField().getText());
				if(employeeDetails==null){
					JOptionPane.showMessageDialog(null,"Invalid details");
				}
				else if (employeeDetails.getStaffRole().equals("manager")){
					RegisterModel register = RegisterModel.getInstance();
					register.removeOrder(searchOrder);
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid details");
				}
				orderview.setVisible(false);
				new DisplayOrderController(user);
			}
		}
	}
	public void managerView(){
		orderview.getManagerId().setVisible(true);
		orderview.getManagerIdField().setVisible(true);
		orderview.getPwd().setVisible(true);
		orderview.getPwdField().setVisible(true);
		orderview.getCancelButton().setVisible(true);
	}
	
	public void clearLabels(){
		for(int i=12 ; i<orderview.getPanel().getComponentCount();i++){
			panel.getComponent(i).setVisible(false);
			panel.remove(panel.getComponent(i));
		}
		panel.revalidate();
		panel.repaint();
	}

	public void getOrder(){
		RegisterModel register = RegisterModel.getInstance();
		boolean found = false;
		String orderId = orderview.getOrderIdField().getText();
		if(orderId.equals("")){
			JOptionPane.showMessageDialog(null,"Order Id is Empty");
		}
		else{
			for (StoreOrderModel order : register.getOrderList()){
				if(order.getOrderNumber().equals(orderId)){
					searchOrder = order;
					found = true;
				}
			}

			if(found){
				String tops="";
				int yPosition = 280; 
				for(PizzaModel pizza: searchOrder.getPizzaList()){
					for(PizzaToppings topping : pizza.getToppingList() ){
						tops = tops+" "+topping.getName();
					}
					String subOrder = "Pizza- "+pizza.getSize()+" "+pizza.getCrust()+" "+tops+" Qty:"+pizza.getQuantity();
					JLabel item = new JLabel(subOrder);
					Font myFFont = new Font("Serif", Font.PLAIN, 1);
					Font newFFont = myFFont.deriveFont(20F);
					item.setFont(newFFont);
					item.setBounds(340, yPosition, 400, 25);
					yPosition = yPosition+30;
					panel.add(item);

				}
				for(Sides bs : searchOrder.getSideList()){
					String subOrder = "Side- "+bs.getSize()+" "+bs.getType()+" Qty:"+bs.getQuantity();
					JLabel item = new JLabel(subOrder);
					Font myFFont = new Font("Serif", Font.PLAIN, 1);
					Font newFFont = myFFont.deriveFont(20F);
					item.setFont(newFFont);
					item.setBounds(340, yPosition, 400, 25);
					yPosition = yPosition+30;
					panel.add(item);
				}
				for(DrinksModel drinks : searchOrder.getDrinksList()){
					String subOrder = "Drinks- "+drinks.getSize()+" "+drinks.getType()+" Qty:"+drinks.getQuantity();
					JLabel item = new JLabel(subOrder);
					Font myFFont = new Font("Serif", Font.PLAIN, 1);
					Font newFFont = myFFont.deriveFont(20F);
					item.setFont(newFFont);
					item.setBounds(340, yPosition, 400, 25);
					yPosition = yPosition+30;
					panel.add(item);
				}
				if(searchOrder.isSpecialOrder()==true){
					FullMenuModel menu= FullMenuModel.getInstance();
					String spLOrder = "Special- "+menu.getSpecialName()+" "+menu.getSpecialCost();
					JLabel item = new JLabel(spLOrder);
					Font myFFont = new Font("Serif", Font.PLAIN, 1);
					Font newFFont = myFFont.deriveFont(20F);
					item.setFont(newFFont);
					item.setBounds(340, yPosition, 400, 25);
					yPosition = yPosition+30;
					panel.add(item);
				}
				orderview.getManagerCancelButton().setVisible(true);
			}
			else{
				JLabel item = new JLabel("Order Not Found");
				Font myFFont = new Font("Serif", Font.PLAIN, 1);
				Font newFFont = myFFont.deriveFont(20F);
				item.setFont(newFFont);
				item.setBounds(340, 280, 400, 25);
				item.setVisible(true);
				panel.add(item);
			}
			
			panel.revalidate();
			panel.repaint();
		}
	}

}