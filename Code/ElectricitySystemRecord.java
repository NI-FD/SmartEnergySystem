
/**
 * Title      : ElectricitySystemRecord.java
 * Description: This class contains the information of an ElectricitySystemRecord.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ElectricitySystemRecord {
	
	private int id;		//the user id.
	private int year;		//the year of record generation.
	private int month;		//the month of record generation.
	private int day;		//the day of record generation.
	private int hour;		//the hour of record generation.
	private int minute;		//the minute of record generation.
	private int second;		//the second of record generation.
	private float electricity_usage = 0;		//the electricity usage
	private float electricity_price = 0;		//the electricity price
	private int efirsthour;		//the first hour of record generation
	private int efirstminute;		//the first minute of record generation
	private int efirstsecond;		//the first second of record generation
	private int etotaltime = 0;		//the total time of record
	
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
	 * This method is used to get electricity_usage.
	 * @return The return value is electricity_usage.
	 */
	public float getElectricity_usage() {
		return electricity_usage;
	}
	
	/**
	 * This method is used to set electricity_usage.
	 * @param electricity_usage The electricity_usage.
	 */
	public void setElectricity_usage(float electricity_usage) {
		this.electricity_usage = electricity_usage;
	}
	
	/**
	 * This method is used to get electricity_price.
	 * @return The return value is electricity_price.
	 */
	public float getElectricity_price() {
		return electricity_price;
	}
	
	/**
	 * This method is used to set electricity_price.
	 * @param electricity_price The electricity_price.
	 */
	public void setElectricity_price(float electricity_price) {
		this.electricity_price = electricity_price;
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
	public int getEfirsthour() {
		return efirsthour;
	}
	
	/**
	 * This method is used to set first hour.
	 * @param efirsthour The first hour
	 */
	public void setEfirsthour(int efirsthour) {
		this.efirsthour = efirsthour;
	}
	
	/**
	 * This method is used to get efirstminute.
	 * @return The return value is efirstminute.
	 */
	public int getEfirstminute() {
		return efirstminute;
	}
	
	/**
	 * This method is used to set efirstminute.
	 * @param efirstminute The efirstminute.
	 */
	public void setEfirstminute(int efirstminute) {
		this.efirstminute = efirstminute;
	}
	
	/**
	 * This method is used to get efirstsecond.
	 * @return The return value is efirstsecond.
	 */
	public int getEfirstsecond() {
		return efirstsecond;
	}
	
	/**
	 * This method is used to set efirstsecond.
	 * @param efirstsecond The efirstsecond.
	 */
	public void setEfirstsecond(int efirstsecond) {
		this.efirstsecond = efirstsecond;
	}
	
	/**
	 * This method is used to get etotaltime.
	 * @return The return value is etotaltime.
	 */
	public int getEtotaltime() {
		return etotaltime;
	}
	
	/**
	 * This method is used to set etotaltime.
	 * @param etotaltime The etotaltime.
	 */
	public void setEtotaltime(int etotaltime) {
		this.etotaltime = etotaltime;
	}
	
	
}
