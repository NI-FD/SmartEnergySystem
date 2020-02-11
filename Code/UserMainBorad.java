
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Title      : UserMainBorad.java
 * Description: This class is the GUI content, it display the operation of user view.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class UserMainBorad extends JFrame implements ActionListener {

	private JPanel contentPane;
	
	static TariffImpl tariffimpl = new TariffImpl();
	static UserImpl userimpl = new UserImpl();
	static SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
	static ManageTime managetime = new ManageTime();
	public static java.text.DecimalFormat df = new  java.text.DecimalFormat("#0.00");
	
	public static JTextArea textArea;
	public static JTextArea textArea_1;
	public static JLabel label_3;
	public static JLabel lblElectricity;
	public static JLabel lblGad;
	public static JLabel lblBudget;
	
	StartElectricity electricity_thread = new StartElectricity();
	StartGas gas_thread = new StartGas();
	Thread t1 = new Thread(electricity_thread);
	Thread t2 = new Thread(gas_thread);
	
	public static int eletricity_judge;
	public static int gas_judge;
	/*
	public static String elestatus = "Not Alive";
	public static String gasstatus = "Not Alive";
	public static String eletime = Integer.toString(systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getEtotaltime());
	public static String gastime = Integer.toString(systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getGtotaltime());
	public static String eleuse = df.format(systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getElectricity_usage());
	public static String gasuse = df.format(systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getGas_usage());
	public static String elecost = df.format( Float.parseFloat(eleuse) * (systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getElectricity_price()));
	public static String gascost = df.format( Float.parseFloat(gasuse) * (systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getGas_price()));

	*/
	
	public static String elestatus;
	public static String gasstatus;
	public static String eletime;
	public static String gastime;
	public static String eleuse;
	public static String gasuse;
	public static String elecost;
	public static String gascost;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainBorad frame = new UserMainBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserMainBorad() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		elestatus = "Not Alive";
		gasstatus = "Not Alive";
		
		try{
			eletime = Integer.toString(systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getEtotaltime());
		}catch(Exception e){
			eletime = "0";
		}
		
		try{
			gastime = Integer.toString(systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getGtotaltime());
		}catch(Exception e){
			gastime = "0";
		}
		
		try{
			eleuse = df.format(systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getElectricity_usage());
		}catch(Exception e){
			eleuse = "0";
		}
		
		try{
			gasuse = df.format(systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getGas_usage());
		}catch(Exception e){
			gasuse = "0";
		}
		
		try{
			elecost = df.format( Float.parseFloat(eleuse) * (systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getElectricity_price()));
		}catch(Exception e){
			elecost = "0";
		}
		
		try{
			gascost = df.format( Float.parseFloat(gasuse) * (systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getGas_price()));
		}catch(Exception e){
			gascost = "0";
		}
		
		
		eletricity_judge = 0;
		gas_judge = 0;
		
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, contentPane);
		textArea.setColumns(2);
		textArea.setRows(6);
		textArea.setText("Status:	" + elestatus + "\n" + "Time:	" + eletime + " min\n" + "Daily Usage:	"  + eleuse + " kWh\n" + "Daily Cost:	" + elecost + " £\n" + "Budget:	" + Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget()) + " £\n" + "Tariff:	" + tariffimpl.checkTariff()[0] + " £");
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		textArea_1 = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea_1, 0, SpringLayout.NORTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea_1, 67, SpringLayout.EAST, textArea);
		textArea_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		textArea_1.setRows(6);
		textArea_1.setColumns(2);
		textArea_1.setText("Status:	" + gasstatus + "\n" + "Time:	" + gastime + " min\n" + "Daily Usage:	"  + gasuse + " kWh\n" + "Daily Cost:	" + gascost + " £\n" + "Budget:	" + Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()) + " £\n" + "Tariff:	" + tariffimpl.checkTariff()[1] + " £");
		textArea_1.setEditable(false);
		contentPane.add(textArea_1);
		
		lblElectricity = new JLabel("Electricity");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblElectricity, -164, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblElectricity);
		contentPane.add(lblElectricity);
		
		lblGad = new JLabel("Gas");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGad, -6, SpringLayout.NORTH, textArea_1);
		contentPane.add(lblGad);
		
		JLabel lblUserInformation = new JLabel("[User Information]");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUserInformation, 0, SpringLayout.NORTH, contentPane);
		contentPane.add(lblUserInformation);
		
		JLabel lblId = new JLabel("ID:");
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, 156, SpringLayout.WEST, lblId);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblId, 22, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblId, 28, SpringLayout.WEST, contentPane);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblName, 6, SpringLayout.SOUTH, lblId);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblName, 0, SpringLayout.WEST, lblId);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lblId);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 176, SpringLayout.EAST, lblId);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, lblName);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_1, -144, SpringLayout.EAST, contentPane);
		contentPane.add(label_1);
		
		JLabel lblTotalBudget = new JLabel("Total Budget:");
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, lblTotalBudget);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTotalBudget, 251, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTotalBudget, 0, SpringLayout.NORTH, lblId);
		contentPane.add(lblTotalBudget);
		
		JLabel lblenergy = new JLabel("[Energy Information]");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblElectricity, 0, SpringLayout.EAST, lblenergy);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUserInformation, 0, SpringLayout.WEST, lblenergy);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblenergy, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblenergy, 6, SpringLayout.SOUTH, lblName);
		contentPane.add(lblenergy);
		
		JLabel lblotherFunction = new JLabel("[Other Function]");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblotherFunction, 0, SpringLayout.WEST, lblenergy);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblotherFunction, -35, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblotherFunction);
		
		JButton btnHistoric = new JButton("Historic");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnHistoric, 6, SpringLayout.SOUTH, lblotherFunction);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnHistoric, 0, SpringLayout.WEST, lblUserInformation);
		contentPane.add(btnHistoric);
		btnHistoric.addActionListener(this);
		
		JButton btnBills = new JButton("Bills");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBills, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnHistoric, -6, SpringLayout.WEST, btnBills);
		contentPane.add(btnBills);
		btnBills.addActionListener(this);
		
		JButton btnBudget = new JButton("Budget");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBudget, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBills, -3, SpringLayout.WEST, btnBudget);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBudget, 0, SpringLayout.EAST, label);
		contentPane.add(btnBudget);
		btnBudget.addActionListener(this);
		
		JButton btnContact = new JButton("Contact");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnContact, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnContact, -94, SpringLayout.EAST, contentPane);
		contentPane.add(btnContact);
		btnContact.addActionListener(this);
		
		JButton btnQuite = new JButton("Quite");
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea_1, 0, SpringLayout.EAST, btnQuite);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnQuite, 6, SpringLayout.EAST, btnContact);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnQuite, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnQuite);
		btnQuite.addActionListener(this);
		
		JLabel label_2 = new JLabel("---------------------------------------");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 6, SpringLayout.SOUTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 6, SpringLayout.EAST, lblenergy);
		contentPane.add(label_2);
		
		label_3 = new JLabel("------------------------------------------");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, lblotherFunction);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_3, 6, SpringLayout.EAST, lblotherFunction);
		contentPane.add(label_3);
		
		JLabel lblId_1 = new JLabel(Integer.toString(userimpl.getNowUserInfo().getId()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblId_1, 22, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblId_1, 6, SpringLayout.EAST, lblId);
		contentPane.add(lblId_1);
		
		JLabel lblName_1 = new JLabel(userimpl.getNowUserInfo().getName());
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblName_1, 0, SpringLayout.NORTH, lblName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblName_1, 6, SpringLayout.EAST, lblName);
		contentPane.add(lblName_1);
		
		lblBudget = new JLabel(Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget() + userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()) + " £");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBudget, 0, SpringLayout.NORTH, lblId);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBudget, 6, SpringLayout.EAST, lblTotalBudget);
		contentPane.add(lblBudget);
		
		JButton btnEon = new JButton("EON");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEon, 8, SpringLayout.SOUTH, lblenergy);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEon, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEon, -6, SpringLayout.NORTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEon, -16, SpringLayout.WEST, lblElectricity);
		btnEon.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(btnEon);
		btnEon.addActionListener(this);
		
		JButton btnEoff = new JButton("EOFF");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEoff, 2, SpringLayout.NORTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEoff, 16, SpringLayout.EAST, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEoff, -6, SpringLayout.NORTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEoff, 0, SpringLayout.EAST, textArea);
		btnEoff.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(btnEoff);
		btnEoff.addActionListener(this);
		
		JButton btnGon = new JButton("GON");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGad, 37, SpringLayout.EAST, btnGon);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGon, 1, SpringLayout.NORTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnGon, 0, SpringLayout.WEST, textArea_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGon, -5, SpringLayout.NORTH, textArea_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGon, -149, SpringLayout.EAST, contentPane);
		btnGon.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(btnGon);
		btnGon.addActionListener(this);
		
		JButton btnGoff = new JButton("GOFF");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoff, 1, SpringLayout.NORTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnGoff, 206, SpringLayout.EAST, textArea);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnGoff, -5, SpringLayout.NORTH, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGoff, -10, SpringLayout.EAST, contentPane);
		btnGoff.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(btnGoff);
		btnGoff.addActionListener(this);
		
		//electricity signal
		if(Float.parseFloat(elecost) <= (userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget())){
			lblElectricity.setForeground(Color.green);
		}
		else{
			lblElectricity.setForeground(Color.red);
		}
		
		//gas signal
		if(Float.parseFloat(gascost) <= (userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget())){
			lblGad.setForeground(Color.green);
		}
		else{
			lblGad.setForeground(Color.red);
		}
		
		//total signal
		if((userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget() + userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()) >= (Float.parseFloat(elecost) + Float.parseFloat(gascost))){
			lblBudget.setForeground(Color.green);
		}
		else{
			lblBudget.setForeground(Color.red);
		}
		
		setTitle("Smart Energy Monitoring System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getActionCommand()=="Historic"){  
        	if(eletricity_judge != 0 || gas_judge != 0){
        		label_3.setText("Please turn off the meter(electricity / gas)");
        		label_3.setForeground(Color.red);
        	}
        	else{
            	this.setVisible(false);
    	   		new HistoricBorad();
        	}
        }
        else if(e.getActionCommand()=="Bills"){
    		this.setVisible(false);
    		new CheckBillBorad();
        }
        else if(e.getActionCommand()=="Budget"){
        	if(eletricity_judge != 0 || gas_judge != 0){
        		label_3.setText("Please turn off the meter(electricity / gas)");
        		label_3.setForeground(Color.red);
        	}
        	else{
    	   		this.setVisible(false);
    	   		new BudgetBorad();
        	}
        }
        else if(e.getActionCommand()=="Contact"){
        	if(eletricity_judge != 0 || gas_judge != 0){
        		label_3.setText("Please turn off the meter(electricity / gas)");
        		label_3.setForeground(Color.red);
        	}
        	else{
    	   		this.setVisible(false);
    	   		new ContactBorad();
        	}
        }
        else if(e.getActionCommand()=="Quite"){  
	       	// System.exit(0);
        	eletricity_judge = 0;
        	gas_judge = 0;  
        	eletricity_judge = -1;
        	gas_judge = -1;  
        	this.setVisible(false);
        	new SelectSystemBorad();
        }  
        else if(e.getActionCommand()=="EON"){  
        	
        	eletricity_judge = 1;
        	if(!t1.isAlive()){
        		t1.start();
        	}
        	
        }  
        else if(e.getActionCommand()=="EOFF"){  
        	
        	eletricity_judge = 0;
        	
        }  
        else if(e.getActionCommand()=="GON"){  
        	
        	gas_judge = 1;
        	if(!t2.isAlive()){
        		t2.start();
        	}
        	

        }  
        else if(e.getActionCommand()=="GOFF"){  
        	
        	gas_judge = 0;
        	
        }  
	}
}
