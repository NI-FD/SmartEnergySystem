
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JCheckBox;
import javax.naming.ldap.Rdn;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Title      : MessageBorad.java
 * Description: This class is the GUI content, it display the list of message from user.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class MessageBorad extends JFrame implements ActionListener {

	ManageContact managecontact = new ManageContact();
	ContactImpl contactimpl = new ContactImpl();
	
	private JPanel contentPane;
	
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	
	private JButton button;
	private JButton button_1;
	
	private JLabel lblPage;
	
	int i = 0;
	private JLabel lblWarnning;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageBorad frame = new MessageBorad();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MessageBorad() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		checkBox = new JCheckBox("1");
		contentPane.add(checkBox);
		
		checkBox_1 = new JCheckBox("2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox_1, 6, SpringLayout.SOUTH, checkBox);
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox_1, 0, SpringLayout.WEST, checkBox);
		contentPane.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox_2, 6, SpringLayout.SOUTH, checkBox_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox_2, 0, SpringLayout.WEST, checkBox);
		contentPane.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox_3, 6, SpringLayout.SOUTH, checkBox_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox_3, 0, SpringLayout.WEST, checkBox);
		contentPane.add(checkBox_3);
		
		checkBox_4 = new JCheckBox("5");
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox_4, 6, SpringLayout.SOUTH, checkBox_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox_4, 0, SpringLayout.WEST, checkBox);
		contentPane.add(checkBox_4);
		
		button = new JButton("<");
		contentPane.add(button);
		button.addActionListener(this);
		
		lblPage = new JLabel("Page: 1");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPage, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, -5, SpringLayout.NORTH, lblPage);
		contentPane.add(lblPage);
		
		button_1 = new JButton(">");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button_1, -2, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPage, -24, SpringLayout.WEST, button_1);
		contentPane.add(button_1);
		button_1.addActionListener(this);
		
		JButton btnConfirm = new JButton("Confirm");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConfirm, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnConfirm, -2, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 17, SpringLayout.EAST, btnConfirm);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		JButton btnBack = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, -15, SpringLayout.WEST, btnBack);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBack, -2, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel lblPleaseChooseOne = new JLabel("The feedback has two types, 'Advice' & 'Complaints'");
		lblPleaseChooseOne.setForeground(Color.RED);
		sl_contentPane.putConstraint(SpringLayout.NORTH, checkBox, 16, SpringLayout.SOUTH, lblPleaseChooseOne);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPleaseChooseOne, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPleaseChooseOne, 0, SpringLayout.WEST, btnConfirm);
		contentPane.add(lblPleaseChooseOne);
		
		lblWarnning = new JLabel("You can check the details of message which you want!");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWarnning, 47, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblWarnning, -16, SpringLayout.NORTH, button);
		contentPane.add(lblWarnning);
		
		label = new JLabel("---------------------------------------------------");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, -6, SpringLayout.NORTH, lblWarnning);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, btnBack);
		contentPane.add(label);
		
		label_1 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 24, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, checkBox, 5, SpringLayout.EAST, label_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 4, SpringLayout.NORTH, checkBox);
		contentPane.add(label_1);
		
		label_2 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, checkBox_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_2, 24, SpringLayout.WEST, contentPane);
		contentPane.add(label_2);
		
		label_3 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, checkBox_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_3, 24, SpringLayout.WEST, contentPane);
		contentPane.add(label_3);
		
		label_4 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 0, SpringLayout.NORTH, checkBox_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_4, 24, SpringLayout.WEST, contentPane);
		contentPane.add(label_4);
		
		label_5 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_5, 0, SpringLayout.NORTH, checkBox_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_5, 24, SpringLayout.WEST, contentPane);
		contentPane.add(label_5);
		
		label_6 = new JLabel("|");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_6, 6, SpringLayout.SOUTH, label_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_6, 24, SpringLayout.WEST, contentPane);
		contentPane.add(label_6);
	
		Contact[][] contactlist = managecontact.contactList(contactimpl.getContact());
		
		lblPage.setText("Page: " + (i + 1));
		button.setEnabled(false);
		if(contactlist == null){
			
			hideLabel();
			button_1.setEnabled(false);
			btnConfirm.setEnabled(false);
			lblWarnning.setText("No Record! After to try!");
			lblWarnning.setForeground(Color.red);
		}
		else{
			displayLabel();	
			showList(); 
			if(contactlist.length <= 1){
				button_1.setEnabled(false);	
			}
		}	
		
		setTitle("Message Borad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Confirm"){
			int select_num = 0;
			int select_judge = 0;
			if(checkBox.isSelected()){
				select_num++;
				select_judge = 0;
			}
			if(checkBox_1.isSelected()){
				select_num++;
				select_judge = 1;
			}
			if(checkBox_2.isSelected()){
				select_num++;
				select_judge = 2;
			}
			if(checkBox_3.isSelected()){
				select_num++;
				select_judge = 3;
			}
			if(checkBox_4.isSelected()){
				select_num++;
				select_judge = 4;
			}
			
			if(select_num == 1){
				this.setVisible(false);
				new FeedbackDetailsBorad(select_judge , i);
			}
			else{
				unSelect();
				lblWarnning.setText("You can only choose one!");
				lblWarnning.setForeground(Color.red);
			}
			
		}
		else if(e.getActionCommand() == "Back"){
			this.setVisible(false);
			new ManagerMainBorad();
		}
		else if(e.getActionCommand() == "<"){
			i--;
			displayLabel();
			showList();
			lblPage.setText("Page: " + (i + 1));
			button_1.setEnabled(true);
			if(i == 0){
				button.setEnabled(false);
			}
		}
		else if(e.getActionCommand() == ">"){
			i++;
			displayLabel();
			showList();
			button.setEnabled(true);
			Contact[][] contactlist = managecontact.contactList(contactimpl.getContact());
			if(contactlist.length == (i+1)){
				button_1.setEnabled(false);			
			}
		}
	}
	
	public void showList(){
		
		Contact[][] contactlist = managecontact.contactList(contactimpl.getContact());
		String str_type;
	
		if(contactlist[i][0] != null){
			
			if(contactlist[i][0].getType() == 0){
				str_type = "Advice";
			}
			else{
				str_type = "Complaints";
			}
			checkBox.setText("●[Name]: " + contactlist[i][0].getName() + ";  [Type]: " + str_type + ";  [Time]: " + contactlist[i][0].getDate());
		}
		else{
			checkBox.setVisible(false);
			checkBox.setSelected(false);
		}
		
		if(contactlist[i][1] != null){
			
			if(contactlist[i][1].getType() == 0){
				str_type = "Advice";
			}
			else{
				str_type = "Complaints";
			}
			checkBox_1.setText("●[Name]: " + contactlist[i][1].getName() + ";  [Type]: " + str_type + ";  [Time]: " + contactlist[i][1].getDate());
		}
		else{
			checkBox_1.setVisible(false);
			checkBox_1.setSelected(false);
		}
		
		if(contactlist[i][2] != null){
			
			if(contactlist[i][2].getType() == 0){
				str_type = "Advice";
			}
			else{
				str_type = "Complaints";
			}
			checkBox_2.setText("●[Name]: " + contactlist[i][2].getName() + ";  [Type]: " + str_type + ";  [Time]: " + contactlist[i][2].getDate());
		}
		else{
			checkBox_2.setVisible(false);
			checkBox_2.setSelected(false);
		}
		
		if(contactlist[i][3] != null){
			
			if(contactlist[i][3].getType() == 0){
				str_type = "Advice";
			}
			else{
				str_type = "Complaints";
			}
			checkBox_3.setText("●[Name]: " + contactlist[i][3].getName() + ";  [Type]: " + str_type + ";  [Time]: " + contactlist[i][3].getDate());
		}
		else{
			checkBox_3.setVisible(false);
			checkBox_3.setSelected(false);
		}
		
		if(contactlist[i][4] != null){
			
			if(contactlist[i][4].getType() == 0){
				str_type = "Advice";
			}
			else{
				str_type = "Complaints";
			}
			checkBox_4.setText("●[Name]: " + contactlist[i][4].getName() + ";  [Type]: " + str_type + ";  [Time]: " + contactlist[i][4].getDate());
		}
		else{
			checkBox_4.setVisible(false);
			checkBox_4.setSelected(false);
		}
		
	}
	
	public void displayLabel(){
		
		checkBox.setVisible(true);
		checkBox_1.setVisible(true);
		checkBox_2.setVisible(true);
		checkBox_3.setVisible(true);
		checkBox_4.setVisible(true);
		
		checkBox.setSelected(false);
		checkBox_1.setSelected(false);
		checkBox_2.setSelected(false);
		checkBox_3.setSelected(false);
		checkBox_4.setSelected(false);
		
	}
	
	public void hideLabel(){
		
		checkBox.setVisible(false);
		checkBox_1.setVisible(false);
		checkBox_2.setVisible(false);
		checkBox_3.setVisible(false);
		checkBox_4.setVisible(false);
		
		checkBox.setSelected(false);
		checkBox_1.setSelected(false);
		checkBox_2.setSelected(false);
		checkBox_3.setSelected(false);
		checkBox_4.setSelected(false);
		
	}
	
	public void unSelect(){
		
		checkBox.setSelected(false);
		checkBox_1.setSelected(false);
		checkBox_2.setSelected(false);
		checkBox_3.setSelected(false);
		checkBox_4.setSelected(false);
		
	}
}
