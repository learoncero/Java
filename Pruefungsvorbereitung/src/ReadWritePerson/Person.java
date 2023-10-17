package ReadWritePerson;

public class Person {
    private String _name;
    private boolean _isReadOnly;

    public Person(String name) {
        _name = name;
        _isReadOnly = true; // Standardmäßig im Read-Only-Modus
    }

    public String getName() {
        return _name;
    }

    public void unlock(String password) {
        if (password.equals("pass123")) {
            _isReadOnly = false; // Wechsel in den Read/Write-Modus
        } else {
            throw new IllegalArgumentException("Ungültiges Passwort!");
        }
    }

    public void setName(String name) throws ReadOnlyException {
        if (_isReadOnly) {
            throw new ReadOnlyException("Objekt im Read-Only-Modus! Schreibzugriff nicht erlaubt.");
        }
        else {
        	_name = name;
        }
    }

    public static void main(String[] args) {
        Person person = new Person("John Doe");
        System.out.println(person.getName()); // Lesender Zugriff auf den Namen

        try {
            person.setName("Jane Doe"); // Versuch, den Namen zu ändern (im Read-Only-Modus)
        } catch (ReadOnlyException e) {
            System.out.println(e.getMessage()); // Ausnahme behandeln: Schreibzugriff nicht erlaubt
        }

        person.unlock("pass123"); // Objekt entsperren

        try {
			person.setName("Jane Doe");
		} catch (ReadOnlyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Schreibender Zugriff auf den Namen
        System.out.println(person.getName());

    }
}
   
