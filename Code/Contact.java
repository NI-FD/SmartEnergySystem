
/**
 * Title      : Contact.java
 * Description: This class contains the information of a contact.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class Contact {
	
	private int id = 0;		//the user id
	private String name = "";		//the user name	
	private int type = 0;		//the message type
	private String content = "";		//the message content
	private String date = "";		//the message date
	
	/**
	 * This method is used to get date.
	 * @return The return value is date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * This method is used to set date.
	 * @param date The date of the message
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * This method is used to get user id.
	 * @return The return value is user id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method is used to set user id.
	 * @param id The user id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method is used to get user name.
	 * @return The return value is user name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method is used to set user name.
	 * @param name The user name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method is used to get message type.
	 * @return The return value is message type.
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * This method is used to set message type.
	 * @param type The message type
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * This method is used to get message content.
	 * @return The return value is message content.
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * This method is used to set message content.
	 * @param content The message content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
