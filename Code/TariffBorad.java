
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
 * Title      : TariffBorad.java
 * Description: This class is the GUI content, it display the operation of changing the tariff.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class TariffBorad extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label;
	private JLabel lblEle;
	private JLabel lblGas_1;
	
	TariffImpl tariffimpl = new TariffImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TariffBorad frame = new TariffBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TariffBorad() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblElectricity = new JLabel("Electricity:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblElectricity, 32, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblElectricity, -172, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblElectricity);
		
		JLabel lblGas = new JLabel("Gas:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGas, 37, SpringLayout.SOUTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGas, 0, SpringLayout.EAST, lblElectricity);
		contentPane.add(lblGas);
		
		JLabel lblCurrentTariff = new JLabel("Current Tariff");
		contentPane.add(lblCurrentTariff);
		
		JLabel lblNewTariff = new JLabel("New Tariff");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewTariff, 36, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCurrentTariff, 0, SpringLayout.NORTH, lblNewTariff);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCurrentTariff, -84, SpringLayout.WEST, lblNewTariff);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewTariff, -64, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewTariff);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -5, SpringLayout.NORTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewTariff);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -5, SpringLayout.EAST, lblNewTariff);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblEle = new JLabel(Float.toString(tariffimpl.checkTariff()[0]));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEle, 0, SpringLayout.NORTH, lblElectricity);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEle, 66, SpringLayout.EAST, lblElectricity);
		contentPane.add(lblEle);
		
		lblGas_1 = new JLabel(Float.toString(tariffimpl.checkTariff()[1]));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGas_1, 0, SpringLayout.NORTH, lblGas);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGas_1, 0, SpringLayout.WEST, lblEle);
		contentPane.add(lblGas_1);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -5, SpringLayout.NORTH, lblGas);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, lblNewTariff);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -69, SpringLayout.EAST, contentPane);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JButton btnConfirm = new JButton("Confirm");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConfirm, 83, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnConfirm, -45, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnConfirm);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, lblNewTariff);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		label = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 116, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, -6, SpringLayout.NORTH, btnConfirm);
		contentPane.add(label);
		
		
		
		
		setTitle("Change the Tariff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Confirm"){
			try{
				String[] price = new String[2];
				
				String electricity = textField.getText();
				String gas = textField_1.getText();
			
				float en = Float.parseFloat(electricity);
				float gn = Float.parseFloat(gas);
				float total = en + gn;
				
				price[0] = electricity;
				price[1] = gas;
				
				if(en < 0 || gn <0){
					label.setText("Please enter the positive number!");
					label.setForeground(Color.red);
				}
				else if(electricity == null || gas == null){
					label.setText("Please enter number!");
					label.setForeground(Color.red);
				}
				else{
					tariffimpl.modifyTariff(price);
					lblEle.setText(electricity);
					lblGas_1.setText(gas);
					label.setText("The tariff has been changed!");
					label.setForeground(Color.red);
				}
			}catch(Exception ex){
				label.setText("Please enter number!");
				label.setForeground(Color.red);
			}
		}
		else if(e.getActionCommand()=="Back"){
			this.setVisible(false);
			new ManagerMainBorad();
		}
		
	}
}
