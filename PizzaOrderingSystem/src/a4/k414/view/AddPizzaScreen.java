package a4.k414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AddPizzaScreen extends JFrame {
	
	
	public static void main(String args[]){
		String[] inp = {"a", "b","c", "d","e"};
		new AddPizzaScreen(inp, inp, inp);
				
	}
	
	private JLabel welcomeLabel = new JLabel("Select Pizza");
	private JLabel size = new JLabel("Size");
	private JLabel crust = new JLabel("Crust");
	private JLabel topppings = new JLabel("Toppings");
	private JLabel qty = new JLabel("quantity");
	private JComboBox<String> sizeField;
	private JComboBox<String> crustField;
	private JComboBox<String> qtyField;
	private JButton addButton = new JButton("Add");
	private JButton cancelButton = new JButton("Cancel");
	private JPanel panel = new JPanel();
	private String errorMsg = "Error... Try Again";
	
	
	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFont = myTFont.deriveFont(30F);
		Font newFFont = myFFont.deriveFont(30F);
		welcomeLabel.setFont(tNewFont);
		welcomeLabel.setForeground(Color.RED);
		size.setFont(newFFont);
		size.setForeground(Color.BLUE);
		crust.setFont(newFFont);
		crust.setForeground(Color.BLUE);
		topppings.setFont(newFFont);
		topppings.setForeground(Color.BLUE);
		qty.setFont(newFFont);
		qty.setForeground(Color.BLUE);
		sizeField.setFont(newFFont);
		crustField.setFont(newFFont);
		qtyField.setFont(newFFont);
		addButton.setFont(newFont);
		addButton.setForeground(Color.BLUE);
		cancelButton.setFont(newFont);
		cancelButton.setForeground(Color.BLUE);

	}
	
	
	
	
	public AddPizzaScreen(String[] size, String[] crust,String[] toppings){
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		this.add(panel);
		panel.setLayout(null);
		sizeField = new JComboBox<String>(size);
		crustField = new JComboBox<String>(crust);
		String[] quantity = {"1","2","3","4","5"};
		qtyField = new JComboBox<String>(quantity);
		setBounds();
		addtoPanel();
		// Get from menu
		addToppings(toppings);
		setFonts();
		this.setTitle("Pizza menu view");
		this.setIconImage(new ImageIcon("C:/Users/ks_an/javaworkspace/PizzaOrderingSystem/icon2.png").getImage());
		this.setVisible(true);
	}
	public void addToppings(String[] toppings){
		int x=120,y=350,count=1;
		for(String top: toppings){
			JCheckBox toppingCheckbox = new JCheckBox(top);
			toppingCheckbox.setBounds(x,y,150,25);
			Font myFFont = new Font("Serif", Font.PLAIN, 1);
			Font newFFont = myFFont.deriveFont(30F);
			toppingCheckbox.setFont(newFFont);
			panel.add(toppingCheckbox);
			x=x+170;
			if(count%4==0){
				y=y+40;
				x=120;
			}
			count++;
		}
	}
	public void setBounds(){
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(250,30,300,65);
		
		size.setBounds(250,120,150,35);
		sizeField.setBounds(400,120,100,35);
		
		crust.setBounds(250,200,100,35);
		crustField.setBounds(400,200,100,35);
		
		topppings.setBounds(120,300,150,35);
				
		qty.setBounds(250,700,150,35);
		qtyField.setBounds(400,700,100,35);
		
		
		addButton.setBounds(180,870,200,65);
		cancelButton.setBounds(500,870,200,65);
		
	}
	public JButton getAddButton() {
		return addButton;
	}

	
	public JButton getCancelButton() {
		return cancelButton;
	}


	public String getsizeField() {
		return (String) sizeField.getSelectedItem();
	}
	
	public String getcrustField() {
		return (String) crustField.getSelectedItem();
	}
	
	public String getqtyField() {
		return (String) qtyField.getSelectedItem();
	}
	
	public void addtoPanel(){
		panel.add(welcomeLabel);
		panel.add(size);
		panel.add(sizeField);
		panel.add(crust);
		panel.add(crustField);
		panel.add(topppings);
		panel.add(qty);
		panel.add(qtyField);
		panel.add(addButton);
		panel.add(cancelButton);
	}
	
		
	public void ButtonListner(ActionListener l){
		addButton.addActionListener(l);
		cancelButton.addActionListener(l);
	}
	
	
	public void errorMsg(){
		JOptionPane.showMessageDialog(this,errorMsg);
	}
	public JPanel getPanel() {
		return panel;
	}

}