
/**
 * Title      : Register.java
 * Description: This class manage the process of register.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class Register {

	/**
	 * This method is used to judge the user.
	 * @param name The user name
	 * @return The return is whether the user exist.
	 */
	public boolean check(String name){
		UserImpl userimpl = new UserImpl();	
		User user = new User();
		
		user = userimpl.queryUserInfoByName(name);
		
		if(user == null || user.getId() == 0){
			return true;
		}
		else{
			return false;
		}			
	}
	
}
