
import junit.framework.TestCase;

public class ManageTimeTest extends TestCase {

	public void testCreate(){
		ManageTime managetime = new ManageTime();
		
		int year;
		year = managetime.getYear();
		
		int month;
		month = managetime.getMonth();
		
		int day;
	    day = managetime.getDay();
	    
	    int hour;
	    hour = managetime.getHour();
	    
	    int minute;
	    minute = managetime.getMinute();
	    
	    int second;
	    second = managetime.getSecond();
	   
	    assertEquals(2018, year);
	    assertEquals(5, month);
	    assertEquals(31, day);
	    
	}
	
	
}
