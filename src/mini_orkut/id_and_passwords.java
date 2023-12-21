package mini_orkut;

import java.util.HashMap;

public class id_and_passwords {
	HashMap<String,String> logininfo = new HashMap<String,String>();
	id_and_passwords(){
		//These are the Registered Username and passwords
		logininfo.put("Vinay RG","Welcome@123");
		logininfo.put("CodeClause","123");
		logininfo.put("E for Elephant","1234");
		
	}
	protected HashMap getLoginInfo() {
		return logininfo;
	}

}
