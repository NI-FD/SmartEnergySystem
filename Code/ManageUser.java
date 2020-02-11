
import java.util.ArrayList;

/**
 * Title      : ManageUser.java
 * Description: This class manage the information of user.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ManageUser {
	
	/**
	 * This method is used to convert the ArrayList to User[][].
	 * @param userlist The User object list.
	 * @return The return is User[][].
	 */
	public User[][] userList(ArrayList<User> userlist){
		if(userlist == null){
			return null;
		}
		else{
			int m;
			ArrayList<Integer> remove = new ArrayList();
//			System.out.println(userlist.size());
			for(m = 0 ; m < userlist.size() ; m++){
				if(userlist.get(m).getId() == 0){
					remove.add(m);
					System.out.println("index: " + m);
				}	
			}
			
			System.out.println("remove: " + remove.size());
			
			for(m = 0 ; m < remove.size() ; m++){
				if(m == 0){
					userlist.remove(userlist.get(remove.get(m)));
				}
				else{
					userlist.remove(userlist.get(remove.get(m)-m));
				}
			}
			
	//		System.out.println("after: " + userlist.get(0).getName());
			
			User[][] list = new User[(int)Math.ceil((double)userlist.size()/(double)5)][5];
			System.out.println(list.length);
			int i;
			int j = 0;
			int count = 0;
			
			for(i = 0 ; i < userlist.size() ; i++){
				if( i < 5 ){
					list[j][i] = (User)userlist.get(i);
					if(i == 4){
						j++;
					}
				}
				else{
					list[j][i % 5] = userlist.get(i);
					count++;
					if( count == 5){
						j++;
						count = 0;
					}
				}
				
			}
			
	//		System.out.println("Name: " + list[0][0].getName());
			
			return list;
		}

	
	}
	
}
