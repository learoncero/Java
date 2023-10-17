package at.fhv.itb.lro3572;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class CoursePlanner {
	private LinkedList<Course> _courses;
	private static CoursePlanner _instance;
	
	private CoursePlanner(LinkedList<Course> courses){
		_courses = courses;
	}
	
	public void addCourse(Course course) {
		_courses.add(course);
	}
	
	public void removeCourse(Course course) {
		_courses.remove(course);
	}
	
	public static CoursePlanner instance(LinkedList<Course> courses) {
		if (_instance == null) {
			_instance = new CoursePlanner(courses);
		}
		return _instance;
	}
	
	public void printCoursesDate(LocalDate date) {
		System.out.println("Courses on date " + date);
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (Course course: _courses) {
			LinkedList<Appointment> appointments = course.getAppointments();
			for (Appointment appointment: appointments) {
				if ((appointment.getStart().getYear() == date.getYear()) && (appointment.getStart().getMonth() == date.getMonth())
						&& appointment.getStart().getDayOfMonth() == date.getDayOfMonth()) {
					System.out.println("Course Name: " + course.getName());
					appointment.printParticipants();
					System.out.println("Instructor: ");
					System.out.print("\t\tPersonal Number: " + appointment.getInstructor().getPersNumber());
					System.out.print("\t\tFirst Name: " + appointment.getInstructor().getfName());
					System.out.println("\t\tLast Name: " + appointment.getInstructor().getlName());
					System.out.println("----------------------------------------------------------------------------------------------------------");
				}
			}
		}
	}
	
	public void printCoursesInstructor(Instructor instructor) {
		System.out.println("Courses from the instructor " + instructor.getfName() + " " + instructor.getlName());
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (Course course: _courses) {
			LinkedList<Appointment> appointments = course.getAppointments();
			for (Appointment appointment: appointments) {
				if (appointment.getInstructor().equals(instructor)) {
					System.out.println("Course Name: " + course.getName());
					System.out.println("Start Date and Time: " + appointment.getStart());
					appointment.printParticipants();
					System.out.println("----------------------------------------------------------------------------------------------------------");
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "CoursePlanner [_courses=" + _courses + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		Course c1 = new GroupCourse("Group 1", 2);
		Course c2 = new IndividualTraining("Individual 1");
		Course c3 = new GroupCourse("Group 2", 3);
		Course c4 = new IndividualTraining("Individual 2");
		
		Instructor instructor = new Instructor(123, "Lea", "Roncero");
		
		Appointment a1 = new Appointment(c1, LocalDateTime.of(2023, 04, 17, 10, 30), LocalDateTime.of(2023, 04, 17, 11, 30), instructor);
		Appointment a2 = new Appointment(c1, LocalDateTime.of(2023, 04, 18, 12, 30), LocalDateTime.of(2023, 04, 18, 17, 30), instructor);
		Appointment a3 = new Appointment(c2, LocalDateTime.of(2023, 04, 19, 14, 00), LocalDateTime.of(2023, 04, 19, 16, 00), instructor);
		Appointment a4 = new Appointment(c4, LocalDateTime.of(2023, 04, 20, 8, 00), LocalDateTime.of(2023, 04, 20, 17, 00), instructor);
		Appointment a5 = new Appointment(c3, LocalDateTime.of(2023, 04, 20, 9, 15), LocalDateTime.of(2023, 04, 21, 12, 15), instructor);
		Appointment a6 = new Appointment(c4, LocalDateTime.of(2023, 04, 21, 10, 30), LocalDateTime.of(2023, 04, 21, 15, 30), instructor);
		
		Person p1 = new Person(1, "Peter", "Schneider");
		Person p2 = new Person(2, "Sarah", "Neville");
		Person p3 = new Person(3, "Manuel", "Schönberger");
		Person p4 = new Person(4, "Patrick", "Ritschel");
		a1.addParticipant(p4);
		a1.addParticipant(p3);
		a2.addParticipant(p2);
		a2.addParticipant(p1);
		a3.addParticipant(p4);
		a4.addParticipant(p3);
		a5.addParticipant(p1); 
		a5.addParticipant(p2);
		a5.addParticipant(p3);
		a6.addParticipant(p1);
		a6.addParticipant(p2);
		
		LinkedList<Course> courses = new LinkedList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		CoursePlanner coursePlanner = CoursePlanner.instance(courses);
		coursePlanner.addCourse(c4);
		
		coursePlanner.printCoursesDate(LocalDate.of(2023, 04, 20));
//		coursePlanner.printCoursesInstructor(instructor);
	}
}
