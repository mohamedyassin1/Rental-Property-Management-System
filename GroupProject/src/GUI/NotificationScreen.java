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
import controller.NotificationController;

public class NotificationScreen implements Component{
	private JFrame notificationFrame;
	public NotificationScreen(){
		draw();
	}
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	@SuppressWarnings("serial")
	@Override
	public void draw() {
		notificationFrame = new JFrame();
		notificationFrame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		notificationFrame.setLocation(dim.width/2-250, dim.height/2-250); 
		notificationFrame.getContentPane().setLayout(null);
		notificationFrame.setSize(767,305);

		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(new Color(0, 191, 255));
		TitlePanel.setBounds(0, 0, 753, 22);
		notificationFrame.getContentPane().add(TitlePanel);
		TitlePanel.setLayout(null);
		NotificationController controller = new NotificationController();
		JLabel titleLabel = new JLabel("Notifications");
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		titleLabel.setBounds(350, 0, 355, 22);
		TitlePanel.add(titleLabel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 740, 221);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		notificationFrame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			controller.getNotifications(),
			new String[] {
				"PropertyID", "Address"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane.setViewportView(table);
		
		notificationFrame.setVisible(true);
		
		
	}
}

