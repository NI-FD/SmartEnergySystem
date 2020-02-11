
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class ContactTest extends TestCase {

	@Test
	public void testCreate() {
		Contact contact = new Contact();
		
		contact.setId(1);
		contact.setName("tset");
		contact.setType(1);
		contact.setContent("tsettest");
		contact.setDate("11.2");
		
		int id = contact.getId();
		int type = contact.getType();
		String name = contact.getName();
		String content = contact.getContent();
		String date = contact.getDate();
		
	    assertEquals(1, id);
	    assertEquals(1, type);
	    assertEquals("test", name);
	    assertEquals("testtest", content);
	    assertEquals("11.2", date);
	    
		
	}

}
