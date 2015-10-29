package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AddDrinksScreen extends JFrame {
	
	public static void main(String args[]){
		String[] inp = {"a", "b","c", "d","e"};
		new AddDrinksScreen(inp, inp);
				
	}
	
	private JLabel welcomeLabel = new JLabel("Select Drinks");
	private JLabel size = new JLabel("Size");
	private JLabel type = new JLabel("Type");
	private JLabel qty = new JLabel("quantity");
	private JComboBox<String> sizeField;
	private JComboBox<String> typeField;
	private JComboBox<String> qtyField;
	private JButton addButton = new JButton("Add");
	private JButton cancelButton = new JButton("Cancel");
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
		type.setFont(newFFont);
		type.setForeground(Color.BLUE);
		qty.setFont(newFFont);
		qty.setForeground(Color.BLUE);
		sizeField.setFont(newFFont);
		typeField.setFont(newFFont);
		qtyField.setFont(newFFont);
		addButton.setFont(newFont);
		addButton.setForeground(Color.BLUE);
		cancelButton.setFont(newFont);
		cancelButton.setForeground(Color.BLUE);

	}
	
	public AddDrinksScreen(String[] size, String[] type){
		JPanel panel = new JPanel();
		this.setSize(900,500);
		this.add(panel);
		panel.setLayout(null);
		// Get from menu
		sizeField = new JComboBox<String>(size);
		typeField = new JComboBox<String>(type);
		String[] quantity = {"1","2","3","4","5"};
		qtyField = new JComboBox<String>(quantity);
		
		setBounds();
		addtoPanel(panel);
		setFonts();
		this.setTitle("Drinks view");
		this.setIconImage(new ImageIcon("C:/Users/ks_an/javaworkspace/PizzaOrderingSystem/icon2.png").getImage());
		this.setVisible(true);
	}
	
	public void setBounds(){
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(250,30,300,65);

		size.setBounds(250,100,150,35);
		sizeField.setBounds(400,100,200,35);

		type.setBounds(250,200,150,35);
		typeField.setBounds(400,200,200,35);


		qty.setBounds(250,300,150,35);
		qtyField.setBounds(400,300,200,35);


		addButton.setBounds(180,370,100,65);
		cancelButton.setBounds(500,370,150,65);
		
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
	
	public String getTypeField() {
		return (String) typeField.getSelectedItem();
	}
	
	public String getqtyField() {
		return (String) qtyField.getSelectedItem();
	}
	
	
	public void addtoPanel(JPanel panel){
		panel.add(welcomeLabel);
		panel.add(size);
		panel.add(sizeField);
		panel.add(type);
		panel.add(typeField);
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

}