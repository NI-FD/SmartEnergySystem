
/**
 * Title      : User.java
 * Description: This class contains the information of a User.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class User {
	

	private String name;		//the user name
	private String password;		//the user password
	private int id;		//the user id
	private String address;		//the user address
	private String email;		// the user email
	private int phone;		//the user phone
	private float electricity_budget = 0;		//the user electricity budget
	private float gas_budget = 0;		//the user gas budget
	
	/**
	 * This method is used to get email.
	 * @return The return value is email.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * This method is used to set email.
	 * @param email The user email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This method is used to get name.
	 * @return The return value is name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method is used to set name.
	 * @param name The user name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method is used to get password.
	 * @return The return value is password.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * This method is used to set password.
	 * @param password The user password.
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @param id The user id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method is used to get electricity_budget.
	 * @return The return value is electricity_budget.
	 */
	public float getElectricity_budget() {
		return electricity_budget;
	}
	
	/**
	 * This method is used to set electricity_budget.
	 * @param electricity_budget The user electricity budget.
	 */
	public void setElectricity_budget(float electricity_budget) {
		this.electricity_budget = electricity_budget;
	}
	
	/**
	 * This method is used to get gas_budget.
	 * @return The return value is gas_budget.
	 */
	public float getGas_budget() {
		return gas_budget;
	}
	
	/**
	 * This method is used to set gas_budget.
	 * @param gas_budget The user gas_budget.
	 */
	public void setGas_budget(float gas_budget) {
		this.gas_budget = gas_budget;
	}
	
	/**
	 * This method is used to get address.
	 * @return The return value is address.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * This method is used to set address.
	 * @param address The user address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * This method is used to get phone.
	 * @return The return value is phone.
	 */
	public int getPhone() {
		return phone;
	}
	
	/**
	 * This method is used to set phone.
	 * @param phone The user phone.
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}
