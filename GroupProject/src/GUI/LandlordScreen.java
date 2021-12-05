package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LandlordScreen implements Component{
	public LandlordScreen() {
		draw();
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,300);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 486, 41);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logged in as Landlord");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(134, 0, 226, 41);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 191, 255));
		comboBox.setMaximumRowCount(50);
		comboBox.setBounds(37, 112, 168, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel PropertySelector = new JLabel("My Properties");
		PropertySelector.setFont(new Font("SansSerif", Font.BOLD, 12));
		PropertySelector.setBounds(64, 92, 168, 13);
		frame.getContentPane().add(PropertySelector);
		
		JLabel RegisterFormLabel = new JLabel("Register a New Property");
		RegisterFormLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		RegisterFormLabel.setBounds(269, 92, 177, 13);
		frame.getContentPane().add(RegisterFormLabel);
		
		JButton RegisterFormButton = new JButton("Register a New Property");
		RegisterFormButton.setBackground(new Color(0, 191, 255));
		RegisterFormButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		RegisterFormButton.setBounds(249, 111, 179, 22);
		RegisterFormButton.setForeground(new Color(255, 255, 255));
		RegisterFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new RegisterPropertyScreen();
			}
		});
		frame.getContentPane().add(RegisterFormButton);
		
		JButton payFees = new JButton("Pay Fee");
		payFees.setBackground(new Color(0, 191, 255));
		payFees.setBounds(54, 202, 104, 34);
		payFees.setForeground(new Color(255, 255, 255));
		payFees.setFont(new Font("SansSerif", Font.BOLD, 16));
		frame.getContentPane().add(payFees);
		
		JComboBox stateOfListing = new JComboBox();
		stateOfListing.setBackground(new Color(0, 191, 255));
		stateOfListing.setFont(new Font("SansSerif", Font.BOLD, 12));
		stateOfListing.setModel(new DefaultComboBoxModel(new String[] {"Active", "Rented", "Cancelled", "Suspended"}));
		stateOfListing.setBounds(249, 195, 152, 27);
		frame.getContentPane().add(stateOfListing);
		
		JButton updateState = new JButton("Update State");
		updateState.setBackground(new Color(0, 191, 255));
		updateState.setFont(new Font("SansSerif", Font.BOLD, 12));
		updateState.setBounds(254, 232, 147, 21);
		updateState.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(updateState);
		
		JButton LogoutButton = new JButton("Logout");
		LogoutButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		LogoutButton.setBackground(new Color(255, 0, 0));
		LogoutButton.setBounds(343, 51, 103, 21);
		frame.getContentPane().add(LogoutButton);
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new MainMenu();
			}
		});
		frame.setVisible(true); //making frame actually visible		
	}
}
