
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;

/**
 * Title      : ManageUserBill.java
 * Description: This class is the GUI content, it display the operation of user's bills list.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ManageUserBill extends JFrame implements ActionListener {

	public static java.text.DecimalFormat df = new  java.text.DecimalFormat("#0.00");
	
	private JPanel contentPane;
	
	private JLabel lblM;
	private JLabel lblM_1;
	private JLabel lblM_2;
	private JLabel lblM_3;
	private JLabel lblM_4;
	
	private JLabel lblU;
	private JLabel lblU_1;
	private JLabel lblU_2;
	private JLabel lblU_3;
	private JLabel lblU_4;
	
	private JLabel lblC;
	private JLabel lblC_1;
	private JLabel lblC_2;
	private JLabel lblC_3;
	private JLabel lblC_4;
	
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	
	private JLabel lblPage;
	private JLabel lblPleaseChooseThe;
	
	private JRadioButton rdbtnByPosting;
	private JRadioButton rdbtnByEmaill;
	private JRadioButton rdbtnBySystem;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel lblSendBy;
	
	private JButton button;
	private JButton button_1;
	private JButton btnSend;
	
	private SystemRecord[][] list;
	private SystemRecord[][] judge_list;
	UserImpl userimpl = new UserImpl();
	ManageRecord managerecord = new ManageRecord();
	SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
	
	private int id;
	int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUserBill frame = new ManageUserBill(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageUserBill(int id) {
		
		i = 0;
		this.id = id;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblUsage = new JLabel("Usage");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsage, 32, SpringLayout.NORTH, contentPane);
		contentPane.add(lblUsage);
		
		JLabel lblCost = new JLabel("Cost");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCost, 32, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblUsage, -59, SpringLayout.WEST, lblCost);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCost, -57, SpringLayout.EAST, contentPane);
		contentPane.add(lblCost);
		
		JLabel lblMonth = new JLabel("Date");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMonth, 0, SpringLayout.NORTH, lblUsage);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblMonth, -83, SpringLayout.WEST, lblUsage);
		contentPane.add(lblMonth);
		
		lblM = new JLabel("m1");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblM, 0, SpringLayout.WEST, lblMonth);
		contentPane.add(lblM);
		
		lblM_1 = new JLabel("m2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblM_1, 96, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblM_1, 0, SpringLayout.WEST, lblMonth);
		contentPane.add(lblM_1);
		
		lblM_2 = new JLabel("m3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblM_2, 125, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblM_2, 0, SpringLayout.WEST, lblMonth);
		contentPane.add(lblM_2);
		
		lblM_3 = new JLabel("m4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblM_3, 13, SpringLayout.SOUTH, lblM_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblM_3, 0, SpringLayout.WEST, lblMonth);
		contentPane.add(lblM_3);
		
		lblM_4 = new JLabel("m5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblM_4, 13, SpringLayout.SOUTH, lblM_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblM_4, 0, SpringLayout.WEST, lblMonth);
		contentPane.add(lblM_4);
		
		lblU = new JLabel("u1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU, 0, SpringLayout.NORTH, lblM);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU, 0, SpringLayout.WEST, lblUsage);
		contentPane.add(lblU);
		
		lblU_1 = new JLabel("u2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU_1, 0, SpringLayout.NORTH, lblM_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU_1, 0, SpringLayout.WEST, lblUsage);
		contentPane.add(lblU_1);
		
		lblU_2 = new JLabel("u3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU_2, 0, SpringLayout.NORTH, lblM_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU_2, 0, SpringLayout.WEST, lblUsage);
		contentPane.add(lblU_2);
		
		lblU_3 = new JLabel("u4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU_3, 0, SpringLayout.NORTH, lblM_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU_3, 0, SpringLayout.WEST, lblUsage);
		contentPane.add(lblU_3);
		
		lblU_4 = new JLabel("u5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU_4, 0, SpringLayout.NORTH, lblM_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU_4, 0, SpringLayout.WEST, lblUsage);
		contentPane.add(lblU_4);
		
		lblC = new JLabel("c1");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC);
		
		lblC_1 = new JLabel("c2");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblC, -10, SpringLayout.NORTH, lblC_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC_1, 0, SpringLayout.NORTH, lblM_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC_1, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC_1);
		
		lblC_2 = new JLabel("c3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC_2, 13, SpringLayout.SOUTH, lblC_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC_2, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC_2);
		
		lblC_3 = new JLabel("c4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC_3, 13, SpringLayout.SOUTH, lblC_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC_3, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC_3);
		
		lblC_4 = new JLabel("c5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC_4, 13, SpringLayout.SOUTH, lblC_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC_4, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC_4);
		
		checkBox = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox, -4, SpringLayout.NORTH, lblM);
		sl_contentPane.putConstraint(SpringLayout.EAST, checkBox, -6, SpringLayout.WEST, lblM);
		contentPane.add(checkBox);
		checkBox.addActionListener(this);
		
		checkBox_1 = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox_1, 0, SpringLayout.WEST, checkBox);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, checkBox_1, -153, SpringLayout.SOUTH, contentPane);
		contentPane.add(checkBox_1);
		checkBox_1.addActionListener(this);
		
		checkBox_2 = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox_2, 121, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox_2, 0, SpringLayout.WEST, checkBox);
		contentPane.add(checkBox_2);
		checkBox_2.addActionListener(this);
		
		checkBox_3 = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox_3, -4, SpringLayout.NORTH, lblM_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox_3, 0, SpringLayout.WEST, checkBox);
		contentPane.add(checkBox_3);
		checkBox_3.addActionListener(this);
		
		checkBox_4 = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox_4, -4, SpringLayout.NORTH, lblM_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox_4, 0, SpringLayout.WEST, checkBox);
		contentPane.add(checkBox_4);
		checkBox_4.addActionListener(this);
		
		button = new JButton("<");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 6, SpringLayout.SOUTH, lblM_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, checkBox_4);
		contentPane.add(button);
		button.addActionListener(this);
		
		button_1 = new JButton(">");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 6, SpringLayout.SOUTH, lblC_4);
		contentPane.add(button_1);
		button_1.addActionListener(this);
		
		lblPage = new JLabel("Page: 1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPage, 11, SpringLayout.SOUTH, lblU_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, button_1, 35, SpringLayout.EAST, lblPage);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPage, 21, SpringLayout.EAST, button);
		contentPane.add(lblPage);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		btnSend = new JButton("Send");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSend, 0, SpringLayout.NORTH, btnBack);
		contentPane.add(btnSend);
		btnSend.addActionListener(this);
		
		rdbtnByPosting = new JRadioButton("Post");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnByPosting, -4, SpringLayout.NORTH, lblM_1);
		rdbtnByPosting.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(rdbtnByPosting);
		rdbtnByPosting.addActionListener(this);
		
		rdbtnByEmaill = new JRadioButton("Emaill");
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnByEmaill, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnByPosting, 0, SpringLayout.WEST, rdbtnByEmaill);
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnByEmaill, -4, SpringLayout.NORTH, lblM_2);
		rdbtnByEmaill.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(rdbtnByEmaill);
		rdbtnByEmaill.addActionListener(this);
		
		rdbtnBySystem = new JRadioButton("System");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnBySystem, -4, SpringLayout.NORTH, lblM_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnBySystem, 0, SpringLayout.WEST, contentPane);
		rdbtnBySystem.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(rdbtnBySystem);
		rdbtnBySystem.addActionListener(this);
		
		lblPleaseChooseThe = new JLabel("Please choose one bill and the send type you want to send!");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPleaseChooseThe, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPleaseChooseThe, -242, SpringLayout.SOUTH, contentPane);
		lblPleaseChooseThe.setForeground(Color.BLACK);
		contentPane.add(lblPleaseChooseThe);
		
		label = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSend, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lblUsage);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -53, SpringLayout.WEST, lblMonth);
		contentPane.add(label);
		
		label_1 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		contentPane.add(label_1);
		
		label_2 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_2, 0, SpringLayout.SOUTH, checkBox);
		contentPane.add(label_2);
		
		label_3 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, checkBox_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label);
		contentPane.add(label_3);
		
		label_4 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 2, SpringLayout.SOUTH, label_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_4, 0, SpringLayout.WEST, label);
		contentPane.add(label_4);
		
		label_5 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_5, 0, SpringLayout.SOUTH, checkBox_2);
		contentPane.add(label_5);
		
		label_6 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_6, 0, SpringLayout.NORTH, checkBox_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_6, 0, SpringLayout.WEST, label);
		contentPane.add(label_6);
		
		label_7 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_7, 2, SpringLayout.SOUTH, label_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_7, 0, SpringLayout.WEST, label);
		contentPane.add(label_7);
		
		label_8 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_8, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_8, 0, SpringLayout.SOUTH, checkBox_4);
		contentPane.add(label_8);
		
		label_9 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_9, 3, SpringLayout.SOUTH, label_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_9, 0, SpringLayout.WEST, label);
		contentPane.add(label_9);
		
		lblSendBy = new JLabel("Send by:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSendBy, 0, SpringLayout.NORTH, lblM);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSendBy, 0, SpringLayout.WEST, contentPane);
		contentPane.add(lblSendBy);
		
		JLabel lblMultiplyChoice = new JLabel("*Multiply Choice");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMultiplyChoice, 2, SpringLayout.NORTH, lblM_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMultiplyChoice, 0, SpringLayout.WEST, contentPane);
		lblMultiplyChoice.setForeground(Color.RED);
		lblMultiplyChoice.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		contentPane.add(lblMultiplyChoice);
		
		JLabel lblSingleChoice = new JLabel("*Single Choice");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSingleChoice, -204, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblM, 6, SpringLayout.SOUTH, lblSingleChoice);
		lblSingleChoice.setForeground(Color.RED);
		lblSingleChoice.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSingleChoice, 0, SpringLayout.WEST, checkBox);
		contentPane.add(lblSingleChoice);
		
		init(); 
//		if(list == null){
//			button.setEnabled(false);
//			button_1.setEnabled(false);
//			btnSend.setEnabled(false);
//			lblPleaseChooseThe.setText("No Record! Please try another option!");
//			lblPleaseChooseThe.setForeground(Color.red);
//			hideLabel();
//		}
//		else{
//			showBillList(list);
//		}
		showBillList(list);
		
		setTitle("Manage User's Bills");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int judge_select = 0;
		int judge_num = 0;
		int record_select = 0;
		int record_num = 0;
		Object[] options = { "Cancel", "Confirm" }; ;
		int m;
		
		if(e.getActionCommand() == "Send"){
			
			judge_select = 0;
			judge_num = 0;
			record_num = 0;
			record_select = 0;
			
			if(checkBox.isSelected()){
				record_num = 0;
				record_select++;
			}
			
			if(checkBox_1.isSelected()){
				record_num = 1;
				record_select++;
			}
			
			if(checkBox_2.isSelected()){
				record_num = 2;
				record_select++;
			}
			
			if(checkBox_3.isSelected()){
				record_num = 3;
				record_select++;
			}
			
			if(checkBox_4.isSelected()){
				record_num = 4;
				record_select++;
			}
			
		
			if(rdbtnByPosting.isSelected()){
				judge_select++;
				judge_num = 1;
			}
				
			if(rdbtnByEmaill.isSelected()){
				judge_select++;
				judge_num = judge_num + 2;
			}

			if(rdbtnBySystem.isSelected()){
				judge_select++;
				judge_num = judge_num + 3;
			}

			if(record_select == 1){
				if(judge_select == 1){
					switch(judge_num){
					case 1 : //post				 
						m = JOptionPane.showOptionDialog(null, "The bill will be sent by posting!\nname: " + userimpl.queryUserInfoById(id).getName() + "\nAddress: " + userimpl.queryUserInfoById(id).getAddress(), "Information Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						System.out.println(m);
						if(m == 1){
							systemrecordimpl.updateSystemRecordTariff(id, judge_list[i][record_num].getYear() , judge_list[i][record_num].getMonth());
							this.setVisible(false);
							new ManageUserBill(id);
						}
						break;
						
					case 2 : //email
						m = JOptionPane.showOptionDialog(null, "The bill will be sent by email!\nname: " + userimpl.queryUserInfoById(id).getName() + "\nEmail: " + userimpl.queryUserInfoById(id).getEmail(), "Information Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						System.out.println(m);
						if(m == 1){
							systemrecordimpl.updateSystemRecordTariff(id, judge_list[i][record_num].getYear() , judge_list[i][record_num].getMonth());
							this.setVisible(false);
							new ManageUserBill(id);
						}
						break;
						
					case 3 : //system
						m = JOptionPane.showOptionDialog(null, "The bill will be sent by system!\nname: " + userimpl.queryUserInfoById(id).getName(), "Information Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						System.out.println(m);
						if(m == 1){
							systemrecordimpl.updateSystemRecordTariff(id, judge_list[i][record_num].getYear() , judge_list[i][record_num].getMonth());
							systemrecordimpl.addBillRecord(judge_list[i][record_num]);
							this.setVisible(false);
							new ManageUserBill(id);
						}
						break;
						
					}
				}
				else{
					switch(judge_num){
					case 3 : //post,email
						m = JOptionPane.showOptionDialog(null, "The bill will be sent by posting and email!\nname: " + userimpl.queryUserInfoById(id).getName() + "\nEmail: " + userimpl.queryUserInfoById(id).getEmail() + "\nAddress: " + userimpl.queryUserInfoById(id).getAddress(), "Information Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						System.out.println(m);
						if(m == 1){
							systemrecordimpl.updateSystemRecordTariff(id, judge_list[i][record_num].getYear() , judge_list[i][record_num].getMonth());
							this.setVisible(false);
							new ManageUserBill(id);
						}
						break;
						
					case 4 : //post,system
						m = JOptionPane.showOptionDialog(null, "The bill will be sent by posting and system!\nname: " + userimpl.queryUserInfoById(id).getName() + "\nAddress: " + userimpl.queryUserInfoById(id).getAddress(), "Information Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						System.out.println(m);
						if(m == 1){
							systemrecordimpl.updateSystemRecordTariff(id, judge_list[i][record_num].getYear() , judge_list[i][record_num].getMonth());
							systemrecordimpl.addBillRecord(judge_list[i][record_num]);
							this.setVisible(false);
							new ManageUserBill(id);
						}
						break;
						
					case 5 : //email,system
						m = JOptionPane.showOptionDialog(null, "The bill will be sent by email and system!\nname: " + userimpl.queryUserInfoById(id).getName() + "\nEmail: " + userimpl.queryUserInfoById(id).getEmail() + "\nAddress: ", "Information Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						System.out.println(m);
						if(m == 1){
							systemrecordimpl.updateSystemRecordTariff(id, judge_list[i][record_num].getYear() , judge_list[i][record_num].getMonth());
							systemrecordimpl.addBillRecord(judge_list[i][record_num]);
							this.setVisible(false);
							new ManageUserBill(id);
						}
						break;
						
					case 6 : //post,email,system	
						m = JOptionPane.showOptionDialog(null, "The bill will be sent by posting, email and system!\nname: " + userimpl.queryUserInfoById(id).getName() + "\nEmail: " + userimpl.queryUserInfoById(id).getEmail() + "\nAddress: " + userimpl.queryUserInfoById(id).getAddress(), "Information Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
						System.out.println(m);
						if(m == 1){
							systemrecordimpl.updateSystemRecordTariff(id, judge_list[i][record_num].getYear() , judge_list[i][record_num].getMonth());
							systemrecordimpl.addBillRecord(judge_list[i][record_num]);
							this.setVisible(false);
							new ManageUserBill(id);
						}
						break;
				
					}
				}
				
				if(judge_select == 0){
					lblPleaseChooseThe.setText("Please choose the send type! ");
					lblPleaseChooseThe.setForeground(Color.red);
				}
			}
			else{
				lblPleaseChooseThe.setText("You can only choose one record to send !");
				lblPleaseChooseThe.setForeground(Color.red);
			}
			
		}
		
		else if(e.getActionCommand() == "Back"){
			
			this.setVisible(false);
			new ManageUserBorad();
			
		}
		else if(e.getActionCommand() == "<"){
			
			displayLabel();
			i--;
			lblPage.setText("Page: " + (i + 1));
			showBillList(list);
			button_1.setEnabled(true);
			if(i == 0){
				button.setEnabled(false);
			}
			
		}
		else if(e.getActionCommand() == ">"){
			
			displayLabel();
			i++;
			lblPage.setText("Page: " + (i + 1));
			showBillList(list);
			button.setEnabled(true);
			if(list.length == (i+1)){
				button_1.setEnabled(false);
			}
			
		}
		
	}
	
	public void showBillList(SystemRecord[][] alist ){
		if(alist == null || alist.length == 0){
			button.setEnabled(false);
			button_1.setEnabled(false);
			btnSend.setEnabled(false);
			lblPleaseChooseThe.setText("No Record! Please try another option!");
			lblPleaseChooseThe.setForeground(Color.red);
			hideLabel();
		}
		else{
			int mr = 0;
			int mc = 0;
			int my = 0;
			int mm = 0;
			int num = 0;
			int count_s = 0;
			int month_num = 0;
			SystemRecord transfermonth = new SystemRecord();
			SystemRecord transfermonth_1 = new SystemRecord();
			SystemRecord checkmonth = new SystemRecord();
			SystemRecord[] storemonth = new SystemRecord[100];		
			
			ArrayList<Integer> myear = new ArrayList<Integer>();		
			ArrayList<Integer> mmonth = new ArrayList<Integer>();
			
			for(mr = 0 ; mr < alist.length ; mr++){
				for(mc = 0 ; mc < 5 ; mc++){
					checkmonth = alist[mr][mc];
					if(checkmonth == null){
						break;
					}
					if(myear.indexOf(checkmonth.getYear()) == -1){
						myear.add(checkmonth.getYear());
					}
					if(mmonth.indexOf(checkmonth.getMonth()) == -1){
						mmonth.add(checkmonth.getMonth());
					}	
				}
			}
//			System.out.println("Year num: " + myear.size());
//			System.out.println("Month num: " + mmonth.size());

			for(my = 0 ; my < myear.size() ; my++){
				for(mm = 0 ; mm < mmonth.size() ; mm++){
					count_s = 0;
//					System.out.println("my: " + my);
//					System.out.println("mm: " + mm);
					
					for(mr = 0 ; mr < alist.length ; mr++){
						for(mc = 0 ; mc < 5 ; mc++){
							
//							System.out.println("mr: " + mr);
//							System.out.println("mc: " + mc);
							
							checkmonth = alist[mr][mc];
							if(checkmonth == null){
								break;
							}
							if(myear.get(my) == checkmonth.getYear() && mmonth.get(mm) == checkmonth.getMonth() && checkmonth.getElectricity_oldprice() >= 0){
								if(count_s == 0){
									
//									System.out.println("year: " + checkmonth.getYear());
//									System.out.println("month: " +  checkmonth.getMonth());
									
									storemonth[month_num] = checkmonth;
									storemonth[month_num].setTotal_cost((storemonth[month_num].getElectricity_oldprice()*storemonth[month_num].getElectricity_usage()) + (storemonth[month_num].getGas_oldprice() * storemonth[month_num].getGas_usage())); 
									count_s++;
									month_num++;
								//	System.out.println("First");
								}
								else{
									
									transfermonth = storemonth[month_num-1];
									transfermonth_1 = storemonth[month_num-1];
								//	System.out.println("lei ji1");
									transfermonth_1.setElectricity_usage(checkmonth.getElectricity_usage() + transfermonth.getElectricity_usage());
									transfermonth_1.setGas_usage(checkmonth.getGas_usage() + transfermonth.getGas_usage());
									transfermonth_1.setTotal_cost(((checkmonth.getElectricity_oldprice()*checkmonth.getElectricity_usage()) + (checkmonth.getGas_oldprice() * checkmonth.getGas_usage()) + transfermonth.getTotal_cost()));
									
									storemonth[month_num-1] = transfermonth_1;
								//	System.out.println("lei ji2");
								}
							}
						}
					}
				}
			}
			
			mr = 0;
			mc = 0;
			
			SystemRecord[][] monthlist = new SystemRecord[(int)Math.ceil((double)month_num/(double)5)][5];
			
			for(num = 0 ; num < month_num ; num++){
				checkmonth = storemonth[num];
				if(mc < 5){
					monthlist[mr][mc] = checkmonth;
					if(mc == 4){
						mc = 0;
						mr++;
					}
					else{
						mc++;
					}
				}	
			}
			judge_list = monthlist;
			
			if(monthlist.length == 0){
				button.setEnabled(false);
				button_1.setEnabled(false);
				btnSend.setEnabled(false);
				lblPleaseChooseThe.setText("No Record! Please try another option!");
				lblPleaseChooseThe.setForeground(Color.red);
				hideLabel();
			}
			else{
				
				displayLabel();
				
				lblPage.setText("Page: " + (i + 1));
				button.setEnabled(false);
				if(monthlist.length <= 1){
					button_1.setEnabled(false);	
				}
				else{
					button_1.setEnabled(true);
				}
				
				if(monthlist[i][0] != null){
					lblM.setText(Integer.toString(monthlist[i][0].getYear()) + "." + Integer.toString(monthlist[i][0].getMonth()));
					lblU.setText(df.format((monthlist[i][0].getElectricity_usage() + monthlist[i][0].getGas_usage())));
					lblC.setText(df.format(monthlist[i][0].getTotal_cost()));
				}else{
					checkBox.setVisible(false);
					lblM.setVisible(false);
					lblU.setVisible(false);
					lblC.setVisible(false);
				}	
				
				if(monthlist[i][1] != null){
					lblM_1.setText(Integer.toString(monthlist[i][1].getYear()) + "." + Integer.toString(monthlist[i][1].getMonth()));
					lblU_1.setText(df.format((monthlist[i][1].getElectricity_usage() + monthlist[i][1].getGas_usage())));
					lblC_1.setText(df.format(monthlist[i][1].getTotal_cost()));
				}else{
					checkBox_1.setVisible(false);
					lblM_1.setVisible(false);
					lblU_1.setVisible(false);
					lblC_1.setVisible(false);
				}	
				if(monthlist[i][2] != null){
					lblM_2.setText(Integer.toString(monthlist[i][2].getYear()) + "." + Integer.toString(monthlist[i][2].getMonth()));
					lblU_2.setText(df.format(monthlist[i][2].getElectricity_usage() + monthlist[i][2].getGas_usage()));
					lblC_2.setText(df.format(monthlist[i][2].getTotal_cost()));
				}else{
					checkBox_2.setVisible(false);
					lblM_2.setVisible(false);
					lblU_2.setVisible(false);
					lblC_2.setVisible(false);
				}
				
				if(monthlist[i][3] != null){
					lblM_3.setText(Integer.toString(monthlist[i][3].getYear()) + "." + Integer.toString(monthlist[i][3].getMonth()));
					lblU_3.setText(df.format(monthlist[i][3].getElectricity_usage() + monthlist[i][3].getGas_usage()));
					lblC_3.setText(df.format(monthlist[i][3].getTotal_cost()));
				}else{
					checkBox_3.setVisible(false);
					lblM_3.setVisible(false);
					lblU_3.setVisible(false);
					lblC_3.setVisible(false);
				}
				
				if(monthlist[i][4] != null){
					lblM_4.setText(Integer.toString(monthlist[i][4].getYear()) + "." + Integer.toString(monthlist[i][4].getMonth()));
					lblU_4.setText(df.format(monthlist[i][4].getElectricity_usage() + monthlist[i][4].getGas_usage()));
					lblC_4.setText(df.format(monthlist[i][4].getTotal_cost()));
				}else{
					checkBox_4.setVisible(false);
					lblM_4.setVisible(false);
					lblU_4.setVisible(false);
					lblC_4.setVisible(false);
				}
				
			}
		}
	
	}
	
	public void displayLabel(){
		
		checkBox.setVisible(true);
		lblM.setVisible(true);
		lblU.setVisible(true);
		lblC.setVisible(true);
		
		checkBox_1.setVisible(true);
		lblM_1.setVisible(true);
		lblU_1.setVisible(true);
		lblC_1.setVisible(true);
		
		checkBox_2.setVisible(true);
		lblM_2.setVisible(true);
		lblU_2.setVisible(true);
		lblC_2.setVisible(true);
		
		checkBox_3.setVisible(true);
		lblM_3.setVisible(true);
		lblU_3.setVisible(true);
		lblC_3.setVisible(true);
		
		checkBox_4.setVisible(true);
		lblM_4.setVisible(true);
		lblU_4.setVisible(true);
		lblC_4.setVisible(true);
	}
	
	public void hideLabel(){
		lblM.setText(" ");
		lblU.setText(" ");
		lblC.setText(" ");
		
		lblM_1.setText(" ");
		lblU_1.setText(" ");
		lblC_1.setText(" ");
		
		lblM_2.setText(" ");
		lblU_2.setText(" ");
		lblC_2.setText(" ");
		 
		lblM_3.setText(" ");
		lblU_3.setText(" ");
		lblC_3.setText(" ");
		
		lblM_4.setText(" ");
		lblU_4.setText(" ");
		lblC_4.setText(" ");
		
		checkBox.setVisible(false);
		lblM.setVisible(false);
		lblU.setVisible(false);
		lblC.setVisible(false);
		
		checkBox_1.setVisible(false);
		lblM_1.setVisible(false);
		lblU_1.setVisible(false);
		lblC_1.setVisible(false);
		
		checkBox_2.setVisible(false);
		lblM_2.setVisible(false);
		lblU_2.setVisible(false);
		lblC_2.setVisible(false);
		
		checkBox_3.setVisible(false);
		lblM_3.setVisible(false);
		lblU_3.setVisible(false);
		lblC_3.setVisible(false);
		
		checkBox_4.setVisible(false);
		lblM_4.setVisible(false);
		lblU_4.setVisible(false);
		lblC_4.setVisible(false);
	}
	
	public void init(){
		list = managerecord.List(systemrecordimpl.getRecordById(this.id));
	}
}
