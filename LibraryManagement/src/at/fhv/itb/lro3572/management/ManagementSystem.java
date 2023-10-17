package at.fhv.itb.lro3572.management;

import java.util.LinkedList;

import at.fhv.itb.lro3572.exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.person.Borrower;
import at.fhv.itb.lro3572.person.Employee;
import at.fhv.itb.lro3572.person.ExternalPersonRole;
import at.fhv.itb.lro3572.product.Book;
import at.fhv.itb.lro3572.product.CD;
import at.fhv.itb.lro3572.product.GameConsole;
import at.fhv.itb.lro3572.product.Product;
import at.fhv.itb.lro3572.product.ReservableProduct;
import at.fhv.itb.lro3572.product.VideoGame;
import at.fhv.itb.lro3572.person.StudentRole;

public class ManagementSystem {
	private static ManagementSystem _instance;
	private LinkedList<Employee> _employees;
	private LinkedList<Borrower> _borrowers;
	private LinkedList<Product> _mediums;
	
	private ManagementSystem() {
		_employees = new LinkedList<>();
	    _borrowers = new LinkedList<>();
	    _mediums = new LinkedList<>();
	}
	
//	methods
	public static ManagementSystem getInstance() {
		if (_instance == null) {
			_instance = new ManagementSystem();
		}
		return _instance;
	}
	
	public void registerBorrower(Borrower borrower) {
		_borrowers.add(borrower);
	}
	
	public void addEmployee(Employee e) {
		_employees.add(e);
	}
	
	public void addProduct(Product product) {
		_mediums.add(product);
	}
	
	public void printSpecificProductInformation(Employee employee, int productID) {
		for (Product p: _mediums) {
			if (p.getProductID() == productID) {
				System.out.println("--------------------------------------------------------------");
				System.out.println("Product Type: " + p.getClass().getSimpleName() + ", ID: " + p.getProductID() +
						", Title: " + p.getTitle());
				
				if (p.getBorrowedBy() != null) {
					System.out.println("Lending Status: ");
					System.out.println("  - Borrowed by: " + p.getBorrowedBy().getBorrowerID() + ", " + 
					p.getBorrowedBy().getName());
					System.out.println("  - Due date: " + p.getDueDate());
				}
				else {
					System.out.println("Lending Status: Available");
				}
				
				if (p instanceof ReservableProduct) {
					ReservableProduct rp = (ReservableProduct) p;
					if (rp.getReservedBy() != null) {
						System.out.println("Reservation: " + rp.getReservedBy().getBorrowerID() + ", " +
						rp.getReservedBy().getName());
					}
					else {
						System.out.println("Reservation: NONE");
					}
				}
				System.out.println("--------------------------------------------------------------");
			}
		}
	}
	
	public void printInventory(Employee employee) {
		System.out.println("Inventory:");
		for (Product p: _mediums) {
			int id = p.getProductID();
			printSpecificProductInformation(employee, id);
		}
	}
	
	public void newBorrowing(Product product, Borrower borrower, int lendingPeriod_Weeks) {
		if (_borrowers.contains(borrower)) {
			try {
				System.out.println(product.borrow(borrower, lendingPeriod_Weeks));
			} catch (AlreadyBorrowedException | LendingPeriodTooLongException | AlreadyReservedException | ExtensionLimitExceededException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("You must first be registered in the system.");
		}
	}
	
	public void extendBorrowing(Product product, int extension_weeks) {
		try {
		 	System.out.println(product.extendBorrowing(extension_weeks));
		} catch (AlreadyReservedException | LendingPeriodTooLongException | ExtensionLimitExceededException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void returnProduct(Product product) {
		checkForReservations(product);
		System.out.println(product.returnProduct());
	}
	
	private void checkForReservations(Product p) {
		if (p instanceof ReservableProduct) {
			ReservableProduct rp = (ReservableProduct) p;
			if (rp.getReservedBy() != null) {
				informReserver(rp);
			}
		}
	}
	
	private void informReserver(ReservableProduct rp) {
		System.out.println("Message to Person with ID " + rp.getReservedBy().getBorrowerID() + ": Product with title "
				+ rp.getTitle() + " has been returned to the library.");
	}
	
	public void newReservation(ReservableProduct rProduct, Borrower borrower) {
		try {
			System.out.println(rProduct.reserve(borrower));
		} catch (AlreadyReservedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteReservation(ReservableProduct rProduct) {
		System.out.println(rProduct.deleteReservation());
	}
	
	public void printCurrentlyBorrowed(Borrower b) {
		System.out.println("--------------------------------------------------------------");
		if (b.getCurrentlyBorrowed().isEmpty()) {
			System.out.println("Currently borrowed products by borrower " + b.getName() + ": NONE");
		}
		else {
			System.out.println("Currently borrowed products by borrower " + b.getName() + ": ");
			for (Product p: b.getCurrentlyBorrowed()) {
				System.out.println("  - Product ID: " + p.getProductID() + ", Title: " + p.getTitle());
			}
		}
		System.out.println("--------------------------------------------------------------");
	}
	
	public void printPastBorrowed(Borrower b) {
		System.out.println("Products borrowed in the past: ");
		for (Product p: b.getPastBorrowed()) {
			System.out.println("  - Product ID: " + p.getProductID() + ", Title: " + p.getTitle());
		}
	}
	
	public static void main(String[] args) {
		ManagementSystem ms = ManagementSystem.getInstance();
		
		Book atomicHabits = new Book("Atomic Habits", "978-1847941831", "James Clear");
		CD nevermind = new CD("Nevermind", "Nirvana", "Alternative Rock", "Geffen Records");
		VideoGame superMario = new VideoGame("Super Mario", GameConsole.Nintendo, "Nintendo");
		
		ms.addProduct(atomicHabits);
		ms.addProduct(nevermind);
		ms.addProduct(superMario);
		
		Borrower b1 = new Borrower("Mustermann", "Dorf 251 6858 Bildstein", new StudentRole());
		Borrower b2 = new Borrower("Musterfrau", "Hochschulstraße 1 6850 Dornbirn", new ExternalPersonRole());
		ms.registerBorrower(b1);
		ms.registerBorrower(b2);
		
		Employee e1 = new Employee("Angestellter 1", "ABCD");
		ms.addEmployee(e1);
		
		ms.newBorrowing(atomicHabits, b1, 1);
		ms.newBorrowing(superMario, b1, 2);
		ms.printCurrentlyBorrowed(b1);
//		ms.newReservation(atomicHabits, b2);
		ms.extendBorrowing(atomicHabits, 2);
		ms.extendBorrowing(atomicHabits, 2);
		
//		ms.returnProduct(atomicHabits);
//		ms.deleteReservation(atomicHabits);
//		ms.newBorrowing(atomicHabits, b1, 1);
		
//		ms.printInventory(e1);
		
//		ms.printCurrentlyBorrowed(b1);
//		ms.returnProduct(superMario);
//		ms.printPastBorrowed(b1);
//		ms.printPastBorrowed(b1);
		
	}
}
                    