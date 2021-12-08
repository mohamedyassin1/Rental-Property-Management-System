package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ManagerScreen implements Component {
	public ManagerScreen() {
		draw();
	}
	public void draw() {
		frame.setResizable(false);
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
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 486, 38);
		titlePanel.setBackground(new Color(0, 191, 255));
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel managerTitle = new JLabel("Logged in as Manager");
		managerTitle.setForeground(new Color(255, 255, 255));
		managerTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		managerTitle.setBounds(101, 0, 244, 38);
		titlePanel.add(managerTitle);
		
		JButton setFee = new JButton("Set Fees");
		setFee.setForeground(new Color(255, 255, 255));
		setFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setFee.setFont(new Font("SansSerif", Font.BOLD, 12));
		setFee.setBackground(new Color(0, 191, 255));
		setFee.setBounds(20, 114, 130, 28);
		frame.getContentPane().add(setFee);
		
		JButton changePeriod = new JButton("Change Fee Period");
		changePeriod.setForeground(new Color(255, 255, 255));
		changePeriod.setFont(new Font("SansSerif", Font.BOLD, 12));
		changePeriod.setBackground(new Color(0, 191, 255));
		changePeriod.setBounds(20, 152, 169, 28);
		frame.getContentPane().add(changePeriod);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 191, 255));
		comboBox.setMaximumRowCount(50);
		comboBox.setFont(new Font("SansSerif", Font.BOLD, 18));
		comboBox.setBounds(20, 71, 139, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel propertySelect = new JLabel("Select Property");
		propertySelect.setFont(new Font("SansSerif", Font.BOLD, 12));
		propertySelect.setBounds(25, 48, 111, 13);
		frame.getContentPane().add(propertySelect);
		
		JButton generateSummary = new JButton("Periodical Summary Report");
		generateSummary.setForeground(Color.WHITE);
		generateSummary.setFont(new Font("SansSerif", Font.BOLD, 12));
		generateSummary.setBackground(new Color(0, 191, 255));
		generateSummary.setBounds(232, 69, 194, 28);
		frame.getContentPane().add(generateSummary);
		
		JButton renterInfo = new JButton("Renter Information");
		renterInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		renterInfo.setForeground(Color.WHITE);
		renterInfo.setFont(new Font("SansSerif", Font.BOLD, 12));
		renterInfo.setBackground(new Color(0, 191, 255));
		renterInfo.setBounds(232, 114, 194, 28);
		frame.getContentPane().add(renterInfo);
		
		JButton landlordInfo = new JButton("Landlord Information");
		landlordInfo.setForeground(Color.WHITE);
		landlordInfo.setFont(new Font("SansSerif", Font.BOLD, 12));
		landlordInfo.setBackground(new Color(0, 191, 255));
		landlordInfo.setBounds(232, 157, 194, 28);
		frame.getContentPane().add(landlordInfo);
		
		JButton propertyInfo = new JButton("Property Information");
		propertyInfo.setForeground(Color.WHITE);
		propertyInfo.setFont(new Font("SansSerif", Font.BOLD, 12));
		propertyInfo.setBackground(new Color(0, 191, 255));
		propertyInfo.setBounds(232, 201, 194, 28);
		frame.getContentPane().add(propertyInfo);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setBounds(20, 206, 169, 28);
		frame.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new MainMenu();
			}
		});
		
		frame.setVisible(true);
	}
		
	}
