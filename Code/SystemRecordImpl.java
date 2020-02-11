
import java.util.ArrayList;

/**
 * Title      : SystemRecordImpl.java
 * Description: This class is implement of SystemRecordInter.java.
 * @author wenyuan zhang
 * @version 1.0
 */

public class SystemRecordImpl implements SystemRecordInter {

	ReadFile rf= new ReadFile();
	WriteFile wf = new WriteFile();

	ManageTime gettime = new ManageTime();
	

	@Override
	public void updateGTotalTime(int id, int year, int month, int day, int time) {
		// TODO Auto-generated method stub
		int i, j;
		int flag = 1;
		String filePath = "source/GasSystemRecord.txt";
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> Nlist = new ArrayList();
		String store_time = "";
		Olist = rf.readLine(filePath);
		
//		System.out.println(Olist.size());
		if(Olist.size() == 0){
			System.out.println("Error");
		}
		else{
			String[] check = new String[13];
			for(i = 0 ; i<Olist.size() ; i++){
				check = Olist.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					check[12] = Integer.toString(time);
				}
				store_time = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7]
						+ "*" + check[8] + "*" + check[9] + "*" + check[10] + "*" + check[11] + "*" + check[12];
				Nlist.add(store_time);
			}
			wf.writeLineCover(Nlist, filePath);
		}
	}

	@Override
	public void updateGFirstTime(int id, int year, int month, int day, int hour, int minute, int second) {
		// TODO Auto-generated method stub
		int i, j;
		int flag = 1;
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
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					check[9] = Integer.toString(hour);
					check[10] = Integer.toString(minute);
				    check[11] = Integer.toString(second);	
				}
				store_eleuse = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7]
						+ "*" + check[8] + "*" + check[9] + "*" + check[10] + "*" + check[11] + "*" + check[12];
				Nlist.add(store_eleuse);
			}
			wf.writeLineCover(Nlist, filePath);
		}	
	}
	
	@Override
	public boolean checkSameRecord(int id, int year, int month, int day) {
		// TODO Auto-generated method stub
		if(this.getRecordByIdDate(id , year, month, day) == null){				
			return true;	
		}
		else{
			return false;	
		}
	}
	
	@Override
	public boolean checkElectricitySameRecord(int id, int year, int month, int day) {
		// TODO Auto-generated method stub
		if(this.getElectricityRecordByIdDate(id , year , month , day) == null){				
			return true;	
		}
		else{
			return false;	
		}
	}

	@Override
	public boolean checkGasSameRecord(int id, int year, int month, int day) {
		// TODO Auto-generated method stub
		if(this.getGasRecordByIdDate(id , year , month , day) == null){				
			return true;	
		}
		else{
			return false;	
		}
	}
	
	@Override
	public void updateEFirstTime(int id, int year, int month, int day, int hour, int minute, int second) {
		// TODO Auto-generated method stub
		int i, j;
		int flag = 1;
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
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					check[9] = Integer.toString(hour);
					check[10] = Integer.toString(minute);
				    check[11] = Integer.toString(second);	
				}
				store_eleuse = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7]
						+ "*" + check[8] + "*" + check[9] + "*" + check[10] + "*" + check[11] + "*" + check[12];
				Nlist.add(store_eleuse);
			}
			wf.writeLineCover(Nlist, filePath);
		}	
	}
	
	@Override
	public void updateETotalTime(int id, int year, int month, int day, int time) {
		// TODO Auto-generated method stub
		int i, j;
		int flag = 1;
		String filePath = "source/ElectricitySystemRecord.txt";
		SystemRecord systemrecord = new SystemRecord();
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> Nlist = new ArrayList();
		String store_time = "";
		Olist = rf.readLine(filePath);
		
//		System.out.println(Olist.size());
		if(Olist.size() == 0){
			System.out.println("Error");
		}
		else{
			String[] check = new String[13];
			for(i = 0 ; i<Olist.size() ; i++){
				check = Olist.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					check[12] = Integer.toString(time);
				}
				store_time = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7]
						+ "*" + check[8] + "*" + check[9] + "*" + check[10] + "*" + check[11] + "*" + check[12];
				Nlist.add(store_time);
			}
			wf.writeLineCover(Nlist, filePath);
		}
	}
	
	@Override
	public void updateSystemRecordTariff(int id, int year, int month) {
		// TODO Auto-generated method stub
		int i, j;
		int flag = 1;
		String filePath = "source/SystemRecord.txt";
		SystemRecord systemrecord = new SystemRecord();
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> Nlist = new ArrayList();
		String store_time = "";
		Olist = rf.readLine(filePath);
		
//		System.out.println(Olist.size());
		if(Olist.size() == 0){
			System.out.println("Error");
		}
		else{
			String[] check = new String[10];
			for(i = 0 ; i<Olist.size() ; i++){
				check = Olist.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month){
					check[5] = Float.toString(Float.parseFloat(check[5])/(-1));
				}
				store_time = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7]
						+ "*" + check[8] + "*" + check[9];
				Nlist.add(store_time);
			}
			wf.writeLineCover(Nlist, filePath);
		}
		
	}
	
