
import java.util.ArrayList;


/**
 * Title      : UserInter.java
 * Description: This interface contains the control interface of controlling the UserInfo.txt and NowUser.
 * @author      wenyuan zhang
 * @version     1.0
 */

public interface UserInter {
	
	/**
	 * This method is used to modify the gas usage in UserInfo.txt.
	 * @param id The user id.
	 * @param budget The array includes gas and electricity budget.
	 */
	public void UpdateUserBudget(int id , float[] budget);
	
	/**
	 * This method is used to add a new user into UserInfo.txt.
	 * @param user The user need to be stored.
	 */
	public void addNewUser(User user);
	
	/**
	 * This method is used to delete a user in UserInfo.txt by user id.
	 * @param id The user id.
	 */
	public void deleteUserById(int id);
	
	/**
	 * This method is used to get a user in UserInfo.txt by user id.
	 * @param id The user id.
	 * @return The return value is a User object.
	 */
	public User queryUserInfoById(int id);
	
	/**
	 * This method is used to get a user in UserInfo.txt by user name.
	 * @param name The user name.
	 * @return The return value is a User object.
	 */
	public User queryUserInfoByName(String name);
	
	/**
	 * This method is used to print a user details.
	 * @param user The user object.
	 */
	public void printUserInfo(User user);
	
	/**
	 * This method is used to get all user list in UserInfo.txt.
	 * @return The return value is a ArrayList include all user.
	 */
	public ArrayList<User> getAllUserInfo();
	
	
	
	/**
	 * This method is used to record the current user in NowUser.txt who is using the system.
	 * @param user The user object.
	 */
	public void updateNowUser(User user);
	
	/**
	 * This method is used to get a user in NowUser.txt by user name.
	 * @return The return value is a User object.
	 */
	public User getNowUserInfo();
}
