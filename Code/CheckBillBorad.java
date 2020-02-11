
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

/**
 * Title      : CheckBillBorad.java
 * Description: This class is the GUI content, it display the operation of checking bill.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class CheckBillBorad extends JFrame implements ActionListener {
	
	public static java.text.DecimalFormat df = new  java.text.DecimalFormat("#0.00");
	
	private JPanel contentPane;
	
	private JLabel lblD;
	private JLabel lblD_1;
	private JLabel lblD_2;
	private JLabel lblD_3;
	private JLabel lblD_4;

	private JLabel lblEu;
	private JLabel lblEu_1;
	private JLabel lblEu_2;
	private JLabel lblEu_3;
	private JLabel lblEu_4;
	
	private JLabel lblEc;
	private JLabel lblEc_1;
	private JLabel lblEc_2;
	private JLabel lblEc_3;
	private JLabel lblEc_4;
	
	private JLabel lblGu;
	private JLabel lblGu_1;
	private JLabel lblGu_2;
	private JLabel lblGu_3;
	private JLabel lblGu_4;
	
	private JLabel lblGc;
	private JLabel lblGc_1;
	private JLabel lblGc_2;
	private JLabel lblGc_3;
	private JLabel lblGc_4;
	
	private JLabel lblPage;
	
	private JButton button;
	private JButton button_1;
	
	private JLabel lblPleasePayYour;
	
	int i;
	
	private SystemRecord[][] list;
	ManageRecord managerecord = new ManageRecord();
	SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
	UserImpl userimpl = new UserImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBillBorad frame = new CheckBillBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckBillBorad() {
		
		i = 0;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblDate = new JLabel("Date");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDate, 67, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDate, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblDate);
		
		JLabel lblElectricity = new JLabel("Electricity");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblElectricity, 114, SpringLayout.WEST, contentPane);
		contentPane.add(lblElectricity);
		
		JLabel lblGas = new JLabel("Gas");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblElectricity, 0, SpringLayout.NORTH, lblGas);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGas, 40, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGas, -106, SpringLayout.EAST, contentPane);
		contentPane.add(lblGas);
		
		JLabel lblEusage = new JLabel("Usage");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEusage, 0, SpringLayout.NORTH, lblDate);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEusage, 47, SpringLayout.EAST, lblDate);
		contentPane.add(lblEusage);
		
		JLabel lblEcost = new JLabel("Cost");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEcost, 0, SpringLayout.NORTH, lblDate);
		contentPane.add(lblEcost);
		
		JLabel lblEusage_1 = new JLabel("Usage");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEusage_1, 258, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEcost, -58, SpringLayout.WEST, lblEusage_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEusage_1, 0, SpringLayout.NORTH, lblDate);
		contentPane.add(lblEusage_1);
		
		JLabel lblEcost_1 = new JLabel("Cost");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEcost_1, 0, SpringLayout.NORTH, lblDate);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEcost_1, 55, SpringLayout.EAST, lblEusage_1);
		contentPane.add(lblEcost_1);
		
		lblD = new JLabel("d1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblD, 17, SpringLayout.SOUTH, lblDate);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblD, 0, SpringLayout.WEST, lblDate);
		contentPane.add(lblD);
		
		lblD_1 = new JLabel("d2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblD_1, 6, SpringLayout.SOUTH, lblD);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblD_1, 0, SpringLayout.WEST, lblDate);
		contentPane.add(lblD_1);
		
		lblD_2 = new JLabel("d3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblD_2, 6, SpringLayout.SOUTH, lblD_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblD_2, 0, SpringLayout.WEST, lblDate);
		contentPane.add(lblD_2);
		
		lblD_3 = new JLabel("d4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblD_3, 6, SpringLayout.SOUTH, lblD_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblD_3, 0, SpringLayout.WEST, lblDate);
		contentPane.add(lblD_3);
		
		lblD_4 = new JLabel("d5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblD_4, 6, SpringLayout.SOUTH, lblD_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblD_4, 0, SpringLayout.WEST, lblDate);
		contentPane.add(lblD_4);
		
		lblEu = new JLabel("eu1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEu, 0, SpringLayout.NORTH, lblD);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEu, 0, SpringLayout.WEST, lblEusage);
		contentPane.add(lblEu);
		
		lblEu_1 = new JLabel("eu2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEu_1, 0, SpringLayout.NORTH, lblD_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEu_1, 0, SpringLayout.WEST, lblEusage);
		contentPane.add(lblEu_1);
		
		lblEu_2 = new JLabel("eu3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEu_2, 0, SpringLayout.NORTH, lblD_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEu_2, 0, SpringLayout.WEST, lblEusage);
		contentPane.add(lblEu_2);
		
		lblEu_3 = new JLabel("eu4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEu_3, 0, SpringLayout.NORTH, lblD_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEu_3, 0, SpringLayout.WEST, lblEusage);
		contentPane.add(lblEu_3);
		
		lblEu_4 = new JLabel("eu5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEu_4, 0, SpringLayout.NORTH, lblD_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEu_4, 0, SpringLayout.WEST, lblEusage);
		contentPane.add(lblEu_4);
		
		lblEc = new JLabel("ec1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEc, 0, SpringLayout.NORTH, lblD);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEc, 0, SpringLayout.WEST, lblEcost);
		contentPane.add(lblEc);
		
		lblEc_1 = new JLabel("ec2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEc_1, 0, SpringLayout.NORTH, lblD_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEc_1, 0, SpringLayout.WEST, lblEcost);
		contentPane.add(lblEc_1);
		
		lblEc_2 = new JLabel("ec4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEc_2, 0, SpringLayout.NORTH, lblD_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEc_2, 0, SpringLayout.WEST, lblEcost);
		contentPane.add(lblEc_2);
		
		lblEc_3 = new JLabel("ec5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEc_3, 0, SpringLayout.NORTH, lblD_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEc_3, 0, SpringLayout.WEST, lblEcost);
		contentPane.add(lblEc_3);
		
		lblEc_4 = new JLabel("ec3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEc_4, 0, SpringLayout.NORTH, lblD_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEc_4, 0, SpringLayout.WEST, lblEcost);
		contentPane.add(lblEc_4);
		
		lblGu = new JLabel("gu1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGu, 0, SpringLayout.NORTH, lblD);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGu, 0, SpringLayout.WEST, lblEusage_1);
		contentPane.add(lblGu);
		
		lblGu_1 = new JLabel("gu2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGu_1, 0, SpringLayout.NORTH, lblD_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGu_1, 0, SpringLayout.WEST, lblEusage_1);
		contentPane.add(lblGu_1);
		
		lblGu_2 = new JLabel("gu3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGu_2, 0, SpringLayout.NORTH, lblD_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGu_2, 0, SpringLayout.WEST, lblEusage_1);
		contentPane.add(lblGu_2);
		
		lblGu_3 = new JLabel("gu4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGu_3, 0, SpringLayout.NORTH, lblD_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGu_3, 0, SpringLayout.WEST, lblEusage_1);
		contentPane.add(lblGu_3);
		
		lblGu_4 = new JLabel("gu5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGu_4, 0, SpringLayout.NORTH, lblD_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGu_4, 0, SpringLayout.WEST, lblEusage_1);
		contentPane.add(lblGu_4);
		
		lblGc = new JLabel("gc1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGc, 0, SpringLayout.NORTH, lblD);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGc, 0, SpringLayout.WEST, lblEcost_1);
		contentPane.add(lblGc);
		
		lblGc_1 = new JLabel("gc2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGc_1, 0, SpringLayout.NORTH, lblD_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGc_1, 0, SpringLayout.WEST, lblEcost_1);
		contentPane.add(lblGc_1);
		
		lblGc_2 = new JLabel("gc3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGc_2, 0, SpringLayout.NORTH, lblD_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGc_2, 0, SpringLayout.WEST, lblEcost_1);
		contentPane.add(lblGc_2);
		
		lblGc_3 = new JLabel("gc4");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGc_3, 0, SpringLayout.WEST, lblEcost_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGc_3, 0, SpringLayout.SOUTH, lblD_3);
		contentPane.add(lblGc_3);
		
		lblGc_4 = new JLabel("gc5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGc_4, 0, SpringLayout.NORTH, lblD_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGc_4, 0, SpringLayout.WEST, lblEcost_1);
		contentPane.add(lblGc_4);
		
		button = new JButton("<");
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 104, SpringLayout.WEST, contentPane);
		contentPane.add(button);
		
		button_1 = new JButton(">");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, lblGas);
		contentPane.add(button_1);
		
		
		lblPage = new JLabel("Page: 1");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPage, 5, SpringLayout.NORTH, button);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPage, 17, SpringLayout.EAST, button);
		contentPane.add(lblPage);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnBack);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel lblBilled = new JLabel("[Billed]");
		lblBilled.setForeground(Color.RED);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBilled, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBilled, 10, SpringLayout.WEST, contentPane);
		lblBilled.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		contentPane.add(lblBilled);
		
		lblPleasePayYour = new JLabel("\nPlease pay your bill as soon as possible");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPleasePayYour, 0, SpringLayout.WEST, lblEusage);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPleasePayYour, -6, SpringLayout.NORTH, button);
		contentPane.add(lblPleasePayYour);
		
		init();
		showBill(list);
		
		
		setTitle("Check Bills");
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
			new UserMainBorad();
			
		}
		else if(e.getActionCommand() == "<"){
			
			displayLabel();
			i--;
			lblPage.setText("Page: " + (i + 1));
			showBill(list);
			button_1.setEnabled(true);
			if(i == 0){
				button.setEnabled(false);
			}
			
		}
		else if(e.getActionCommand() == ">"){
			
			displayLabel();
			i++;
			lblPage.setText("Page: " + (i + 1));
			showBill(list);
			button.setEnabled(true);
			if(list.length == (i+1)){
				button_1.setEnabled(false);
			}
			
		}
		
	}
	
	
	public void showBill(SystemRecord[][] bill){
		
		if(bill == null || bill.length == 0){
			button.setEnabled(false);
			button_1.setEnabled(false);
			lblPleasePayYour.setText("There are no bills yet!");
			lblPleasePayYour.setForeground(Color.red);
			hideLabel();
		}
		else{
			displayLabel();
			
			button.setEnabled(false);
			
			if(bill.length <= (i+1)){
				button_1.setEnabled(false);
			}
			
			if(bill[i][0] != null){
				lblD.setText(bill[i][0].getYear()+ "." + bill[i][0].getMonth());
				lblEu.setText(df.format(bill[i][0].getElectricity_usage()));
				lblEc.setText(df.format(bill[i][0].getElectricity_usage()*bill[i][0].getElectricity_oldprice()));
				lblGu.setText(df.format(bill[i][0].getGas_usage()));
				lblGc.setText(df.format(bill[i][0].getGas_usage()*bill[i][0].getGas_oldprice()));
			}	
			else{
				lblD.setVisible(false);
				lblEu.setVisible(false);
				lblEc.setVisible(false);
				lblGu.setVisible(false);
				lblGc.setVisible(false);
			}
			if(bill[i][1] != null){
				lblD_1.setText(bill[i][1].getYear()+ "." + bill[i][1].getMonth());
				lblEu_1.setText(df.format(bill[i][1].getElectricity_usage()));
				lblEc_1.setText(df.format(bill[i][1].getElectricity_usage()*bill[i][1].getElectricity_oldprice()));
				lblGu_1.setText(df.format(bill[i][1].getGas_usage()));
				lblGc_1.setText(df.format(bill[i][1].getGas_usage()*bill[i][1].getGas_oldprice()));
			}	
			else{
				lblD_1.setVisible(false);
				lblEu_1.setVisible(false);
				lblEc_1.setVisible(false);
				lblGu_1.setVisible(false);
				lblGc_1.setVisible(false);
			}
			
			if(bill[i][2] != null){
				lblD_2.setText(bill[i][2].getYear()+ "." + bill[i][2].getMonth());
				lblEu_2.setText(df.format(bill[i][2].getElectricity_usage()));
				lblEc_2.setText(df.format(bill[i][2].getElectricity_usage()*bill[i][2].getElectricity_oldprice()));
				lblGu_2.setText(df.format(bill[i][2].getGas_usage()));
				lblGc_2.setText(df.format(bill[i][2].getGas_usage()*bill[i][2].getGas_oldprice()));
			}
			else{
				lblD_2.setVisible(false);
				lblEu_2.setVisible(false);
				lblEc_2.setVisible(false);
				lblGu_2.setVisible(false);
				lblGc_2.setVisible(false);
			}
			
			if(bill[i][3] != null){
				lblD_3.setText(bill[i][3].getYear()+ "." + bill[i][3].getMonth());
				lblEu_3.setText(df.format(bill[i][3].getElectricity_usage()));
				lblEc_3.setText(df.format(bill[i][3].getElectricity_usage()*bill[i][3].getElectricity_oldprice()));
				lblGu_3.setText(df.format(bill[i][3].getGas_usage()));
				lblGc_3.setText(df.format(bill[i][3].getGas_usage()*bill[i][3].getGas_oldprice()));
			}
			else{
				lblD_3.setVisible(false);
				lblEu_3.setVisible(false);
				lblEc_3.setVisible(false);
				lblGu_3.setVisible(false);
				lblGc_3.setVisible(false);
			}
			
			if(bill[i][4] != null){
				lblD_4.setText(bill[i][4].getYear()+ "." + bill[i][4].getMonth());
				lblEu_4.setText(df.format(bill[i][4].getElectricity_usage()));
				lblEc_4.setText(df.format(bill[i][4].getElectricity_usage()*bill[i][4].getElectricity_oldprice()));
				lblGu_4.setText(df.format(bill[i][4].getGas_usage()));
				lblGc_4.setText(df.format(bill[i][4].getGas_usage()*bill[i][4].getGas_oldprice()));
			}
			else{
				lblD_4.setVisible(false);
				lblEu_4.setVisible(false);
				lblEc_4.setVisible(false);
				lblGu_4.setVisible(false);
				lblGc_4.setVisible(false);
			}
		}
		
	}
	
	public void hideLabel(){
		lblD.setText(" ");
		lblEu.setText(" ");
		lblEc.setText(" ");
		lblGu.setText(" ");
		lblGc.setText(" ");
		
		lblD_1.setText(" ");
		lblEu_1.setText(" ");
		lblEc_1.setText(" ");
		lblGu_1.setText(" ");
		lblGc_1.setText(" ");
		
		lblD_2.setText(" ");
		lblEu_2.setText(" ");
		lblEc_2.setText(" ");
		lblGu_2.setText(" ");
		lblGc_2.setText(" ");
		
		lblD_3.setText(" ");
		lblEu_3.setText(" ");
		lblEc_3.setText(" ");
		lblGu_3.setText(" ");
		lblGc_3.setText(" ");
		
		lblD_4.setText(" ");
		lblEu_4.setText(" ");
		lblEc_4.setText(" ");
		lblGu_4.setText(" ");
		lblGc_4.setText(" ");
		
		lblD.setVisible(false);
		lblEu.setVisible(false);
		lblEc.setVisible(false);
		lblGu.setVisible(false);
		lblGc.setVisible(false);
		
		lblD_1.setVisible(false);
		lblEu_1.setVisible(false);
		lblEc_1.setVisible(false);
		lblGu_1.setVisible(false);
		lblGc_1.setVisible(false);
		
		lblD_2.setVisible(false);
		lblEu_2.setVisible(false);
		lblEc_2.setVisible(false);
		lblGu_2.setVisible(false);
		lblGc_2.setVisible(false);
		
		lblD_3.setVisible(false);
		lblEu_3.setVisible(false);
		lblEc_3.setVisible(false);
		lblGu_3.setVisible(false);
		lblGc_3.setVisible(false);
		
		lblD_4.setVisible(false);
		lblEu_4.setVisible(false);
		lblEc_4.setVisible(false);
		lblGu_4.setVisible(false);
		lblGc_4.setVisible(false);
	}
	
	public void displayLabel(){
		
		lblD.setVisible(true);
		lblEu.setVisible(true);
		lblEc.setVisible(true);
		lblGu.setVisible(true);
		lblGc.setVisible(true);
		
		lblD_1.setVisible(true);
		lblEu_1.setVisible(true);
		lblEc_1.setVisible(true);
		lblGu_1.setVisible(true);
		lblGc_1.setVisible(true);
		
		lblD_2.setVisible(true);
		lblEu_2.setVisible(true);
		lblEc_2.setVisible(true);
		lblGu_2.setVisible(true);
		lblGc_2.setVisible(true);
		
		lblD_3.setVisible(true);
		lblEu_3.setVisible(true);
		lblEc_3.setVisible(true);
		lblGu_3.setVisible(true);
		lblGc_3.setVisible(true);
		
		lblD_4.setVisible(true);
		lblEu_4.setVisible(true);
		lblEc_4.setVisible(true);
		lblGu_4.setVisible(true);
		lblGc_4.setVisible(true);
		
	}
	
	public void init(){
		list = managerecord.List(systemrecordimpl.getBillById(userimpl.getNowUserInfo().getId()));
	}
	
}
