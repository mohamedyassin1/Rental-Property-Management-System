package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		emailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the emailFrame
		emailFrame.setLocation(dim.width/2-250, dim.height/2-250); 
		emailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emailFrame.getContentPane().setLayout(null);
		emailFrame.setSize(767,305);
		
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
		TitlePanel.setBounds(0, 0, 753, 22);
		emailFrame.getContentPane().add(TitlePanel);
		TitlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Email a Landlord For More Information\r\n");
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		titleLabel.setBounds(54, 0, 355, 22);
		TitlePanel.add(titleLabel);
		
		JLabel inboxLabel = new JLabel("Inbox");
		inboxLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		inboxLabel.setBounds(548, 0, 69, 22);
		TitlePanel.add(inboxLabel);
		
		JTextArea inbox = new JTextArea();
		inbox.setBackground(new Color(192, 192, 192));
		inbox.setEditable(false);
		inbox.setBounds(422, 37, 295, 200);
		emailFrame.getContentPane().add(inbox);
		
		emailFrame.setVisible(true);
		
		
	}
}
