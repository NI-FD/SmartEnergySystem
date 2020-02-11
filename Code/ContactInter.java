
import java.util.ArrayList;

/**
 * Title      : ContactInter.java
 * Description: This interface contains the control interface of controlling the Contact.txt.
 * @author      wenyuan zhang
 * @version     1.0
 */

public interface ContactInter {

	/**
	 * This method is used to add new message into Contact.txt.
	 * @param id The user id.
	 * @param name The user name.
	 * @param type The message type.
	 * @param content The message contents.
	 * @param date The date of message generation.
	 * @return The return value indicate whether the operation finish.
	 */
	public boolean addContact(String id , String name , String type , String content , String date);
	
	/**
	 * This method is used to get the contact list from Contact.txt.
	 * @return The return value indicate whether the operation finish.
	 */
	public ArrayList<Contact> getContact();
	
}
