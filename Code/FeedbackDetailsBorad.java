
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Title      : FeedbackDetailsBorad.java
 * Description: This class is the GUI content, it display the details of feedback from user.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class FeedbackDetailsBorad extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedbackDetailsBorad frame = new FeedbackDetailsBorad(0 , 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FeedbackDetailsBorad(int judge , int i) {

		UserImpl userimpl = new UserImpl();
		ContactImpl contactimpl = new ContactImpl();
		ManageContact managecontact = new ManageContact();
		Contact contact = new Contact();
		User user = new User();
		
		Contact[][] contactlist = managecontact.contactList(contactimpl.getContact());
		contact = contactlist[i][judge];
		user = userimpl.queryUserInfoById(contact.getId());
		
		String str_type = "";
		String content = managecontact.oldLine(contact.getContent());
		if(contact.getType() == 0){
			str_type = "Advice";
		}
		else{
			str_type = "Complaints";
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblUserName = new JLabel("User Name:");
		contentPane.add(lblUserName);
		
		JLabel lblMessageType = new JLabel("Message Type:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUserName, 0, SpringLayout.WEST, lblMessageType);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblUserName, -20, SpringLayout.NORTH, lblMessageType);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMessageType, 48, SpringLayout.WEST, contentPane);
		contentPane.add(lblMessageType);
		
		JLabel lblMessageTime = new JLabel("Message Time:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMessageTime, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblMessageType, -6, SpringLayout.NORTH, lblMessageTime);
		contentPane.add(lblMessageTime);
		
		JLabel lblUserId = new JLabel("User ID:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUserId, 0, SpringLayout.WEST, lblUserName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblUserId, -6, SpringLayout.NORTH, lblUserName);
		contentPane.add(lblUserId);
		
		JLabel lblContent = new JLabel("Content:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblContent, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblContent, -124, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblMessageTime, -6, SpringLayout.NORTH, lblContent);
		contentPane.add(lblContent);
		
		JLabel lblUserEmail = new JLabel("User Email:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUserEmail, 0, SpringLayout.NORTH, lblUserId);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUserEmail, 121, SpringLayout.EAST, lblUserId);
		contentPane.add(lblUserEmail);
		
		JLabel lblUserPhone = new JLabel("User Phone:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUserPhone, 0, SpringLayout.NORTH, lblUserName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUserPhone, 0, SpringLayout.WEST, lblUserEmail);
		contentPane.add(lblUserPhone);
		
		JLabel lblId = new JLabel(Integer.toString(user.getId()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblId, 0, SpringLayout.NORTH, lblUserId);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblId, 6, SpringLayout.EAST, lblUserId);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel(user.getName());
		sl_contentPane.putConstraint(SpringLayout.WEST, lblName, 6, SpringLayout.EAST, lblUserName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblName, 0, SpringLayout.SOUTH, lblUserName);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel(user.getEmail());
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 0, SpringLayout.NORTH, lblUserId);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEmail, 6, SpringLayout.EAST, lblUserEmail);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel(Integer.toString(user.getPhone()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPhone, 0, SpringLayout.NORTH, lblUserName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPhone, 6, SpringLayout.EAST, lblUserPhone);
		contentPane.add(lblPhone);
		
		JLabel lblType = new JLabel(str_type);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblType, 0, SpringLayout.NORTH, lblMessageType);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblType, 6, SpringLayout.EAST, lblMessageType);
		contentPane.add(lblType);
		
		JLabel lblTime = new JLabel(contact.getDate());
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTime, 6, SpringLayout.EAST, lblMessageTime);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTime, 0, SpringLayout.SOUTH, lblMessageTime);
		contentPane.add(lblTime);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		JTextArea textArea = new JTextArea(content);
		textArea.setRows(1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblContent);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, btnBack);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, 391, SpringLayout.WEST, contentPane);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		setTitle("Message's Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);	
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Back"){
			this.setVisible(false);
			new MessageBorad();
		}
	}

}
