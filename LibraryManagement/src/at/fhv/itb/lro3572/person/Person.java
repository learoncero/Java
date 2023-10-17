package at.fhv.itb.lro3572.person;

public abstract class Person {
	private String _name;
	private String _address;
	
	public Person (String name, String address) {
		_name = name;
		_address = address;
	}

	public String getName() {
		return _name;
	}

	public String getAddress() {
		return _address;
	}
}
