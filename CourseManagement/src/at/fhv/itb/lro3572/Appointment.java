package at.fhv.itb.lro3572;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Appointment {
	private Course _course;
	private LocalDateTime _start; 
	private LocalDateTime _end; 
	private LinkedList<Person> _participants;
	private Instructor _instructor;
	
	public Appointment(Course course, LocalDateTime start, LocalDateTime end, Instructor instructor, LinkedList<Person> participants) {
		if (start.getDayOfYear() != end.getDayOfYear()) {
			System.out.println("Courses can be one day only!\n");
		}
		_course = course;
		course.getAppointments().add(this);
		_start = start;
		_end = end;
		_participants = participants;
		_instructor = instructor;
		instructor.addAppointment(this);
	}
	
	public Appointment(Course course, LocalDateTime start, LocalDateTime end, Instructor instructor) {
		this(course, start, end, instructor, new LinkedList<>());
	}
	
//	start getters and setters
	public Course getCourse() {
		return _course;
	}

	public void setCourse(Course course) {
		_course = course;
	}

	public LocalDateTime getStart() {
		return _start;
	}

	public void setStart(LocalDateTime start) {
		_start = start;
	}

	public LocalDateTime getEnd() {
		return _end;
	}

	public void setEnd(LocalDateTime end) {
		_end = end;
	}

	public LinkedList<Person> getParticipants() {
		return _participants;
	}

	public void setParticipants(LinkedList<Person> participants) {
		_participants = participants;
	}

	public LinkedList<Person> getPersons() {
		return _participants;
	}

	public void setPersons(LinkedList<Person> persons) {
		_participants = persons;
	}

	public Instructor getInstructor() {
		return _instructor;
	}

	public void setInstructor(Instructor instructor) {
		_instructor = instructor;
	}
//	end getters and setters
	
	public void addParticipant(Person person) {
		if (_participants.size() < _course.getMaxParticipants()) {
			_participants.add(person);
			person.addAppointment(this);
		}
		else {
			System.out.println("This appointment is fully booked!\n");
		}
	}

	public void removeParticipant(Person person) {
		_participants.remove(person);
		person.removeAppointment(this);
	}
	
	public void addInstructor(Instructor instructor) {
		if (_instructor != null) {
			_instructor = instructor;
			_instructor.addAppointment(this);
		}
		else {
			System.out.println("An instructor is already registered for this course!");
		}
	}
	
	public void removeInstructor() {
		_instructor = null;
		_instructor.removeAppointment(this);
	}

	public void printParticipants() {
		System.out.println("Participants: ");
		for (Person participant: _participants) {
			System.out.print("\t\tPersonal Number: " + participant.getPersNumber());
			System.out.print("\t\tFirst Name: " + participant.getfName());
			System.out.println("\t\tLast Name: " + participant.getlName());
		}
	}
	
	@Override
	public String toString() {
		return "Appointment [_course=" + _course + ", _start=" + _start + ", _end=" + _end + ", _participants="
				+ _participants + ", _instructor=" + _instructor + ", getCourse()=" + getCourse() + ", getStart()="
				+ getStart() + ", getEnd()=" + getEnd() + ", getParticipants()=" + getParticipants() + ", getPersons()="
				+ getPersons() + ", getInstructor()=" + getInstructor() + "]";
	}

	public static void main(String[] args) {
		Course c1 = new IndividualTraining("C1");
		Instructor inst = new Instructor(123, "Inst", "Instructor");
		Person lea = new Person(1, "Lea", "Roncero");
		Person lea1 = new Person(1, "Lea", "Roncero");
		Appointment app = new Appointment(c1, LocalDateTime.of(2023, 04, 17, 10, 30), LocalDateTime.of(2023, 04, 17, 12, 30), inst);
		app.addParticipant(lea);
		app.addParticipant(lea1);
		app.printParticipants();
	}
}
