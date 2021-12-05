package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmailSystemScreen implements Component{
	private JFrame emailFrame;
	
	public EmailSystemScreen(){
		draw();
	}
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	@Override
	public void draw() {
		emailFrame = new JFrame();
		emailFrame.getContentPane().setBackground(new Color(255, 255, 255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		emailFrame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		emailFrame.setSize(500,300);
		emailFrame.getContentPane().setForeground(new Color(255, 255, 255));
		emailFrame.getContentPane().setBackground(new Color(255, 255, 255));
		emailFrame.getContentPane().setLayout(null);
		
		
		JTextArea Message = new JTextArea();
		Message.setForeground(new Color(255, 255, 255));
		Message.setBackground(new Color(192, 192, 192));
		Message.setColumns(10);
		Message.setRows(10);
		Message.setBounds(75, 93, 324, 133);
		emailFrame.getContentPane().add(Message);
		
		JTextField Recipient = new JTextField();
		Recipient.setBounds(75, 32, 279, 19);
		emailFrame.getContentPane().add(Recipient);
		Recipient.setColumns(10);
		
		JTextField Subject = new JTextField();
		Subject.setColumns(10);
		Subject.setBounds(75, 64, 279, 19);
		emailFrame.getContentPane().add(Subject);
		
		JLabel RecipientLabel = new JLabel("To");
		RecipientLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		RecipientLabel.setBounds(10, 35, 45, 13);
		emailFrame.getContentPane().add(RecipientLabel);
		
		JLabel SubjectLabel = new JLabel("Subject");
		SubjectLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		SubjectLabel.setBounds(10, 67, 45, 13);
		emailFrame.getContentPane().add(SubjectLabel);
		
		JLabel MessageLevel = new JLabel("Message");
		MessageLevel.setFont(new Font("SansSerif", Font.BOLD, 12));
		MessageLevel.setBounds(10, 99, 55, 13);
		emailFrame.getContentPane().add(MessageLevel);
		
		JButton SendButton = new JButton("Send");
		SendButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		SendButton.setBounds(173, 232, 85, 21);
		emailFrame.getContentPane().add(SendButton);
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(new Color(0, 191, 255));
		TitlePanel.setBounds(0, 0, 486, 22);
		emailFrame.getContentPane().add(TitlePanel);
		TitlePanel.setLayout(null);
		
		JLabel title = new JLabel("Email a Landlord For More Information\r\n");
		title.setFont(new Font("SansSerif", Font.BOLD, 18));
		title.setForeground(new Color(255,255,255));
		title.setBounds(54, 0, 355, 22);
		TitlePanel.add(title);
		
		emailFrame.setVisible(true);
		
		
	}
}
