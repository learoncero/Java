package at.fhv.itb.lro3572.exceptions;

public class AlreadyBorrowedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AlreadyBorrowedException (String message) {
		super(message);
	}

}
