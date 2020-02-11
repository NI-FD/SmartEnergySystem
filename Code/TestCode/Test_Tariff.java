
public class Test_Tariff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TariffImpl ti = new TariffImpl();
		
		String[] in = new String[2];
		in[0] = "1";
		in[1] = "1";
		ti.modifyTariff(in);
		
		float[] check = ti.checkTariff();
		System.out.println("Electricity: " + check[0]);
		System.out.println("Gas: " + check[1]);
	}

}
