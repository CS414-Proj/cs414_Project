package a4.k414.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import a4.k414.view.ManagerActionsScreen;

public class ManagerActionsController 
{
	private ManagerActionsScreen homeScreenManager;
	private String user;
	
	public ManagerActionsController(String user)
	{
		this.user=user;
		this.homeScreenManager = new ManagerActionsScreen(user);
		this.homeScreenManager.ButtonListener(new ManagerHomeActionListener());
	}

	class ManagerHomeActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton tempButton = (JButton)e.getSource();
		    			
			if(tempButton.equals(homeScreenManager.getDefineMenuButton()))
	        {
				new CreateMenuController(user);
				homeScreenManager.setVisible(false);
	        }
	        else if(tempButton.equals(homeScreenManager.getEditMenuButton())) 
	        {
	        	new ManageMenuController(user);
	        	homeScreenManager.setVisible(false);
	        }
	        else if(tempButton.equals(homeScreenManager.getSetSpecialButton())) 
	        {
	        	homeScreenManager.setVisible(false);
	        	new CreateSpecialController(user);
	        }
	        else if(tempButton.equals(homeScreenManager.getViewOrderButton())) 
	        {
	        	homeScreenManager.setVisible(false);
	        	new DisplayOrderController(user);
	        }
	        else if(tempButton.equals(homeScreenManager.getLogoutButton())) 
	        {
	        	homeScreenManager.setVisible(false);
	        	new UserLoginController();
	        }
		}
	}
} 
