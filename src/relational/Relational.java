package relational;

public class Relational {

	public static void main(String[] args) {
		int a = 5, b = 6;
		System.out.println("This is lessThen, 5 < 6 =  "+ lessThen(a, b));
		System.out.println("This is grtThen, 5 > 6 =  "+ grtThen(a, b));
		System.out.println("This is lessOrThen, 5 < 6 =  "+ lessOrThen(a, b));
		System.out.println("This is lessOrThen, 5 <= 5 =  "+ lessOrThen(a, a));
		System.out.println("This is grtOrThen, 5 > 6 =  "+ grtOrThen(a, b));
		System.out.println("This is grtOrThen, 5 >= 5 =  "+ grtOrThen(a, a));
		System.out.println("This is equals, 5 == 5 =  "+ equals(a, a));





	}
	
	public static boolean lessThen(int a, int b){
		
		return a < b;
	}

	public static boolean grtThen(int a, int b){
		
		return a > b;
	}
	public static boolean lessOrThen(int a, int b){
		
		return a <= b;
	}
	public static boolean grtOrThen(int a, int b){
		
		return a >= b;
	}
	
	public static boolean equals(int a, int b){
		
		return a == b;
	}
}
