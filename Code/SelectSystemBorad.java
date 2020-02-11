
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;

/**
 * Title      : SelectSystemBorad.java
 * Description: This class is the GUI content, it display the two option to select the system to use.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class SelectSystemBorad extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSystemBorad frame = new SelectSystemBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectSystemBorad() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnCustomer = new JButton("Customer");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCustomer, -86, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCustomer, -58, SpringLayout.EAST, contentPane);
		contentPane.add(btnCustomer);
		btnCustomer.addActionListener(this);
		
		JButton btnManager = new JButton("Manager");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnManager, 0, SpringLayout.NORTH, btnCustomer);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnManager, 62, SpringLayout.WEST, contentPane);
		contentPane.add(btnManager);
		btnManager.addActionListener(this);
		
		
		setTitle("Select the System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Manager"){
			this.setVisible(false);
			new ManagerMainBorad();
		}
		else if(e.getActionCommand()=="Customer"){
			this.setVisible(false);
			new LoginBorad();
		}
	}
}
