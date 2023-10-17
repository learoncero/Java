package at.fhv.itb.lro3572;

import java.util.LinkedList;

public class GroupCourse extends Course {
	
	public GroupCourse(String name, int maxParticipants) {
		_name = name; 
		_maxParticipants = maxParticipants;
		_appointments = new LinkedList<>();
	}
}
