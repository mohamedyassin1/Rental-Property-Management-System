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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.EmailController;

public class EmailSystemScreen implements Component{
	private JFrame emailFrame;
	
	public EmailSystemScreen(){
		draw();
	}
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	@SuppressWarnings("serial")
	@Override
	public void draw() {
		emailFrame = new JFrame();
		emailFrame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		emailFrame.setLocation(dim.width/2-250, dim.height/2-250); 
		emailFrame.getContentPane().setLayout(null);
		emailFrame.setSize(767,305);
		
		JTextArea Message = new JTextArea();
		Message.setForeground(new Color(255, 255, 255));
		Message.setBackground(new Color(192, 192, 192));
		Message.setColumns(10);
		Message.setRows(10);
		Message.setBounds(75, 93, 324, 133);
		Message.setLineWrap(true);
		emailFrame.getContentPane().add(Message);
		
		JComboBox renterRecipient = new JComboBox();
		JTextField landlordRecipient = new JTextField();
		EmailController controller = new EmailController();
		if (controller.getUserType().equals("Renter")) {
			renterRecipient.setModel(new DefaultComboBoxModel(controller.getProperties()));
			renterRecipient.setMaximumRowCount(50);
			renterRecipient.setBounds(75, 32, 279, 19);
			emailFrame.getContentPane().add(renterRecipient);
		}
		else {
			landlordRecipient.setBounds(75, 32, 279, 19);
			emailFrame.getContentPane().add(landlordRecipient);
			landlordRecipient.setColumns(10);
		}
		
		JComboBox Subject = new JComboBox();
		Subject.setModel(new DefaultComboBoxModel(new String[] {"Need further details", "Arrange a Meeting"}));
		Subject.setMaximumRowCount(2);
		Subject.setBounds(75, 61, 279, 21);
		emailFrame.getContentPane().add(Subject);
		
		
		JLabel RecipientLabel = new JLabel("PropertyID");
		RecipientLabel.setToolTipText("PropertyID");
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
		SendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subjectInput = String.valueOf(Subject.getSelectedItem());
				String messageInput = Message.getText();
				if (controller.getUserType().equals("Renter")) {
					int propertyIDInput = (Integer.valueOf(String.valueOf(renterRecipient.getSelectedItem())));
					controller.send(propertyIDInput, messageInput, subjectInput);
					if (subjectInput.equals("Need further details")) {
						JOptionPane.showMessageDialog(frame, "Email successfully sent");
					}
					else {
						JOptionPane.showMessageDialog(frame, "Email successfully sent to the landlord at : " + controller.getLandlordEmail());
					}
				}
				else {
					
				}
			}
		});
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(new Color(0, 191, 255));
		TitlePanel.setBounds(0, 0, 753, 22);
		emailFrame.getContentPane().add(TitlePanel);
		TitlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Email");
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		titleLabel.setBounds(54, 0, 355, 22);
		TitlePanel.add(titleLabel);
		
		JLabel inboxLabel = new JLabel("Inbox");
		inboxLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		inboxLabel.setBounds(548, 0, 69, 22);
		TitlePanel.add(inboxLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(427, 33, 316, 221);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		emailFrame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			controller.getLandlordInbox(),
			new String[] {
				"From", "Subject", "Message"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	          String email = (table.getValueAt(table.getSelectedRow(), 2).toString());
	          JOptionPane.showMessageDialog(table, "<html><body><p style='width: 100px;'>" + email + "</p></body></html>");
	        }
	    });
		scrollPane.setViewportView(table);
		
		emailFrame.setVisible(true);
		
		
	}
}
