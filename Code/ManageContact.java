
import java.util.ArrayList;

/**
 * Title      : ManageContact.java
 * Description: This class manage the content of contact.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ManageContact {
	
	/**
	 * This method is used to convert the ArrayList to Contact[][].
	 * @param contactlist The contact object list
	 * @return The return is Contact[][].
	 */
	public Contact[][] contactList(ArrayList<Contact> contactlist){
		if(contactlist == null){
			return null;
		}
		else{
			Contact[][] list = new Contact[(int)Math.ceil((double)contactlist.size()/(double)5)][5];
			int i;
			int j = 0;
			int count = 0;
			System.out.println("length: " + contactlist.size());
			for(i = 0 ; i < contactlist.size() ; i++){
				if( i < 5 ){
					list[j][i] = (Contact)contactlist.get(i);
					if(i == 4){
						j++;
					}
				}
				else{
					list[j][i % 5] = contactlist.get(i);
					count++;
					if( count == 5){
						j++;
						count = 0;
					}
				}	
			}
			return list;	
		}
	}
	
	/**
	 * This method is used to convert symbol to another symbol.
	 * @param content The string need to be converted.
	 * @return The return is new string.
	 */
	public String newLine(String content){
		
		int i;
		String newcontent;
		String[] check;
		check = content.split("\\\n");
		if(check.length == 0){
			return content;
		}
		else{
			newcontent = check[0]; 
			for(i = 1 ; i < check.length ; i++){
				newcontent = newcontent + "/n" + check[i];
			}
			
			return newcontent;
		}
	}
	
	/**
	 * This method is used to convert symbol to another symbol.
	 * @param content The string need to be converted.
	 * @return The return is new string.
	 */
	public String oldLine(String content){
		
		int i;
		String oldcontent;
		String[] check;
		check = content.split("\\/n");
		if(check.length == 0){
			return content;
		}
		else{
			oldcontent = check[0]; 
			for(i = 1 ; i < check.length ; i++){
				oldcontent = oldcontent + "\r\n" + check[i];
			}
			
			return oldcontent;
		}		
	}
	
}
