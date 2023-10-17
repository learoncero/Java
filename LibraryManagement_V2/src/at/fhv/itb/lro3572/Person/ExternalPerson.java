package at.fhv.itb.lro3572.Person;

public class ExternalPerson extends Role {
	private int _lendingFee_cents;
	
	public ExternalPerson(String name, String address) {
		super(name, address);
		_lendingPeriodPrintMedia_weeks = 4;
		_lendingPeriodOther_weeks = 2;
		_maxExtensions = 1;
		_lendingFee_cents = 50;
	}
}
