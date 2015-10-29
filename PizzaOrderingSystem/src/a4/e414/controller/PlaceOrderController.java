package a4.e414.controller;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import a4.e414.model.DrinksModel;
import a4.e414.model.FullMenuModel;
import a4.e414.model.PizzaModel;
import a4.e414.model.PizzaToppings;
import a4.e414.model.Sides;
import a4.e414.model.StoreOrderModel;
import a4.e414.model.TransactionModel;
import a4.e414.view.PlaceOrderScreen;

public class PlaceOrderController {

	private PlaceOrderScreen takeOrderScreen;
	private PlaceOrderController takeOrder;
	private StoreOrderModel order;
	private String user;
	private String action;
	private int yPosition = 400;
	private int subOrderId=123;

	public PlaceOrderController(String user,String ordernum, StoreOrderModel order,String action){
		this.user=user;
		this.order = order;
		this.action= action;
		this.takeOrderScreen = new PlaceOrderScreen(ordernum,action);
		this.takeOrderScreen.ButtonListner(new OrderListner());
		this.takeOrder=this;
	}

	public String addSubOrder(String order){
		JCheckBox jl = new JCheckBox(order);
		jl.setBounds(120,yPosition,400,35);
		subOrderId++;
		jl.setName(subOrderId+"");
		yPosition=yPosition+40;
		JPanel panel= takeOrderScreen.getPanel();
		panel.add(jl);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font newFFont = myFFont.deriveFont(20F);
		jl.setFont(newFFont);
		panel.revalidate();
		panel.repaint();
		return subOrderId+"";
	}

	public void addPizza(String size,String crust,String quantity,ArrayList<String> topping,String subOrderId){
		PizzaModel pizza = new PizzaModel();
		pizza.setSize(size);
		pizza.setCrust(crust);
		pizza.setQuantity(Integer.parseInt(quantity));
		pizza.setSubOrderId(subOrderId);
		for(String top: topping){
			PizzaToppings topObj = new PizzaToppings();
			topObj.setName(top);
			pizza.addToppings(topObj);
		}
		pizza.calculatecost(); // Calculate cost
		order.addPizza(pizza);
	}

	public void addSide(String size,String type,String quantity,String subOrderId){
		Sides bs = new Sides();
		bs.setSize(size);
		bs.setType(type);
		bs.setQuantity(Integer.parseInt(quantity));
		bs.setSubOrderId(subOrderId);
		bs.calculatecost();
		order.addSide(bs);
	}

	public void addDrinks(String size,String type,String quantity,String subOrderId){
		DrinksModel drinks = new DrinksModel();
		drinks.setSize(size);
		drinks.setType(type);
		drinks.setQuantity(Integer.parseInt(quantity));
		drinks.setSubOrderId(subOrderId);
		drinks.calculatecost();
		order.addDrinks(drinks);
	}

	public void deleteItem(String itemDesc,String subOrderId){
		//Delete item from order
		StringTokenizer st = new StringTokenizer(itemDesc);
		if(st.hasMoreTokens()){
			String item = st.nextToken();
			if(item.equals("Pizza-")){
				order.deletePizza(subOrderId);
			}
			else if(item.equals("Side-")){
				order.deleteSide(subOrderId);
			}
			else if(item.equals("Drinks-")){
				order.deleteDrink(subOrderId);
			}
			else if(item.equals("Special-")){
				order.setSpecialOrder(false);
			}
		}
	}


	class OrderListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==takeOrderScreen.getPizzaButton()){
				new AddPizzaController(user,takeOrder);
			}
			else if(e.getSource()==takeOrderScreen.getsideButton()){
				new AddSideOrderController(user, takeOrder);
			}
			else if(e.getSource()==takeOrderScreen.getDrinksButton()){
				new AddDrinksController(user, takeOrder);
			}
			else if(e.getSource()==takeOrderScreen.getSpecialButton()){
				FullMenuModel menu = FullMenuModel.getInstance();
				//My Edit
				if(menu.getSpecialName().equals("None")){
					JOptionPane.showMessageDialog(null,"Special is not defined; see the manager");
				}
				else{
				order.setSpecialOrder(true);
				String splOrder = "Special- "+menu.getSpecialName()+"- $"+menu.getSpecialCost();
				addSubOrder(splOrder);
				}
			}
			else if(e.getSource()==takeOrderScreen.getDeleteButton()){
				JPanel panel = takeOrderScreen.getPanel();
				JCheckBox cb;
				//Delete checked items in view
				for(Component comp: takeOrderScreen.getPanel().getComponents()){
					if(comp instanceof JCheckBox){
						cb=(JCheckBox) comp;
						if(cb.isSelected()){
							panel.remove(cb);
							deleteItem(cb.getText(),cb.getName());
						}
					}
				}
				//Reposition
				yPosition=400;
				for(Component comp: takeOrderScreen.getPanel().getComponents()){
					if(comp instanceof JCheckBox){
						comp.setBounds(120,yPosition,400,25);
						yPosition=yPosition+40;
					}
					Font myFFont = new Font("Serif", Font.PLAIN, 1);
					Font newFFont = myFFont.deriveFont(20F);
					comp.setFont(newFFont);
				}

				panel.revalidate();
				panel.repaint();
			}
			else if(e.getSource()==takeOrderScreen.getConfirmButton()){
				//Create list of all the suborders and send to chef after payment
				order.setOrderNumber(takeOrderScreen.getOrderNumField().getText());
				if(action.equals("kiosk")){
					order.setOrderType(takeOrderScreen.getOrderTypeLabel().getText());
				}
				else if(action.equals("cashier")){
					order.setOrderType((String)takeOrderScreen.getOrderTypeField().getSelectedItem());
				}
				order.setCustomerName(takeOrderScreen.getCustNameField().getText());
				order.setCustomerNum(takeOrderScreen.getCustPhField().getText());
				//My Edit
				int flag = 0;
				if(order.getCustomerName().equals("") || order.getCustomerNum().equals("")){
					JOptionPane.showMessageDialog(null,"Please input the customer details");
					flag ++;
				}
				if(order.getPizzaList().isEmpty() && order.getSideList().isEmpty() && order.getDrinksList().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please select atleast 1 pizza or 1 side or 1 drink");
					flag ++;
				}
				if(flag == 0){
				//
				takeOrderScreen.setVisible(false);
				TransactionModel sale = new TransactionModel(user,order,action);
				sale.createPayment();
				}
			}
			else if(e.getSource()==takeOrderScreen.getCancelButton()){
				takeOrderScreen.setVisible(false);
				if(action.equals("kiosk")){
					new AutomatedKioskController();
				}
				else{
					new CashierActionsController(user);
				}
			}
		}
	}

}