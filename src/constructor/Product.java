package constructor;

public class Product {
	private int id;
	private String name;
	private double cost;
	private int rating;

	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, double cost, int rating) {
		this(id,name,cost);

		this.rating = rating;
	}
	
	public Product(int id, String name, double cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	
	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", salary=" + cost + ", rating=" + rating + "]";
	}

}
