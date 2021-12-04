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

public class RegisteredRenterScreen implements Component{
	RegisteredRenterScreen() {
		draw();
	}

	@SuppressWarnings("serial")
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
		frame.setSize(500,500);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 238, 466, 215);
		frame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"LandlordEmail", "Property Type", "#Bedrooms", "#Bathrooms", "Furnished", "Quadrant"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, Boolean.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 191, 255));
		titlePanel.setBounds(0, 0, 486, 82);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel Title = new JLabel("Browse Properties");
		Title.setBounds(135, 20, 220, 32);
		titlePanel.add(Title);
		Title.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		JComboBox PropertyType = new JComboBox();
		PropertyType.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Townhouse", "Duplex", "Condo", "Studio", "Basement"}));
		PropertyType.setBackground(new Color(0, 191, 255));
		PropertyType.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PropertyType.setBounds(10, 192, 73, 21);
		frame.getContentPane().add(PropertyType);
		
		JComboBox NumBedrooms = new JComboBox();
		NumBedrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,7,8}));
		NumBedrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NumBedrooms.setBackground(new Color(0, 191, 255));
		NumBedrooms.setBounds(108, 192, 67, 21);
		frame.getContentPane().add(NumBedrooms);
		
		JComboBox NumBathrooms = new JComboBox();
		NumBathrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8}));
		NumBathrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NumBathrooms.setBackground(new Color(0, 191, 255));
		NumBathrooms.setBounds(196, 192, 60, 21);
		frame.getContentPane().add(NumBathrooms);
		
		JComboBox Quadrant = new JComboBox();
		Quadrant.setModel(new DefaultComboBoxModel(new String[] {"NW", "SW", "NE", "SE"}));
		Quadrant.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quadrant.setBackground(new Color(0, 191, 255));
		Quadrant.setBounds(374, 193, 88, 21);
		frame.getContentPane().add(Quadrant);
		
		JRadioButton Furnished = new JRadioButton("Furnished");
		Furnished.setBounds(280, 193, 88, 21);
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
			}
		});
		Search.setBackground(new Color(0, 191, 255));
		Search.setFont(new Font("SansSerif", Font.BOLD, 18));
		Search.setBounds(135, 92, 198, 52);
		frame.getContentPane().add(Search);
		
		JButton Unsubscribe = new JButton("Unsubscribe");
		Unsubscribe.setFont(new Font("SansSerif", Font.BOLD, 10));
		Unsubscribe.setBackground(new Color(0, 191, 255));
		Unsubscribe.setBounds(359, 111, 117, 21);
		frame.getContentPane().add(Unsubscribe);
		
		JButton btnViewNotifications = new JButton("Notifications");
		btnViewNotifications.setFont(new Font("SansSerif", Font.BOLD, 10));
		btnViewNotifications.setBackground(new Color(0, 191, 255));
		btnViewNotifications.setBounds(10, 111, 115, 21);
		frame.getContentPane().add(btnViewNotifications);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,500);
		frame.setVisible(true); //making frame actually visible
	}
}