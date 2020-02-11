
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Title      : ManageTime.java
 * Description: This class is used to get the current date and manage the date data.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ManageTime {

	/**
	 * This method is used to get the current year value.
	 */
	public int getYear(){
		String date = getStringDate();
		String[] spiltdate = new String[6];
		spiltdate = date.split("\\*");
		return Integer.parseInt(spiltdate[0]);
	}
	
	/**
	 * This method is used to get the current month value.
	 */
	public int getMonth(){
		String date = getStringDate();
		String[] spiltdate = new String[6];
		spiltdate = date.split("\\*");
		return Integer.parseInt(spiltdate[1]);		
	}
	
	/**
	 * This method is used to get the current day value.
	 */
	public int getDay(){
		String date = getStringDate();
		String[] spiltdate = new String[6];
		spiltdate = date.split("\\*");
		return Integer.parseInt(spiltdate[2]);	
	}
	
	/**
	 * This method is used to get the current hour value.
	 */
	public int getHour(){
		String date = getStringDate();
		String[] spiltdate = new String[6];
		spiltdate = date.split("\\*");
		return Integer.parseInt(spiltdate[3]);
	}
	
	/**
	 * This method is used to get the current minute value.
	 */
	public int getMinute(){
		String date = getStringDate();
		String[] spiltdate = new String[6];
		spiltdate = date.split("\\*");
		return Integer.parseInt(spiltdate[4]);
	}
	
	/**
	 * This method is used to get the current second value.
	 */
	public int getSecond(){
		String date = getStringDate();
		String[] spiltdate = new String[6];
		spiltdate = date.split("\\*");
		return Integer.parseInt(spiltdate[5]);
	}
	
	/**
	 * This method is used to get the different between two times.
	 * @param fhour The old hour value.
	 * @param fminute The old minute value.
	 * @param fsecond The old second value.
	 */
	public String getDifferent(int fhour , int fminute , int fsecond ){
		String hour = Integer.toString(getHour() - fhour);
		String minute = Integer.toString(getMinute() - fminute);
		String second = Integer.toString(getSecond() - fsecond);
		
		return (hour + ":" + minute + ":" + second);
	}
	
	/**
	 * This method is used to display the current date on console.
	 */
	public static String getStringDate() {
		
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy*MM*dd*HH*mm*ss");
		String dateString = formatter.format(currentTime);
		return dateString;
		
	}
	
	/**
	 * This method is used to display the current date on console.
	 */
	public static String getNormalDate() {
		
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		String dateString = formatter.format(currentTime);
		return dateString;
		
	}
}
