package Prioritätswarteschlange;

public class PrioTooLowException extends Exception {
	private static final long serialVersionUID = 1L;

	public PrioTooLowException(String message) {
		super(message);
	}
}
