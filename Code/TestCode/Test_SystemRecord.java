
public class Test_SystemRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SystemRecord systemrecord = new SystemRecord();
		SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
		ManageTime gettime = new ManageTime();
		
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
		
	}

}
