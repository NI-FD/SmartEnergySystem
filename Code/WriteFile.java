
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Title      : WriteFile.java
 * Description: This class is used to write string into a 'txt' file.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class WriteFile {
	
	int i;
	
	/**
	 * This method is used to write contents into a 'txt' file and cover the old content.
	 * @param info The information list that is needed to write into 'txt' file.
	 * @param filePath The path of the file that you want to write.
	 * @return The return value indicate whether the operation finish.
	 */
	public synchronized boolean writeLineCover(ArrayList<String> info , String filePath){
		
		File file = new File(filePath);
		try {
			FileWriter out = new FileWriter(file , false);
			
			for(i = 0 ; i<info.size() ; i++){
				out.write(info.get(i) + "\n");
			}
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	

	}
	
	/**
	 * This method is used to write contents into a 'txt' file and add new contents after old contents.
	 * @param info The information list that is needed to write into 'txt' file.
	 * @param filePath The path of the file that you want to write.
	 * @return The return value indicate whether the operation finish.
	 */
	public synchronized boolean writeLineAppend(ArrayList<String> info , String filePath){
		
		File file = new File(filePath);
		try {
			FileWriter out = new FileWriter(file , true);
			
			for(i = 0 ; i<info.size() ; i++){

				out.write(info.get(i) + "\n");
				
			}
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
}
