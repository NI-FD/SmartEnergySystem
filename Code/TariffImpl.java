
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Title      : TariffImpl.java
 * Description: This class is implement of TariffInter.java.
 * @author wenyuan zhang
 * @version 1.0
 */

public class TariffImpl implements TariffInter {

	ReadFile rf = new ReadFile();
	WriteFile wf = new WriteFile();
	ManageTime managetime = new ManageTime();
	
	int i;
	
	@Override
	public void modifyTariff(String[] price) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList();
		String store_price = "";
		for(i = 0 ; i<price.length; i++){
			if(i == 0){
				store_price =price[i];
			}else{
				store_price =store_price + "*" + price[i];
			}
		}
		list.add(store_price);
		wf.writeLineCover(list , "source/Tariff.txt");
		
		updateDayElectricityTariff(checkTariff());
		updateDayGasTariff(checkTariff());
	
		
	}

	@Override
	public float[] checkTariff() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList();
		list = rf.readLine("source/Tariff.txt");
		float[] tariff = new float[2];
		String[] slist = list.get(0).split("\\*");
		
		for(i = 0 ; i<slist.length; i++){
			tariff[i] = Float.parseFloat(slist[i]);
		}
		
		return tariff;
	}
	
	@Override
	public void updateDayElectricityTariff(float[] price) {
		// TODO Auto-generated method stub
		int year = managetime.getYear();
		int month = managetime.getMonth();
		int day = managetime.getDay();
		
		String filePath = "source/ElectricitySystemRecord.txt";
		SystemRecord systemrecord = new SystemRecord();
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> Nlist = new ArrayList();
		String store_eleuse = "";
		Olist = rf.readLine(filePath);
		
//		System.out.println(Olist.size());
		if(Olist.size() == 0){
			System.out.println("Error");
		}
		else{
			String[] check = new String[13];
			for(i = 0 ; i<Olist.size() ; i++){
				check = Olist.get(i).split("\\*");
				if(Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					check[8] = Float.toString(price[0]);
				}
				store_eleuse = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7] + "*" + check[8] + "*" + check[9] 
						+ "*" + check[10] + "*" + check[11] + "*" + check[12];
				Nlist.add(store_eleuse);
			}
			wf.writeLineCover(Nlist, filePath);
		}	
		
	}

	@Override
	public void updateDayGasTariff(float[] price) {
		// TODO Auto-generated method stub
		int year = managetime.getYear();
		int month = managetime.getMonth();
		int day = managetime.getDay();
		
		String filePath = "source/GasSystemRecord.txt";
		SystemRecord systemrecord = new SystemRecord();
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> Nlist = new ArrayList();
		String store_eleuse = "";
		Olist = rf.readLine(filePath);
		
//		System.out.println(Olist.size());
		if(Olist.size() == 0){
			System.out.println("Error");
		}
		else{
			String[] check = new String[13];
			for(i = 0 ; i<Olist.size() ; i++){
				check = Olist.get(i).split("\\*");
				if(Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					check[8] = Float.toString(price[1]);
				}
				store_eleuse = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7] + "*" + check[8] + "*" + check[9] 
						+ "*" + check[10] + "*" + check[11] + "*" + check[12];
				Nlist.add(store_eleuse);
			}
			wf.writeLineCover(Nlist, filePath);
		}	
		
	}

	
	
}
