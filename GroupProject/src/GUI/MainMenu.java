package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;
import controller.*;
import model.*;
import GUI.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainMenu implements Component{
	public static String dbUsernameInput;
	public static String dbPasswordInput;
	public MainMenu(){
		draw();
	}
	@Override
	public void draw() {
		//Frame setup
		frame.setTitle("Main Menu");
		frame.setResizable(false);
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,500);
		frame.getContentPane().setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 191, 255));
		titlePanel.setBounds(0, 0, 486, 69);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Group26 Properties Limited");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		titleLabel.setBounds(95, 10, 297, 49);
		titlePanel.add(titleLabel);
		
		JLabel dbUsername = new JLabel("MySQL username\r\n");
		dbUsername.setFont(new Font("SansSerif", Font.BOLD, 16));
		dbUsername.setBounds(31, 71, 144, 21);
		frame.getContentPane().add(dbUsername);
		
		JLabel dbPassword = new JLabel("MySQL password");
		dbPassword.setFont(new Font("SansSerif", Font.BOLD, 16));
		dbPassword.setBounds(258, 71, 170, 21);
		frame.getContentPane().add(dbPassword);
		
		JTextField sqlUsername = new JTextField();
		sqlUsername.setFont(new Font("SansSerif", Font.BOLD, 14));
		sqlUsername.setColumns(10);
		sqlUsername.setBounds(29, 98, 170, 21);
		frame.getContentPane().add(sqlUsername);
		
		JPasswordField sqlPassword = new JPasswordField();
		sqlPassword.setBounds(240, 98, 170, 21);
		frame.getContentPane().add(sqlPassword);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		emailLabel.setBounds(103, 154, 72, 21);
		frame.getContentPane().add(emailLabel);
		
		JLabel lblUsername = new JLabel("Name");
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblUsername.setBounds(103, 211, 66, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		passwordLabel.setBounds(103, 275, 85, 20);
		frame.getContentPane().add(passwordLabel);
		
		JTextField email = new JTextField();
		email.setFont(new Font("SansSerif", Font.BOLD, 14));
		email.setBounds(222, 156, 206, 23);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JTextField name = new JTextField();
		name.setFont(new Font("SansSerif", Font.BOLD, 14));
		name.setColumns(10);
		name.setBounds(222, 213, 206, 23);
		frame.getContentPane().add(name);
		
		JPasswordField password = new JPasswordField();
		password.setBounds(222, 275, 206, 19);
		frame.getContentPane().add(password);
		
		JComboBox loginChooser = new JComboBox();
		loginChooser.setModel(new DefaultComboBoxModel(new String[] {"Renter", "Landlord", "Manager"}));
		loginChooser.setFont(new Font("SansSerif", Font.BOLD, 12));
		loginChooser.setBounds(152, 338, 150, 21);
		frame.getContentPane().add(loginChooser);
		
		JButton register = new JButton("Register");
		register.setBackground(new Color(0, 191, 255));
		register.setFont(new Font("SansSerif", Font.BOLD, 14));
		register.setBounds(31, 402, 138, 32);
		frame.getContentPane().add(register);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameInput = name.getText().trim();
				String passwordInput = String.valueOf(password.getPassword()).trim();
				String emailInput = email.getText().trim();
				String selectedType = String.valueOf(loginChooser.getSelectedItem());
				if(nameInput.length() >=3 && passwordInput.length()>=3 && emailInput.length()>=3 && emailInput.contains("@") && nameInput.matches("[a-zA-Z]+")){
					AuthenticateController authenticate = new AuthenticateController(nameInput, emailInput, passwordInput, selectedType);
					authenticate.register();
					JOptionPane.showMessageDialog(frame, "you have successfully registered");
				}else{
					JOptionPane.showMessageDialog(frame, "Please make sure your input meeets the following reguirements\n1. All inputs have at least 3 characters\n2. Email should have the '@' character\n3. Name Only Contains Letters");
				}
			}
		});
		
		JButton login = new JButton("Login");
		login.setFont(new Font("SansSerif", Font.BOLD, 14));
		login.setBackground(new Color(0, 191, 255));
		login.setBounds(179, 402, 138, 32);
		frame.getContentPane().add(login);
		
		JButton guestLogin = new JButton("Login as Guest");
		guestLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
		guestLogin.setBackground(new Color(0, 191, 255));
		guestLogin.setBounds(327, 402, 150, 32);
		frame.getContentPane().add(guestLogin);
		guestLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUsernameInput = sqlUsername.getText();
				dbPasswordInput = String.valueOf(sqlPassword.getPassword());
				AuthenticateController authenticate = new AuthenticateController();
			    Component c = new UnregisteredRenterScreen();
			}
		});
	
			
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedLogin = String.valueOf(loginChooser.getSelectedItem());
					dbUsernameInput = sqlUsername.getText();
					dbPasswordInput = String.valueOf(sqlPassword.getPassword());
					if (selectedLogin == "Landlord")
					{
						String nameInput = name.getText();
						String passwordInput = String.valueOf(password.getPassword());
						String emailInput = email.getText();
						String selectedType = String.valueOf(loginChooser.getSelectedItem());
						AuthenticateController authenticate = new AuthenticateController(nameInput, emailInput, passwordInput, selectedType);
						if(authenticate.login()){
							Component c = new LandlordScreen();
						}
						else{
							JOptionPane.showMessageDialog(frame, "Login failed, check inputs");
						}	
					}
					if (selectedLogin == "Renter") {
						String nameInput = name.getText();
						String passwordInput = String.valueOf(password.getPassword());
						String emailInput = email.getText();
						String selectedType = String.valueOf(loginChooser.getSelectedItem());
						AuthenticateController authenticate = new AuthenticateController(nameInput, emailInput, passwordInput, selectedType);
						if(authenticate.login()){
							Component c = new RegisteredRenterScreen();
						}
						else{
							JOptionPane.showMessageDialog(frame, "Login failed, check inputs");
						}	
					}
					if (selectedLogin == "Manager") {
						String nameInput = name.getText();
						String passwordInput = String.valueOf(password.getPassword());
						String emailInput = email.getText();
						String selectedType = String.valueOf(loginChooser.getSelectedItem());
						AuthenticateController authenticate = new AuthenticateController(nameInput, emailInput, passwordInput, selectedType);
						if(authenticate.login()){
							Component c = new ManagerScreen();
						}
						else{
							JOptionPane.showMessageDialog(frame, "Login failed, check inputs");
						}	
					}

				}
			});
			frame.setVisible(true);
		}
}
