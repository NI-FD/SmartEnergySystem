
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;
import java.util.regex.*;

/**
 * Title      : RegisterBorad.java
 * Description: This class is the GUI content, it display the operation of register.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class RegisterBorad extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblMustEnterThe;
	private JLabel lblPassword_1;
	private JLabel lblEmail_1;
	private JLabel lblPhoneNumber_1;
	private JLabel lblAddress_1;
	private Integer[] isOk = new Integer[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterBorad frame = new RegisterBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterBorad() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblName = new JLabel("Name:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblName, 25, SpringLayout.NORTH, contentPane);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblName, 0, SpringLayout.EAST, lblPassword);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 91, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPassword, -16, SpringLayout.NORTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblEmail);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAddress, 0, SpringLayout.EAST, lblName);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAddress, 19, SpringLayout.SOUTH, lblPhoneNumber);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPhoneNumber, 18, SpringLayout.SOUTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPhoneNumber, 37, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblPhoneNumber);
		contentPane.add(lblPhoneNumber);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblName);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 11, SpringLayout.EAST, lblName);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -5, SpringLayout.NORTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, -5, SpringLayout.NORTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, textField_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_4, -5, SpringLayout.NORTH, lblAddress);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConfirm, 0, SpringLayout.WEST, lblPhoneNumber);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnConfirm, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		JButton btnClear = new JButton("Clear");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnClear, 0, SpringLayout.NORTH, btnConfirm);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnClear, 47, SpringLayout.EAST, btnConfirm);
		contentPane.add(btnClear);
		btnClear.addActionListener(this);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnConfirm);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBack, 54, SpringLayout.EAST, btnClear);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel lblcantIncludeSpecificy = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblcantIncludeSpecificy, 1, SpringLayout.NORTH, lblName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblcantIncludeSpecificy, 12, SpringLayout.EAST, textField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblcantIncludeSpecificy, -33, SpringLayout.SOUTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblcantIncludeSpecificy, 0, SpringLayout.EAST, contentPane);
		lblcantIncludeSpecificy.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		contentPane.add(lblcantIncludeSpecificy);
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				boolean isMatch1 = Pattern.matches("^\\w+$", textField.getText());
				if(!isMatch1) {
					lblcantIncludeSpecificy.setText("The input is invalid.");
					lblcantIncludeSpecificy.setForeground(Color.RED);
					isOk[0] = 0;
				}else
					{
					lblcantIncludeSpecificy.setText("The input is valid.");
					lblcantIncludeSpecificy.setForeground(Color.BLACK);
					isOk[0] = 1;
					}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				lblcantIncludeSpecificy.setText("Only number,English letters and underscores.");			
			}
		});
		
		
		
		JLabel label = new JLabel("*");
		JLabel lblPassword_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lblName);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, lblName);
		contentPane.add(label);
	
		JLabel label_1 = new JLabel("*");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_1, -6, SpringLayout.WEST, lblPassword);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("*");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_3, -6, SpringLayout.WEST, lblEmail);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("*");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 0, SpringLayout.NORTH, lblPhoneNumber);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_4, -6, SpringLayout.WEST, lblPhoneNumber);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("*");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_5, 0, SpringLayout.NORTH, lblAddress);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_5, -6, SpringLayout.WEST, lblAddress);
		contentPane.add(label_5);
		
		lblMustEnterThe = new JLabel("Must enter the * option");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMustEnterThe, 133, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblMustEnterThe, -14, SpringLayout.NORTH, btnClear);
		contentPane.add(lblMustEnterThe);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword_1, 4, SpringLayout.NORTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword_1, 0, SpringLayout.WEST, lblcantIncludeSpecificy);
		lblPassword_1.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		lblPassword_1.setForeground(Color.RED);
		contentPane.add(lblPassword_1);
		textField_1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				boolean isMatch2 = Pattern.matches("^[a-zA-Z]\\w{5,17}$", textField_1.getText());
				if(!isMatch2) {
					lblPassword_1.setText("The input is invalid.");
					lblPassword_1.setForeground(Color.RED);
					isOk[1] = 0;
				}else
					{
					lblPassword_1.setText("The input is valid.");
					lblPassword_1.setForeground(Color.BLACK);
					isOk[1] = 1;
					}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				lblPassword_1.setText("Only number,English letters and underscores.");			
			}
		});
		
		lblEmail_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail_1, 4, SpringLayout.NORTH, lblEmail);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEmail_1, 0, SpringLayout.WEST, lblcantIncludeSpecificy);
		lblEmail_1.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		lblEmail_1.setForeground(Color.RED);
		contentPane.add(lblEmail_1);
		textField_2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				boolean isMatch3 = Pattern.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", textField_2.getText());
				if(!isMatch3) {
					lblEmail_1.setText("The input is invalid.");
					lblEmail_1.setForeground(Color.RED);
					isOk[2] = 0;
				}else
					{
					lblEmail_1.setText("The input is valid.");
					lblEmail_1.setForeground(Color.BLACK);
					isOk[2] = 1;
					}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				lblEmail_1.setText("Please input valid e-mail address.");			
			}
		});
		
		
		lblPhoneNumber_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPhoneNumber_1, 4, SpringLayout.NORTH, lblPhoneNumber);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPhoneNumber_1, 0, SpringLayout.WEST, lblcantIncludeSpecificy);
		lblPhoneNumber_1.setForeground(Color.RED);
		lblPhoneNumber_1.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		contentPane.add(lblPhoneNumber_1);
		textField_3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub ^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$
				boolean isMatch4 = Pattern.matches("^[1-9]\\d*$", textField_3.getText());
				if(!isMatch4) {
					lblPhoneNumber_1.setText("The input is invalid.");
					lblPhoneNumber_1.setForeground(Color.RED);
					isOk[3] = 0;
				}else
					{
					lblPhoneNumber_1.setText("The input is valid.");
					lblPhoneNumber_1.setForeground(Color.BLACK);
					isOk[3] = 1;
					}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				lblPhoneNumber_1.setText("Please input valid phone number.");			
			}
		});
		
		lblAddress_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAddress_1, 4, SpringLayout.NORTH, lblAddress);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAddress_1, 0, SpringLayout.WEST, lblcantIncludeSpecificy);
		lblAddress_1.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		lblAddress_1.setForeground(Color.RED);
		contentPane.add(lblAddress_1);
		textField_4.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				boolean isMatch5 = Pattern.matches("^\\w+$", textField_4.getText());
				if(!isMatch5) {
					lblAddress_1.setText("The input is invalid.");
					lblAddress_1.setForeground(Color.RED);
					isOk[4] = 0;
				}else
					{
					lblAddress_1.setText("The input is valid.");
					lblAddress_1.setForeground(Color.BLACK);
					isOk[4] = 1;
					}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				lblAddress_1.setText("In addition to punctuation.");			
			}
		});
		
		setTitle("Add New Customer");
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
        	if(isOk[0] == 1 && isOk[1] == 1 && isOk[2] == 1 && isOk[3] == 1 && isOk[4] == 1){
            	try{
                	String name = textField.getText();
                	String password = textField_1.getText();
                	String address = textField_4.getText();
                	String email = textField_2.getText();
                	String phone = textField_3.getText();
                	Register register = new Register();
                	if(register.check(name)){
                		User user = new User();
                		UserImpl userimpl = new UserImpl();
                		
                		user.setName(name);
                		user.setPassword(password);
                		user.setAddress(address);
                		user.setEmail(email);
                		user.setPhone(Integer.parseInt(phone));
                		
                		userimpl.addNewUser(user);
                		this.lblMustEnterThe.setText("The user had been add to database!");
                		this.lblMustEnterThe.setForeground(Color.red);
                	}
                	else if(!register.check(name)){
                		this.lblMustEnterThe.setText("The user had existed! Please try again!");
                		this.lblMustEnterThe.setForeground(Color.red);
                	}
                	else{
                		this.lblMustEnterThe.setText("Wrong Input! Please try again!");
                		this.lblMustEnterThe.setForeground(Color.red);
                	}
            	}catch(Exception ex){
            		this.lblMustEnterThe.setText("Wrong Input! Please try again!");
            		this.lblMustEnterThe.setForeground(Color.red);
            	}
        	}
        	else{
        		this.lblMustEnterThe.setText("Wrong Input! Please try again!");
        		this.lblMustEnterThe.setForeground(Color.red);
        	}
        	
        }
        else if(e.getActionCommand()=="Back"){
    		this.setVisible(false);
    		new ManageUserBorad();
        }
        else if(e.getActionCommand()=="Clear")  
        {  
        	clear();  
        }  
	}
	
    public void clear() {  
    	textField.setText("");  
    	textField_1.setText("");  
    	textField_2.setText("");  
    	textField_3.setText("");
    	textField_4.setText("");
    }

	
//	private JPanel contentPane;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JTextField textField_4;
//	private JLabel lblMustEnterThe;
//	private JLabel lblPassword_1;
//	private JLabel lblEmail_1;
//	private JLabel lblPhoneNumber_1;
//	private JLabel lblAddress_1;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterBorad frame = new RegisterBorad();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public RegisterBorad() {
//
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		SpringLayout sl_contentPane = new SpringLayout();
//		contentPane.setLayout(sl_contentPane);
//		
//		JLabel lblName = new JLabel("Name:");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblName, 25, SpringLayout.NORTH, contentPane);
//		contentPane.add(lblName);
//		
//		JLabel lblPassword = new JLabel("Password:");
//		sl_contentPane.putConstraint(SpringLayout.EAST, lblName, 0, SpringLayout.EAST, lblPassword);
//		contentPane.add(lblPassword);
//		
//		JLabel lblEmail = new JLabel("Email:");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail, 91, SpringLayout.NORTH, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPassword, -16, SpringLayout.NORTH, lblEmail);
//		sl_contentPane.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblEmail);
//		contentPane.add(lblEmail);
//		
//		JLabel lblAddress = new JLabel("Address:");
//		sl_contentPane.putConstraint(SpringLayout.EAST, lblAddress, 0, SpringLayout.EAST, lblName);
//		contentPane.add(lblAddress);
//		
//		JLabel lblPhoneNumber = new JLabel("Phone Number:");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAddress, 19, SpringLayout.SOUTH, lblPhoneNumber);
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPhoneNumber, 18, SpringLayout.SOUTH, lblEmail);
//		sl_contentPane.putConstraint(SpringLayout.WEST, lblPhoneNumber, 37, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblPhoneNumber);
//		contentPane.add(lblPhoneNumber);
//		
//		textField = new JTextField();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblName);
//		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 11, SpringLayout.EAST, lblName);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
//		textField_1 = new JTextField();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -5, SpringLayout.NORTH, lblPassword);
//		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
//		contentPane.add(textField_1);
//		textField_1.setColumns(10);
//		
//		textField_2 = new JTextField();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, -5, SpringLayout.NORTH, lblEmail);
//		sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
//		contentPane.add(textField_2);
//		textField_2.setColumns(10);
//		
//		textField_3 = new JTextField();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, textField_2);
//		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
//		contentPane.add(textField_3);
//		textField_3.setColumns(10);
//		
//		textField_4 = new JTextField();
//		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_4, -5, SpringLayout.NORTH, lblAddress);
//		sl_contentPane.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
//		contentPane.add(textField_4);
//		textField_4.setColumns(10);
//		
//		JButton btnConfirm = new JButton("Confirm");
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnConfirm, 0, SpringLayout.WEST, lblPhoneNumber);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnConfirm, -10, SpringLayout.SOUTH, contentPane);
//		contentPane.add(btnConfirm);
//		btnConfirm.addActionListener(this);
//		
//		JButton btnClear = new JButton("Clear");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, btnClear, 0, SpringLayout.NORTH, btnConfirm);
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnClear, 47, SpringLayout.EAST, btnConfirm);
//		contentPane.add(btnClear);
//		btnClear.addActionListener(this);
//		
//		JButton btnBack = new JButton("Back");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnConfirm);
//		sl_contentPane.putConstraint(SpringLayout.WEST, btnBack, 54, SpringLayout.EAST, btnClear);
//		contentPane.add(btnBack);
//		btnBack.addActionListener(this);
//		
//		JLabel lblcantIncludeSpecificy = new JLabel("* Can't include symbol ' * '");
//		lblcantIncludeSpecificy.setForeground(Color.RED);
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblcantIncludeSpecificy, 1, SpringLayout.NORTH, lblName);
//		sl_contentPane.putConstraint(SpringLayout.WEST, lblcantIncludeSpecificy, 12, SpringLayout.EAST, textField);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblcantIncludeSpecificy, -33, SpringLayout.SOUTH, lblPassword);
//		sl_contentPane.putConstraint(SpringLayout.EAST, lblcantIncludeSpecificy, 0, SpringLayout.EAST, contentPane);
//		lblcantIncludeSpecificy.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
//		contentPane.add(lblcantIncludeSpecificy);
//		
//		JLabel label = new JLabel("*");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lblName);
//		sl_contentPane.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, lblName);
//		contentPane.add(label);
//		
//		JLabel label_1 = new JLabel("*");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, lblPassword);
//		sl_contentPane.putConstraint(SpringLayout.EAST, label_1, -6, SpringLayout.WEST, lblPassword);
//		contentPane.add(label_1);
//		
//		JLabel label_3 = new JLabel("*");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, lblEmail);
//		sl_contentPane.putConstraint(SpringLayout.EAST, label_3, -6, SpringLayout.WEST, lblEmail);
//		contentPane.add(label_3);
//		
//		JLabel label_4 = new JLabel("*");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 0, SpringLayout.NORTH, lblPhoneNumber);
//		sl_contentPane.putConstraint(SpringLayout.EAST, label_4, -6, SpringLayout.WEST, lblPhoneNumber);
//		contentPane.add(label_4);
//		
//		JLabel label_5 = new JLabel("*");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, label_5, 0, SpringLayout.NORTH, lblAddress);
//		sl_contentPane.putConstraint(SpringLayout.EAST, label_5, -6, SpringLayout.WEST, lblAddress);
//		contentPane.add(label_5);
//		
//		lblMustEnterThe = new JLabel("Must enter the * option");
//		sl_contentPane.putConstraint(SpringLayout.WEST, lblMustEnterThe, 133, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblMustEnterThe, -14, SpringLayout.NORTH, btnClear);
//		contentPane.add(lblMustEnterThe);
//		lblPassword_1 = new JLabel("password");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword_1, 4, SpringLayout.NORTH, lblPassword);
//		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword_1, 0, SpringLayout.WEST, lblcantIncludeSpecificy);
//		lblPassword_1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
//		lblPassword_1.setForeground(Color.RED);
//		contentPane.add(lblPassword_1);
//		
//		lblEmail_1 = new JLabel("email");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEmail_1, 4, SpringLayout.NORTH, lblEmail);
//		sl_contentPane.putConstraint(SpringLayout.WEST, lblEmail_1, 0, SpringLayout.WEST, lblcantIncludeSpecificy);
//		lblEmail_1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
//		lblEmail_1.setForeground(Color.RED);
//		contentPane.add(lblEmail_1);
//		
//		lblPhoneNumber_1 = new JLabel("phone number");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPhoneNumber_1, 4, SpringLayout.NORTH, lblPhoneNumber);
//		sl_contentPane.putConstraint(SpringLayout.WEST, lblPhoneNumber_1, 0, SpringLayout.WEST, lblcantIncludeSpecificy);
//		lblPhoneNumber_1.setForeground(Color.RED);
//		lblPhoneNumber_1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
//		contentPane.add(lblPhoneNumber_1);
//		
//		lblAddress_1 = new JLabel("address");
//		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAddress_1, 4, SpringLayout.NORTH, lblAddress);
//		sl_contentPane.putConstraint(SpringLayout.WEST, lblAddress_1, 0, SpringLayout.WEST, lblcantIncludeSpecificy);
//		lblAddress_1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
//		lblAddress_1.setForeground(Color.RED);
//		contentPane.add(lblAddress_1);
//		
//		
//		setTitle("Add New Customer");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		setContentPane(contentPane);
//		this.setVisible(true);
//		this.setResizable(false);
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//        if(e.getActionCommand()=="Confirm")  
//        {  
//        	try{
//            	String name = textField.getText();
//            	String password = textField_1.getText();
//            	String address = textField_2.getText();
//            	String email = textField_3.getText();
//            	String phone = textField_4.getText();
//            	Register register = new Register();
//            	if(register.check(name)){
//            		User user = new User();
//            		UserImpl userimpl = new UserImpl();
//            		
//            		user.setName(name);
//            		user.setPassword(password);
//            		user.setAddress(address);
//            		user.setEmail(email);
//            		user.setPhone(Integer.parseInt(phone));
//            		
//            		userimpl.addNewUser(user);
//            		this.lblMustEnterThe.setText("The user had been add to database!");
//            		this.lblMustEnterThe.setForeground(Color.red);
//            	}
//            	else if(!register.check(name)){
//            		this.lblMustEnterThe.setText("The user had existed! Please try again!");
//            		this.lblMustEnterThe.setForeground(Color.red);
//            	}
//            	else{
//            		this.lblMustEnterThe.setText("Wrong Input! Please try again!");
//            		this.lblMustEnterThe.setForeground(Color.red);
//            	}
//        	}catch(Exception ex){
//        		this.lblMustEnterThe.setText("Wrong Input! Please try again!");
//        		this.lblMustEnterThe.setForeground(Color.red);
//        	}
//
//
//        }
//        else if(e.getActionCommand()=="Back"){
//    		this.setVisible(false);
//    		new ManageUserBorad();
//        }
//        else if(e.getActionCommand()=="Clear")  
//        {  
//        	clear();  
//        }  
//	}
//	
//    public  void clear()  
//    {  
//    	textField.setText("");  
//    	textField_1.setText("");  
//    	textField_2.setText("");  
//    	textField_3.setText("");
//    	textField_4.setText("");
//    }
//    
}
