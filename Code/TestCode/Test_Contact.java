
public class Test_Contact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contact contact = new Contact();
		ContactImpl contactimpl = new ContactImpl();
		ManageContact managecontact = new ManageContact();
		String type = "1";
		String content = "test";
		
		contactimpl.addContact("2" , "xsy" , type , content , ManageTime.getNormalDate());
		
		
		
		System.out.println("name: " + managecontact.contactList(contactimpl.getContact())[0][0].getName());
		//System.out.println("name: " + contactimpl.getContact().get(1).getName());
		
	}

}
