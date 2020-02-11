
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Title      : ReadFile.java
 * Description: This class is used to read string from a 'txt' file.
 * @author      wenyuan zhang
 * @version     1.0
 */

public class ReadFile {
	
	/**
	 * This method is used to get contents from a 'txt' file.
	 * @param filePath The path of the file that you want to read.
	 * @return The return value is the all content of the file.
	 */
	public ArrayList readLine(String filePath){
		ArrayList<String> info = new ArrayList();
		File file = new File(filePath);
	    BufferedReader reader = null;
	    try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
//                System.out.println(tempString);
                info.add(tempString);    
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return info;
	}
		
}
