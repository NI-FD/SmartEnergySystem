
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPasswordField;

/**
 * Title      : LoginBorad.java
 * Description: This class is the GUI content, it display the operation of login.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class LoginBorad extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblPleaseEnterThe;
	
	UserImpl userimpl = new UserImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginBorad frame = new LoginBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginBorad() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblName = new JLabel("Name:");
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPassword, -126, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblName, 0, SpringLayout.WEST, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword, 113, SpringLayout.WEST, contentPane);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 29, SpringLayout.EAST, lblName);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblName, 5, SpringLayout.NORTH, textField);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnConfirm, 200, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnConfirm, -255, SpringLayout.EAST, contentPane);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnConfirm);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBack, 72, SpringLayout.EAST, btnConfirm);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel lblWelcomeToUse = new JLabel("Welcome to Use Smart Energy Monitoring System");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 36, SpringLayout.SOUTH, lblWelcomeToUse);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWelcomeToUse, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWelcomeToUse, 64, SpringLayout.WEST, contentPane);
		contentPane.add(lblWelcomeToUse);
		
		lblPleaseEnterThe = new JLabel("*Please enter the correct value\n");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPleaseEnterThe, 0, SpringLayout.WEST, lblName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPleaseEnterThe, -6, SpringLayout.NORTH, btnConfirm);
		contentPane.add(lblPleaseEnterThe);
		
		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 121, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPleaseEnterThe, 16, SpringLayout.SOUTH, passwordField);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 6, SpringLayout.EAST, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, textField);
		contentPane.add(passwordField);
		
		
		setTitle("Login in System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getActionCommand()=="Confirm")  
        {  
        	String name = textField.getText();
        	String password = passwordField.getText();
        	Login login = new Login();
        	if(login.check(name, password)){
        		userimpl.updateNowUser(userimpl.queryUserInfoByName(name));
        		this.setVisible(false);
        		new UserMainBorad();
        		System.out.println("CORRECT");
        	}
        	else{
        		lblPleaseEnterThe.setText("*The user's name or password is incorrect!");
        		lblPleaseEnterThe.setForeground(Color.red);
        		System.out.println("INCORRECT");
        	}
        }
        else if(e.getActionCommand()=="Back"){
        	 //System.exit(0);
    		this.setVisible(false);
    		new SelectSystemBorad();
        }
	}
}
