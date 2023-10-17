package at.fhv.itb.lro3572;

public class Person implements ComparableType {
	private String _name; 
	private int _salary;
	
	public Person(String name, int salary) {
		_name = name; 
		_salary = salary;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getSalary() {
		return _salary;
	}

	public void setSalary(int salary) {
		_salary = salary;
	}

	@Override
	public String toString() {
		return "Person [_name=" + _name + ", _salary=" + _salary + "]";
	}

	@Override
	public boolean less(ComparableType c) {
		return _salary < ((Person)c).getSalary();
	}
}
