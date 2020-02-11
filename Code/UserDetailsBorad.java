
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * Title      : UserDetailsBorad.java
 * Description: This class is the GUI content, it display the user details.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class UserDetailsBorad extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	private JButton btnClickToView;
	
	private User[][] uld;
	
	private int a , b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetailsBorad frame = new UserDetailsBorad(0,0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserDetailsBorad(int judge , int i) {

		UserImpl userimpl = new UserImpl();
		ManageUser manageuser = new ManageUser();
		uld = manageuser.userList(userimpl.getAllUserInfo());
		b = judge;
		a = i;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lbluserInformation = new JLabel("[User Information]");
		lbluserInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbluserInformation, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbluserInformation, 28, SpringLayout.WEST, contentPane);
		contentPane.add(lbluserInformation);
		
		JLabel lblName = new JLabel("Name:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblName, 61, SpringLayout.WEST, contentPane);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, 6, SpringLayout.SOUTH, lblName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblName);
		contentPane.add(lblPassword);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmailAddress, 6, SpringLayout.SOUTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEmailAddress, 0, SpringLayout.WEST, lblName);
		contentPane.add(lblEmailAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPhoneNumber, 6, SpringLayout.SOUTH, lblEmailAddress);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPhoneNumber, 0, SpringLayout.WEST, lblName);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAddress, 0, SpringLayout.WEST, lblName);
		contentPane.add(lblAddress);
		
		JLabel lblId = new JLabel("ID:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblId, 61, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblName, 6, SpringLayout.SOUTH, lblId);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblId, 6, SpringLayout.SOUTH, lbluserInformation);
		contentPane.add(lblId);
		
		JLabel lblElectricityBudget = new JLabel("Electricity Budget:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblElectricityBudget, 6, SpringLayout.SOUTH, lblPhoneNumber);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblElectricityBudget, 0, SpringLayout.WEST, lblName);
		contentPane.add(lblElectricityBudget);
		
		JLabel lblGasBudget = new JLabel("Gas Budget:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAddress, 6, SpringLayout.SOUTH, lblGasBudget);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGasBudget, 6, SpringLayout.SOUTH, lblElectricityBudget);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGasBudget, 0, SpringLayout.WEST, lblName);
		contentPane.add(lblGasBudget);
		
		JLabel lblId_1 = new JLabel(Integer.toString(uld[i][judge].getId()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblId_1, 0, SpringLayout.NORTH, lblId);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblId_1, 149, SpringLayout.EAST, lblId);
		contentPane.add(lblId_1);
		
		JLabel lblName_1 = new JLabel(uld[i][judge].getName());
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblName_1, 0, SpringLayout.NORTH, lblName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblName_1, 0, SpringLayout.WEST, lblId_1);
		contentPane.add(lblName_1);
		
		JLabel lblEmail = new JLabel(uld[i][judge].getEmail());
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 0, SpringLayout.NORTH, lblEmailAddress);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblId_1);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel(Integer.toString(uld[i][judge].getPhone()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPhone, 0, SpringLayout.NORTH, lblPhoneNumber);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPhone, 0, SpringLayout.WEST, lblId_1);
		contentPane.add(lblPhone);
		
		JLabel lblEle = new JLabel(Float.toString(uld[i][judge].getElectricity_budget()) + " £");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEle, 6, SpringLayout.SOUTH, lblPhone);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEle, 54, SpringLayout.EAST, lblElectricityBudget);
		contentPane.add(lblEle);
		
		JLabel lblGas = new JLabel(Float.toString(uld[i][judge].getGas_budget()) + " £");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGas, 0, SpringLayout.NORTH, lblGasBudget);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGas, 93, SpringLayout.EAST, lblGasBudget);
		contentPane.add(lblGas);
		
		JTextArea textArea = new JTextArea(uld[i][judge].getAddress());
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblAddress);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, lblName);
		contentPane.add(textArea);
		
		btnClickToView = new JButton("Click to view");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnClickToView, 0, SpringLayout.NORTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnClickToView, 0, SpringLayout.WEST, lblId_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnClickToView, -170, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnClickToView, -92, SpringLayout.EAST, contentPane);
		contentPane.add(btnClickToView);
		btnClickToView.addActionListener(this);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -3, SpringLayout.SOUTH, btnBack);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -11, SpringLayout.WEST, btnBack);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		
		setTitle("User's Deatils");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand() == "Back"){
			
			this.setVisible(false);
			new ManageUserBorad();
			
		}
		else if(e.getActionCommand() == "Click to view"){
			
			btnClickToView.setText(uld[a][b].getPassword());
			
		}
		else if(e.getActionCommand() == uld[a][b].getPassword()){
			
			btnClickToView.setText("Click to view");
			
		}
		
		
	}
}
