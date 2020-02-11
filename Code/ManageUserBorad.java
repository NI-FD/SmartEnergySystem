
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

/**
 * Title      : ManageUserBorad.java
 * Description: This class is the GUI content, it display the operation of managing user.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ManageUserBorad extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JCheckBox chckbxUser;
	private JCheckBox chckbxUser_1;
	private JCheckBox chckbxUser_2;
	private JCheckBox chckbxUser_3;
	private JCheckBox chckbxUser_4;
    private JLabel lblP ;
    private JButton button;
    private JButton button_1;
    private JLabel lblWarnning;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnDetails;
    private JButton btnBill;
	
	ManageUser manageuser = new ManageUser();
	UserImpl userimpl = new UserImpl();
	User user = new User();
	User[][] uld; 
	
	int i, j;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUserBorad frame = new ManageUserBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageUserBorad() {

		i = 0;
		uld = manageuser.userList(userimpl.getAllUserInfo());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		chckbxUser = new JCheckBox();
		contentPane.add(chckbxUser);
		
		JLabel label = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -346, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxUser, -4, SpringLayout.NORTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxUser, 7, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, contentPane);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, label);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 6, SpringLayout.SOUTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 6, SpringLayout.SOUTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 6, SpringLayout.SOUTH, label_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_4, 0, SpringLayout.WEST, label);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_5, 6, SpringLayout.SOUTH, label_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, label);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_6, 6, SpringLayout.SOUTH, label_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_6, 0, SpringLayout.WEST, label);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_7, 6, SpringLayout.SOUTH, label_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_7, 0, SpringLayout.WEST, label);
		contentPane.add(label_7);
		
		chckbxUser_1 = new JCheckBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxUser_1, -4, SpringLayout.NORTH, label_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxUser_1, 0, SpringLayout.WEST, chckbxUser);
		contentPane.add(chckbxUser_1);
		
		chckbxUser_2 = new JCheckBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxUser_2, -4, SpringLayout.NORTH, label_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxUser_2, 0, SpringLayout.WEST, chckbxUser);
		contentPane.add(chckbxUser_2);
		
		chckbxUser_3 = new JCheckBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxUser_3, -4, SpringLayout.NORTH, label_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxUser_3, 0, SpringLayout.WEST, chckbxUser);
		contentPane.add(chckbxUser_3);
		
		JLabel label_8 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_8, 6, SpringLayout.SOUTH, label_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_8, 0, SpringLayout.WEST, label);
		contentPane.add(label_8);
		
		btnAdd = new JButton("Add");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAdd, -5, SpringLayout.NORTH, label_3);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnDelete = new JButton("Delete");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDelete, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAdd, 0, SpringLayout.WEST, btnDelete);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDelete, -5, SpringLayout.NORTH, label_5);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnDetails = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDetails, -5, SpringLayout.NORTH, label_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDetails, 0, SpringLayout.WEST, contentPane);
		contentPane.add(btnDetails);
		btnDetails.addActionListener(this);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		button = new JButton("<");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnBack);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, chckbxUser);
		contentPane.add(button);
		button.addActionListener(this);
		
		button_1 = new JButton(">");
		sl_contentPane.putConstraint(SpringLayout.WEST, button_1, 80, SpringLayout.EAST, button);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(button_1);
		button_1.addActionListener(this);
		
		lblP = new JLabel("Page: " + (i+1));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP, 5, SpringLayout.NORTH, btnBack);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP, 16, SpringLayout.EAST, button);
		contentPane.add(lblP);
		
		JLabel lblUserList = new JLabel("User List:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUserList, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUserList, 24, SpringLayout.WEST, contentPane);
		contentPane.add(lblUserList);
		
		JLabel label_9 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_9, 6, SpringLayout.SOUTH, label_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_9, 0, SpringLayout.WEST, label);
		contentPane.add(label_9);
		
		chckbxUser_4 = new JCheckBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxUser_4, -4, SpringLayout.NORTH, label_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxUser_4, 0, SpringLayout.WEST, chckbxUser);
		contentPane.add(chckbxUser_4);
		
		lblWarnning = new JLabel("View the details or delete the user!");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWarnning, 0, SpringLayout.NORTH, label_9);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWarnning, 10, SpringLayout.WEST, chckbxUser_4);
		contentPane.add(lblWarnning);
		
		btnBill = new JButton("Bill");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBill, -5, SpringLayout.NORTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBill, 0, SpringLayout.WEST, btnAdd);
		btnBill.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		contentPane.add(btnBill);
		btnBill.addActionListener(this);
		
		showUser();
		
		
		setTitle("Manage User Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int select_num = 0;
		int select_judge = 0;
		
		if(e.getActionCommand() == "Add"){
			this.setVisible(false);
			new RegisterBorad();
		}
		else if(e.getActionCommand()=="Delete"){
			
			select_num = 0;
			select_judge = 0;
			if(chckbxUser.isSelected()){
				select_num++;
				select_judge = 0;
			}
			if(chckbxUser_1.isSelected()){
				select_num++;
				select_judge = 1;
			}
			if(chckbxUser_2.isSelected()){
				select_num++;
				select_judge = 2;
			}
			if(chckbxUser_3.isSelected()){
				select_num++;
				select_judge = 3;
			}
			if(chckbxUser_4.isSelected()){
				select_num++;
				select_judge = 4;
			}
			
			if(select_num == 1){
				userimpl.deleteUserById(uld[i][select_judge].getId());
				this.setVisible(false);
				new ManageUserBorad();
			}
			else{
				unSelect();
				lblWarnning.setText("You can only choose one!");
				lblWarnning.setForeground(Color.red);
			}
			
		}
		else if(e.getActionCommand()=="Details"){
			select_num = 0;
			select_judge = 0;
			if(chckbxUser.isSelected()){
				select_num++;
				select_judge = 0;
			}
			if(chckbxUser_1.isSelected()){
				select_num++;
				select_judge = 1;
			}
			if(chckbxUser_2.isSelected()){
				select_num++;
				select_judge = 2;
			}
			if(chckbxUser_3.isSelected()){
				select_num++;
				select_judge = 3;
			}
			if(chckbxUser_4.isSelected()){
				select_num++;
				select_judge = 4;
			}
			
			if(select_num == 1){
				this.setVisible(false);
				new UserDetailsBorad(select_judge , i);
			}
			else{
				unSelect();
				lblWarnning.setText("You can only choose one!");
				lblWarnning.setForeground(Color.red);
			}
		}
		else if(e.getActionCommand() == "Bill"){
			
			select_num = 0;
			select_judge = 0;
			if(chckbxUser.isSelected()){
				select_num++;
				select_judge = 0;
			}
			if(chckbxUser_1.isSelected()){
				select_num++;
				select_judge = 1;
			}
			if(chckbxUser_2.isSelected()){
				select_num++;
				select_judge = 2;
			}
			if(chckbxUser_3.isSelected()){
				select_num++;
				select_judge = 3;
			}
			if(chckbxUser_4.isSelected()){
				select_num++;
				select_judge = 4;
			}
			
			if(select_num == 1){
				this.setVisible(false);
				new ManageUserBill(uld[i][select_judge].getId());
			}
			else{
				unSelect();
				lblWarnning.setText("You can only choose one!");
				lblWarnning.setForeground(Color.red);
			}
			
		}
		else if(e.getActionCommand()=="Back"){
			this.setVisible(false);
			new ManagerMainBorad();
		}
		else if(e.getActionCommand()=="<"){
			
			i--;
			lblP.setText("Page: " + (i + 1));
			
			showUser();
			
			button_1.setEnabled(true);
			if(i == 0){
				button.setEnabled(false);
			}
			
		}
		else if(e.getActionCommand()==">"){
			//this.setVisible(false);
			//new TariffManagerBorad();
			
			i++;
			lblP.setText("Page: " + (i + 1));
			
			showUser();	
			
			button.setEnabled(true);
			if(uld.length == (i+1)){
				button_1.setEnabled(false);			
			}
			
		}
		
	}
	
	public void showUser(){
		
		if(uld == null || uld.length == 0){
			button.setEnabled(false);
			button_1.setEnabled(false);
			btnDelete.setEnabled(false);
			btnDetails.setEnabled(false);
			btnBill.setEnabled(false);
			lblWarnning.setText("No Record! Please try another option!");
			lblWarnning.setForeground(Color.red);
			hideLabel();
		}
		else{
			
			button.setEnabled(false);
			
			if(uld.length <= (i+1)){
				button_1.setEnabled(false);
			}
			
			if(uld[i][0] != null){
				chckbxUser.setVisible(true);
				chckbxUser.setText("[ID]: " + uld[i][0].getId() + "  [Name]: " + uld[i][0].getName());
			}	
			else
				chckbxUser_1.setVisible(false);
			if(uld[i][1] != null){
				chckbxUser_1.setVisible(true);
				chckbxUser_1.setText("[ID]: " + uld[i][1].getId() + "  [Name]: " + uld[i][1].getName());
			}	
			else
				chckbxUser_1.setVisible(false);
			
			if(uld[i][2] != null){
				chckbxUser_2.setVisible(true);
				chckbxUser_2.setText("[ID]: " + uld[i][2].getId() + "  [Name]: " + uld[i][2].getName());
			}
			else
				chckbxUser_2.setVisible(false);
			
			if(uld[i][3] != null){
				chckbxUser_3.setVisible(true);
				chckbxUser_3.setText("[ID]: " + uld[i][3].getId() + "  [Name]: " + uld[i][3].getName());
			}
			else
				chckbxUser_3.setVisible(false);
			
			if(uld[i][4] != null){
				chckbxUser_4.setVisible(true);
				chckbxUser_4.setText("[ID]: " + uld[i][4].getId() + "  [Name]: " + uld[i][4].getName());
			}
			else
				chckbxUser_4.setVisible(false);
		}
	}
	
	public void unSelect(){
		
		chckbxUser.setSelected(false);
		chckbxUser_1.setSelected(false);
		chckbxUser_2.setSelected(false);
		chckbxUser_3.setSelected(false);
		chckbxUser_4.setSelected(false);
		
	}
	
	public void hideLabel(){
		
		chckbxUser.setEnabled(false);
		chckbxUser_1.setEnabled(false);
		chckbxUser_2.setEnabled(false);
		chckbxUser_3.setEnabled(false);
		chckbxUser_4.setEnabled(false);
		
	}
	
}
