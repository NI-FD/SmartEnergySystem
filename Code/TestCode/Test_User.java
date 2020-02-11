
import java.util.ArrayList;

public class Test_User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManageUser manageuser = new ManageUser();
		User nuser = new User();
		User user = new User();
		User userprint = new User();
		UserImpl userimpl = new UserImpl();
		float[] budget = new float[2];
		int i, j;
		
		user.setId(0);
		user.setName("Tom");
		user.setPassword("12");
		user.setAddress("Xi Tu Cheng Lu No.10");
		user.setEmail("rrr@qq.com");
		user.setPhone(123151111);
		user.setElectricity_budget((float) 1.2);
		user.setGas_budget((float) 9.9);
		
		System.out.println("This is addNewUser():");
		userimpl.addNewUser(user);
		System.out.println("");
		
		System.out.println("This is queryUserInfoById():");
		userprint = userimpl.queryUserInfoById(1);
		userimpl.printUserInfo(userprint);
		System.out.println("");
		
		System.out.println("This is queryUserInfoByName():");
		userprint = userimpl.queryUserInfoByName("Jerry");
		userimpl.printUserInfo(userprint);
		System.out.println("");
		
		System.out.println("This is UpdateUserBudget(1 , [0.1] , [0.2]):");
		budget[0] = (float) 0.1;
		budget[1] = (float) 0.2;
		userimpl.UpdateUserBudget(1, budget);
		userprint = userimpl.queryUserInfoById(1);
		userimpl.printUserInfo(userprint);
		System.out.println("");


//		User[][] list = new User[20][20];
//		System.out.println("i: " + manageuser.userList(userimpl.getAllUserInfo())[2][1].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[0][0].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[0][1].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[0][2].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[0][3].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[0][4].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[1][0].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[1][1].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[1][2].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[1][3].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[1][4].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[2][0].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[2][1].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[2][2].getName());
//		System.out.println("ss " + manageuser.userList(userimpl.getAllUserInfo())[2][3].getName());
		
		User[][] list = manageuser.userList(userimpl.getAllUserInfo());
		System.out.println("i:" + list.length);
		for(i = 0 ; i < list.length ; i++){
			for(j = 0 ; j < list[i].length ; j++){
				if(list[i][j] == null)
					break;
				System.out.println("ss " + list[i][j].getName());

			}
		}
		
	}

}
