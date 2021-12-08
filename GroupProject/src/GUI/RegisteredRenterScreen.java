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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import controller.ViewSearchCriteria;

public class RegisteredRenterScreen implements Component{
	RegisteredRenterScreen() {
		draw();
	}

	@SuppressWarnings("serial")
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		frame.setTitle("Registered Renter Screen");
		frame.setResizable(false);
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,500);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 238, 466, 215);
		frame.getContentPane().add(scrollPane);
		ViewSearchCriteria v = new ViewSearchCriteria();
		JTable table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			v.getActiveProperties(),
			new String[] {
				"PropertyID", "Property Type", "#Bedrooms", "#Bathrooms", "Furnished", "Quadrant"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class,String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(66);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(52);
		scrollPane.setViewportView(table);
		
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 191, 255));
		titlePanel.setBounds(0, 0, 486, 82);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel Title = new JLabel("Browse Properties");
		Title.setBounds(135, 20, 220, 32);
		Title.setForeground(new Color(255, 255, 255));
		titlePanel.add(Title);
		Title.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		JComboBox PropertyType = new JComboBox();
		PropertyType.setModel(new DefaultComboBoxModel(new String[] {"APARTMENT", "TOWNHOUSE", "DUPLEX", "CONDO", "STUDIO", "BASEMENT"}));
		PropertyType.setBackground(new Color(0, 191, 255));
		PropertyType.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PropertyType.setBounds(10, 192, 73, 21);
		PropertyType.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(PropertyType);
		
		JComboBox NumBedrooms = new JComboBox();
		NumBedrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,7,8}));
		NumBedrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NumBedrooms.setBackground(new Color(0, 191, 255));
		NumBedrooms.setBounds(108, 192, 67, 21);
		NumBedrooms.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(NumBedrooms);
		
		JComboBox NumBathrooms = new JComboBox();
		NumBathrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8}));
		NumBathrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NumBathrooms.setBackground(new Color(0, 191, 255));
		NumBathrooms.setBounds(196, 192, 60, 21);
		NumBathrooms.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(NumBathrooms);
		
		JComboBox Quadrant = new JComboBox();
		Quadrant.setModel(new DefaultComboBoxModel(new String[] {"NW", "SW", "NE", "SE"}));
		Quadrant.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quadrant.setBackground(new Color(0, 191, 255));
		Quadrant.setBounds(374, 193, 88, 21);
		Quadrant.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(Quadrant);
		
		JRadioButton Furnished = new JRadioButton("Furnished");
		Furnished.setBounds(280, 193, 88, 21);
		Furnished.setBackground(new Color(0, 191, 255));
		Furnished.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(Furnished);
		
		JLabel label1 = new JLabel("PropertyType");
		label1.setBounds(10, 168, 79, 13);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("#Bedrooms");
		label2.setBounds(108, 168, 67, 13);
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("#Bathrooms");
		label3.setBounds(200, 168, 73, 13);
		frame.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("Furnished?");
		label4.setBounds(293, 168, 67, 13);
		frame.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("Quadrant");
		label5.setBounds(388, 168, 88, 13);
		frame.getContentPane().add(label5);
		
		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String propertyTypeInput = String.valueOf(PropertyType.getSelectedItem());
				int numBedroomsInput = Integer.valueOf(String.valueOf(NumBedrooms.getSelectedItem()));
				int numBathroomsInput = Integer.valueOf(String.valueOf(NumBathrooms.getSelectedItem()));
				String quadrantTypeInput = String.valueOf(Quadrant.getSelectedItem());
				String furnishedInput = "NO";
				if(Furnished.isSelected()){
					furnishedInput = "YES";
				}
				// v.getCriteriaProperties(propertyTypeInput, numBedroomsInput, numBathroomsInput, furnishedInput, quadrantTypeInput);
				JTable table = new JTable();
				table.setBackground(new Color(255, 255, 255));
				table.setModel(new DefaultTableModel(
					v.getCriteriaProperties(propertyTypeInput, numBedroomsInput, numBathroomsInput, furnishedInput, quadrantTypeInput),
					new String[] {
						"PropertyID", "Property Type", "#Bedrooms", "#Bathrooms", "Furnished", "Quadrant"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class,String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table.getColumnModel().getColumn(0).setPreferredWidth(65);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(63);
				table.getColumnModel().getColumn(3).setPreferredWidth(66);
				table.getColumnModel().getColumn(4).setPreferredWidth(55);
				table.getColumnModel().getColumn(5).setPreferredWidth(52);
				scrollPane.setViewportView(table);
			}
		});
		Search.setBackground(new Color(0, 191, 255));
		Search.setFont(new Font("SansSerif", Font.BOLD, 18));
		Search.setBounds(167, 88, 142, 44);
		Search.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(Search);
		
		JButton Unsubscribe = new JButton("Unsubscribe");
		Unsubscribe.setFont(new Font("SansSerif", Font.BOLD, 10));
		Unsubscribe.setBackground(new Color(0, 191, 255));
		Unsubscribe.setBounds(359, 92, 117, 21);
		Unsubscribe.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(Unsubscribe);
		
		JButton viewNotifications = new JButton("Notifications");
		viewNotifications.setFont(new Font("SansSerif", Font.BOLD, 10));
		viewNotifications.setBackground(new Color(0, 191, 255));
		viewNotifications.setBounds(10, 92, 115, 21);
		viewNotifications.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(viewNotifications);
		
		JButton emailButton = new JButton("Email Landlord");
		emailButton.setBackground(new Color(0, 191, 255));
		emailButton.setFont(new Font("SansSerif", Font.BOLD, 10));
		emailButton.setBounds(358, 123, 118, 21);
		emailButton.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(emailButton);
		emailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new EmailSystemScreen();
			}
		});
		
		
		JButton returnButton = new JButton("Logout");
		returnButton.setFont(new Font("SansSerif", Font.BOLD, 10));
		returnButton.setBackground(Color.RED);
		returnButton.setForeground(new Color(255, 255, 255));
		returnButton.setBounds(10, 123, 115, 21);
		frame.getContentPane().add(returnButton);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new MainMenu();
			}
		});
		
		JButton saveCriteria = new JButton("Save Filters");
		saveCriteria.setFont(new Font("SansSerif", Font.BOLD, 10));
		saveCriteria.setBackground(new Color(0, 191, 255));
		saveCriteria.setBounds(187, 142, 102, 21);
		saveCriteria.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(saveCriteria);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,500);
		frame.setVisible(true); //making frame actually visible
	}
}