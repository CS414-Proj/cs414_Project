package a4.e414.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import a4.e414.model.FullMenuModel;
import a4.e414.model.PizzaModel;
import a4.e414.model.DrinksModel;
import a4.e414.model.Sides;
import a4.e414.model.StoreOrderModel;
import a4.e414.model.PizzaToppings;
import a4.e414.view.CreateSpecialScreen;

public class CreateSpecialController {

	CreateSpecialScreen setSpecialScreen;
	CreateSpecialController setSpecial;
	StoreOrderModel splOrder;
	String user;
	private int yPosition = 520;
	private int subOrderId=123;
	private boolean pizzaSet = false;
	private boolean sideSet = false;
	private boolean drinksSet = false;

	public CreateSpecialController(String user){
		this.user=user;
		this.splOrder = new StoreOrderModel();
		splOrder.setOrderNumber("999");
		this.setSpecialScreen = new CreateSpecialScreen();
		this.setSpecialScreen.ButtonListner(new SetspecialListner());
		this.setSpecial=this;
	}

	public String addSubOrder(String order){
		JLabel jl = new JLabel(order);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font newFFont = myFFont.deriveFont(20F);
		jl.setFont(newFFont);
		jl.setBounds(200,yPosition,400,35);
		subOrderId++;
		jl.setName(subOrderId+"");
		yPosition=yPosition+30;
		JPanel panel= setSpecialScreen.getPanel();
		panel.add(jl);
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
		pizzaSet = true;
		splOrder.addPizza(pizza);
	}

	public void addside(String size,String type,String quantity,String subOrderId){
		Sides bs = new Sides();
		bs.setSize(size);
		bs.setType(type);
		bs.setQuantity(Integer.parseInt(quantity));
		bs.setSubOrderId(subOrderId);
		bs.calculatecost();
		sideSet = true;
		splOrder.addSide(bs);
	}

	public void addDrinks(String size,String type,String quantity,String subOrderId){
		DrinksModel drinks = new DrinksModel();
		drinks.setSize(size);
		drinks.setType(type);
		drinks.setQuantity(Integer.parseInt(quantity));
		drinks.setSubOrderId(subOrderId);
		drinks.calculatecost();
		drinksSet = true;
		splOrder.addDrinks(drinks);
	}


	class SetspecialListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==setSpecialScreen.getPizzaButton()){
				new AddPizzaController(user,setSpecial);
			}
			else if(e.getSource()==setSpecialScreen.getsideButton()){
				new AddSideOrderController(user, setSpecial);
			}
			else if(e.getSource()==setSpecialScreen.getDrinksButton()){
				new AddDrinksController(user, setSpecial);
			}
			else if(e.getSource()==setSpecialScreen.getConfirmButton()){
				String splName = setSpecialScreen.getSplNameField().getText();
				String splcost = setSpecialScreen.getSplCostField().getText();
				float cost = 0;
				boolean flag=true;
				try
				{
					cost = Float.parseFloat(splcost);
				}
				catch(NumberFormatException error)
				{
					flag = false;
				}
				if(splName.equals("") || flag==false)
				{
					JOptionPane.showMessageDialog(null,"Invalid inputs given..!!!");
				}
				else if(pizzaSet==false && sideSet==false && drinksSet==false){		//My Edit
					JOptionPane.showMessageDialog(null,"Select atleast 1 Pizza,1 side,1 Drink");
				}
				else{
					// Add spl to menu
					FullMenuModel menu = FullMenuModel.getInstance();
					menu.setSpecialName(splName);
					menu.setSpecialCost(cost);
					menu.setSpecialOrder(splOrder);
					setSpecialScreen.setVisible(false);
					new ManagerActionsController(user);
				}
				
			}
			else if(e.getSource()==setSpecialScreen.getViewSplButton()){
				setSpecialScreen.setVisible(false);
				new DisplaySpecialController(user);
			}
			else if(e.getSource()==setSpecialScreen.getCancelButton()){
				setSpecialScreen.setVisible(false);
				new ManagerActionsController(user);
			}
		}
	}

}
