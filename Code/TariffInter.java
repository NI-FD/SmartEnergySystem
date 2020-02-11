
/**
 * Title      : TariffInter.java
 * Description: This interface contains the control interface of controlling the Tariff.txt.
 * @author      wenyuan zhang
 * @version     1.0
 */

public interface TariffInter {

	/**
	 * This method is used to modify electricity tariff today in ElectricitySystemRecord.txt.
	 * @param price The array include electricity and gas tariff.
	 */
	public void updateDayElectricityTariff(float[] price);
	
	/**
	 * This method is used to modify gas tariff today in GasSystemRecord.txt.
	 * @param price The array include electricity and gas tariff.
	 */
	public void updateDayGasTariff(float[] price);
	
	/**
	 * This method is used to modify gas and electricity tariff in Tariff.txt.
	 * @param price The array include electricity and gas tariff.
	 */
	public void modifyTariff(String[] price);
	
	
	
	/**
	 * This method is used to get gas and electricity tariff in Tariff.txt.
	 * @return The return value is an array include electricity and gas tariff.
	 */
	public float[] checkTariff();

}
