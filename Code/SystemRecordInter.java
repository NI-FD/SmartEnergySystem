
/**
 * Title      : SystemRecordInter.java
 * Description: This interface contains the control interface of controlling the SystemRecord.txt, Bill.txt, ElectricitySystemRecord.txt and GasSystemRecord.txt .
 * @author      wenyuan zhang
 * @version     1.0
 */

import java.util.ArrayList;

public interface SystemRecordInter {
	
	/**
	 * This method is used to add new meter read into SystemRecord.txt.
	 * @param systemrecord2 The SystemRecord object list which need to be stored into 'txt' file.
	 * @return The return value indicate whether the operation finish.
	 */
	public boolean addNewRecord(SystemRecord[][] systemrecord2);
	
	/**
	 * This method is used to add new electricity meter read into ElectricitySystemRecord.txt.
	 * @param electricitysystemrecord The ElectricitySystemRecord object which need to be stored into 'txt' file.
	 * @return The return value indicate whether the operation finish.
	 */
	public boolean addNewElectricityRecord(ElectricitySystemRecord electricitysystemrecord);
	
	/**
	 * This method is used to add new gas meter read into GasSystemRecord.txt.
	 * @param gassystemrecord The GasSystemRecord object which need to be stored into 'txt' file.
	 * @return The return value indicate whether the operation finish.
	 */
	public boolean addNewGasRecord(GasSystemRecord gassystemrecord);
	
	/**
	 * This method is used to add new bill record into Bill.txt.
	 * @param bill The SystemRecord object which need to be stored into 'txt' file.
	 * @return The return value indicate whether the operation finish.
	 */
	public boolean addBillRecord(SystemRecord bill);
	
	
	
	/**
	 * This method is used to modify the electricity total time in ElectricitySystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @param day The day of meter read.
	 * @param time The time of meter read.
	 */
	public void updateETotalTime(int id , int year , int month , int day , int time);
	
	/**
	 * This method is used to modify the gas total time in GasSystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @param day The day of meter read.
	 * @param time The time of meter read.
	 */
	public void updateGTotalTime(int id , int year , int month , int day , int time);
	
	/**
	 * This method is used to modify the first electricity time in ElectricitySystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @param day The day of meter read.
	 * @param hour The hour of meter read.
	 * @param minute The minute of meter read.
	 * @param second The second of meter read.
	 */
	public void updateEFirstTime(int id , int year , int month , int day , int hour , int minute , int second);
	
	/**
	 * This method is used to modify the first gas time in GasSystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @param day The day of meter read.
	 * @param hour The hour of meter read.
	 * @param minute The minute of meter read.
	 * @param second The second of meter read.
	 */
	public void updateGFirstTime(int id , int year , int month , int day , int hour , int minute , int second);
	
	/**
	 * This method is used to modify the electricity usage in ElectricitySystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @param day The day of meter read.
	 * @param usage The usage of electricity.
	 */
	public void updateElectricityRecord(int id , int year , int month , int day , float usage);
	
	/**
	 * This method is used to modify the gas usage in GasSystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @param day The day of meter read.
	 * @param usage The usage of gas.
	 */
	public void updateGasRecord(int id , int year , int month , int day , float usage);
	
	/**
	 * This method is used to modify the usage, price, time of gas and electricity in GasSystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @param day The day of meter read.
	 * @param ele_usage The usage of electricity.
	 * @param ele_price The price of electricity.
	 * @param gas_usage The usage of gas.
	 * @param gas_price The price of gas.
	 * @param ele_time The time of electricity.
	 * @param gas_time The time of gas.
	 */
	public void updateSystemRecord(int id , int year , int month , int day , float ele_usage , float ele_price , float gas_usage , float gas_price , int ele_time ,int gas_time);
	
	/**
	 * This method is used to modify record tariff in SystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 */
	public void updateSystemRecordTariff(int id , int year , int month);
	
	
	
	/**
	 * This method is used to get a SystemRecord object from SystemRecotd.txt by the id, year, month, day.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @return The return value is the result of querying.
	 */
	public SystemRecord getRecordByIdDate(int id , int year , int month , int day);
	
	/**
	 * This method is used to get a ElectricitySystemRecord object from ElectricitySystemRecotd.txt by the id, year, month, day.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @return The return value is the result of querying.
	 */
	public ElectricitySystemRecord getElectricityRecordByIdDate(int id , int year , int month , int day);
	
	/**
	 * This method is used to get a GasSystemRecord object from GasSystemRecord.txt by the id, year, month, day.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @return The return value is the result of querying.
	 */
	public GasSystemRecord getGasRecordByIdDate(int id , int year , int month , int day);
	
	/**
	 * This method is used to get a user's all ElectricitySystemRecord list from ElectricitySystemRecotd.txt by the id.
	 * @param id The user id.
	 * @return The return value is the result of querying.
	 */
	public ArrayList<ElectricitySystemRecord> getElectricityRecordById(int id);
	
	/**
	 * This method is used to get a user's all GasSystemRecord list from GasSystemRecord.txt by the id.
	 * @param id The user id.
	 * @return The return value is the result of querying.
	 */
	public ArrayList<GasSystemRecord> getGasRecordById(int id);
	
	/**
	 * This method is used to get a user's all SystemRecord list from SystemRecord.txt by the id.
	 * @param id The user id.
	 * @return The return value is the result of querying.
	 */
	public ArrayList<SystemRecord> getRecordById(int id);
	
	/**
	 * This method is used to get a user's all SystemRecord list from Bill.txt by the id.
	 * @param id The user id.
	 * @return The return value is the result of querying.
	 */
	public ArrayList<SystemRecord> getBillById(int id);
	
	
	
	/**
	 * This method is used to check whether the SystemRecord object which include the id, year, month, day is same as the SystemRecord object in SystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @return The return value is the result of querying.
	 */
	public boolean checkSameRecord(int id , int year , int month , int day);
	
	/**
	 * This method is used to check whether the ElectricitySystemRecord object which include the id, year, month, day is same as the ElectricitySystemRecord object in ElectricitySystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @return The return value is the result of querying.
	 */
	public boolean checkElectricitySameRecord(int id , int year , int month , int day);
	
	/**
	 * This method is used to check whether the GasSystemRecord object which include the id, year, month, day is same as the GasSystemRecord object in GasSystemRecord.txt.
	 * @param id The user id.
	 * @param year The year of meter read.
	 * @param month The month of meter read.
	 * @return The return value is the result of querying.
	 */
	public boolean checkGasSameRecord(int id , int year , int month , int day);
	

	
}
