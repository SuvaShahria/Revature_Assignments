package arithmetic;

public class Arithmetic {

	public static void main(String[] args) {
		
		int a = 10, b = 2,c = 3;
		
	System.out.println("This is add,10+2 =  "+ add(a, b));
	System.out.println("This is sub,10-2 =  "+ sub(a, b));
	System.out.println("This is mul,10*2 =  "+ mult(a, b));
	System.out.println("This is div,10/2 =  "+ div(a, b));
	System.out.println("This is remainder,10%3 =  "+ remainder(a, c));

	}
	
	public static int add(int a, int b){
		return a + b;
	}
	
	public static int sub(int a, int b){
		return a - b;
	}
	
	public static int mult(int a, int b){
		return a * b;
	}
	
	public static int div(int a, int b){
		return a/b;
	}

	public static int remainder(int a, int b){
		return a%b;
	}
}
