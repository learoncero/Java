package at.fhv.itb.lro3572.exceptions;

public class LendingPeriodTooLongException extends Exception {
	private static final long serialVersionUID = 1L;

	public LendingPeriodTooLongException(String message) {
		super(message);
	}
}
