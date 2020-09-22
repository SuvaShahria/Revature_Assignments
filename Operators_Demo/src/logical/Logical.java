package logical;

public class Logical {

	public static void main(String[] args) {
		int a = 5, b = 6, c = 7;
	
		boolean logAnd = a < 20 && b <20;
		boolean logOr = a < 20 || b >20;

		
		System.out.println("This is logical And, 5 < 20 && 6 <20 =  "+ logAnd);
		System.out.println("This is logical Or, 5 < 20 || 6 >20 =  "+ logOr);

	}
	
	

}
