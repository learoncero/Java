package at.fhv.itb.lro3572;

public class DatabaseConnection {
	private static DatabaseConnection[] _connections = new DatabaseConnection[3];
	
	static {
		for (int i = 0; i < _connections.length; i += 1) {
			_connections[i] = new DatabaseConnection();
		}
	}
	
	private DatabaseConnection() {
		// private constructor so that no one can open new connections from outside
	}
	
	public static DatabaseConnection getConnection() throws MaxConnectionException {
		int i;
		for (i = 0; ((i < _connections.length) && (_connections[i] == null)); i += 1);
		if (i < _connections.length) {
			DatabaseConnection dc = _connections[i];
			_connections[i] = null;
			return dc;
		} else {
			throw new MaxConnectionException("Max number reached.");
		}
	}
	
	public static void returnConnection(DatabaseConnection databaseConnection) {
		int i;
		for (i = 0; _connections[i] != null; i += 1);
		_connections[i] = databaseConnection;
	}
	
}
