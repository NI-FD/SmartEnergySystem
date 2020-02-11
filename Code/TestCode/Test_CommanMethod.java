
public class Test_CommanMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ManageTime gettime = new ManageTime();
		
		System.out.println("Year: " + gettime.getYear());
		System.out.println("Month: " + gettime.getMonth());
		System.out.println("Day: " + gettime.getDay());
		System.out.println("Hour: " + gettime.getHour());
		System.out.println("Minute: " + gettime.getMinute());
		System.out.println("Second: " + gettime.getSecond());
		
		System.out.println(gettime.getDifferent(15, 1, 17));
		
		SystemRecord systemrecord = new SystemRecord();
		SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
		
		
		systemrecord.setId(1);
		systemrecord.setYear(gettime.getYear());
		systemrecord.setMonth(gettime.getMonth());
		systemrecord.setDay(gettime.getDay());
//		systemrecord.setHour(gettime.getHour());
//		systemrecord.setMinute(gettime.getMinute());
//		systemrecord.setSecond(gettime.getSecond());
		systemrecord.setElectricity_usage(13);
		systemrecord.setElectricity_oldprice((float) 0.5);
		systemrecord.setGas_usage(12);
		systemrecord.setGas_oldprice((float) 0.1);
//		systemrecord.setFirsthour(14);
//		systemrecord.setFirstminute(7);
//		systemrecord.setFirstsecond(1);
		
//		systemrecordimpl.addNewRecord(systemrecord);
		systemrecordimpl.updateElectricityRecord(1, 2018, 4, 29, 100);
		systemrecordimpl.updateGasRecord(1, 2018, 4, 29, 99);
	}

}
