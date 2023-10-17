package at.fhv.itb.lro3572.Exceptions;

public class ExtensionLimitExceededException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExtensionLimitExceededException(String message) {
		super(message);
	}
}
