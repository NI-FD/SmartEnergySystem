
public class Test_Login_Register_Details extends JFrame implements ActionListener{
    //定义组件   
    JButton jb1,jb2,jb3=null;  
    JPanel jp1,jp2,jp3,jp4,jp5,jp6=null;  
    JTextField jtf1,jtf2,jtf3,jtf4=null;  
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5=null;  
    JPasswordField jpf=null;  
	
    public static void main(String[] args) {  
 
    	Test_Login_Register_Details rb=new Test_Login_Register_Details();  
    }  
     
    public Test_Login_Register_Details(){
    	  //创建组件  
        jb1=new JButton("Login");  
        jb2=new JButton("Register"); 
        jb3=new JButton("Details");

        //设置监听  
        jb1.addActionListener(this); 
        jb2.addActionListener(this);  
        jb3.addActionListener(this);  

        jp1 = new JPanel();  
        jp2 = new JPanel();  
        jp3 = new JPanel();  

        jp1.add(jb1);       //添加按钮
        jp2.add(jb2);  
        jp3.add(jb3);

        //加入JFrame中  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  

        this.setLayout(new GridLayout(3,1));            //选择GridLayout布局管理器        
        this.setTitle("Smart Energy Manage System");          
        this.setSize(300,150);         
        this.setLocation(400, 200);           
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出 
        this.setVisible(true);  
        this.setResizable(true);  
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getActionCommand()=="Login")  
        {  
        	this.setVisible(false); 
        	new LoginBorad();
        }
        else if(e.getActionCommand()=="Register")
        {
        	this.setVisible(false);
        	new RegisterBorad(); 
        }
        else if(e.getActionCommand()=="Details")  
        {  
        	
        }  
	}
	
}
