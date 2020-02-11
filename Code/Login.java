
/**
 * Title      : Login.java
 * Description: This class manage the process of login.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class Login {
	
	/**
	 * This method is used to judge the user.
	 * @param name The user name
	 * @param password The user password
	 * @return The return is whether the user exist.
	 */
	public boolean check(String name, String password){
		
		UserImpl userimpl = new UserImpl();	
		User user = new User();
		
		user = userimpl.queryUserInfoByName(name);
		
		if(user == null || user.getId() == 0){
			return false;
		}
		else if(user.getPassword().equals(password)){
			return true;
		}
		else
			return false;		
	}
	
}
