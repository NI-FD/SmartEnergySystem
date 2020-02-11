
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JCheckBox;
import javax.swing.JButton;

/**
 * Title      : ManagerMainBorad.java
 * Description: This class is the GUI content, it display the operation of manager.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ManagerMainBorad extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMainBorad frame = new ManagerMainBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerMainBorad() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnUserInformationManager = new JButton("User Information Management");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnUserInformationManager, 98, SpringLayout.WEST, contentPane);
		contentPane.add(btnUserInformationManager);
		btnUserInformationManager.addActionListener(this);
		
		JButton btnTariffManagement = new JButton("Tariff Management");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTariffManagement, 153, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTariffManagement, 101, SpringLayout.WEST, contentPane);
		contentPane.add(btnTariffManagement);
		btnTariffManagement.addActionListener(this);
		
		JButton btnQuite = new JButton("Quite");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnQuite, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnQuite, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnQuite);
		btnQuite.addActionListener(this);
		
		JButton btnFeedbackManagement = new JButton("Feedback Management");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnUserInformationManager, -24, SpringLayout.NORTH, btnFeedbackManagement);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFeedbackManagement, 99, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnFeedbackManagement, -19, SpringLayout.NORTH, btnTariffManagement);
		contentPane.add(btnFeedbackManagement);
		btnFeedbackManagement.addActionListener(this);
		
		
		setTitle("Smart Energy Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "User Information Management"){
			this.setVisible(false);
			new ManageUserBorad();
		}
		else if(e.getActionCommand()=="Feedback Management"){
			this.setVisible(false);
			new MessageBorad();
		}
		else if(e.getActionCommand()=="Tariff Management"){
			this.setVisible(false);
			new TariffBorad();
		}
		else if(e.getActionCommand()=="Quite"){
			this.setVisible(false);
			new SelectSystemBorad();
		}
	}
}
