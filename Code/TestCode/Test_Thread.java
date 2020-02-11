

public class Test_Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserImpl userimpl = new UserImpl();
		User user = new User();
		SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
		SystemRecord systemrecord = new SystemRecord();
		ManageTime managetime = new ManageTime();
		TariffImpl tariffimpl = new TariffImpl();
		
		int hour = managetime.getHour();
		int minute = managetime.getMinute();
		int second = managetime.getSecond();
		
		StartElectricity star = new StartElectricity();
		StartGas gas = new StartGas();
		Thread t1 = new Thread(star);
		Thread t2 = new Thread(gas);
		
//		systemrecordimpl.updateFirstTime(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay(), hour, minute, second);
		
		t1.start();

		t2.start();

		
		
	}

}
