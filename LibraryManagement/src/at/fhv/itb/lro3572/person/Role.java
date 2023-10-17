package at.fhv.itb.lro3572.person;

public abstract class Role {
	protected int _maxLendingPeriodBoMa_Weeks;
	protected int _maxLendingPeriodOther_Weeks;
	protected int _maxExtensions;
	
	
	public int getMaxLendingPeriodBoMa_Weeks() {
		return _maxLendingPeriodBoMa_Weeks;
	}
	public void setMaxLendingPeriodBoMa_Weeks(int maxLendingPeriodBoMa_Weeks) {
		_maxLendingPeriodBoMa_Weeks = maxLendingPeriodBoMa_Weeks;
	}
	public int getMaxLendingPeriodOther_Weeks() {
		return _maxLendingPeriodOther_Weeks;
	}
	public void setMaxLendingPeriodOther_Weeks(int maxLendingPeriodOther_Weeks) {
		_maxLendingPeriodOther_Weeks = maxLendingPeriodOther_Weeks;
	}
	public int getMaxExtensions() {
		return _maxExtensions;
	}
	public void setMaxExtensions(int maxExtensions) {
		_maxExtensions = maxExtensions;
	}
}
