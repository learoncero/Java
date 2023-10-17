package at.fhv.itb.lro3572.Person;

public class Teacher extends Role {
	public Teacher(String name, String address) {
		super(name, address);
		_lendingPeriodPrintMedia_weeks = 8;
		_lendingPeriodOther_weeks = 2;
		_maxExtensions = 2;
	}
}
