package GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainMenu implements Component{
	public MainMenu(){
		draw();
	}
	@Override
	public void draw() {
		//Frame setup
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,500);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		
		JButton register = new JButton("Register");
		springLayout.putConstraint(SpringLayout.WEST, register, 27, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, register, -80, SpringLayout.SOUTH, frame.getContentPane());
		register.setBackground(new Color(0, 191, 255));
		register.setForeground(new Color(255, 255, 255));
		register.setFont(new Font("SansSerif", Font.BOLD, 16));
		frame.getContentPane().add(register);
		
		JButton login = new JButton("Login");
		springLayout.putConstraint(SpringLayout.WEST, login, 165, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, register, -6, SpringLayout.WEST, login);
		springLayout.putConstraint(SpringLayout.NORTH, login, 0, SpringLayout.NORTH, register);
		springLayout.putConstraint(SpringLayout.SOUTH, login, 0, SpringLayout.SOUTH, register);
		springLayout.putConstraint(SpringLayout.EAST, login, -189, SpringLayout.EAST, frame.getContentPane());
		login.setBackground(new Color(0, 191, 255));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new RegisteredRenterScreen();
			}
		});
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("SansSerif", Font.BOLD, 16));
		frame.getContentPane().add(login);
		
		JTextField email = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, email, 199, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, email, -286, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, email, -91, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		springLayout.putConstraint(SpringLayout.NORTH, emailLabel, 2, SpringLayout.NORTH, email);
		springLayout.putConstraint(SpringLayout.EAST, emailLabel, -57, SpringLayout.WEST, email);
		emailLabel.setBackground(new Color(255, 255, 255));
		emailLabel.setForeground(new Color(0, 0, 0));
		emailLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		frame.getContentPane().add(emailLabel);
		
		JLabel Password = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.NORTH, register, 88, SpringLayout.SOUTH, Password);
		springLayout.putConstraint(SpringLayout.WEST, Password, 80, SpringLayout.WEST, frame.getContentPane());
		Password.setForeground(new Color(0, 0, 0));
		Password.setFont(new Font("SansSerif", Font.BOLD, 16));
		frame.getContentPane().add(Password);
		
		JPasswordField password = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, Password, 0, SpringLayout.NORTH, password);
		springLayout.putConstraint(SpringLayout.EAST, Password, -24, SpringLayout.WEST, password);
		springLayout.putConstraint(SpringLayout.NORTH, password, 60, SpringLayout.SOUTH, email);
		springLayout.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, email);
		springLayout.putConstraint(SpringLayout.SOUTH, password, -198, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, password, 0, SpringLayout.EAST, email);
		frame.getContentPane().add(password);
		
		JPanel titlePanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, email, 49, SpringLayout.SOUTH, titlePanel);
		springLayout.putConstraint(SpringLayout.NORTH, titlePanel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, titlePanel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, titlePanel, 96, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, titlePanel, 486, SpringLayout.WEST, frame.getContentPane());
		titlePanel.setBackground(new Color(0, 191, 255));
		frame.getContentPane().add(titlePanel);
		SpringLayout sl_titlePanel = new SpringLayout();
		titlePanel.setLayout(sl_titlePanel);
		
		JLabel Title = new JLabel("Group26 Properties Limited\r\n");
		sl_titlePanel.putConstraint(SpringLayout.NORTH, Title, 10, SpringLayout.NORTH, titlePanel);
		sl_titlePanel.putConstraint(SpringLayout.WEST, Title, 39, SpringLayout.WEST, titlePanel);
		sl_titlePanel.putConstraint(SpringLayout.SOUTH, Title, -20, SpringLayout.SOUTH, titlePanel);
		sl_titlePanel.putConstraint(SpringLayout.EAST, Title, 0, SpringLayout.EAST, titlePanel);
		Title.setForeground(new Color(255, 255, 255));
		Title.setFont(new Font("SansSerif", Font.BOLD, 28));
		titlePanel.add(Title);
		
		JButton GuestLogin = new JButton("Login as Guest");
		springLayout.putConstraint(SpringLayout.NORTH, GuestLogin, 0, SpringLayout.NORTH, register);
		springLayout.putConstraint(SpringLayout.WEST, GuestLogin, 6, SpringLayout.EAST, login);
		springLayout.putConstraint(SpringLayout.SOUTH, GuestLogin, 0, SpringLayout.SOUTH, register);
		springLayout.putConstraint(SpringLayout.EAST, GuestLogin, -16, SpringLayout.EAST, titlePanel);
		GuestLogin.setForeground(new Color(255, 255, 255));
		GuestLogin.setBackground(new Color(0, 191, 255));
		GuestLogin.setFont(new Font("SansSerif", Font.BOLD, 16));
		GuestLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(GuestLogin);
		frame.setVisible(true);
	}
}