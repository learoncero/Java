package at.fhv.itb.lro3572;

import java.util.LinkedList;

public abstract class Course {
	protected String _name;
	protected LinkedList<Appointment> _appointments;
	protected int _maxParticipants;
	
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public LinkedList<Appointment> getAppointments() {
		return _appointments;
	}

	public void setAppointments(LinkedList<Appointment> appointments) {
		_appointments = appointments;
	}

	public int getMaxParticipants() {
		return _maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		_maxParticipants = maxParticipants;
	}

	@Override
	public String toString() {
		return "Course [_name=" + _name + ", _appointments=" + _appointments + ", _maxParticipants=" + _maxParticipants
				+ "]";
	}
}

