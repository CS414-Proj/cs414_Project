package a4.k414.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import a4.k414.model.FullMenuModel;
import a4.k414.view.DisplaySideOrderScreen;

public class AddSideOrderController {

	private DisplaySideOrderScreen viewSideOrderScreen;
	private PlaceOrderController takeOrder;
	private CreateSpecialController setSpecial;
	private String user;
	private String action = "none";

	public AddSideOrderController(String user, PlaceOrderController takeOrder){
		this.user=user;
		FullMenuModel menu = FullMenuModel.getInstance();
		this.viewSideOrderScreen = new DisplaySideOrderScreen(menu.getBsSizeArray(),menu.getBsTypeArray());
		this.viewSideOrderScreen.ButtonListner(new SideStickOrderListner());
		this.takeOrder=takeOrder;
		action="takeOrder";
	}
	
	public AddSideOrderController(String user, CreateSpecialController setSpecial){
		this.user=user;
		FullMenuModel menu = FullMenuModel.getInstance();
		this.viewSideOrderScreen = new DisplaySideOrderScreen(menu.getBsSizeArray(),menu.getBsTypeArray());
		this.viewSideOrderScreen.ButtonListner(new SideStickOrderListner());
		this.setSpecial=setSpecial;
		action="setSpecial";
	}
	
	class SideStickOrderListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==viewSideOrderScreen.getAddButton()){
				String size = viewSideOrderScreen.getsizeField();
				String type = viewSideOrderScreen.getTypeField();
				String quantity = viewSideOrderScreen.getqtyField();
				// scc
				if(size == null || type == null || quantity == null){
					JOptionPane.showMessageDialog(null,"Select the Side size, type and quantity \n If menu is not defined see the manager");
				}
				else{
				String subOrder = "Side- "+size+" "+type+" Qty:"+quantity;
				if(action.equals("takeOrder")){
					String subOrderId=takeOrder.addSubOrder(subOrder);
					takeOrder.addSide(size, type, quantity,subOrderId);
				}
				else if(action.equals("setSpecial")){
					String subOrderId=setSpecial.addSubOrder(subOrder);
					setSpecial.addside(size, type, quantity,subOrderId);
				}
				viewSideOrderScreen.setVisible(false);
				}
			}
			else if(e.getSource()==viewSideOrderScreen.getCancelButton()){
				viewSideOrderScreen.setVisible(false);
			}
		}
	}

}
