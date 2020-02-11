
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Title      : HistoricBorad.java
 * Description: This class is the GUI content, it display the historic of data by different formal.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class HistoricBorad extends JFrame implements ActionListener {

	public static java.text.DecimalFormat df = new  java.text.DecimalFormat("#0.00");
	
	private JPanel contentPane;
	private JTextField txtStart;
	private JTextField txtEnd;
	
	public JRadioButton rdbtnDaily;
	public JRadioButton rdbtnWeekly;
	public JRadioButton rdbtnMonthly;
	public JRadioButton rdbtnCustom;
	
	public JLabel lblT;
	public JLabel lblT_1;
	public JLabel lblT_2;
	public JLabel lblT_3;
	public JLabel lblT_4;
	
	public JLabel lblU;
	public JLabel lblU_1;
	public JLabel lblU_2;
	public JLabel lblU_3;
	public JLabel lblU_4;
	
	public JLabel lblC;
	public JLabel lblC_1;
	public JLabel lblC_2;
	public JLabel lblC_3;
	public JLabel lblC_4;
	
	public JLabel lblPage;
	public JLabel lblWarning;
	
	public JButton button;
	public JButton button_1;
	
//	public String year;
//	public String month;
//	public String day;
//	public String ele_usage;
//	public String ele_price;
//	public String ele_time;
//	public String gas_usage;
//	public String gas_price;
//	public String gas_time;
	
	UserImpl userimpl = new UserImpl();
	ManageRecord managerecord = new ManageRecord();
	SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
	ElectricitySystemRecord electricitysystemrecord = new ElectricitySystemRecord();
	GasSystemRecord gassystemrecord = new GasSystemRecord();
	ElectricitySystemRecord[][] eld; 
	GasSystemRecord[][] gld;
	SystemRecord[][] alist;
	int judge_num;
	
	int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricBorad frame = new HistoricBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HistoricBorad() {
		i = 0;
		
		eld = managerecord.eleList(systemrecordimpl.getElectricityRecordById(userimpl.getNowUserInfo().getId()));
		gld = managerecord.gasList(systemrecordimpl.getGasRecordById(userimpl.getNowUserInfo().getId()));
		alist = managerecord.totallist(eld, gld);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		rdbtnDaily = new JRadioButton("Daily");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnDaily, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnDaily, 10, SpringLayout.WEST, contentPane);
		contentPane.add(rdbtnDaily);
		rdbtnDaily.setSelected(true);
		rdbtnDaily.addActionListener(this);
		
		rdbtnWeekly = new JRadioButton("Weekly");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnWeekly, 23, SpringLayout.SOUTH, rdbtnDaily);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnWeekly, 0, SpringLayout.WEST, rdbtnDaily);
		contentPane.add(rdbtnWeekly);
		rdbtnWeekly.addActionListener(this);
		
		rdbtnMonthly = new JRadioButton("Monthly");
		contentPane.add(rdbtnMonthly);
	    rdbtnMonthly.addActionListener(this);
		
		rdbtnCustom = new JRadioButton("Custom");
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnCustom, 150, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, rdbtnMonthly, -23, SpringLayout.NORTH, rdbtnCustom);
		sl_contentPane.putConstraint(SpringLayout.EAST, rdbtnMonthly, 0, SpringLayout.EAST, rdbtnCustom);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnCustom, 0, SpringLayout.WEST, rdbtnDaily);
		contentPane.add(rdbtnCustom);
		rdbtnCustom.addActionListener(this);
		
		txtStart = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtStart, 6, SpringLayout.SOUTH, rdbtnCustom);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtStart, 33, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtStart, -324, SpringLayout.EAST, contentPane);
		txtStart.setText("2017.3.3");
		contentPane.add(txtStart);
		txtStart.setColumns(10);
		
		JLabel lblTo = new JLabel("to");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTo, 24, SpringLayout.SOUTH, rdbtnCustom);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTo, -6, SpringLayout.WEST, txtStart);
		contentPane.add(lblTo);
		
		txtEnd = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEnd, 211, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtEnd, -31, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtStart, -9, SpringLayout.NORTH, txtEnd);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEnd, 0, SpringLayout.WEST, txtStart);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEnd, 0, SpringLayout.EAST, txtStart);
		txtEnd.setText("2018.5.5");
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);
		
		JLabel lblEg = new JLabel("e.g. 1997.11.2 to 1997.12.12");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEg, 6, SpringLayout.SOUTH, txtEnd);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEg, 10, SpringLayout.WEST, contentPane);
		lblEg.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(lblEg);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		JButton btnConfirm = new JButton("Confirm");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnConfirm, 0, SpringLayout.NORTH, btnBack);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConfirm, 16, SpringLayout.EAST, lblEg);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		
		button = new JButton(">");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, -5, SpringLayout.NORTH, lblTo);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, -36, SpringLayout.EAST, contentPane);
		contentPane.add(button);
		button.addActionListener(this);
		
		button_1 = new JButton("<");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, -5, SpringLayout.NORTH, lblTo);
		sl_contentPane.putConstraint(SpringLayout.WEST, button_1, 39, SpringLayout.EAST, txtStart);
		contentPane.add(button_1);
		button_1.addActionListener(this);
		
		lblPage = new JLabel("Page: " + (i+1));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPage, 0, SpringLayout.NORTH, lblTo);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPage, 20, SpringLayout.EAST, button_1);
		contentPane.add(lblPage);
		
		JLabel lblTime = new JLabel("Time");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTime, 0, SpringLayout.NORTH, rdbtnDaily);
		contentPane.add(lblTime);
		
		JLabel lblUsage = new JLabel("Usage");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsage, 0, SpringLayout.NORTH, rdbtnDaily);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUsage, 0, SpringLayout.WEST, lblPage);
		contentPane.add(lblUsage);
		
		JLabel lblCost = new JLabel("Cost");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCost, 0, SpringLayout.NORTH, rdbtnDaily);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCost, -25, SpringLayout.EAST, contentPane);
		contentPane.add(lblCost);
		
		lblT = new JLabel("t1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblT, 9, SpringLayout.SOUTH, lblTime);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTime, 0, SpringLayout.WEST, lblT);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblT, 133, SpringLayout.WEST, contentPane);
		lblT.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(lblT);
		
		lblT_1 = new JLabel("t2");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblT_1, 47, SpringLayout.EAST, rdbtnWeekly);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblT_1, 0, SpringLayout.SOUTH, rdbtnWeekly);
		lblT_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(lblT_1);
		
		lblT_2 = new JLabel("t3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblT_2, 0, SpringLayout.NORTH, rdbtnMonthly);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblT_2, 42, SpringLayout.EAST, rdbtnMonthly);
		lblT_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(lblT_2);
		
		lblT_3 = new JLabel("t4");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblT_3, 42, SpringLayout.EAST, rdbtnCustom);
		lblT_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(lblT_3);
		
		lblT_4 = new JLabel("t5");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblT_3, -21, SpringLayout.NORTH, lblT_4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblT_4, -6, SpringLayout.NORTH, button_1);
		lblT_4.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(lblT_4);
		
		lblU = new JLabel("u1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU, 6, SpringLayout.SOUTH, lblUsage);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU, 0, SpringLayout.WEST, lblPage);
		contentPane.add(lblU);
		
		lblU_1 = new JLabel("u2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU_1, 0, SpringLayout.NORTH, lblT_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU_1, 0, SpringLayout.WEST, lblPage);
		contentPane.add(lblU_1);
		
		lblU_2 = new JLabel("u3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU_2, 0, SpringLayout.NORTH, rdbtnMonthly);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU_2, 0, SpringLayout.WEST, lblPage);
		contentPane.add(lblU_2);
		
		lblU_3 = new JLabel("u4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU_3, -3, SpringLayout.NORTH, lblT_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU_3, 0, SpringLayout.WEST, lblPage);
		contentPane.add(lblU_3);
		
		lblU_4 = new JLabel("u5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblU_4, -3, SpringLayout.NORTH, lblT_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblU_4, 0, SpringLayout.WEST, lblPage);
		contentPane.add(lblU_4);
		
		lblC = new JLabel("c1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC, 6, SpringLayout.SOUTH, lblCost);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC);
		
		lblC_1 = new JLabel("c2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC_1, 0, SpringLayout.NORTH, lblT_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC_1, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC_1);
		
		lblC_2 = new JLabel("c3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC_2, -3, SpringLayout.NORTH, lblT_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC_2, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC_2);
		
		lblC_3 = new JLabel("c4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC_3, -3, SpringLayout.NORTH, lblT_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC_3, 0, SpringLayout.WEST, lblCost);
		contentPane.add(lblC_3);
		
		lblC_4 = new JLabel("c5");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC_4, 0, SpringLayout.WEST, lblCost);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblC_4, -6, SpringLayout.NORTH, button);
		contentPane.add(lblC_4);
		
		JLabel label = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblT_4, 6, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, -3, SpringLayout.NORTH, lblT_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 6, SpringLayout.EAST, txtStart);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 6, SpringLayout.EAST, txtStart);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_1, 0, SpringLayout.SOUTH, txtStart);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_2, 0, SpringLayout.SOUTH, txtEnd);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_2, 0, SpringLayout.EAST, label);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 4, SpringLayout.NORTH, rdbtnCustom);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label);
		contentPane.add(label_3);
		
		JLabel label_5 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_5, 0, SpringLayout.NORTH, rdbtnWeekly);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, label);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_6, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_6, 0, SpringLayout.SOUTH, rdbtnDaily);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_7, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_7, 0, SpringLayout.WEST, label);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_8, 6, SpringLayout.EAST, txtEnd);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_8, 0, SpringLayout.SOUTH, button);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_9, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_9, 0, SpringLayout.SOUTH, lblT_3);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_10, 1, SpringLayout.SOUTH, label_5);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_10, -6, SpringLayout.WEST, lblT_1);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_11, 0, SpringLayout.NORTH, lblT);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_11, 0, SpringLayout.WEST, label);
		contentPane.add(label_11);
		
		JLabel label_4 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 6, SpringLayout.SOUTH, label_10);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_4, -6, SpringLayout.WEST, lblT_2);
		contentPane.add(label_4);
		
		JLabel label_12 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_12, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_12, -6, SpringLayout.NORTH, label_9);
		contentPane.add(label_12);
		
		lblWarning = new JLabel("Click the 'Confirm' to query the record.");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWarning, 0, SpringLayout.WEST, button_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblWarning, 0, SpringLayout.SOUTH, txtEnd);
		contentPane.add(lblWarning);
		
		
		button_1.setEnabled(false);
		//show
		if(alist == null){
			
			hideLabel();
			button.setEnabled(false);
			btnConfirm.setEnabled(false);
			lblWarning.setText("No Record! After to try!");
			lblWarning.setForeground(Color.red);
		}
		else{
			systemrecordimpl.addNewRecord(alist);
			showDaily(); 
			if(alist.length <= 1){
				button.setEnabled(false);	
			}
		}	
		
		setTitle("Consumption History");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		
		this.setVisible(true);
		this.setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand()=="Confirm"){
			int judge_select = 0;
			judge_num = 0;
			if(rdbtnCustom.isSelected()){
				judge_select++;
				judge_num = 4;
			}
				
			if(rdbtnMonthly.isSelected()){
				judge_select++;
				judge_num = 3;
			}

			if(rdbtnWeekly.isSelected()){
				judge_select++;
				judge_num = 2;
			}

			if(rdbtnDaily.isSelected()){
				judge_select++;
				judge_num = 1;
			}

			if(judge_select > 1){
				rdbtnDaily.setSelected(false);
				rdbtnWeekly.setSelected(false);
				rdbtnMonthly.setSelected(false);
				rdbtnCustom.setSelected(false);
				lblWarning.setText("You can only choose one option!");
				lblWarning.setForeground(Color.red);
			}				
			else if(judge_select == 0){
				lblWarning.setText("Please choose one option!");
				lblWarning.setForeground(Color.red);
			}	
			else if(judge_select == 1){
				switch(judge_num){
				case 1 : 
					i = 0; 
					init(); 
					if(alist == null){
						hideLabel();
						lblWarning.setText("No Record! Please try another option!");
						lblWarning.setForeground(Color.red);
					}
					else{
						showDaily(); 
						break;
					}
				
				case 2 :
					i = 0; 
					init(); 
					if(alist == null){
						hideLabel();
						lblWarning.setText("No Record! Please try another option!");
						lblWarning.setForeground(Color.red);
					}
					else{
						showWeekly(); 
						break;
					}
					
				case 3 : 
					i = 0; 
					init(); 
					if(alist == null){
						hideLabel();
						lblWarning.setText("No Record! Please try another option!");
						lblWarning.setForeground(Color.red);
					}
					else{
						showMonth(); 
						break;
					}
					
				case 4 : 
					i = 0; 
					init(); 
					if(alist == null){
						hideLabel();
						lblWarning.setText("No Record! Please try another option!");
						lblWarning.setForeground(Color.red);
					}
					else{
						showCustom(); 
						break;
					}
			}
			}
		}
		else if(e.getActionCommand()=="Back"){
			this.setVisible(false);
			new UserMainBorad();
		}
		else if(e.getActionCommand()=="<"){
			displayLabel();
			i--;
			lblPage.setText("Page: " + (i + 1));
			switch(judge_num){
			case 1 : showDaily(); break;
			case 2 : showWeekly(); break;
			case 3 : showMonth(); break;
			case 4 : System.out.println("custom");break;
			}
			button.setEnabled(true);
			if(i == 0){
				button_1.setEnabled(false);
			}
			
		}
		else if(e.getActionCommand()==">"){
			displayLabel();
			i++;
			lblPage.setText("Page: " + (i + 1));
			switch(judge_num){
			case 1 : showDaily(); break;
			case 2 : showWeekly(); break;
			case 3 : showMonth(); break;
			case 4 : System.out.println("custom");break;
			}
			button_1.setEnabled(true);
			if(alist.length == (i+1)){
				button.setEnabled(false);			
			}
			
		}
	}
	
	public void showDaily(){
		//Display
		
		displayLabel();
		
		lblPage.setText("Page: " + (i + 1));
		button_1.setEnabled(false);
		if(alist.length <= 1){
			button.setEnabled(false);	
		}
		else{
			button.setEnabled(true);
		}
		
		if(alist[i][0] != null){
			lblT.setText(Integer.toString(alist[i][0].getYear()) + "." + Integer.toString(alist[i][0].getMonth()) + "." +Integer.toString(alist[i][0].getDay()));
			lblU.setText(df.format(alist[i][0].getElectricity_usage() + alist[i][0].getGas_usage()));
			lblC.setText(df.format(alist[i][0].getElectricity_usage() * alist[i][0].getElectricity_oldprice() + alist[i][0].getGas_usage() * alist[i][0].getGas_oldprice()));
		}else{
			lblT.setVisible(false);
			lblU.setVisible(false);
			lblC.setVisible(false);
		}
		
		if(alist[i][1] != null){
			lblT_1.setText(Integer.toString(alist[i][1].getYear()) + "." + Integer.toString(alist[i][1].getMonth()) + "." +Integer.toString(alist[i][1].getDay()));
			lblU_1.setText(df.format((alist[i][1].getElectricity_usage() + alist[i][1].getGas_usage())));
			lblC_1.setText(df.format(alist[i][1].getElectricity_usage() * alist[i][1].getElectricity_oldprice() + alist[i][1].getGas_usage() * alist[i][1].getGas_oldprice()));
		}else{
			lblT_1.setVisible(false);
			lblU_1.setVisible(false);
			lblC_1.setVisible(false);
		}	
		if(alist[i][2] != null){
			lblT_2.setText(Integer.toString(alist[i][2].getYear()) + "." + Integer.toString(alist[i][2].getMonth()) + "." +Integer.toString(alist[i][2].getDay()));
			lblU_2.setText(df.format(alist[i][2].getElectricity_usage() + alist[i][2].getGas_usage()));
			lblC_2.setText(df.format(alist[i][2].getElectricity_usage() * alist[i][2].getElectricity_oldprice() + alist[i][2].getGas_usage() * alist[i][2].getGas_oldprice()));
		}else{
			lblT_2.setVisible(false);
			lblU_2.setVisible(false);
			lblC_2.setVisible(false);
		}
		
		if(alist[i][3] != null){
			lblT_3.setText(Integer.toString(alist[i][3].getYear()) + "." + Integer.toString(alist[i][3].getMonth()) + "." +Integer.toString(alist[i][3].getDay()));
			lblU_3.setText(df.format(alist[i][3].getElectricity_usage() + alist[i][3].getGas_usage()));
			lblC_3.setText(df.format(alist[i][3].getElectricity_usage() * alist[i][3].getElectricity_oldprice() + alist[i][3].getGas_usage() * alist[i][3].getGas_oldprice()));
		}else{
			lblT_3.setVisible(false);
			lblU_3.setVisible(false);
			lblC_3.setVisible(false);
		}
		
		if(alist[i][4] != null){
			lblT_4.setText(Integer.toString(alist[i][4].getYear()) + "." + Integer.toString(alist[i][4].getMonth()) + "." +Integer.toString(alist[i][4].getDay()));
			lblU_4.setText(df.format(alist[i][4].getElectricity_usage() + alist[i][4].getGas_usage()));
			lblC_4.setText(df.format(alist[i][4].getElectricity_usage() * alist[i][4].getElectricity_oldprice() + alist[i][4].getGas_usage() * alist[i][4].getGas_oldprice()));
		}else{
			lblT_4.setVisible(false);
			lblU_4.setVisible(false);
			lblC_4.setVisible(false);
		}
	}
	
	public void showWeekly(){
		int flag_1 = 0;
		int mr = 0;
		int mc = 0;
		int mw = 0;
		int mww = 0;
		int week_num = 0;
		Week week = new Week();
		SystemRecord transferweek = new SystemRecord();
		SystemRecord transferweek_1 = new SystemRecord();
		SystemRecord checkweek = new SystemRecord();
		SystemRecord[] storeweek = new SystemRecord[100];

		ArrayList<Integer> myear = new ArrayList<Integer>();
		
		String today="";
		
		for(mr = 0 ; mr < alist.length ; mr++){
			for(mc = 0 ; mc < 5 ; mc++){
				checkweek = alist[mr][mc];
				if(checkweek == null){
					break;
				}
				checkweek.setWeek(week.getWeekByDate(checkweek.getYear(), checkweek.getMonth(), checkweek.getDay()));
				alist[mr][mc] = checkweek;
				today = Integer.toString(checkweek.getYear()) + "-" + Integer.toString(checkweek.getMonth()) + "-" + Integer.toString(checkweek.getDay());
				System.out.println(today);
				if(myear.indexOf(checkweek.getYear()) == -1){
					myear.add(checkweek.getYear());
				}
			}
		}
//		System.out.println("Year num: " + myear.size());
		
		for(mw = 0 ; mw < myear.size() ; mw++){

			for(mr = 0 ; mr < alist.length ; mr++){
				for(mc = 0 ; mc < 5 ; mc++){
					
//					System.out.println("mr: " + mr);
//					System.out.println("mc: " + mc);
					
					checkweek = alist[mr][mc];
					if(checkweek == null){
						break;
					}
					if(myear.get(mw) == checkweek.getYear()){
//						System.out.println("to Year: " + myear.get(mw));
						if(week_num == 0){
							System.out.println("First");
							storeweek[week_num] = checkweek;
							storeweek[week_num].setTotal_cost((storeweek[week_num].getElectricity_oldprice()*storeweek[week_num].getElectricity_usage()) + (storeweek[week_num].getGas_oldprice() * storeweek[week_num].getGas_usage()));
							storeweek[week_num].setWeek(week.getWeekByDate(checkweek.getYear(), checkweek.getMonth(), checkweek.getDay()));
							week_num++;
						}
						else{
							for(mww = 0 ; mww < week_num ; mww++){
								if(storeweek[mww].getYear() == checkweek.getYear() && storeweek[mww].getWeek() == week.getWeekByDate(checkweek.getYear(), checkweek.getMonth(), checkweek.getDay())){
//									System.out.println("update");
//									System.out.println("Year: " + storeweek[mww].getYear());
//									System.out.println("Week: " + storeweek[mww].getWeek());
									
									flag_1++;
									transferweek = storeweek[mww];
									transferweek_1 = storeweek[mww];
								//	System.out.println("lei ji1");
									transferweek_1.setElectricity_usage(checkweek.getElectricity_usage() + transferweek.getElectricity_usage());
									transferweek_1.setGas_usage(checkweek.getGas_usage() + transferweek.getGas_usage());
									transferweek_1.setTotal_cost(((checkweek.getElectricity_oldprice()*checkweek.getElectricity_usage()) + (checkweek.getGas_oldprice() * checkweek.getGas_usage()) + transferweek.getTotal_cost()));
									storeweek[mww] = transferweek_1;
								}
								else{
									flag_1 = 0;
								}
							}
							if(flag_1 == 0){
//								System.out.println("add");
								storeweek[week_num] = checkweek;
								storeweek[week_num].setTotal_cost((storeweek[week_num].getElectricity_oldprice()*storeweek[week_num].getElectricity_usage()) + (storeweek[week_num].getGas_oldprice() * storeweek[week_num].getGas_usage()));
								storeweek[week_num].setWeek(week.getWeekByDate(checkweek.getYear(), checkweek.getMonth(), checkweek.getDay()));
								week_num++;
							}
						}
					}
				}
			}
		}
		
		mr = 0;
		mc = 0;
		SystemRecord[][] weeklist = new SystemRecord[(int)Math.ceil((double)week_num/(double)5)][5];
//		System.out.println("weeklist.length: " + weeklist.length);
//		System.out.println("Week num: " + week_num);
		for(mw = 0 ; mw < week_num ; mw++){
			checkweek = storeweek[mw];
			if(mc < 5){
				weeklist[mr][mc] = checkweek;
				if(mc == 4){
					mc = 0;
					mr++;
				}
				else{
					mc++;
				}
			}	
		}
		
//		System.out.println("Ele usage: " + weeklist[0][1].getElectricity_usage());
//		System.out.println("Gas usage: " + weeklist[0][1].getGas_usage());
		
		
		displayLabel();
		
		lblPage.setText("Page: " + (i + 1));
		button_1.setEnabled(false);
		if(weeklist.length <= 1){
			button.setEnabled(false);	
		}
		else{
			button.setEnabled(true);
		}
		
		if(weeklist[i][0] != null){
			lblT.setText(Integer.toString(weeklist[i][0].getYear()) + " Week: " + Integer.toString(weeklist[i][0].getWeek()));
			lblU.setText(df.format((weeklist[i][0].getElectricity_usage() + weeklist[i][0].getGas_usage())));
			lblC.setText(df.format(weeklist[i][0].getTotal_cost()));
		}else{
			lblT.setVisible(false);
			lblU.setVisible(false);
			lblC.setVisible(false);
		}	
		
		if(weeklist[i][1] != null){
			lblT_1.setText(Integer.toString(weeklist[i][1].getYear()) + " Week: " + Integer.toString(weeklist[i][1].getWeek()));
			lblU_1.setText(df.format((weeklist[i][1].getElectricity_usage() + weeklist[i][1].getGas_usage())));
			lblC_1.setText(df.format(weeklist[i][1].getTotal_cost()));
		}else{
			lblT_1.setVisible(false);
			lblU_1.setVisible(false);
			lblC_1.setVisible(false);
		}	
		if(weeklist[i][2] != null){
			lblT_2.setText(Integer.toString(weeklist[i][2].getYear()) + " Week: " + Integer.toString(weeklist[i][2].getWeek()));
			lblU_2.setText(df.format(weeklist[i][2].getElectricity_usage() + weeklist[i][2].getGas_usage()));
			lblC_2.setText(df.format(weeklist[i][2].getTotal_cost()));
		}else{
			lblT_2.setVisible(false);
			lblU_2.setVisible(false);
			lblC_2.setVisible(false);
		}
		
		if(weeklist[i][3] != null){
			lblT_3.setText(Integer.toString(weeklist[i][3].getYear()) + " Week: " + Integer.toString(weeklist[i][3].getWeek()));
			lblU_3.setText(df.format(weeklist[i][3].getElectricity_usage() + weeklist[i][3].getGas_usage()));
			lblC_3.setText(df.format(weeklist[i][3].getTotal_cost()));
		}else{
			lblT_3.setVisible(false);
			lblU_3.setVisible(false);
			lblC_3.setVisible(false);
		}
		
		if(weeklist[i][4] != null){
			lblT_4.setText(Integer.toString(weeklist[i][4].getYear()) + " Week: " + Integer.toString(weeklist[i][4].getWeek()));
			lblU_4.setText(df.format(weeklist[i][4].getElectricity_usage() + weeklist[i][4].getGas_usage()));
			lblC_4.setText(df.format(weeklist[i][4].getTotal_cost()));
		}else{
			lblT_4.setVisible(false);
			lblU_4.setVisible(false);
			lblC_4.setVisible(false);
		}
		
		
	}
	
	public void showMonth(){
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
//		System.out.println("Year num: " + myear.size());
//		System.out.println("Month num: " + mmonth.size());

		for(my = 0 ; my < myear.size() ; my++){
			for(mm = 0 ; mm < mmonth.size() ; mm++){
				count_s = 0;
//				System.out.println("my: " + my);
//				System.out.println("mm: " + mm);
				
				for(mr = 0 ; mr < alist.length ; mr++){
					for(mc = 0 ; mc < 5 ; mc++){
						
//						System.out.println("mr: " + mr);
//						System.out.println("mc: " + mc);
						
						checkmonth = alist[mr][mc];
						if(checkmonth == null){
							break;
						}
						if(myear.get(my) == checkmonth.getYear() && mmonth.get(mm) == checkmonth.getMonth()){
							if(count_s == 0){
								
//								System.out.println("year: " + checkmonth.getYear());
//								System.out.println("month: " +  checkmonth.getMonth());
								
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
		
		
		displayLabel();
		
		lblPage.setText("Page: " + (i + 1));
		button_1.setEnabled(false);
		if(monthlist.length <= 1){
			button.setEnabled(false);	
		}
		else{
			button.setEnabled(true);
		}
		
		if(monthlist[i][0] != null){
			lblT.setText(Integer.toString(monthlist[i][0].getYear()) + "." + Integer.toString(monthlist[i][0].getMonth()));
			lblU.setText(df.format((monthlist[i][0].getElectricity_usage() + monthlist[i][0].getGas_usage())));
			lblC.setText(df.format(monthlist[i][0].getTotal_cost()));
		}else{
			lblT.setVisible(false);
			lblU.setVisible(false);
			lblC.setVisible(false);
		}	
		
		if(monthlist[i][1] != null){
			lblT_1.setText(Integer.toString(monthlist[i][1].getYear()) + "." + Integer.toString(monthlist[i][1].getMonth()));
			lblU_1.setText(df.format((monthlist[i][1].getElectricity_usage() + monthlist[i][1].getGas_usage())));
			lblC_1.setText(df.format(monthlist[i][1].getTotal_cost()));
		}else{
			lblT_1.setVisible(false);
			lblU_1.setVisible(false);
			lblC_1.setVisible(false);
		}	
		if(monthlist[i][2] != null){
			lblT_2.setText(Integer.toString(monthlist[i][2].getYear()) + "." + Integer.toString(monthlist[i][2].getMonth()));
			lblU_2.setText(df.format(monthlist[i][2].getElectricity_usage() + monthlist[i][2].getGas_usage()));
			lblC_2.setText(df.format(monthlist[i][2].getTotal_cost()));
		}else{
			lblT_2.setVisible(false);
			lblU_2.setVisible(false);
			lblC_2.setVisible(false);
		}
		
		if(monthlist[i][3] != null){
			lblT_3.setText(Integer.toString(monthlist[i][3].getYear()) + "." + Integer.toString(monthlist[i][3].getMonth()));
			lblU_3.setText(df.format(monthlist[i][3].getElectricity_usage() + monthlist[i][3].getGas_usage()));
			lblC_3.setText(df.format(monthlist[i][3].getTotal_cost()));
		}else{
			lblT_3.setVisible(false);
			lblU_3.setVisible(false);
			lblC_3.setVisible(false);
		}
		
		if(monthlist[i][4] != null){
			lblT_4.setText(Integer.toString(monthlist[i][4].getYear()) + "." + Integer.toString(monthlist[i][4].getMonth()));
			lblU_4.setText(df.format(monthlist[i][4].getElectricity_usage() + monthlist[i][4].getGas_usage()));
			lblC_4.setText(df.format(monthlist[i][4].getTotal_cost()));
		}else{
			lblT_4.setVisible(false);
			lblU_4.setVisible(false);
			lblC_4.setVisible(false);
		}
	}
	
	public void showCustom(){
		String start_input;
		String end_input;
		String[] start_date = new String[3];
		String[] end_date = new String[3];
		int date_num = 0;
		int mr = 0;
		int mc = 0;
		int num = 0;
		
		SystemRecord checkcustom = new SystemRecord();
		SystemRecord transfercustom = new SystemRecord();
		SystemRecord[] storecustom = new SystemRecord[alist.length * 5];
		
		//Get date
		start_input = txtStart.getText();
		end_input = txtEnd.getText();
		
		//Split the date
		start_date = start_input.split("\\.");
		end_date = end_input.split("\\.");
		
		if(Integer.parseInt(start_date[0]) > Integer.parseInt(end_date[0]) || Integer.parseInt(start_date[1]) > Integer.parseInt(end_date[1])){
			lblWarning.setText("The date is wrong!");
			lblWarning.setForeground(Color.red);
		}
		else if(Integer.parseInt(start_date[0]) == Integer.parseInt(end_date[0]) && Integer.parseInt(start_date[1]) == Integer.parseInt(end_date[1]) && Integer.parseInt(start_date[2]) > Integer.parseInt(end_date[2])){
			lblWarning.setText("The date is wrong!");
			lblWarning.setForeground(Color.red);
		}
		else{
//			for(date_num = 0 ; date_num < 3 ; date_num++){
//			System.out.println("Start: "  + start_date[date_num]);
//			System.out.println("End: "  + end_date[date_num]);
//		}	
		
		//judge the range of date
		date_num = 0;
		if(start_date[0] == end_date[0]){
			for(mr = 0 ; mr < alist.length ; mr++){
				for(mc = 0 ; mc < 5 ; mc++){
					checkcustom = alist[mr][mc];
					if(checkcustom == null){
						break;
					}
					if(checkcustom.getMonth() <= Integer.parseInt(end_date[1]) && checkcustom.getMonth() >= Integer.parseInt(start_date[1])){
						if(checkcustom.getMonth() == Integer.parseInt(end_date[1]) || checkcustom.getMonth() == Integer.parseInt(start_date[1])){
							if(checkcustom.getDay() <= Integer.parseInt(end_date[2]) && checkcustom.getDay() >= Integer.parseInt(start_date[2])){
								storecustom[date_num] = checkcustom;
								date_num++;								
							}
						}
						else{
							storecustom[date_num] = checkcustom;
							date_num++;
						}
					}
				}
			}
		}
		else{
			for(mr = 0 ; mr < alist.length ; mr++){
				for(mc = 0 ; mc < 5 ; mc++){
					checkcustom = alist[mr][mc];
					if(checkcustom == null){
						break;
					}
					if(checkcustom.getYear() == Integer.parseInt(start_date[0])){
						if(checkcustom.getMonth() >= Integer.parseInt(start_date[1])){
							if(checkcustom.getMonth() == Integer.parseInt(start_date[1])){
								if(checkcustom.getDay() >= Integer.parseInt(start_date[2])){
									storecustom[date_num] = checkcustom;
									date_num++;								
								}
							}
							else{
								storecustom[date_num] = checkcustom;
								date_num++;		
							}
						}
					}
					else if(checkcustom.getYear() == Integer.parseInt(end_date[0])){
						if(checkcustom.getMonth() <= Integer.parseInt(end_date[1])){
							if(checkcustom.getMonth() == Integer.parseInt(end_date[1])){
								if(checkcustom.getDay() <= Integer.parseInt(end_date[2])){
									storecustom[date_num] = checkcustom;
									date_num++;								
								}
							}
							else{
								storecustom[date_num] = checkcustom;
								date_num++;		
							}
						}
					}
					else{
						storecustom[date_num] = checkcustom;
						date_num++;	
					}
					
				}
			}
		}
		
		
		//transfer the date
		mr = 0;
		mc = 0;
		
		SystemRecord[][] customlist = new SystemRecord[(int)Math.ceil((double)date_num/(double)5)][5];
//		System.out.println("num: " + date_num);
		
		for(num = 0 ; num < date_num ; num++){
			checkcustom = storecustom[num];
			
//			System.out.println("day: " + checkcustom.getDay());
			
			if(mc < 5){
				customlist[mr][mc] = checkcustom;
				if(mc == 4){
					mc = 0;
					mr++;
				}
				else{
					mc++;
				}
			}	
		}
		
		if(date_num == 0){
			
			hideLabel();
			System.out.println("No record");
			lblWarning.setText("No Record! Please try another option!");
			lblWarning.setForeground(Color.red);
		}
		else{
			displayLabel();
			
			lblPage.setText("Page: " + (i + 1));
			button_1.setEnabled(false);
			if(customlist.length <= 1){
				button.setEnabled(false);	
			}
			else{
				button.setEnabled(true);
			}
			
			if(customlist[i][0] != null){
				lblT.setText(Integer.toString(customlist[i][0].getYear()) + "." + Integer.toString(customlist[i][0].getMonth()) + "." +Integer.toString(customlist[i][0].getDay()));
				lblU.setText(df.format(customlist[i][0].getElectricity_usage() + customlist[i][0].getGas_usage()));
				lblC.setText(df.format(customlist[i][0].getElectricity_usage() * customlist[i][0].getElectricity_oldprice() + customlist[i][0].getGas_usage() * customlist[i][0].getGas_oldprice()));
			}else{
				lblT.setVisible(false);
				lblU.setVisible(false);
				lblC.setVisible(false);
			}
			
			if(customlist[i][1] != null){
				lblT_1.setText(Integer.toString(customlist[i][1].getYear()) + "." + Integer.toString(customlist[i][1].getMonth()) + "." +Integer.toString(customlist[i][1].getDay()));
				lblU_1.setText(df.format((customlist[i][1].getElectricity_usage() + customlist[i][1].getGas_usage())));
				lblC_1.setText(df.format(customlist[i][1].getElectricity_usage() * customlist[i][1].getElectricity_oldprice() + customlist[i][1].getGas_usage() * customlist[i][1].getGas_oldprice()));
			}else{
				lblT_1.setVisible(false);
				lblU_1.setVisible(false);
				lblC_1.setVisible(false);
			}	
			if(customlist[i][2] != null){
				lblT_2.setText(Integer.toString(customlist[i][2].getYear()) + "." + Integer.toString(customlist[i][2].getMonth()) + "." +Integer.toString(customlist[i][2].getDay()));
				lblU_2.setText(df.format(customlist[i][2].getElectricity_usage() + customlist[i][2].getGas_usage()));
				lblC_2.setText(df.format(customlist[i][2].getElectricity_usage() * customlist[i][2].getElectricity_oldprice() + customlist[i][2].getGas_usage() * customlist[i][2].getGas_oldprice()));
			}else{
				lblT_2.setVisible(false);
				lblU_2.setVisible(false);
				lblC_2.setVisible(false);
			}
			
			if(customlist[i][3] != null){
				lblT_3.setText(Integer.toString(customlist[i][3].getYear()) + "." + Integer.toString(customlist[i][3].getMonth()) + "." +Integer.toString(customlist[i][3].getDay()));
				lblU_3.setText(df.format(customlist[i][3].getElectricity_usage() + customlist[i][3].getGas_usage()));
				lblC_3.setText(df.format(customlist[i][3].getElectricity_usage() * customlist[i][3].getElectricity_oldprice() + customlist[i][3].getGas_usage() * customlist[i][3].getGas_oldprice()));
			}else{
				lblT_3.setVisible(false);
				lblU_3.setVisible(false);
				lblC_3.setVisible(false);
			}
			
			if(customlist[i][4] != null){
				lblT_4.setText(Integer.toString(customlist[i][4].getYear()) + "." + Integer.toString(customlist[i][4].getMonth()) + "." +Integer.toString(customlist[i][4].getDay()));
				lblU_4.setText(df.format(customlist[i][4].getElectricity_usage() + customlist[i][4].getGas_usage()));
				lblC_4.setText(df.format(customlist[i][4].getElectricity_usage() * customlist[i][4].getElectricity_oldprice() + customlist[i][4].getGas_usage() * customlist[i][4].getGas_oldprice()));
			}else{
				lblT_4.setVisible(false);
				lblU_4.setVisible(false);
				lblC_4.setVisible(false);
			}
		}
		}
		
	}
	
	public void displayLabel(){
		
		lblT.setVisible(true);
		lblU.setVisible(true);
		lblC.setVisible(true);
		
		lblT_1.setVisible(true);
		lblU_1.setVisible(true);
		lblC_1.setVisible(true);
		
		lblT_2.setVisible(true);
		lblU_2.setVisible(true);
		lblC_2.setVisible(true);
		
		lblT_3.setVisible(true);
		lblU_3.setVisible(true);
		lblC_3.setVisible(true);
		
		lblT_4.setVisible(true);
		lblU_4.setVisible(true);
		lblC_4.setVisible(true);
	}
	
	public void init(){
		eld = managerecord.eleList(systemrecordimpl.getElectricityRecordById(userimpl.getNowUserInfo().getId()));
		gld = managerecord.gasList(systemrecordimpl.getGasRecordById(userimpl.getNowUserInfo().getId()));
		alist = managerecord.totallist(eld, gld);
	}
	
	public void hideLabel(){
		lblT.setText("");
		lblU.setText("");
		lblC.setText("");
		
		lblT_1.setText("");
		lblU_1.setText("");
		lblC_1.setText("");
		
		lblT_2.setText("");
		lblU_2.setText("");
		lblC_2.setText("");
		
		lblT_3.setText("");
		lblU_3.setText("");
		lblC_3.setText("");
		
		lblT_4.setText("");
		lblU_4.setText("");
		lblC_4.setText("");
		
		lblT.setVisible(false);
		lblU.setVisible(false);
		lblC.setVisible(false);
		
		lblT_1.setVisible(false);
		lblU_1.setVisible(false);
		lblC_1.setVisible(false);
		
		lblT_2.setVisible(false);
		lblU_2.setVisible(false);
		lblC_2.setVisible(false);
		
		lblT_3.setVisible(false);
		lblU_3.setVisible(false);
		lblC_3.setVisible(false);
		
		lblT_4.setVisible(false);
		lblU_4.setVisible(false);
		lblC_4.setVisible(false);
	}
}
