package at.fhv.itb.lro3572.person;

public class Employee extends Person {
	private static int _count = 0;
	private String _employeeID;
	
	public Employee (String name, String address) {
		super(name, address);
		_employeeID = getNextID();
	}
	
	private String getNextID() {
		_count += 1;
		return "E" + _count;
	}
}
