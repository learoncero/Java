package at.fhv.itb.lro3572;

import java.util.LinkedList;

public class IndividualTraining extends Course {
	
	public IndividualTraining(String name) {
		_name = name; 
		_maxParticipants = 1;
		_appointments = new LinkedList<>();
	}

}
