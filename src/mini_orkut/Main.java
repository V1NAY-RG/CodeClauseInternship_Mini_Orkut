package mini_orkut;

public class Main {
//MINI ORKUT
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Just used to call login page and passwords class
		id_and_passwords id = new id_and_passwords();
		Orkut_login_page loginPage = new Orkut_login_page(id.getLoginInfo());
		
	}
}
