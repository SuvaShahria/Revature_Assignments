package regex;

public class Regex {

	public static void main(String[] args) {
		String ssn = "123456789";
		if(isValidSSN(ssn)){
			System.out.println(ssn+" VALIDATED");
		}else{
			System.out.println(ssn+" is INVALID");
		}
		
		String apc = "08505";
		if(isValidAPC(apc)){
			System.out.println(apc+" VALIDATED");
		}else{
			System.out.println(apc+" is INVALID");
		}
		String LP = "AB4K52";
		if(isValidLP(LP)){
			System.out.println(LP+" VALIDATED");
		}else{
			System.out.println(LP+" is INVALID");
		}	
		

	}
	public static boolean isValidSSN(String ssn) {
		if(ssn.matches("[0-9]{9}")) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isValidAPC(String apc) {
		if(apc.matches("[0-9]{5}")) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isValidLP(String lp) {
		if(lp.matches("[A-Z]{2}[A-Z0-9]{4}")) {
			return true;
		}else {
			return false;
		}
	}

}
