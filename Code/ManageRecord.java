
import java.util.ArrayList;

/**
 * Title      : ManageRecord.java
 * Description: This class manage the record of meter read.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ManageRecord {
	
	/**
	 * This method is used to convert the ArrayList to SystemRecord[][].
	 * @param list The SystemRecord object list.
	 * @return The return is SystemRecord[][].
	 */
	public SystemRecord[][] List(ArrayList<SystemRecord> list){
		if(list == null){
			return null;
		}
		else{
			SystemRecord[][] nlist = new SystemRecord[(int)Math.ceil((double)list.size()/(double)5)][5];
			int i;
			int j = 0;
			int count = 0;
			System.out.println("length: " + list.size());
			for(i = 0 ; i < list.size() ; i++){
				if( i < 5 ){
					nlist[j][i] = (SystemRecord)list.get(i);
					if(i == 4){
						j++;
					}
				}
				else{
					nlist[j][i % 5] = list.get(i);
					count++;
					if( count == 5){
						j++;
						count = 0;
					}
				}
				
			}
			return nlist;	
		}
	
	}
	
	/**
	 * This method is used to convert the ArrayList to ElectricitySystemRecord[][].
	 * @param elelist The ElectricitySystemRecord object list.
	 * @return The return is ElectricitySystemRecord[][].
	 */
	public ElectricitySystemRecord[][] eleList(ArrayList<ElectricitySystemRecord> elelist){
		if(elelist == null){
			return null;
		}
		else{
			ElectricitySystemRecord[][] list = new ElectricitySystemRecord[(int)Math.ceil((double)elelist.size()/(double)5)][5];
			int i;
			int j = 0;
			int count = 0;
			System.out.println("length: " + elelist.size());
			for(i = 0 ; i < elelist.size() ; i++){
				if( i < 5 ){
					list[j][i] = (ElectricitySystemRecord)elelist.get(i);
					if(i == 4){
						j++;
					}
				}
				else{
					list[j][i % 5] = elelist.get(i);
					count++;
					if( count == 5){
						j++;
						count = 0;
					}
				}
				
			}
			return list;	
		}
	
	}
	
	/**
	 * This method is used to convert the ArrayList to GasSystemRecord[][].
	 * @param gaslist The GasSystemRecord object list.
	 * @return The return is GasSystemRecord[][].
	 */
	public GasSystemRecord[][] gasList(ArrayList<GasSystemRecord> gaslist){
		if(gaslist == null){
			return null;
		}
		else{
			GasSystemRecord[][] list = new GasSystemRecord[(int)Math.ceil((double)gaslist.size()/(double)5)][5];
			int i;
			int j = 0;
			int count = 0;
			
			for(i = 0 ; i < gaslist.size() ; i++){
				if( i < 5 ){
					list[j][i] = (GasSystemRecord)gaslist.get(i);
					if(i == 4){
						j++;
					}
				}
				else{
					list[j][i % 5] = gaslist.get(i);
					count++;
					if( count == 5){
						j++;
						count = 0;
					}
				}
				
			}
			
			return list;
		}
	}
	
	/**
	 * This method is used to combine two list together.
	 * @param elelist The ElectricitySystemRecord object list.
	 * @param gaslist The GasSystemRecord object list
	 * @return The return is SystemRecord[][].
	 */
	public SystemRecord[][] totallist(ElectricitySystemRecord[][] elelist , GasSystemRecord[][] gaslist){
		
		if(elelist == null && gaslist == null){
			return null;
		}
		else{
			int i, j, k, l;
			int row = 0;
			
			if(elelist.length == 0 && gaslist.length == 0){
				System.out.println("start: " + elelist.length);
				return null;
			}
			else if(gaslist == null){
				row = elelist.length;
			}
			else if(elelist == null){
				row = gaslist.length;
			}

			else if(elelist.length >= gaslist.length){
				row = elelist.length;
			}
			
			else if(elelist.length < gaslist.length){
				row = gaslist.length;
			}	
		
			
			SystemRecord systemrecord;
			
			if(gaslist == null){
			//	totallist = new SystemRecord[row][5];
				SystemRecord[][] totallist = new SystemRecord[row][5];
				for(i = 0 ; i < row ; i++){
					for(j = 0 ; j < 5 ; j++){
						systemrecord = new SystemRecord();
						if(elelist[i][j] == null){
							break;
						}	
						systemrecord.setId(elelist[i][j].getId());
						systemrecord.setYear(elelist[i][j].getYear());
						systemrecord.setMonth(elelist[i][j].getMonth());
						systemrecord.setDay(elelist[i][j].getDay());
						systemrecord.setElectricity_usage(elelist[i][j].getElectricity_usage());
						systemrecord.setElectricity_oldprice(elelist[i][j].getElectricity_price());
						systemrecord.setGas_usage(0);
						systemrecord.setGas_oldprice(0);
						systemrecord.setEtotaltime(elelist[i][j].getEtotaltime());
						systemrecord.setGtotaltime(0); 
						totallist[i][j] = systemrecord;
					}
				}
				return totallist;
			}
			else if(elelist == null){
			//	totallist = new SystemRecord[row][5];
				SystemRecord[][] totallist = new SystemRecord[row][5];
				for(i = 0 ; i < row ; i++){
					for(j = 0 ; j < 5 ; j++){
						systemrecord = new SystemRecord();
						if(gaslist[i][j] == null){
							break;
						}	
						systemrecord.setId(gaslist[i][j].getId());
						systemrecord.setYear(gaslist[i][j].getYear());
						systemrecord.setMonth(gaslist[i][j].getMonth());
						systemrecord.setDay(gaslist[i][j].getDay());
						systemrecord.setElectricity_usage(0);
						systemrecord.setElectricity_oldprice(0);
						systemrecord.setGas_usage(gaslist[i][j].getGas_usage());
						systemrecord.setGas_oldprice(gaslist[i][j].getGas_price());
						systemrecord.setEtotaltime(0);
						systemrecord.setGtotaltime(gaslist[i][j].getGtotaltime()); 
						totallist[i][j] = systemrecord;
					}
				}
				return totallist;
			}

			else if(elelist.length >= gaslist.length){
				int[] ui = new int[elelist.length*5];
				int[] uj = new int[elelist.length*5];
				int uii = 0;
				int ujj = 0;
				int ti, tj;
				SystemRecord[][] totallist = new SystemRecord[row][5];
			//	totallist = new SystemRecord[row][5];
				System.out.println("row: " + row);
				for(i = 0 ; i < row ; i++){
					for(j = 0 ; j < elelist[i].length ; j++){
						systemrecord = new SystemRecord();
						if(elelist[i][j] == null){
							break;
						}
						systemrecord.setId(elelist[i][j].getId());
						systemrecord.setYear(elelist[i][j].getYear());
						systemrecord.setMonth(elelist[i][j].getMonth());
						systemrecord.setDay(elelist[i][j].getDay());
						systemrecord.setElectricity_usage(elelist[i][j].getElectricity_usage());
						systemrecord.setElectricity_oldprice(elelist[i][j].getElectricity_price());
						systemrecord.setGas_usage(0);
						systemrecord.setGas_oldprice(0);
						systemrecord.setEtotaltime(elelist[i][j].getEtotaltime());
						systemrecord.setGtotaltime(0);
						totallist[i][j] = systemrecord;
					}
				}
//				System.out.println("Method: " + totallist[0][0].getDay());
//				System.out.println("Method: " + totallist[0][1].getDay());
//				System.out.println("Method: " + totallist[0][2].getDay());
				
				for(i = 0 ; i < totallist.length ; i++){
					for(j = 0 ; j < 5 ; j++){
						systemrecord = new SystemRecord();
						systemrecord = totallist[i][j];
						
						for(k = 0 ; k < gaslist.length ; k++){
							
							for(l = 0 ; l < 5 ; l++){
								if(gaslist[k][l] == null){
								//	System.out.println("breakgas");
									break;
								}
								if(systemrecord != null){
									if(systemrecord.getYear() == gaslist[k][l].getYear() && systemrecord.getMonth() == gaslist[k][l].getMonth() && systemrecord.getDay() == gaslist[k][l].getDay()){
										systemrecord.setGas_usage(gaslist[k][l].getGas_usage());
										systemrecord.setGas_oldprice(gaslist[k][l].getGas_price());
										systemrecord.setGtotaltime(gaslist[k][l].getGtotaltime());
										totallist[i][j] = systemrecord;
										ui[uii] = k;
										uj[ujj] = l;
										uii++;
										ujj++;
										break;
									}
		
								}
								else{
									for(ti = 0 ; ti < ui.length ; ti++){
										for(tj = 0 ; tj < uj.length ; tj++){
											if(ui[ti] != k && uj[tj] != l){
												systemrecord = new SystemRecord();
												systemrecord.setId(gaslist[k][l].getId());
												systemrecord.setYear(gaslist[k][l].getYear());
												systemrecord.setMonth(gaslist[k][l].getMonth());
												systemrecord.setDay(gaslist[k][l].getDay());
												systemrecord.setElectricity_usage(0);
												systemrecord.setElectricity_oldprice(0);
												systemrecord.setGas_usage(gaslist[k][l].getGas_usage());
												systemrecord.setGas_oldprice(gaslist[k][l].getGas_price());
												systemrecord.setEtotaltime(0);
												systemrecord.setGtotaltime(gaslist[k][l].getGtotaltime());
												totallist[i][j] = systemrecord;
											}
										}
									}
								}
							}
						}
					}
				}
//				System.out.println("Method1: " + totallist[0][0].getDay());
//				System.out.println("Method1: " + totallist[0][1].getDay());
//				System.out.println("Method1: " + totallist[0][2].getDay());
//				System.out.println("Method1: " + totallist[0][3].getDay());
//				System.out.println("Method1: " + totallist[0][4].getDay());

				return totallist;
			}
			
			else if(elelist.length < gaslist.length){
				int[] ui = new int[elelist.length*5];
				int[] uj = new int[elelist.length*5];
				int uii = 0;
				int ujj = 0;
				int ti, tj;
				SystemRecord[][] totallist = new SystemRecord[row][5];
			//	totallist = new SystemRecord[row][5];
				
				for(i = 0 ; i < row ; i++){
					for(j = 0 ; j < 5 ; j++){
						systemrecord = new SystemRecord();
						if(gaslist[i][j] == null){
							break;
						}	
						systemrecord.setId(gaslist[i][j].getId());
						systemrecord.setYear(gaslist[i][j].getYear());
						systemrecord.setMonth(gaslist[i][j].getMonth());
						systemrecord.setDay(gaslist[i][j].getDay());
						systemrecord.setElectricity_usage(0);
						systemrecord.setElectricity_oldprice(0);
						systemrecord.setGas_usage(gaslist[i][j].getGas_usage());
						systemrecord.setGas_oldprice(gaslist[i][j].getGas_price());
						systemrecord.setEtotaltime(0);
						systemrecord.setGtotaltime(gaslist[i][j].getGtotaltime());
						totallist[i][j] = systemrecord;
					}
				}
				
				for(i = 0 ; i < totallist.length ; i++){
					for(j = 0 ; j < 5 ; j++){
						systemrecord = new SystemRecord();
						systemrecord = totallist[i][j];
						
						for(k = 0 ; k < elelist.length ; k++){
							
							for(l = 0 ; l < 5 ; l++){
								if(elelist[k][l] == null){
								//	System.out.println("breakgas");
									break;
								}
								
								if(systemrecord != null){
									if(systemrecord.getYear() == elelist[k][l].getYear() && systemrecord.getMonth() == elelist[k][l].getMonth() && systemrecord.getDay() == elelist[k][l].getDay()){
										systemrecord.setGas_usage(elelist[k][l].getElectricity_usage());
										systemrecord.setGas_oldprice(elelist[k][l].getElectricity_price());
										systemrecord.setGtotaltime(elelist[k][l].getEtotaltime());
										totallist[i][j] = systemrecord;							
										ui[uii] = k;
										uj[ujj] = l;
										uii++;
										ujj++;
										break;
									}
		
								}
								else{
									for(ti = 0 ; ti < ui.length ; ti++){
										for(tj = 0 ; tj < uj.length ; tj++){
											if(ui[ti] != k && uj[tj] != l){
												systemrecord = new SystemRecord();
												systemrecord.setId(elelist[k][l].getId());
												systemrecord.setYear(elelist[k][l].getYear());
												systemrecord.setMonth(elelist[k][l].getMonth());
												systemrecord.setDay(elelist[k][l].getDay());
												systemrecord.setElectricity_usage(elelist[k][l].getElectricity_usage());
												systemrecord.setElectricity_oldprice(elelist[k][l].getElectricity_price());
												systemrecord.setGas_usage(0);
												systemrecord.setGas_oldprice(0);
												systemrecord.setEtotaltime(elelist[k][l].getEtotaltime());
												systemrecord.setGtotaltime(0);
												totallist[i][j] = systemrecord;
											}
										}
									}
								}
							}
						}
					}
				}
								
				return totallist;
			}
			return null;
		}	
	}
	
}
