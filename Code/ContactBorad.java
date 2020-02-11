
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Title      : ContactBorad.java
 * Description: This class is the GUI content, it display the operation of contact with manager.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ContactBorad extends JFrame implements ActionListener {

	UserImpl userimpl = new UserImpl();
	//Contact contact = new Contact();
	ContactImpl contactimpl = new ContactImpl();
	ManageContact managecontact = new ManageContact();
	
	private JPanel contentPane;
	
	public JTextArea textArea;
	public JRadioButton rdbtnComplaints;
	public JRadioButton rdbtnAdvice;
	public JLabel lblWarnning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactBorad frame = new ContactBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactBorad() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		rdbtnAdvice = new JRadioButton("Advice");
		contentPane.add(rdbtnAdvice);
		rdbtnAdvice.addActionListener(this);
		rdbtnAdvice.setSelected(true);
		
		textArea = new JTextArea("");
		textArea.setRows(1);
		textArea.setLineWrap(true);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnAdvice, 0, SpringLayout.WEST, textArea);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 57, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -71, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 47, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -52, SpringLayout.EAST, contentPane);
		contentPane.add(textArea);
		
		rdbtnComplaints = new JRadioButton("Complaints");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnComplaints, 27, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnComplaints, 6, SpringLayout.EAST, rdbtnAdvice);
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnAdvice, 0, SpringLayout.NORTH, rdbtnComplaints);
		contentPane.add(rdbtnComplaints);
		rdbtnComplaints.addActionListener(this);
		
		JButton btnConfirm = new JButton("Confirm");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConfirm, 47, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnConfirm, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		JButton btnClear = new JButton("Clear");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnClear, 0, SpringLayout.NORTH, btnConfirm);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnClear, 46, SpringLayout.EAST, btnConfirm);
		contentPane.add(btnClear);
		btnClear.addActionListener(this);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, -44, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		lblWarnning = new JLabel("*Please choose one type!");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWarnning, 6, SpringLayout.SOUTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWarnning, 10, SpringLayout.WEST, textArea);
		contentPane.add(lblWarnning);
		
		JLabel lblYourFeedbackWill = new JLabel("Your feedback will use to improve our system server");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblYourFeedbackWill, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblYourFeedbackWill, -1, SpringLayout.NORTH, rdbtnAdvice);
		contentPane.add(lblYourFeedbackWill);
		
		
		
		
		setTitle("Contact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand() == "Confirm"){
			String type = "";

			if(rdbtnAdvice.isSelected() && rdbtnComplaints.isSelected()){
				rdbtnComplaints.setSelected(false);
				rdbtnAdvice.setSelected(false);
				lblWarnning.setText("Only can choose one type!");	
				lblWarnning.setForeground(Color.red);
			}
			else if(textArea.getText().length() == 0){
				lblWarnning.setText("Please enter something!");	
				lblWarnning.setForeground(Color.red);
			}
			else{
				if(rdbtnAdvice.isSelected()){
					type = "0";
				}
				if(rdbtnComplaints.isSelected()){
					type = "1";
				}
				String content;
				content = managecontact.newLine(textArea.getText());
				contactimpl.addContact(Integer.toString(userimpl.getNowUserInfo().getId()), userimpl.getNowUserInfo().getName() , type, content , ManageTime.getNormalDate());
				lblWarnning.setText("The feedback has been sent!");	
				lblWarnning.setForeground(Color.red);
				textArea.setText("");
			}

		}
		else if(e.getActionCommand() == "Clear"){
			textArea.setText("");
		}
		else if(e.getActionCommand() == "Back"){
			this.setVisible(false);
			new UserMainBorad();
		}
		
	}
}
