package arrays;

public class Array_Problems {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		System.out.println("The odd numbers are");
		for(int i=0; i<arr.length; i++){
			if(arr[i]%2 != 0){
				System.out.print(arr[i]+ " ");
			}
		}
		System.out.println("\n The palindrone numbers are" );
		for(int i=0; i<arr.length; i++){
			if(isPrime(arr[i])){
				System.out.print(arr[i]+ " ");
			}
		}
		System.out.println("\n The palindrone numbers are");
		for(int i=0; i<arr.length; i++){
			if(isPalindrome(arr[i])){
				System.out.print(arr[i]+ " ");
			}
		}

	}
	
	  public static boolean isPalindrome(int num) { 
	        int reverse = 0; 
	        for (int i = num; i > 0; i /= 10){
	            reverse = reverse * 10 + i % 10; 	        	
	        }

	             
	        if(num == reverse){
	        	return true;
	        }else{
	        	return false;
	        }
	        
	    }
	    static boolean isPrime(int num) { 
	        if (num <= 1){
	        	return false; 
	        }

	        for (int i = 2; i < num; i++){
	            if (num % i == 0){
	            	return false; 
	            }
	        }

	                
	      
	        return true; 
	    } 

}