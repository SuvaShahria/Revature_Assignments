package collections;



import java.util.HashSet;
import java.util.Set;
//Create Flight(fid,fname,cost,rating) and eliminate the duplicates
// task comment missing so just played around with it
public class ProductMain {

	public static void main(String[] args) {
		
		Set<Flight> productsList=new HashSet<>();
		productsList.add(new Flight(900, "TV", 188.5, 2.3f));
		productsList.add(new Flight(120, "Netflix", 188.5, 1.8f));
		productsList.add(new Flight(100, "HboMax", 122.22, 2.1f));
		productsList.add(new Flight(100, "AppleTV", 122.22, 1.4f));
		productsList.add(new Flight(100, "TV", 122.22, 3.5f));
		productsList.add(new Flight(101, "TV", 122.22, 2.3f));
		
		System.out.println("Printing all product/s");
		printProducts(productsList);

	}
	
	public static void printProducts(Set<Flight> productsList) {
		for(Flight p:productsList) {
			System.out.println(p);
		}
	}

}