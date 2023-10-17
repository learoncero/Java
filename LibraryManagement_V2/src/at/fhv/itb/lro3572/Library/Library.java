package at.fhv.itb.lro3572.Library;

import java.time.LocalDate;
import java.util.LinkedList;

import at.fhv.itb.lro3572.Exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.Exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.Exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.Exceptions.LendingNotFoundException;
import at.fhv.itb.lro3572.Exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.Media.Book;
import at.fhv.itb.lro3572.Media.Lending;
import at.fhv.itb.lro3572.Media.Magazine;
import at.fhv.itb.lro3572.Media.Media;
import at.fhv.itb.lro3572.Media.ReservableMedia;
import at.fhv.itb.lro3572.Media.Reservation;
import at.fhv.itb.lro3572.Media.Video;
import at.fhv.itb.lro3572.Person.Employee;
import at.fhv.itb.lro3572.Person.Role;
import at.fhv.itb.lro3572.Person.Student;
import at.fhv.itb.lro3572.Person.Teacher;
import at.fhv.itb.lro3572.Media.CD;
import at.fhv.itb.lro3572.Media.GameConsole;
import at.fhv.itb.lro3572.Media.VideoGame;

public class Library {
	private static Library _instance;
	private LinkedList<Reservation> _reservations;
	private LinkedList<Lending> _currLendings;
	private LinkedList<Role> _registeredUsers;
	private LinkedList<Media> _stock;
	private LinkedList<Employee> _employees;
	
	private Library() {
		_reservations = new LinkedList<>();
		_currLendings = new LinkedList<>();
		_registeredUsers = new LinkedList<>();
		_stock = new LinkedList<>();
		_employees = new LinkedList<>();
	}

//	getters
	public LinkedList<Reservation> getReservations() {
		return _reservations;
	}

	public LinkedList<Lending> getCurrLendings() {
		return _currLendings;
	}

	public LinkedList<Role> getRegisteredUsers() {
		return _registeredUsers;
	}

	public LinkedList<Media> getStock() {
		return _stock;
	}

	//  methods
	public static Library getInstance() {
		if (_instance == null) {
			_instance = new Library();
		}
		return _instance;
	}
	
	public void registerUser(Role user) {
		_registeredUsers.add(user);
	}
	
	public void addEmployee(Employee employee) {
		_employees.add(employee);
	}
	
	public void addMediaToStock(Media media) {
		_stock.add(media);
	}
	
	public void newLending(Role user, Media media, int lendingPeriod_weeks) {
		try {
			_currLendings.add(user.borrow(media, lendingPeriod_weeks));
			System.out.println("The lending for the " + media.getClass().getSimpleName() + " " + media.getTitle() + " has successfully been registered in the system!");
		} catch (AlreadyBorrowedException | LendingPeriodTooLongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void extendLending(Role user, Media media, int lendingPeriod_weeks) {
		try {
			System.out.println(user.extendLending(media, lendingPeriod_weeks));
		} catch (LendingPeriodTooLongException | LendingNotFoundException | ExtensionLimitExceededException
				| AlreadyReservedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void returnMedia(Role user, Media media) {
		System.out.println(user.returnMedia(media));
		
		for (Reservation r: _reservations) {
			if (r.getMedia().equals(media)) {
				System.out.println("Message to reserver " + r.getRole().getName() + ": The " + media.getClass().getSimpleName() + 
						" is available for pick up from the library.");
			}
		}
	}
	
	public void newReservation(Role user, ReservableMedia media) {
		try {
			Reservation r = user.reserve(media);
			_reservations.add(r); 
			System.out.println("The reservation with the number " + r.getReservationNumber() + " for the " + media.getClass().getSimpleName() + " " + media.getTitle() + " has successfully been registered in the system!");
		} catch (AlreadyReservedException | AlreadyBorrowedException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public void deleteReservation(Role user, int reservationNumber) {
		for (Reservation r: _reservations) {
			if (r.getReservationNumber() == reservationNumber) {
				r = null;
			}
		}
		System.out.println(user.deleteReservation(reservationNumber)); 
	}
	
	public void printCurrentLendings(Role user) {
		System.out.println(user.getCurrLendingsString());
	}
	
	public void printPastLendings(Role user, LocalDate start, LocalDate end) {
		System.out.println(user.getPastLendingsString(start, end));
	}
	
	public void printCurrentInventory(Employee employee) {
		System.out.println(employee.getCurrInventoryString());
	}
	
	public void checkMediaStatus(Employee employee, int mediaID) {
		System.out.println(employee.checkForMedia(mediaID));
	}
	
	public static void main(String[] args) {
		Library library = Library.getInstance();
		
		Role lea = new Student("Lea", "Bildstein");
		Role manuel = new Student("Manuel", "Wolfurt");
		Role sarah = new Teacher("Sarah", "Bludenz");
		Employee e = new Employee("Employee 1", "Dornbirn");
		library.registerUser(lea);
		library.registerUser(manuel);
		library.registerUser(sarah);
		library.addEmployee(e);
		
		Book atomicHabits = new Book("Atomic Habits", "978-1847941831", "James Clear");
		CD nevermind = new CD("Nevermind", "Nirvana", "Alternative Rock", "Geffen Records");
		VideoGame superMario = new VideoGame("Super Mario", GameConsole.Nintendo, "Nintendo");
		Magazine pragmaticus = new Magazine("Pragmaticus", "Der Pragmaticus Verlag AG ", "Faktenzeitschrift");
		Video iceAge = new Video("Ice Age", "Children's film", 0);
		library.addMediaToStock(atomicHabits);
		library.addMediaToStock(nevermind);
		library.addMediaToStock(superMario);
		library.addMediaToStock(pragmaticus);
		library.addMediaToStock(iceAge);
		
//		library.printCurrentInventory(e);
//		library.checkMediaStatus(e, 5);
//		library.newReservation(manuel, iceAge);
//		library.newLending(sarah, iceAge, 1);
//		library.extendLending(sarah, iceAge, 2);
//		library.extendLending(sarah, iceAge, 2);
//		library.extendLending(sarah, iceAge, 2);
		
		library.newLending(lea, nevermind, 2);
		library.newLending(lea, atomicHabits, 2);
		library.newLending(lea, superMario, 2);
		library.newLending(lea, iceAge, 2);
		library.printCurrentLendings(lea);
		library.printPastLendings(lea, LocalDate.of(2023, 5, 9), LocalDate.of(2023, 5, 15));
		library.returnMedia(lea, iceAge);
		library.returnMedia(lea, iceAge);
		
		
	}
}
