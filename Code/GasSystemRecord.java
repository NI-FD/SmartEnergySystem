
/**
 * Title      : GasSystemRecord.java
 * Description: This class contains the information of a GasSystemRecord.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class GasSystemRecord {
	
	private int id;		//the user id.
	private int year;		//the year of record generation.
	private int month;		//the month of record generation.
	private int day;		//the day of record generation.
	private int hour;		//the hour of record generation.
	private int minute;		//the minute of record generation.
	private int second;		//the second of record generation.
	private float gas_usage = 0;		//the gas usage
	private float gas_price = 0;		//the gas price
	private int gfirsthour;		//the first hour of record generation
	private int gfirstminute;		//the first minute of record generation
	private int gfirstsecond;		//the first second of record generation
	private int gtotaltime = 0;		//the total time of record
	
	/**
	 * This method is used to get hour.
	 * @return The return value is hour
	 */
	public int getHour() {
		return hour;
	}
	
	/**
	 * This method is used to set hour.
	 * @param hour The hour.
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	/**
	 * This method is used to get minute.
	 * @return The return value is minute
	 */
	public int getMinute() {
		return minute;
	}
	
	/**
	 * This method is used to set minute.
	 * @param minute The minute.
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	/**
	 * This method is used to get second.
	 * @return The return value is second.
	 */
	public int getSecond() {
		return second;
	}
	
	/**
	 * This method is used to set second.
	 * @param second The second
	 */
	public void setSecond(int second) {
		this.second = second;
	}
	
	/**
	 * This method is used to get gas_usage.
	 * @return The return value is gas_usage.
	 */
	public float getGas_usage() {
		return gas_usage;
	}
	
	/**
	 * This method is used to set gas_usage.
	 * @param gas_usage The gas_usage.
	 */
	public void setGas_usage(float gas_usage) {
		this.gas_usage = gas_usage;
	}
	
	/**
	 * This method is used to get gas_price.
	 * @return The return value is gas_price.
	 */
	public float getGas_price() {
		return gas_price;
	}
	
	/**
	 * This method is used to set gas_price.
	 * @param gas_price The gas_price.
	 */
	public void setGas_price(float gas_price) {
		this.gas_price = gas_price;
	}
	
	/**
	 * This method is used to get id.
	 * @return The return value is id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method is used to set id.
	 * @param id The id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method is used to get year.
	 * @return The return value is year.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * This method is used to set year.
	 * @param year The year.
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * This method is used to get month.
	 * @return The return value is month.
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * This method is used to set month.
	 * @param month The month.
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	/**
	 * This method is used to get day.
	 * @return The return value is day.
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * This method is used to set day.
	 * @param day The day.
	 */
	public void setDay(int day) {
		this.day = day;
	}
	
	/**
	 * This method is used to get first hour.
	 * @return The return value is first hour.
	 */
	public int getGfirsthour() {
		return gfirsthour;
	}
	
	/**
	 * This method is used to set first hour.
	 * @param gfirsthour The first hour
	 */
	public void setGfirsthour(int gfirsthour) {
		this.gfirsthour = gfirsthour;
	}
	
	/**
	 * This method is used to get efirstminute.
	 * @return The return value is efirstminute.
	 */
	public int getGfirstminute() {
		return gfirstminute;
	}
	
	/**
	 * This method is used to set gfirstminute.
	 * @param gfirstminute The gfirstminute.
	 */
	public void setGfirstminute(int gfirstminute) {
		this.gfirstminute = gfirstminute;
	}
	
	/**
	 * This method is used to get gfirstsecond.
	 * @return The return value is gfirstsecond.
	 */
	public int getGfirstsecond() {
		return gfirstsecond;
	}
	
	/**
	 * This method is used to set gfirstsecond.
	 * @param gfirstsecond The gfirstsecond.
	 */
	public void setGfirstsecond(int gfirstsecond) {
		this.gfirstsecond = gfirstsecond;
	}
	
	/**
	 * This method is used to get gtotaltime.
	 * @return The return value is gtotaltime.
	 */
	public int getGtotaltime() {
		return gtotaltime;
	}
	
	/**
	 * This method is used to set gtotaltime.
	 * @param gtotaltime The gtotaltime.
	 */
	public void setGtotaltime(int gtotaltime) {
		this.gtotaltime = gtotaltime;
	}

}
