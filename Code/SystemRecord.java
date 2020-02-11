
/**
 * Title      : SystemRecord.java
 * Description: This class contains the information of a SystemRecord.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class SystemRecord {

	private int id = 0;		//the user id.
	private int year;		//the year of record generation.
	private int month;		//the month of record generation.
	private int day;		//the day of record generation.
	private float electricity_usage = 0;		//the electricity usage
	private float electricity_oldprice = 0;		//the electricity price
	private float gas_usage = 0;		//the gas usage
	private float gas_oldprice = 0;		//the gas price
	private int etotaltime = 0;		//the total time of electricity record
	private int gtotaltime = 0;		//the total time of gas record
	private float total_cost = 0;		//the total cost of gas and electricity
	private int week = 0;		//the week
	
	/**
	 * This method is used to get week.
	 * @return The return value is week.
	 */
	public int getWeek() {
		return week;
	}
	
	/**
	 * This method is used to set week.
	 * @param week The week
	 */
	public void setWeek(int week) {
		this.week = week;
	}
	
	/**
	 * This method is used to get total cost.
	 * @return The return value is total cost.
	 */
	public float getTotal_cost() {
		return total_cost;
	}
	
	/**
	 * This method is used to set total cost.
	 * @param total_cost The total cost.
	 */
	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}
	
	/**
	 * This method is used to get gas total time.
	 * @return The return value is gas total time.
	 */
	public int getGtotaltime() {
		return gtotaltime;
	}
	
	/**
	 * This method is used to set gas total time.
	 * @param gtotaltime The gas total time.
	 */
	public void setGtotaltime(int gtotaltime) {
		this.gtotaltime = gtotaltime;
	}
	
	/**
	 * This method is used to get electricity total time.
	 * @return The return value is electricity total time.
	 */
	public int getEtotaltime() {
		return etotaltime;
	}
	
	/**
	 * This method is used to set electricity total time.
	 * @param etotaltime The electricity total time.
	 */
	public void setEtotaltime(int etotaltime) {
		this.etotaltime = etotaltime;
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
	 * This method is used to get electricity_usage.
	 * @return The return value is electricity_usage.
	 */
	public float getElectricity_usage() {
		return electricity_usage;
	}
	
	/**
	 * This method is used to set electricity_usage.
	 * @param electricity_usage The electricity usage.
	 */
	public void setElectricity_usage(float electricity_usage) {
		this.electricity_usage = electricity_usage;
	}
	
	/**
	 * This method is used to get electricity_oldprice.
	 * @return The return value is electricity_oldprice.
	 */
	public float getElectricity_oldprice() {
		return electricity_oldprice;
	}
	
	/**
	 * This method is used to set electricity_oldprice.
	 * @param electricity_oldprice The electricity old price.
	 */
	public void setElectricity_oldprice(float electricity_oldprice) {
		this.electricity_oldprice = electricity_oldprice;
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
	 * @param gas_usage The gas usage.
	 */
	public void setGas_usage(float gas_usage) {
		this.gas_usage = gas_usage;
	}
	
	/**
	 * This method is used to get gas_oldprice.
	 * @return The return value is gas_oldprice.
	 */
	public float getGas_oldprice() {
		return gas_oldprice;
	}
	
	/**
	 * This method is used to set gas_oldprice.
	 * @param gas_oldprice The gas old price.
	 */
	public void setGas_oldprice(float gas_oldprice) {
		this.gas_oldprice = gas_oldprice;
	}	
	
	
}
