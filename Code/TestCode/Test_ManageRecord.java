
public class Test_ManageRecord {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManageRecord mr = new ManageRecord();
		SystemRecordImpl sri = new SystemRecordImpl();
		
		//System.out.println(mr.eleList(sri.getElectricityRecordById(1))[0][0].getDay());
		
//		System.out.println("ele1: " + sri.getElectricityRecordById(1).get(0).getDay());
//		System.out.println("ele2: " + sri.getElectricityRecordById(1).get(1).getDay());
//		System.out.println("ele3: " + sri.getElectricityRecordById(1).get(2).getDay());
//		
//		System.out.println("ele0: " + mr.eleList(sri.getElectricityRecordById(1))[0][0].getDay());
//		System.out.println("ele0: " + mr.eleList(sri.getElectricityRecordById(1))[0][1].getDay());
//		System.out.println("ele0: " + mr.eleList(sri.getElectricityRecordById(1))[0][2].getDay());
//		
//		System.out.println(mr.gasList(sri.getGasRecordById(1))[0][0].getDay());
		sri.addNewRecord(mr.totallist(mr.eleList(sri.getElectricityRecordById(1)), mr.gasList(sri.getGasRecordById(1))));
		
//		System.out.println(mr.totallist(mr.eleList(sri.getElectricityRecordById(1)), mr.gasList(sri.getGasRecordById(1)))[0][0].getYear());
//		System.out.println(mr.totallist(mr.eleList(sri.getElectricityRecordById(1)), mr.gasList(sri.getGasRecordById(1)))[0][1].getDay());
//		System.out.println(mr.totallist(mr.eleList(sri.getElectricityRecordById(1)), mr.gasList(sri.getGasRecordById(1)))[0][2].getDay());

	}

}
