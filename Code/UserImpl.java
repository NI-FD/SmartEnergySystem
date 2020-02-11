
import java.util.ArrayList;

/**
 * Title      : Account.java
 * Description: This class is implement of UserInter.java.
 * @author wenyuan zhang
 * @version 1.0
 */

public class UserImpl implements UserInter {

	ReadFile rf= new ReadFile();
	WriteFile wf = new WriteFile();
	
	int i;

	@Override
	public void UpdateUserBudget(int id, float[] budget) {
		// TODO Auto-generated method stub
		int flag = 1;
		String filePath = "source/UserInfo.txt";
		User user = new User();
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> Nlist = new ArrayList();
		String store_budget = "";
		Olist = rf.readLine(filePath);
		
//		System.out.println(Olist.size());
		if(Olist.size() == 0){
			System.out.println("Error");
		}
		else{
			String[] check = new String[8];
			for(i = 0 ; i<Olist.size() ; i++){
				check = Olist.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id){
					check[6] = Float.toString(budget[0]);
					check[7] = Float.toString(budget[1]);
				}
				store_budget = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7];
				Nlist.add(store_budget);
			}
			wf.writeLineCover(Nlist, filePath);
		}	
	}

	@Override
	public void addNewUser(User user) {
		// TODO Auto-generated method stub
		int flag = 0;
		String filePath = "source/UserInfo.txt";
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> list = new ArrayList();
		String store_info = "";
		String[] getid = new String[7];
		Olist = rf.readLine(filePath);
		
		if(Olist.size() == 0){
			list.clear();
			
			store_info = "1" + "*" + user.getName() + "*" + user.getPassword() + "*" + user.getAddress() 
			+"*" + user.getEmail() + "*" + Long.toString(user.getPhone()) + "*" + Float.toString(user.getElectricity_budget()) + "*" + Float.toString(user.getGas_budget()); 
			
			list.add(store_info);
			
			wf.writeLineCover(list, filePath);
			
		}else{
			if(this.queryUserInfoByName(user.getName()) == null || this.queryUserInfoByName(user.getName()).getId() == 0){
				
				list.clear();
				int user_number = Olist.size();
				for(flag = 0 ; flag < user_number ; flag++){
					getid = Olist.get(flag).split("\\*");
					if(Integer.parseInt(getid[0]) == 0){
						if(0 == flag){
							user.setId(2);
						}
						else{
							user.setId(2 + flag);
						}
					}
					else{
						user.setId(user_number + 1);
					}
				}			
				store_info = Integer.toString(user.getId()) + "*" + user.getName() + "*" + user.getPassword() + "*" + user.getAddress() 
				+ "*" + user.getEmail() + "*" + Long.toString(user.getPhone()) + "*" + Float.toString(user.getElectricity_budget()) + "*" + Float.toString(user.getGas_budget());
				
				list.add(store_info);
				
				wf.writeLineAppend(list , filePath);	
				
			}else{
				System.out.println("The name existed!");
			}
			
		}
	
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		String filePath = "source/UserInfo.txt";
		User user = new User();
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> Nlist = new ArrayList();
		String store_budget = "";
		Olist = rf.readLine(filePath);
		
//		System.out.println(Olist.size());
		if(Olist.size() == 0){
			System.out.println("Error");
		}
		else{
			String[] check = new String[8];
			for(i = 0 ; i<Olist.size() ; i++){
				check = Olist.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id){
					check[0] = "0";
				}
				store_budget = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7];
				Nlist.add(store_budget);
			}
			wf.writeLineCover(Nlist, filePath);
		}	
		
	}

	@Override
	public ArrayList<User> getAllUserInfo() {
		// TODO Auto-generated method stub
		String filePath = "source/UserInfo.txt";
		User user;
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
		ArrayList<User> userlist = new ArrayList();

		if(list.size() == 0){
			return null;
		}
		else{
//			System.out.println("Length:" + list.size());
			String[] check = new String[8];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				user = new User();
				user.setId(Integer.parseInt(check[0]));
				user.setName(check[1]);
				user.setPassword(check[2]);
				user.setAddress(check[3]);
				user.setEmail(check[4]);
				user.setPhone(Integer.parseInt(check[5]));
				user.setElectricity_budget(Float.parseFloat(check[6]));
				user.setGas_budget(Float.parseFloat(check[7]));

				userlist.add(user);
			}

			return userlist;
			
		}
	}
	
	@Override
	public User queryUserInfoById(int id) {
		// TODO Auto-generated method stub
		String filePath = "source/UserInfo.txt";
		User user = new User();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[8];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id){
					user.setId(Integer.parseInt(check[0]));
					user.setName(check[1]);
					user.setPassword(check[2]);
					user.setAddress(check[3]);
					user.setEmail(check[4]);
					user.setPhone(Integer.parseInt(check[5]));
					user.setElectricity_budget(Float.parseFloat(check[6]));
					user.setGas_budget(Float.parseFloat(check[7]));
					return user;
				}
			}
			return null;
			
		}
	}
	
	@Override
	public User queryUserInfoByName(String name) {
		// TODO Auto-generated method stub
		String filePath = "source/UserInfo.txt";
		User user = new User();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[8];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				if(check[1].equals(name) && Integer.parseInt(check[0]) != 0){
					user.setId(Integer.parseInt(check[0]));
					user.setName(check[1]);
					user.setPassword(check[2]);
					user.setAddress(check[3]);
					user.setEmail(check[4]);
					user.setPhone(Integer.parseInt(check[5]));
					user.setElectricity_budget(Float.parseFloat(check[6]));
					user.setGas_budget(Float.parseFloat(check[7]));
					return user;
				}
			}
			return null;
			
		}
	}
	
	@Override
	public void printUserInfo(User user) {
		// TODO Auto-generated method stub
		System.out.println("ID: " + user.getId());
		System.out.println("Name: " + user.getName());
		System.out.println("Password: " + user.getPassword());
		System.out.println("Address: " + user.getAddress());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Phone number: " + user.getPhone());
		System.out.println("Ele Budget: " + user.getElectricity_budget());
		System.out.println("Gas Budget: " + user.getGas_budget());
	}
	
	@Override
	public void updateNowUser(User user) {
		// TODO Auto-generated method stub
		String filePath = "source/NowUser.txt";
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> list = new ArrayList();
		String store_info = "";
		String[] getid = new String[7];
		Olist = rf.readLine(filePath);
		
		list.clear();
			
		store_info = Integer.toString(user.getId()) + "*" + user.getName() + "*" + user.getPassword() + "*" + user.getAddress() 
			+"*" + user.getEmail() + "*" + Long.toString(user.getPhone()) + "*" + Float.toString(user.getElectricity_budget()) + "*" + Float.toString(user.getGas_budget()); 
			
		list.add(store_info);
			
		wf.writeLineCover(list, filePath);
			
	}

	@Override
	public User getNowUserInfo() {
		// TODO Auto-generated method stub
		String filePath = "source/NowUser.txt";
		User user = new User();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[8];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				user.setId(Integer.parseInt(check[0]));
				user.setName(check[1]);
				user.setPassword(check[2]);
				user.setAddress(check[3]);
				user.setEmail(check[4]);
				user.setPhone(Integer.parseInt(check[5]));
				user.setElectricity_budget(Float.parseFloat(check[6]));
				user.setGas_budget(Float.parseFloat(check[7]));
				return user;
			}
			return null;
			
		}
	}

}