//	@Override
//	public void deleteRecordById(int id) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public boolean addBillRecord(SystemRecord bill) {
		// TODO Auto-generated method stub
		if(bill == null){
			return false;
		}
		else{
			String filePath = "source/Bill.txt";
			SystemRecord systemrecord;				
			ArrayList<String> Olist = new ArrayList();
			ArrayList<String> list = new ArrayList();
			String store_info = "";
			list.clear();
			systemrecord = bill;
			
			int id = systemrecord.getId();
			int year = systemrecord.getYear();
			int month = systemrecord.getMonth();
			int day = systemrecord.getDay();
			float ele_usage = systemrecord.getElectricity_usage();
			float ele_price = systemrecord.getElectricity_oldprice();
			float gas_usage = systemrecord.getGas_usage();
			float gas_price = systemrecord.getGas_oldprice();
			int ele_time = systemrecord.getEtotaltime();
			int gas_time = systemrecord.getGtotaltime();
			
			store_info = Integer.toString(id) + "*" + Integer.toString(year) + "*" + Integer.toString(month) + "*" + Integer.toString(day) 
			+ "*"  + Float.toString(ele_usage) + "*" + Float.toString(ele_price) + "*" + Float.toString(gas_usage)
			+ "*" + Float.toString(gas_price) + "*" + Integer.toString(ele_time) + "*" + Integer.toString(gas_time); 
			list.add(store_info);
			
			wf.writeLineAppend(list, filePath);
			return true;
		}	
	}
	
	@Override
	public boolean addNewRecord(SystemRecord[][] systemrecord2) {
		// TODO Auto-generated method stub
		if(systemrecord2 == null){
			return false;
		}
		else{
			int i, j;
			String filePath = "source/SystemRecord.txt";
			SystemRecord systemrecord;				
			ArrayList<String> Olist = new ArrayList();
			ArrayList<String> list = new ArrayList();
			String store_info = "";
			Olist = rf.readLine(filePath);
			list.clear();
			
			for(i = 0 ; i < systemrecord2.length ; i++){
				for(j = 0 ; j < 5 ; j++){
					System.out.println("i :" + i);
					System.out.println("j :" + j);
					systemrecord = systemrecord2[i][j];
					if(systemrecord == null){
						System.out.println("i :" + i);
						System.out.println("j :" + j);
						break;
					}
					int id = systemrecord.getId();
					int year = systemrecord.getYear();
					int month = systemrecord.getMonth();
					int day = systemrecord.getDay();
					float ele_usage = systemrecord.getElectricity_usage();
					float ele_price = systemrecord.getElectricity_oldprice();
					float gas_usage = systemrecord.getGas_usage();
					float gas_price = systemrecord.getGas_oldprice();
					int ele_time = systemrecord.getEtotaltime();
					int gas_time = systemrecord.getGtotaltime();
					
					if(!checkSameRecord(id , year , month , day)){
						updateSystemRecord(id, year, month, day, ele_usage, ele_price, gas_usage, gas_price, ele_time, gas_time);
						System.out.println("b");
					}
					else{
						System.out.println("a");
						store_info = Integer.toString(id) + "*" + Integer.toString(year) + "*" + Integer.toString(month) + "*" + Integer.toString(day) 
						+ "*"  + Float.toString(ele_usage) + "*" + Float.toString(ele_price) + "*" + Float.toString(gas_usage)
						+ "*" + Float.toString(gas_price) + "*" + Integer.toString(ele_time) + "*" + Integer.toString(gas_time); 
						list.add(store_info);
						System.out.println(store_info);
					}
				}
			}
			
			if(Olist.size() == 0){
				wf.writeLineCover(list, filePath);
			}
			else{
				wf.writeLineAppend(list, filePath);
			}
			return true;
		}		
	}
	
	@Override
	public boolean addNewElectricityRecord(ElectricitySystemRecord electricitysystemrecord) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/ElectricitySystemRecord.txt";
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> list = new ArrayList();
		String store_info = "";
		Olist = rf.readLine(filePath);
		
		if(Olist.size() == 0){
			list.clear();
			
			store_info = Integer.toString(electricitysystemrecord.getId()) + "*" + Integer.toString(electricitysystemrecord.getYear()) + "*" + Integer.toString(electricitysystemrecord.getMonth()) + "*" + Integer.toString(electricitysystemrecord.getDay()) + "*" + Integer.toString(electricitysystemrecord.getHour())
			+ "*" + Integer.toString(electricitysystemrecord.getMinute()) + "*" + Integer.toString(electricitysystemrecord.getSecond()) + "*" + Float.toString(electricitysystemrecord.getElectricity_usage()) + "*" + Float.toString(electricitysystemrecord.getElectricity_price()) + "*" + Integer.toString(electricitysystemrecord.getEfirsthour()) + "*" + Integer.toString(electricitysystemrecord.getEfirstminute())
			+ "*" + Integer.toString(electricitysystemrecord.getEfirstsecond()) + "*" + Integer.toString(electricitysystemrecord.getEtotaltime()); 
			
			list.add(store_info);
			
			wf.writeLineCover(list, filePath);
			return true;
			
		}else{
			if(this.getElectricityRecordByIdDate(electricitysystemrecord.getId() , electricitysystemrecord.getYear() , electricitysystemrecord.getMonth() , electricitysystemrecord.getDay()) == null){
				
				store_info = Integer.toString(electricitysystemrecord.getId()) + "*" + Integer.toString(electricitysystemrecord.getYear()) + "*" + Integer.toString(electricitysystemrecord.getMonth()) + "*" + Integer.toString(electricitysystemrecord.getDay()) + "*" + Integer.toString(electricitysystemrecord.getHour())
				+ "*" + Integer.toString(electricitysystemrecord.getMinute()) + "*" + Integer.toString(electricitysystemrecord.getSecond()) + "*" + Float.toString(electricitysystemrecord.getElectricity_usage()) + "*" + Float.toString(electricitysystemrecord.getElectricity_price()) + "*" + Integer.toString(electricitysystemrecord.getEfirsthour()) + "*" + Integer.toString(electricitysystemrecord.getEfirstminute())
				+ "*" + Integer.toString(electricitysystemrecord.getEfirstsecond()) + "*" + Integer.toString(electricitysystemrecord.getEtotaltime()); 
				
				list.add(store_info);
				
				wf.writeLineAppend(list , filePath);	
				
				return true;
				
			}else{
				System.out.println("The record existed!");
				return false;
				
			}
			
		}
	}

	@Override
	public boolean addNewGasRecord(GasSystemRecord gassystemrecord) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/GasSystemRecord.txt";
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> list = new ArrayList();
		String store_info = "";
		Olist = rf.readLine(filePath);
		
		if(Olist.size() == 0){
			list.clear();
			
			store_info = Integer.toString(gassystemrecord.getId()) + "*" + Integer.toString(gassystemrecord.getYear()) + "*" + Integer.toString(gassystemrecord.getMonth()) + "*" + Integer.toString(gassystemrecord.getDay()) + "*" + Integer.toString(gassystemrecord.getHour())
			+ "*" + Integer.toString(gassystemrecord.getMinute()) + "*" + Integer.toString(gassystemrecord.getSecond()) + "*" + Float.toString(gassystemrecord.getGas_usage()) + "*" + Float.toString(gassystemrecord.getGas_price()) + "*" + Integer.toString(gassystemrecord.getGfirsthour()) + "*" + Integer.toString(gassystemrecord.getGfirstminute())
			+ "*" + Integer.toString(gassystemrecord.getGfirstsecond()) + "*" + Integer.toString(gassystemrecord.getGtotaltime()); 
			
			list.add(store_info);
			
			wf.writeLineCover(list, filePath);
			return true;
			
		}else{
			if(this.getGasRecordByIdDate(gassystemrecord.getId() , gassystemrecord.getYear() , gassystemrecord.getMonth() , gassystemrecord.getDay()) == null){
				
				store_info = Integer.toString(gassystemrecord.getId()) + "*" + Integer.toString(gassystemrecord.getYear()) + "*" + Integer.toString(gassystemrecord.getMonth()) + "*" + Integer.toString(gassystemrecord.getDay()) + "*" + Integer.toString(gassystemrecord.getHour())
				+ "*" + Integer.toString(gassystemrecord.getMinute()) + "*" + Integer.toString(gassystemrecord.getSecond()) + "*" + Float.toString(gassystemrecord.getGas_usage()) + "*" + Float.toString(gassystemrecord.getGas_price()) + "*" + Integer.toString(gassystemrecord.getGfirsthour()) + "*" + Integer.toString(gassystemrecord.getGfirstminute())
				+ "*" + Integer.toString(gassystemrecord.getGfirstsecond()) + "*" + Integer.toString(gassystemrecord.getGtotaltime()); 
				
				list.add(store_info);
				
				wf.writeLineAppend(list , filePath);	
				
				return true;
				
			}else{
				System.out.println("The record existed!");
				return false;
				
			}
			
		}
	}
	
	@Override
	public void updateSystemRecord(int id, int year, int month, int day, float ele_usage, float ele_price,
			float gas_usage, float gas_price, int ele_time, int gas_time) {
		// TODO Auto-generated method stub
		int i, j;
		int flag = 1;
		String filePath = "source/SystemRecord.txt";
		SystemRecord systemrecord = new SystemRecord();
		ArrayList<String> Olist = new ArrayList();
		ArrayList<String> Nlist = new ArrayList();
		String store = "";
		Olist = rf.readLine(filePath);
		
//		System.out.println(Olist.size());
		if(Olist.size() == 0){
			System.out.println("Error");
		}
		else{
			String[] check = new String[10];
			for(i = 0 ; i<Olist.size() ; i++){
				check = Olist.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					
					check[4] = Float.toString(ele_usage);
					check[5] = Float.toString(ele_price);
					check[6] = Float.toString(gas_usage);
					check[7] = Float.toString(gas_price);
					check[8] = Integer.toString(ele_time);
					check[9] = Integer.toString(gas_time);
					
				}
				store = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7] + "*" + check[8] + "*" + check[9];
				Nlist.add(store);
			}
			wf.writeLineCover(Nlist, filePath);
		}
	}

	@Override
	public void updateElectricityRecord(int id, int year, int month, int day, float usage) {
		// TODO Auto-generated method stub
		int i, j;
		int flag = 1;
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
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					check[7] = Float.toString(usage);
				}
				store_eleuse = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7] + "*" + check[8] + "*" + check[9] 
						+ "*" + check[10] + "*" + check[11] + "*" + check[12];
				Nlist.add(store_eleuse);
			}
			wf.writeLineCover(Nlist, filePath);
		}	
	}

	@Override
	public void updateGasRecord(int id, int year, int month, int day, float usage) {
		// TODO Auto-generated method stub
		int i, j;
		int flag = 1;
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
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					check[7] = Float.toString(usage);
				}
				store_eleuse = check[0] + "*" + check[1] + "*" + check[2] + "*" + check[3] + "*" + check[4] + "*" + check[5] + "*" + check[6] + "*" + check[7] + "*" + check[8] + "*" + check[9] 
						+ "*" + check[10] + "*" + check[11] + "*" + check[12];
				Nlist.add(store_eleuse);
			}
			wf.writeLineCover(Nlist, filePath);
		}	
	}

	@Override
	public ArrayList<SystemRecord> getBillById(int id) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/Bill.txt";
		SystemRecord systemrecord;
		ArrayList<SystemRecord> slist= new ArrayList();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[10];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id ){
					systemrecord = new SystemRecord();
					systemrecord.setId(Integer.parseInt(check[0]));
					systemrecord.setYear(Integer.parseInt(check[1]));
					systemrecord.setMonth(Integer.parseInt(check[2]));
					systemrecord.setDay(Integer.parseInt(check[3]));
					systemrecord.setElectricity_usage(Float.parseFloat(check[4]));
					systemrecord.setElectricity_oldprice(Float.parseFloat(check[5]));
					systemrecord.setGas_usage(Float.parseFloat(check[6]));
					systemrecord.setGas_oldprice(Float.parseFloat(check[7]));
					systemrecord.setEtotaltime(Integer.parseInt(check[8]));
					systemrecord.setGtotaltime(Integer.parseInt(check[9]));
					slist.add(systemrecord);
				}
			}
			
			if(slist.size() == 0){
				return null;
			}
			else{
				return slist;
			}
		}
	}
	
	@Override
	public ArrayList<SystemRecord> getRecordById(int id) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/SystemRecord.txt";
		SystemRecord systemrecord;
		ArrayList<SystemRecord> slist= new ArrayList();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[10];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id ){
					systemrecord = new SystemRecord();
					systemrecord.setId(Integer.parseInt(check[0]));
					systemrecord.setYear(Integer.parseInt(check[1]));
					systemrecord.setMonth(Integer.parseInt(check[2]));
					systemrecord.setDay(Integer.parseInt(check[3]));
					systemrecord.setElectricity_usage(Float.parseFloat(check[4]));
					systemrecord.setElectricity_oldprice(Float.parseFloat(check[5]));
					systemrecord.setGas_usage(Float.parseFloat(check[6]));
					systemrecord.setGas_oldprice(Float.parseFloat(check[7]));
					systemrecord.setEtotaltime(Integer.parseInt(check[8]));
					systemrecord.setGtotaltime(Integer.parseInt(check[9]));
					slist.add(systemrecord);
				}
			}
			
			if(slist.size() == 0){
				return null;
			}
			else{
				return slist;
			}
		}
	}
	
	@Override
	public SystemRecord getRecordByIdDate(int id, int year, int month, int day) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/SystemRecord.txt";
		SystemRecord systemrecord = new SystemRecord();;
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[10];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					systemrecord.setId(Integer.parseInt(check[0]));
					systemrecord.setYear(Integer.parseInt(check[1]));
					systemrecord.setMonth(Integer.parseInt(check[2]));
					systemrecord.setDay(Integer.parseInt(check[3]));
					systemrecord.setElectricity_usage(Float.parseFloat(check[4]));
					systemrecord.setElectricity_oldprice(Float.parseFloat(check[5]));
					systemrecord.setGas_usage(Float.parseFloat(check[6]));
					systemrecord.setGas_oldprice(Float.parseFloat(check[7]));
					systemrecord.setEtotaltime(Integer.parseInt(check[8]));
					systemrecord.setGtotaltime(Integer.parseInt(check[9]));
					return systemrecord;
				}
			}
			return null;
		}
	}
	
	@Override
	public ElectricitySystemRecord getElectricityRecordByIdDate(int id, int year, int month, int day) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/ElectricitySystemRecord.txt";
		ElectricitySystemRecord electricitysystemrecord = new ElectricitySystemRecord();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[13];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					electricitysystemrecord.setId(Integer.parseInt(check[0]));
					electricitysystemrecord.setYear(Integer.parseInt(check[1]));
					electricitysystemrecord.setMonth(Integer.parseInt(check[2]));
					electricitysystemrecord.setDay(Integer.parseInt(check[3]));
					electricitysystemrecord.setHour(Integer.parseInt(check[4]));
					electricitysystemrecord.setMinute(Integer.parseInt(check[5]));
					electricitysystemrecord.setSecond(Integer.parseInt(check[6]));
					electricitysystemrecord.setElectricity_usage(Float.parseFloat(check[7]));
					electricitysystemrecord.setElectricity_price(Float.parseFloat(check[8]));
					electricitysystemrecord.setEfirsthour(Integer.parseInt(check[9]));
					electricitysystemrecord.setEfirstminute(Integer.parseInt(check[10]));
					electricitysystemrecord.setEfirstsecond(Integer.parseInt(check[11]));
					electricitysystemrecord.setEtotaltime(Integer.parseInt(check[12]));
					return electricitysystemrecord;
				}
			}
			return null;
			
		}
	}

	@Override
	public GasSystemRecord getGasRecordByIdDate(int id, int year, int month, int day) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/GasSystemRecord.txt";
		GasSystemRecord gassystemrecord = new GasSystemRecord();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[13];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				if(Integer.parseInt(check[0]) == id && Integer.parseInt(check[1]) == year && Integer.parseInt(check[2]) == month && Integer.parseInt(check[3]) == day){
					gassystemrecord.setId(Integer.parseInt(check[0]));
					gassystemrecord.setYear(Integer.parseInt(check[1]));
					gassystemrecord.setMonth(Integer.parseInt(check[2]));
					gassystemrecord.setDay(Integer.parseInt(check[3]));
					gassystemrecord.setHour(Integer.parseInt(check[4]));
					gassystemrecord.setMinute(Integer.parseInt(check[5]));
					gassystemrecord.setSecond(Integer.parseInt(check[6]));
					gassystemrecord.setGas_usage(Float.parseFloat(check[7]));
					gassystemrecord.setGas_price(Float.parseFloat(check[8]));
					gassystemrecord.setGfirsthour(Integer.parseInt(check[9]));
					gassystemrecord.setGfirstminute(Integer.parseInt(check[10]));
					gassystemrecord.setGfirstsecond(Integer.parseInt(check[11]));
					gassystemrecord.setGtotaltime(Integer.parseInt(check[12]));
					return gassystemrecord;
				}
			}
			return null;
			
		}
	}

	@Override
	public ArrayList<ElectricitySystemRecord> getElectricityRecordById(int id) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/ElectricitySystemRecord.txt";
		ArrayList<ElectricitySystemRecord> elelist = new ArrayList();
		ArrayList<String> list = new ArrayList();
		ElectricitySystemRecord electricitysystemrecord;
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[13];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				
				electricitysystemrecord = new ElectricitySystemRecord();
				
				if(Integer.parseInt(check[0]) == id){
					
					electricitysystemrecord.setId(Integer.parseInt(check[0]));
					electricitysystemrecord.setYear(Integer.parseInt(check[1]));
					electricitysystemrecord.setMonth(Integer.parseInt(check[2]));
					electricitysystemrecord.setDay(Integer.parseInt(check[3]));
					electricitysystemrecord.setHour(Integer.parseInt(check[4]));
					electricitysystemrecord.setMinute(Integer.parseInt(check[5]));
					electricitysystemrecord.setSecond(Integer.parseInt(check[6]));
					electricitysystemrecord.setElectricity_usage(Float.parseFloat(check[7]));
					electricitysystemrecord.setElectricity_price(Float.parseFloat(check[8]));
					electricitysystemrecord.setEfirsthour(Integer.parseInt(check[9]));
					electricitysystemrecord.setEfirstminute(Integer.parseInt(check[10]));
					electricitysystemrecord.setEfirstsecond(Integer.parseInt(check[11]));
					electricitysystemrecord.setEtotaltime(Integer.parseInt(check[12]));
					elelist.add(electricitysystemrecord);
				}
				
			}
			return elelist;
		}
	}

	@Override
	public ArrayList<GasSystemRecord> getGasRecordById(int id) {
		// TODO Auto-generated method stub
		int i, j;
		String filePath = "source/GasSystemRecord.txt";
		GasSystemRecord gassystemrecord;
		ArrayList<GasSystemRecord> gaslist = new ArrayList();
		ArrayList<String> list = new ArrayList();
		list = rf.readLine(filePath);
//		System.out.println(list.size());
		if(list.size() == 0){
			return null;
		}
		else{
			String[] check = new String[13];
			for(i = 0 ; i<list.size() ; i++){
				check = list.get(i).split("\\*");
				gassystemrecord = new GasSystemRecord();
				if(Integer.parseInt(check[0]) == id){
					gassystemrecord.setId(Integer.parseInt(check[0]));
					gassystemrecord.setYear(Integer.parseInt(check[1]));
					gassystemrecord.setMonth(Integer.parseInt(check[2]));
					gassystemrecord.setDay(Integer.parseInt(check[3]));
					gassystemrecord.setHour(Integer.parseInt(check[4]));
					gassystemrecord.setMinute(Integer.parseInt(check[5]));
					gassystemrecord.setSecond(Integer.parseInt(check[6]));
					gassystemrecord.setGas_usage(Float.parseFloat(check[7]));
					gassystemrecord.setGas_price(Float.parseFloat(check[8]));
					gassystemrecord.setGfirsthour(Integer.parseInt(check[9]));
					gassystemrecord.setGfirstminute(Integer.parseInt(check[10]));
					gassystemrecord.setGfirstsecond(Integer.parseInt(check[11]));
					gassystemrecord.setGtotaltime(Integer.parseInt(check[12]));
					
					gaslist.add(gassystemrecord);
				}
			}
			return gaslist;
			
		}
	}

}
