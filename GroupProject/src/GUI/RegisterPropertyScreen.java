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

public class RegisterPropertyScreen implements Component{
	public RegisterPropertyScreen() {
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
		frame.setSize(500,500);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel question1 = new JLabel("What kind of property is this?");
		question1.setFont(new Font("SansSerif", Font.BOLD, 12));
		question1.setBounds(23, 52, 186, 26);
		frame.getContentPane().add(question1);
		
		JComboBox answer1 = new JComboBox();
		answer1.setForeground(new Color(255, 255, 255));
		answer1.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Townhouse", "Duplex", "Condo", "Studio", "Basement"}));
		answer1.setBackground(new Color(0, 191, 255));
		answer1.setBounds(23, 88, 154, 21);
		frame.getContentPane().add(answer1);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 191, 255));
		titlePanel.setBounds(0, 0, 486, 47);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel title = new JLabel("Register Your Property");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("SansSerif", Font.BOLD, 20));
		title.setBounds(129, 10, 218, 27);
		titlePanel.add(title);
		
		JLabel question2 = new JLabel("How many bedrooms does it have?");
		question2.setFont(new Font("SansSerif", Font.BOLD, 12));
		question2.setBounds(23, 129, 240, 26);
		frame.getContentPane().add(question2);
		
		JComboBox answer2 = new JComboBox();
		answer2.setForeground(new Color(255, 255, 255));
		answer2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		answer2.setBackground(new Color(0, 191, 255));
		answer2.setBounds(23, 164, 154, 21);
		frame.getContentPane().add(answer2);
		
		JLabel question3 = new JLabel("How many bathrooms does it have?");
		question3.setFont(new Font("SansSerif", Font.BOLD, 12));
		question3.setBounds(23, 210, 240, 26);
		frame.getContentPane().add(question3);
		
		JComboBox answer2_1 = new JComboBox();
		answer2_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		answer2_1.setForeground(new Color(255, 255, 255));
		answer2_1.setBackground(new Color(0, 191, 255));
		answer2_1.setBounds(23, 246, 154, 21);
		frame.getContentPane().add(answer2_1);
		
		JLabel question4 = new JLabel("Is it furnished?");
		question4.setFont(new Font("SansSerif", Font.BOLD, 12));
		question4.setBounds(23, 288, 240, 26);
		frame.getContentPane().add(question4);
		
		JRadioButton answer4 = new JRadioButton("furnished");
		answer4.setForeground(new Color(255, 255, 255));
		answer4.setFont(new Font("SansSerif", Font.BOLD, 12));
		answer4.setBackground(new Color(0, 191, 255));
		answer4.setBounds(23, 320, 103, 21);
		frame.getContentPane().add(answer4);
		
		JLabel question5 = new JLabel("What quadrant of the city is it located?");
		question5.setFont(new Font("SansSerif", Font.BOLD, 12));
		question5.setBounds(23, 359, 240, 26);
		frame.getContentPane().add(question5);
		
		JComboBox answer2_1_1 = new JComboBox();
		answer2_1_1.setForeground(new Color(255, 255, 255));
		answer2_1_1.setModel(new DefaultComboBoxModel(new String[] {"NW", "NE", "SW", "SE"}));
		answer2_1_1.setBackground(new Color(0, 191, 255));
		answer2_1_1.setBounds(23, 401, 154, 21);
		frame.getContentPane().add(answer2_1_1);
		
		JButton finishRegistration = new JButton("Register");
		finishRegistration.setBackground(new Color(0, 191, 255));
		finishRegistration.setForeground(new Color(255, 255, 255));
		finishRegistration.setFont(new Font("SansSerif", Font.BOLD, 12));
		finishRegistration.setBounds(286, 401, 161, 21);
		finishRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new LandlordScreen();
			}
		});
		frame.getContentPane().add(finishRegistration);
		
		
		frame.setVisible(true);
	}
	

}
