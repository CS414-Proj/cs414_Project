package a4.e414.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import a4.e414.model.RegisterModel;
import a4.e414.view.ChefActionsScreen;

public class ChefActionsController {

	private ChefActionsScreen chefview;
	private String user;

	public ChefActionsController(String user){
		this.user= user;
		this.chefview = new ChefActionsScreen(user);
		this.chefview.ButtonListner(new ChefListner());
	}

	class ChefListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(chefview.getLogoutButton())){
				new UserLoginController();
				chefview.setVisible(false);
			}
			else if(e.getSource().equals(chefview.getManagerButton())){
				new DisplayOrderController(user);
			}
			else if(e.getSource().equals(chefview.getOrderCompleteButton())){
				//Check if all checked
				boolean orderFinished= true;
				JCheckBox cb;
				JPanel panel = chefview.getPanel();
				for(Component comp : panel.getComponents()){
					if(comp instanceof JCheckBox){
						cb=(JCheckBox)comp;
						if(!cb.isSelected()){
							orderFinished= false;
							JOptionPane.showMessageDialog(null,"Order Not complete");
							break;
						}
					}
				}
				//remove current order & show next order
				if(orderFinished){
					RegisterModel.getInstance().removeOrder(RegisterModel.getInstance().getOrderList().get(0));
					new ChefActionsController(user);
				}
			}
			// scc 
			else if(e.getSource().equals(chefview.getBackButton())) 
		        {
				 	chefview.setVisible(false);
		        	new ChefActionsController(user);
		        }
		}
	}

}
