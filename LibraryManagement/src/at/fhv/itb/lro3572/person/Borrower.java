package at.fhv.itb.lro3572.person;

import java.util.LinkedList;

import at.fhv.itb.lro3572.product.Product;
import at.fhv.itb.lro3572.product.ReservableProduct;

public class Borrower extends Person {
	private static int _count;
	private String _borrowerID;
	private Role _role;
	private LinkedList<Product> _currentlyBorrowed;
	private LinkedList<Product> _pastBorrowed;
	private LinkedList<ReservableProduct> _currentlyReserved;
	
	public Borrower(String name, String address, Role role) {
		super(name, address);
		_borrowerID = getNextID();
		_role = role;
		_currentlyBorrowed = new LinkedList<>();
		_pastBorrowed = new LinkedList<>();
		_currentlyReserved = new LinkedList<>();
	}
	
//	getter and setter
	public String getBorrowerID() {
		return _borrowerID;
	}

	public Role getRole() {
		return _role;
	}

	public LinkedList<Product> getCurrentlyBorrowed() {
		return _currentlyBorrowed;
	}

	public LinkedList<Product> getPastBorrowed() {
		return _pastBorrowed;
	}

	public LinkedList<ReservableProduct> getCurrentlyReserved() {
		return _currentlyReserved;
	}
	
//	methods
	private String getNextID() {
		_count += 1;
		return "B" + _count;
	}
	
	public void addCurrBorrowed(Product p) {
		_currentlyBorrowed.add(p);
	}
}
