package at.fhv.itb.lro3572.person;

public class ExternalPersonRole extends Role {
	private int _lendingFee_cents;
	
	public ExternalPersonRole() {
		_maxLendingPeriodBoMa_Weeks = 4;
		_maxLendingPeriodOther_Weeks = 2;
		_maxExtensions = 1;
		_lendingFee_cents = 50;
	}
}
