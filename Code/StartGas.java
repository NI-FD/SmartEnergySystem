
import java.awt.Color;

/**
 * Title      : StartGas.java
 * Description: This class is used to generate the Gas meter read.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class StartGas implements Runnable{


	UserImpl userimpl = new UserImpl();
	User user = new User();
	SystemRecordImpl systemrecordimpl = new SystemRecordImpl();
	GasSystemRecord gassystemrecord = new GasSystemRecord();
	SystemRecord systemrecord = new SystemRecord();
	ManageTime managetime = new ManageTime();
	TariffImpl tariffimpl = new TariffImpl();
	
	float current_elec;
	float current_gas;
	
	int time;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(UserMainBorad.gas_judge == 1){
				if(systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()) != null){
					current_gas = (float)(systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay()).getGas_usage() + Math.random());
				}
				else{
					current_gas = 0;
				}
				
				int hour = managetime.getHour();
				int minute = managetime.getMinute();
				int second = managetime.getSecond();
				
				systemrecord.setId(userimpl.getNowUserInfo().getId());
				systemrecord.setYear(managetime.getYear());
				systemrecord.setMonth(managetime.getMonth());
				systemrecord.setDay(managetime.getDay());

				systemrecord.setEtotaltime(0);
				systemrecord.setGtotaltime(0);
				
				gassystemrecord.setId(userimpl.getNowUserInfo().getId());
				gassystemrecord.setYear(managetime.getYear());
				gassystemrecord.setMonth(managetime.getMonth());
				gassystemrecord.setDay(managetime.getDay());
				gassystemrecord.setHour(managetime.getHour());
				gassystemrecord.setMinute(managetime.getMinute());
				gassystemrecord.setSecond(managetime.getSecond());
				gassystemrecord.setGas_usage(current_gas);
				gassystemrecord.setGas_price(tariffimpl.checkTariff()[1]);
				gassystemrecord.setGfirsthour(hour);
				gassystemrecord.setGfirstminute(minute);
				gassystemrecord.setGfirstsecond(second);
				gassystemrecord.setGtotaltime(0);
				
				if(systemrecordimpl.checkGasSameRecord(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay())){
					systemrecordimpl.addNewGasRecord(gassystemrecord);
				}
				else{
					
					gassystemrecord = systemrecordimpl.getGasRecordByIdDate(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay());

					if(hour != 0 && gassystemrecord.getGfirsthour() != 0){
						time = (int)((hour*60 + minute) - (gassystemrecord.getGfirsthour()*60 + gassystemrecord.getGfirstminute()));
					}
					else if(hour == 0 && gassystemrecord.getGfirsthour() == 0){
						time = (int)((24*60 + minute) - (24*60 + gassystemrecord.getGfirstminute()));
					}
					else if(hour != 0 && gassystemrecord.getGfirsthour() == 0){
						time = (int)((hour*60 + minute) - (0*60 + gassystemrecord.getGfirstminute()));
					}
					
					
//					systemrecordimpl.updateElectricityRecord(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay(), current_elec);
					systemrecordimpl.updateGasRecord(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay(), current_gas);
					
					systemrecordimpl.updateGTotalTime(userimpl.getNowUserInfo().getId(), managetime.getYear(), managetime.getMonth(), managetime.getDay(), time);
					
					//Show
					UserMainBorad.gasstatus = "Alive";
					UserMainBorad.gastime = Integer.toString(time);
					UserMainBorad.gasuse = UserMainBorad.df.format(current_gas);
					UserMainBorad.gascost = UserMainBorad.df.format(tariffimpl.checkTariff()[1] * current_gas);
					UserMainBorad.textArea_1.setText("Status:	" + UserMainBorad.gasstatus + "\n" + "Time:	" + UserMainBorad.gastime + " min\n" + "Daily Usage:	"  + UserMainBorad.gasuse + " kWh\n" + "Daily Cost:	" + UserMainBorad.gascost + " £\n" + "Budget:	" + Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()) + " £\n" + "Tariff:	" + tariffimpl.checkTariff()[1] + " £");
					
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
					
					System.out.println("gas_true");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else if(UserMainBorad.gas_judge == 0){
				UserMainBorad.gasstatus = "Not Alive";
				UserMainBorad.textArea_1.setText("Status:	" + UserMainBorad.gasstatus + "\n" + "Time:	" + UserMainBorad.gastime + " min\n" + "Daily Usage:	"  + UserMainBorad.gasuse + " kWh\n" + "Daily Cost:	" + UserMainBorad.gascost + " £\n" + "Budget:	" + Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()) + " £\n" + "Tariff:	" + tariffimpl.checkTariff()[1] + " £");
				System.out.println("gas_false");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(UserMainBorad.gas_judge == -1){
				UserMainBorad.gasstatus = "Not Alive";
				UserMainBorad.textArea_1.setText("Status:	" + UserMainBorad.gasstatus + "\n" + "Time:	" + UserMainBorad.gastime + " min\n" + "Daily Usage:	"  + UserMainBorad.gasuse + " kWh\n" + "Daily Cost:	" + UserMainBorad.gascost + " £\n" + "Budget:	" + Float.toString(userimpl.queryUserInfoById(userimpl.getNowUserInfo().getId()).getGas_budget()) + " £\n" + "Tariff:	" + tariffimpl.checkTariff()[1] + " £");
				break;
			}
			
		}


		
	}
}
