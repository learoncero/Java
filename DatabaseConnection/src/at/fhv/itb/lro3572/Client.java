package at.fhv.itb.lro3572;

public class Client {
	private DatabaseConnection _connection;
	
	public Client() {
		_connection = null;
	}
	
	public String connect() {
		try {
			_connection = DatabaseConnection.getConnection();
			return "Connection successful";
		} catch (MaxConnectionException e) {
			return e.getMessage();
		}
	}
	
	public String disconnect() {
		DatabaseConnection.returnConnection(_connection);
		return "Disconnect successful";
	}
	
	public static void main(String[] args) {
		Client c1 = new Client();
		Client c2 = new Client();
		Client c3 = new Client();
		Client c4 = new Client();
		Client c5 = new Client();
		
		System.out.println(c1.connect());
		System.out.println(c2.connect());
		System.out.println(c3.connect());
		System.out.println(c4.connect());
		System.out.println(c3.disconnect());
		System.out.println(c4.connect());
		System.out.println(c5.connect());
	}
	
}
