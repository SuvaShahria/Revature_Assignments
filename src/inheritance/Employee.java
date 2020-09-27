package inheritance;

//Employee is-A person
public class Employee extends Person{
//try private Address  presentAddress
	//add has-A relationship Project-pid,name,clientname,cost
	private String designation; //has-A
	private double salary;//has-A
	private Address permenantAddress;//has-A
//	private Address presentAddress;
	private Address presentAddress;
	
	public Address getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(Address presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String designation, double salary) {
		super(id, name);
		this.designation = designation;
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Address getPermenantAddress() {
		return permenantAddress;
	}

	public void setPermenantAddress(Address permenantAddress) {
		this.permenantAddress = permenantAddress;
	}

	@Override
	public String toString() {
		return "Employee [designation=" + designation + ", salary=" + salary + ", permenantAddress=" + permenantAddress + ", presentAddress=" + presentAddress
				+ ", getId()=" + getId() + ", getName()=" + getName() + "]";
	}
	
}