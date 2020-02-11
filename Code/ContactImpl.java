
import java.util.ArrayList;

/**
 * Title      : ContactImpl.java
 * Description: This class is implement of ContactInter.java.
 * @author wenyuan zhang
 * @version 1.0
 */

public class ContactImpl implements ContactInter {

	ReadFile rf= new ReadFile();
	WriteFile wf = new WriteFile();
	
	@Override
	public boolean addContact(String id , String name , String type , String content , String date) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/Contact.txt";
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> list = new ArrayList();
		String store_info = "";
		Olist = rf.readLine(filePath);
		
		list.clear();
		
		store_info = id + "|" + name + "|" + type + "|" + content + "|" + date;
		
		list.add(store_info);	

		if(wf.writeLineAppend(list , filePath)){
			return true;
		}
		else{
			return false;
		}

	}

	@Override
	public ArrayList<Contact> getContact() {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/Contact.txt";
		Contact contact;
		ArrayList<Contact> contactlist = new ArrayList();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[5];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\|");
				contact = new Contact();
				
				contact.setId(Integer.parseInt(check[0]));
				contact.setName(check[1]);
				contact.setType(Integer.parseInt(check[2]));
				contact.setContent(check[3]);
				contact.setDate(check[4]);
				
				contactlist.add(contact);
			}
			return contactlist;
			
		}
	}

}
