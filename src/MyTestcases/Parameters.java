package MyTestcases;

import java.util.Random;

public class Parameters {
	Random rand = new Random();
	
	  String[] FirstNames = {"Alice", "Bob", "Charlie", "David", "Eva",
	            "Frank", "Grace", "Henry", "Ivy", "Jack" };
	  
	  String[] LastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown",
	            "Davis", "Miller", "Wilson", "Moore", "Taylor"};
	
	String  CommonPassword = "ASD123@2";
	
	int RandomIndex = rand.nextInt(10);
	int RandomEmailId = rand.nextInt(999);
	
	String emailID = FirstNames[RandomIndex]+LastNames[RandomIndex]+RandomEmailId+"@"+"Gmail.com";
}
