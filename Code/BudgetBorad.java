
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

/**
 * Title      : BudgetBorad.java
 * Description: This class is the GUI content, it display the operation of budget.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class BudgetBorad extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNull;
	private JLabel lblNull_1;
	private JLabel lblNull_2;
	
	UserImpl userimpl = new UserImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BudgetBorad frame = new BudgetBorad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BudgetBorad() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblCurrentBudget = new JLabel("Current Budget\n(Pound)");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCurrentBudget, 10, SpringLayout.NORTH, contentPane);
		contentPane.add(lblCurrentBudget);
		
		JLabel lblNewBudget = new JLabel("New Budget(Pound)");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCurrentBudget, -41, SpringLayout.WEST, lblNewBudget);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewBudget, 0, SpringLayout.NORTH, lblCurrentBudget);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewBudget, -10, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewBudget);
		
		JLabel lblElectricity = new JLabel("Electricity:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblElectricity, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblElectricity, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblElectricity);
		
		JLabel lblGas = new JLabel("Gas:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGas, 24, SpringLayout.SOUTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGas, 0, SpringLayout.EAST, lblElectricity);
		contentPane.add(lblGas);
		
		JLabel lblTotal = new JLabel("Total:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTotal, 28, SpringLayout.SOUTH, lblGas);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTotal, 0, SpringLayout.EAST, lblElectricity);
		contentPane.add(lblTotal);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -5, SpringLayout.NORTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, lblNewBudget);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -87, SpringLayout.EAST, contentPane);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		lblNull = new JLabel(Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNull, 0, SpringLayout.NORTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNull, 73, SpringLayout.EAST, lblElectricity);
		contentPane.add(lblNull);
		
		lblNull_1 = new JLabel(Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNull_1, 0, SpringLayout.NORTH, lblGas);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNull_1, 0, SpringLayout.WEST, lblNull);
		contentPane.add(lblNull_1);
		
		lblNull_2 = new JLabel(Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget() + userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNull_2, 0, SpringLayout.NORTH, lblTotal);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNull_2, 0, SpringLayout.WEST, lblNull);
		contentPane.add(lblNull_2);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblGas);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewBudget);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -82, SpringLayout.EAST, contentPane);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton btnConfirm = new JButton("Confirm");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConfirm, 66, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnConfirm, -28, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnConfirm);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, -70, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		lblNewLabel_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblCurrentBudget);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, btnConfirm);
		contentPane.add(lblNewLabel_1);
		
		
		
		setTitle("Change Budget");
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
			try{
				float[] budget = new float[2];
				
				String electricity = textField_1.getText();
				String gas = textField.getText();
			
				float en = Float.parseFloat(electricity);
				float gn = Float.parseFloat(gas);
				float total = en + gn;
				
				budget[0] = en;
				budget[1] = gn;
				
				if(en < 0 || gn <0){
					lblNewLabel_1.setText("Please enter the positive number!");
					lblNewLabel_1.setForeground(Color.red);
				}
				else if(electricity == null || gas == null){
					lblNewLabel_1.setText("Please enter number!");
					lblNewLabel_1.setForeground(Color.red);
				}
				else{
					userimpl.UpdateUserBudget(userimpl.getNowUserInfo().getId(), budget);
					userimpl.updateNowUser(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()));
					lblNull.setText(electricity);
					lblNull_1.setText(gas);
					lblNull_2.setText(Float.toString(total));
					lblNewLabel_1.setText("The budget has been changed!");
					lblNewLabel_1.setForeground(Color.red);
				}
			}catch(Exception ex){
				lblNewLabel_1.setText("Please enter number!");
				lblNewLabel_1.setForeground(Color.red);
			}
			
		}
		else if(e.getActionCommand()=="Back"){
			this.setVisible(false);
			new UserMainBorad();
		}
	}
}
