
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;  

/**
 * Title      : Week.java
 * Description: This class is used to calculate the week.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class Week {  
	
	/**
	 * This method is used to calculate the week.
	 * @param year The year
	 * @param month The month
	 * @param day The day
	 * @return The return is the week number in this year.
	 */
	public int getWeekByDate(int year , int month , int day){
		 String today =  Integer.toString(year) + "-" +  Integer.toString(month) + "-" +  Integer.toString(day);
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
         Date date = null;  
         try {  
             date = format.parse(today);  
         } catch (ParseException e) {  
             // TODO Auto-generated catch block  
             e.printStackTrace();  
         }  
           
         Calendar calendar = Calendar.getInstance();  
         calendar.setFirstDayOfWeek(Calendar.MONDAY);  
         calendar.setTime(date);  
           
         return calendar.get(Calendar.WEEK_OF_YEAR); 
	} 
}  
