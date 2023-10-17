package at.fhv.itb.lro3572;

import java.util.LinkedList;

public class Person {
	private int _persNumber;
	private String _fName;
	private String _lName;
	private LinkedList<Appointment> _appointments;
	
	public Person (int persNumber, String firstName, String lastName) {
		_persNumber = persNumber;
		_fName = firstName;
		_lName = lastName;
		_appointments = new LinkedList<>();
	}

//	start getters and setters
	public int getPersNumber() {
		return _persNumber;
	}

	public void setPersNumber(int persNumber) {
		_persNumber = persNumber;
	}

	public String getfName() {
		return _fName;
	}

	public void setfName(String fName) {
		_fName = fName;
	}

	public String getlName() {
		return _lName;
	}

	public void setlName(String lName) {
		_lName = lName;
	}

	public LinkedList<Appointment> getAppointments() {
		return _appointments;
	}

	public void setAppointments(LinkedList<Appointment> appointments) {
		_appointments = appointments;
	}
//	end getters and setters
	
	public void addAppointment(Appointment appointment) {
		_appointments.add(appointment);
	}
	
	public void removeAppointment(Appointment appointment) {
		_appointments.remove(appointment);
	}

	@Override
	public String toString() {
		return "Person [_persNumber=" + _persNumber + ", _fName=" + _fName + ", _lName=" + _lName + ", _appointments="
				+ _appointments + ", getPersNumber()=" + getPersNumber() + ", getfName()=" + getfName()
				+ ", getlName()=" + getlName() + ", getAppointments()=" + getAppointments() + "]";
	}

	public static void main(String[] args) {
		Person lea = new Person(1, "Lea", "Roncero");
		System.out.println(lea);
	}

}