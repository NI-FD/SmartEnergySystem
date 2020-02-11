

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner; 


public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("FUCK");
		user.setId(2);
		user.setPassword("1");
		user.setElectricity_budget(150);
		user.setGas_budget(200);
		readFile("./source/user_info.txt");
			
		
	}
	
    /*
    *按行读取文件
    */
    public static void readFile(String filePath) {
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                System.out.println(tempString);
                String [] arr2 = tempString.split(" ");  //分词
                for(String ss : arr2){
                    System.out.println(ss);
                }
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
    }

}
