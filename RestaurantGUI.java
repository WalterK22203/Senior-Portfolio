//Final Project By Kevin Walter Conejo Molina
import javax.swing.JFrame;
import javax.swing.JLabel; 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantGUI extends JFrame implements ActionListener{
	JLabel restaurantname, FirstnameLabel,LastnameLabel,greetingslabel,partynumber,menulabel,desertsLabel,bevarageslabel, menupayment, BillSumarry,
	cardNumeberLabel,cardMonthLabel,cardYearLabel,emailcostumerLabel;
	JTextField FirstNameTextField,LastnameTextField,tablenumber,partytext,emailcostumerTextfield,carNumberTextField, cardMonthTextField, 
				cardYearTextField;
	JPanel northPanel,northPanel2,northPanelMenu,northPanelPayment, westpanelMenu,
			westpanelMenu2,westpanelPayment,southPanel,southPanel2, centerPanelMenu,centerPanelMenu2,eastpanelMenu,
			centerpanelPayment,southPanelPayment,eastPanelPayment;
	JTextArea commentArea;
	JCheckBox antipastoCheck, pastaCheck, pizzaCheck, saladCheck,cakeCheck,icecreamCheck,pieCheck,sodaCheck,waterCheck,iceteaCheck;
	JComboBox pizzabox,antipastobox,pastabox,saladbox, cakebox,icecreambox,piebox;
	JRadioButton dineinOption,takeoutOption ;
	ButtonGroup dinnerGroup;
	JButton PlaceOrderButton,gobackbutton,Paybutton,CancelButton; 
	String fullnamecostumer,antipastoname, pastaname, pizzaname, saladname, cakename, icecreamname, piename, sodaname, watername,iceteaname,
			pizzaboxname,antipastoboxname,saladboxname, cakeboxname, icecreamboxname,pieboxname,BillSumarryOut;
	JFrame menuWindowDine;
	 
	
	public RestaurantGUI() {
		
		super("Mangioamo Ristorante");
		
		restaurantname = new JLabel("Mangiamo Ristorante");
		restaurantname.setFont(new Font("Algerian", Font.PLAIN, 30));
		
		FirstnameLabel = new JLabel("Enter First Name: ");
		FirstnameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		FirstNameTextField = new JTextField(5);
		LastnameLabel = new JLabel("Enter Last Name: ");
		LastnameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		LastnameTextField = new JTextField(5);
		
		northPanel = new JPanel();
		northPanel2 = new JPanel();
		
		northPanel.add(restaurantname);
		northPanel.add(FirstnameLabel);
		northPanel.add(FirstNameTextField);
		northPanel.add(LastnameLabel);
		northPanel.add(LastnameTextField);
		northPanel2.add(northPanel);
		northPanel.setLayout(new GridLayout(6, 1));
		add(northPanel2,BorderLayout.NORTH);
		
		menulabel = new JLabel("Menu");
		menulabel.setFont(new Font("Algerian", Font.PLAIN, 18));
		antipastoCheck = new JCheckBox("Antipasto");
		antipastoCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		pastaCheck = new JCheckBox("Pasta");
		pastaCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		pizzaCheck = new JCheckBox("Pizza");
		pizzaCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		saladCheck = new JCheckBox("Salad");
		saladCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		
		String antipastoOpt [] = {"", "Calamari Fritti", "Bruschetta Fantastica","Romanian Garlic Bread"};
		double antipastoPrice [] = {0,10.1,12,11.1};
	    antipastobox = new JComboBox(antipastoOpt);
		
	    String pastaOpt [] = {"", "Chicken Fettuccine Alfredo","Shrip Ravioli","Spaghetti Bolognese"};
	    double pastaPrice [] = {0,10.1,12,11.1};
	    pastabox = new JComboBox(pastaOpt);
	    
	    String pizzaOpt [] = {"", "Margarita", "Pepperoni Deluxe","Veggie Ultimate"};
	    double pizzaPrice [] = {0,10.1,12,11.1};
	    pizzabox = new JComboBox(pizzaOpt);
	    
	    String saladOpt [] = {"", "Greek Getaway", "Caesar Paradise"};
	    double saladPrice [] = {0,10.1,12,11.1};
	    saladbox = new JComboBox(saladOpt);
	  
	    centerPanelMenu = new JPanel();
	    centerPanelMenu.setLayout(new GridLayout(10, 20));
	    centerPanelMenu2 = new JPanel();
		
	    centerPanelMenu.add(menulabel);
	    centerPanelMenu.add(antipastoCheck);
	    centerPanelMenu.add(antipastobox);
	    centerPanelMenu.add(pastaCheck);
	    centerPanelMenu.add(pastabox);
	    centerPanelMenu.add(pizzaCheck);
	    centerPanelMenu.add(pizzabox);
	    centerPanelMenu.add(saladCheck);
	    centerPanelMenu.add(saladbox);
	    centerPanelMenu2.add(centerPanelMenu);
		add(centerPanelMenu2, BorderLayout.CENTER);
		
		westpanelMenu = new JPanel();
		westpanelMenu.setLayout(new GridLayout(7, 1));
		westpanelMenu2 = new JPanel();
		
		desertsLabel = new JLabel("Deserts");
		desertsLabel.setFont(new Font("Algerian", Font.PLAIN, 18));
		cakeCheck = new JCheckBox("Cake");
		cakeCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		icecreamCheck = new JCheckBox("Ice Cream");
		icecreamCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		pieCheck = new JCheckBox("Pie");
		pieCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		
		String cakeOpt [] = {"", "Carrot", "Chocolate","Red Velvelt"};
		double cakePrice [] = {0,10.1,12,11.1};
	    cakebox = new JComboBox(cakeOpt);
		
	    String icecreamOpt [] = {"", "Chocolate", "Vanilla","Strawberry"};
	    double icecreamPrice [] = {0,10.1,12,11.1};
	    icecreambox = new JComboBox(icecreamOpt);
		
	    String pieOpt [] = {"", "Lemon", "Apple","Pumpkin"};
	    double piePrice [] = {0,10.1,12,11.1};
	    piebox = new JComboBox(pieOpt);
		
		westpanelMenu.add(desertsLabel);
		westpanelMenu.add(cakeCheck);
		westpanelMenu.add(cakebox);
		westpanelMenu.add(icecreamCheck);
		westpanelMenu.add(icecreambox);
		westpanelMenu.add(pieCheck);
		westpanelMenu.add(piebox);
		westpanelMenu2.add(westpanelMenu);
		add(westpanelMenu2, BorderLayout.WEST);
		
		bevarageslabel = new JLabel("Bevarages");
		bevarageslabel.setFont(new Font("Algerian", Font.PLAIN, 18));
		
		sodaCheck = new JCheckBox("Soda (Can)");
		sodaCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		
		waterCheck = new JCheckBox("Water ");
		waterCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		
		
		iceteaCheck = new JCheckBox("Ice Tea ");
		iceteaCheck.setFont(new Font("Algerian", Font.PLAIN, 15));
		
		eastpanelMenu = new JPanel();
		
		eastpanelMenu.add(bevarageslabel);
		eastpanelMenu.add(sodaCheck);
		eastpanelMenu.add(waterCheck);
		eastpanelMenu.add(iceteaCheck);
		eastpanelMenu.setLayout(new GridLayout(4, 1));
		add(eastpanelMenu, BorderLayout.EAST);
		
		
		dineinOption = new JRadioButton("Dine-in");

		takeoutOption = new JRadioButton("Takeout");
		
		PlaceOrderButton = new JButton("Place Order");
		PlaceOrderButton.addActionListener(this);
		

		dinnerGroup = new ButtonGroup();
		dinnerGroup.add(dineinOption);
		dinnerGroup.add(takeoutOption);
		southPanel = new JPanel();
		
		southPanel.add(dineinOption);
		southPanel.add(takeoutOption);
		southPanel.add(PlaceOrderButton);
		southPanel2 = new JPanel();
		
		
		 southPanel2.add(southPanel);
		add(southPanel, BorderLayout.SOUTH);

		
		setVisible(true);
		setSize(1100, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	 public void actionPerformed(ActionEvent event) {
		if(event.getSource()== PlaceOrderButton ) {
			menuWindowDine = new JFrame("Mangiamo Ristorante Payment");
			String firstname = FirstNameTextField.getText();
			String Lastname = LastnameTextField.getText() ;
			fullnamecostumer = firstname + " "+ Lastname;
			
			String antipastoOutput = "";
			if(antipastoCheck.isSelected())
				antipastoOutput = "Antipasto: ";
			String antipastoBoxOutput = antipastobox.getSelectedItem().toString();
			
			String pastaOutput = "";
			if(pastaCheck.isSelected())
				pastaOutput = "Pasta: ";
			String pastaBoxOutput = pastabox.getSelectedItem().toString();
			
			String pizzaOutput = "";
			if(pizzaCheck.isSelected())
				pizzaOutput = "Pizza: ";
			String pizzaBoxOutput = pizzabox.getSelectedItem().toString();
			
			String saladOutput = "";
			if(saladCheck.isSelected())
				saladOutput = "Salad: ";
			String saladBoxOutput = saladbox.getSelectedItem().toString();
		
			String cakeOutput = "";
			if(cakeCheck.isSelected())
				cakeOutput = "Cake: ";
			String cakeBoxOutput = cakebox.getSelectedItem().toString();
			
			String icecreamOutput = "";
			if(icecreamCheck.isSelected())
				icecreamOutput = "Ice cream: ";
			String icecreamBoxOutput = icecreambox.getSelectedItem().toString();
			
			String pieOutput = "";
			if(pieCheck.isSelected())
				pieOutput = "Pie: ";
			String pieBoxOutput = piebox.getSelectedItem().toString();
			
			String sodaOutput = "";
			if(sodaCheck.isSelected())
				sodaOutput = sodaCheck.getText();;
			
			String waterOutput = "";
			if(waterCheck.isSelected())
				waterOutput = waterCheck.getText();
			
			String iceteaOutput = "";
			if(iceteaCheck.isSelected())
				iceteaOutput = iceteaCheck.getText();
			
			String dinneroptiongroup = "";
			if (dineinOption.isSelected())
				dinneroptiongroup = "Dine-in";
			else if (takeoutOption.isSelected())
				dinneroptiongroup = "Takeout";
			
			
            BillSumarry = new JLabel("<html>" + dinneroptiongroup+ "<br>"+
            						antipastoOutput +antipastoBoxOutput+"<br>"+pastaOutput +pastaBoxOutput +"<br>"+ pizzaOutput +
            						pizzaBoxOutput+"<br>"+ saladOutput+saladBoxOutput+"<br>"+cakeOutput+cakeBoxOutput+"<br>"
            						+icecreamOutput+icecreamBoxOutput+"<br>"+pieOutput+pieBoxOutput+"<br>"+sodaOutput+"<br>"+waterOutput 
            						+"<br>"+ iceteaOutput+"</html>" ); 
            
            BillSumarry.setFont(new Font("Algerian", Font.PLAIN, 15));
            
            BillSumarryOut = BillSumarry.getText();
            
			emailcostumerLabel = new JLabel("Email:");
			emailcostumerLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
			emailcostumerTextfield = new JTextField(5);
			
			cardNumeberLabel = new JLabel("Card Number:");
			cardNumeberLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
			carNumberTextField = new JTextField(5);
			
			cardMonthLabel = new JLabel("Month:");
			cardMonthLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
			cardMonthTextField = new JTextField(5);
					
			cardYearLabel = new JLabel("Year:");
			cardYearLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
			cardYearTextField = new JTextField(5);
            
            greetingslabel = new JLabel("Welcome " + fullnamecostumer + " to Mangioamo Ristorante!!!" );
            greetingslabel.setFont(new Font("Algerian", Font.PLAIN, 20));
            northPanelPayment = new JPanel();
            northPanelPayment.add(greetingslabel);
           	
            centerpanelPayment = new JPanel();
            eastPanelPayment = new JPanel();
            eastPanelPayment.setLayout(new GridLayout(5, 2));
            
            centerpanelPayment.add(BillSumarry);
            eastPanelPayment.add(emailcostumerLabel);
            eastPanelPayment.add(emailcostumerTextfield);
            eastPanelPayment.add(cardNumeberLabel);
            eastPanelPayment.add(carNumberTextField);
            eastPanelPayment.add(cardMonthLabel);
            eastPanelPayment.add(cardMonthTextField);
            eastPanelPayment.add(cardYearLabel);
            eastPanelPayment.add(cardYearTextField);
            
            
            Paybutton = new JButton("Pay");
            Paybutton.setBackground(Color.GREEN);
            Paybutton.setFont(new Font("Arial", Font.PLAIN, 20));
            Paybutton.addActionListener(this);
            
            CancelButton = new JButton("Cancel");
            CancelButton.setBackground(Color.RED);
            CancelButton.setFont(new Font("Arial", Font.PLAIN, 20));
            CancelButton.addActionListener(this);
            
            
            gobackbutton = new JButton("Back");
            gobackbutton.setBackground(Color.BLUE);
            gobackbutton.setFont(new Font("Arial", Font.PLAIN, 20));
            gobackbutton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    menuWindowDine.dispose();
                }
            });
            
            westpanelPayment = new JPanel();
            westpanelPayment.add(gobackbutton);
            southPanelPayment = new JPanel();
            southPanelPayment.add(Paybutton);
            southPanelPayment.add(CancelButton);
            
            menuWindowDine.add(northPanelPayment,BorderLayout.NORTH);
            menuWindowDine.add(westpanelPayment,BorderLayout.WEST);
            menuWindowDine.add(centerpanelPayment,BorderLayout.CENTER);
            menuWindowDine.add(southPanelPayment,BorderLayout.SOUTH);
            menuWindowDine.add(eastPanelPayment,BorderLayout.EAST);
            menuWindowDine.setSize(800, 500);
            menuWindowDine.setVisible(true);
            menuWindowDine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		}else if (event.getSource()== Paybutton) {
			String FName1 = FirstNameTextField.getText();
			String LName1 = LastnameTextField.getText();
			String EmailC1 = emailcostumerTextfield.getText();
			String CardNumber1 = carNumberTextField.getText();
			String CardMonth1 = cardMonthTextField.getText(); 
			String CardYear1 = cardYearTextField.getText();
			
			
			String antipasto1 = antipastobox.getSelectedItem().toString();
			if (antipastobox.getSelectedIndex() == 0) {
			    antipasto1 = "N/A";
			}
			String pasta1 = pastabox.getSelectedItem().toString();
			if (pastabox.getSelectedIndex() == 0) {
			    pasta1 = "N/A";
			}
			String pizza1 = pizzabox.getSelectedItem().toString();
			if (pizzabox.getSelectedIndex() == 0) {
			    pizza1 = "N/A";
			}
			String salad1 = saladbox.getSelectedItem().toString();
			if (saladbox.getSelectedIndex() == 0) {
			    salad1 = "N/A";
			}
			String cake1 = cakebox.getSelectedItem().toString();
			if (cakebox.getSelectedIndex() == 0) {
			    cake1 = "N/A";
			}
			String icecream1 = icecreambox.getSelectedItem().toString();
			if (icecreambox.getSelectedIndex() == 0) {
			    icecream1 = "N/A";
			}
			String pie1 = piebox.getSelectedItem().toString();
			if (piebox.getSelectedIndex() == 0) {
			    pie1 = "N/A";
			}
			
			Boolean soda1 = false;
			Boolean water1 = false;
			Boolean icetea1 = false;
			Boolean antipastoL1 = false;
			Boolean pastaL1 = false;
			Boolean pizzaL1 = false;
			Boolean saladL1 = false;
			Boolean cakeL1 = false;
			Boolean icecreamL1 =false;
			Boolean pieL1 = false;
			Boolean dineinOption1 = false;
			Boolean takeoutOption1 = false;
			
			
			if (dineinOption.isSelected()) {
				dineinOption1 = true;
            }else if(takeoutOption.isSelected()){
            	takeoutOption1 = true;
            }else if(sodaCheck.isSelected()){
            	soda1 = true;
            }else if(waterCheck.isSelected()){
            	water1 = true;
            }else if(iceteaCheck.isSelected()){
            	icetea1 = true;
            }else if(antipastoCheck.isSelected()){
            	antipastoL1 = true;
            }else if(pastaCheck.isSelected()){
            	pastaL1 = true;
            }else if(pizzaCheck.isSelected()){
            	pizzaL1 = true;
            }else if(saladCheck.isSelected()){
            	saladL1 = true;
            }else if(cakeCheck.isSelected()){
            	cakeL1 = true;
            }else if(icecreamCheck.isSelected()){
            	icecreamL1 = true;
            }else if(pieCheck.isSelected()){
            	pieL1 = true;
            }
			
				String outputBox1 = "Thank you!!\nRecipt: \n" + BillSumarryOut;
				JOptionPane.showMessageDialog(null, outputBox1);
				try {
						String URL = "jdbc:mysql://localhost/restaurant?user=root&password=";
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection(URL);
						String insertQuery = "INSERT INTO Billing_Summary (Costumer_First_Name,Costumer_Last_Name,Antipasto_Selected,Antipasto_Name,Pasta_Selected,Pasta_Name,Pizza_Selected,Pizza_Name,Salad_Selected,Salad_Name,Soda_Selected,Water_Selected,Ice_Tea_Selected,Cake_Selected,Cake_Name,Ice_Cream_Selected,Ice_Cream_Name,Pie_Selected,Pie_Name,Dine_In_Selected,Take_Out_Selected,Email,Card_Number,Card_Month,Card_Year ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						
						PreparedStatement insertStatement = conn.prepareStatement(insertQuery);

						insertStatement.setString(1, FName1);
						insertStatement.setString(2, LName1);
						insertStatement.setBoolean(3, antipastoL1);
						insertStatement.setString(4,antipasto1);
						insertStatement.setBoolean(5, pastaL1);
						insertStatement.setString(6,pasta1);
						insertStatement.setBoolean(7, pizzaL1);
						insertStatement.setString(8,pizza1);
						insertStatement.setBoolean(9, saladL1);
						insertStatement.setString(10,salad1);
						
						insertStatement.setBoolean(11, soda1);
						insertStatement.setBoolean(12, water1);
						insertStatement.setBoolean(13, icetea1);
						
						insertStatement.setBoolean(14, cakeL1);
						insertStatement.setString(15,cake1);
						insertStatement.setBoolean(16, icecreamL1);
						insertStatement.setString(17,icecream1);
						insertStatement.setBoolean(18, pieL1);
						insertStatement.setString(19,pie1);
						
						insertStatement.setBoolean(20,dineinOption1);
						insertStatement.setBoolean(21,takeoutOption1);
						
						insertStatement.setString(22,EmailC1);
						insertStatement.setString(23,CardNumber1);
						insertStatement.setString(24,CardMonth1);
						insertStatement.setString(25,CardYear1);
						
						
						
						insertStatement.executeUpdate();

						
					}
				catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				catch(SQLException e) {
					e.printStackTrace();
					
				}
			
		}
		else if (event.getSource()== CancelButton) {
			
			      menuWindowDine.dispose();
			      
			      FirstNameTextField.setText("");
			      LastnameTextField.setText("");
			      emailcostumerTextfield.setText("");
			      carNumberTextField.setText("");
			      cardMonthTextField.setText(""); 
			      cardYearTextField.setText("");
			      
			      pizzabox.setSelectedIndex(0);
			      antipastobox.setSelectedIndex(0);
			      pastabox.setSelectedIndex(0);
			      saladbox.setSelectedIndex(0);
			      cakebox.setSelectedIndex(0);
			      icecreambox.setSelectedIndex(0);
			      piebox.setSelectedIndex(0);
			      
			      antipastoCheck.setSelected(false);
			      pastaCheck.setSelected(false);
			      pizzaCheck.setSelected(false);
			      saladCheck.setSelected(false);
			      cakeCheck.setSelected(false);
			      icecreamCheck.setSelected(false);
			      pieCheck.setSelected(false);
			      sodaCheck.setSelected(false);
			      waterCheck.setSelected(false);
			      iceteaCheck.setSelected(false);
			      
			      dinnerGroup.clearSelection();
			      
			      
		}	
	}
	public static void main(String[] args) {
		RestaurantGUI app = new RestaurantGUI();
	}

}
