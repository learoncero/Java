package at.fhv.itb.lro3572.exceptions;

public class AlreadyReservedException extends Exception {
	private static final long serialVersionUID = 1L;

	public AlreadyReservedException(String message) {
		super(message);
	}
}
