
import java.awt.Color;

/**
 * Title      : StartElectricity.java
 * Description: This class is used to generate the electricity meter read.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class StartElectricity implements Runnable{

	UserImpl userimpl = new UserImpl();
	User user = new User();
	SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
	SystemRecord systemrecord = new SystemRecord();
	ElectricitySystemRecord electricitysystemrecord = new ElectricitySystemRecord();
	ManageTime managetime = new ManageTime();
	TariffImpl tariffimpl = new TariffImpl();
	
	float current_elec;
	float current_gas;
	
	int time;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(UserMainBorad.eletricity_judge == 1){
				if(systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()) != null){
					current_elec = (float) (systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getElectricity_usage() + Math.random());
				}
				else{
					current_elec = 0;
				}

				
				int hour = managetime.getHour();
				int minute = managetime.getMinute();
				int second = managetime.getSecond();
				
				electricitysystemrecord.setId(userimpl.getNowUserInfo().getId());
				electricitysystemrecord.setYear(managetime.getYear());
				electricitysystemrecord.setMonth(managetime.getMonth());
				electricitysystemrecord.setDay(managetime.getDay());
				electricitysystemrecord.setHour(managetime.getHour());
				electricitysystemrecord.setMinute(managetime.getMinute());
				electricitysystemrecord.setSecond(managetime.getSecond());
				electricitysystemrecord.setElectricity_usage(current_elec);
				electricitysystemrecord.setElectricity_price(tariffimpl.checkTariff()[0]);
				electricitysystemrecord.setEfirsthour(hour);
				electricitysystemrecord.setEfirstminute(minute);
				electricitysystemrecord.setEfirstsecond(second);
				electricitysystemrecord.setEtotaltime(0);
				
				if(systemrecordimpl.checkElectricitySameRecord(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay())){
					systemrecordimpl.addNewElectricityRecord(electricitysystemrecord);
				}
				else{
					
					electricitysystemrecord = systemrecordimpl.getElectricityRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay());
					
					if(hour != 0 && electricitysystemrecord.getEfirsthour() != 0){
						time = (int)((hour*60 + minute) - (electricitysystemrecord.getEfirsthour()*60 + electricitysystemrecord.getEfirstminute()));
					}
					else if(hour == 0 && electricitysystemrecord.getEfirsthour() == 0){
						time = (int)((24*60 + minute) - (24*60 + electricitysystemrecord.getEfirstminute()));
					}
					else if(hour != 0 && electricitysystemrecord.getEfirsthour() == 0){
						time = (int)((hour*60 + minute) - (0*60 + electricitysystemrecord.getEfirstminute()));
					}
					
					systemrecordimpl.updateElectricityRecord(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay(), current_elec);
//					systemrecordimpl.updateGasRecord(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay(), current_gas);
					
					systemrecordimpl.updateETotalTime(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay(), time);
					
					UserMainBorad.elestatus = "Alive";
					UserMainBorad.eletime = Integer.toString(time);
					UserMainBorad.eleuse = UserMainBorad.df.format(current_elec);
					UserMainBorad.elecost = UserMainBorad.df.format(tariffimpl.checkTariff()[0] * current_elec);
					UserMainBorad.textArea.setText("Status:	" + UserMainBorad.elestatus + "\n" + "Time:	" + UserMainBorad.eletime + " min\n" + "Daily Usage:	"  + UserMainBorad.eleuse + " kWh\n" + "Daily Cost:	" + UserMainBorad.elecost + " £\n" + "Budget:	" + Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget()) + " £\n" + "Tariff:	" + tariffimpl.checkTariff()[0] + " £");
					
					//electricity signal
					if(Float.parseFloat(UserMainBorad.elecost) <= (userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget())){
						UserMainBorad.lblElectricity.setForeground(Color.green);
					}
					else{
						UserMainBorad.lblElectricity.setForeground(Color.red);
					}
					
					//gas signal
					if(Float.parseFloat(UserMainBorad.gascost) <= (userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget())){
						UserMainBorad.lblGad.setForeground(Color.green);
					}
					else{
						UserMainBorad.lblGad.setForeground(Color.red);
					}
					
					//total signal
					if((userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget() + userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()) >= (Float.parseFloat(UserMainBorad.elecost) + Float.parseFloat(UserMainBorad.gascost))){
						UserMainBorad.lblBudget.setForeground(Color.green);
					}
					else{
						UserMainBorad.lblBudget.setForeground(Color.red);
					}
					
					System.out.println("ele_true");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

			}
			else if(UserMainBorad.eletricity_judge == 0){
				
				UserMainBorad.elestatus = "Not Alive";
				UserMainBorad.textArea.setText("Status:	" + UserMainBorad.elestatus + "\n" + "Time:	" + UserMainBorad.eletime + " min\n" + "Daily Usage:	"  + UserMainBorad.eleuse + " kWh\n" + "Daily Cost:	" + UserMainBorad.elecost + " £\n" + "Budget:	" + Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget()) + " £\n" + "Tariff:	" + tariffimpl.checkTariff()[0] + " £");
				
				System.out.println("ele_false");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(UserMainBorad.eletricity_judge == -1){
				
				UserMainBorad.elestatus = "Not Alive";
				UserMainBorad.textArea.setText("Status:	" + UserMainBorad.elestatus + "\n" + "Time:	" + UserMainBorad.eletime + " min\n" + "Daily Usage:	"  + UserMainBorad.eleuse + " kWh\n" + "Daily Cost:	" + UserMainBorad.elecost + " £\n" + "Budget:	" + Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getElectricity_budget()) + " £\n" + "Tariff:	" + tariffimpl.checkTariff()[0] + " £");
				
				break;
			}
			
		}

		
	}

}
