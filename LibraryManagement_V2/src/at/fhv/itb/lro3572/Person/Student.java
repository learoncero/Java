package at.fhv.itb.lro3572.Person;

public class Student extends Role {
	public Student(String name, String address) {
		super(name, address);
		_lendingPeriodPrintMedia_weeks = 4;
		_lendingPeriodOther_weeks = 2;
		_maxExtensions = 1;
	}
}
