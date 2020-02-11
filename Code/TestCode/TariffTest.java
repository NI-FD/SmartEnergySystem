
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class TariffTest extends TestCase {

	@Test
	public void testCreate() {
		Tariff tariff = new Tariff();
		
		tariff.setGas_price(99);
		tariff.setElectricity_price(98);
		
		float gas_price = tariff.getGas_price();
		float electricity = tariff.getElectricity_price();
		
	    assertEquals(99, (int)gas_price);
	    assertEquals(98, (int)electricity);
	}

}
