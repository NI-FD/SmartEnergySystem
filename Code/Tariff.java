
/**
 * Title      : Tariff.java
 * Description: This class contains the information of a Tariff.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class Tariff {

	private float electricity_price;		//the electricity price
	private float gas_price;		//the gas price
	
	
	/**
	 * This method is used to get electricity_price.
	 * @return The return value is electricity_price.
	 */
	public float getElectricity_price() {
		return electricity_price;
	}
	
	/**
	 * This method is used to set electricity_price.
	 * @param electricity_price The electricity price
	 */
	public void setElectricity_price(float electricity_price) {
		this.electricity_price = electricity_price;
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
	 * @param gas_price The gas price
	 */
	public void setGas_price(float gas_price) {
		this.gas_price = gas_price;
	}
	
}
