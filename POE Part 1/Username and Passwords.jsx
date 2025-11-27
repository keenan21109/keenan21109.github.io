public class UsernameandPasswords {

    HashMap<String,String> logininfo = new HashMap<String,String>();
	
	UsernameandPasswords();{
		
		logininfo.put("Bro","pizza");
		logininfo.put("Brometheus","PASSWORD");
		logininfo.put("BroCode","abc123");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}