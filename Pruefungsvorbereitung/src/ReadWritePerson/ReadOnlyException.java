package ReadWritePerson;

// Benutzerdefinierte Ausnahme für Schreibzugriff auf schreibgeschütztes Objekt
public class ReadOnlyException extends Exception {
	private static final long serialVersionUID = 1L;

	public ReadOnlyException(String message) {
        super(message);
    }
}
