package ReadWritePerson;

//Benutzerdefinierte Ausnahme für Zugriff auf schreibendes Objekt ohne Entsperrung
public class WriteAccessException extends Exception {
	private static final long serialVersionUID = 1L;

	public WriteAccessException(String message) {
        super(message);
    }
}
