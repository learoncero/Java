package at.fhv.itb.lro3572.product;

import java.time.LocalDate;

import at.fhv.itb.lro3572.exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.person.Borrower;

public abstract class Product {
	private static int _count = 0;
	private int _productID;
	protected String _title;
	protected Borrower _borrowedBy;
	protected LocalDate _dueDate;
	protected int _countExtensions;
	
	public Product(String title) {
		_productID = getNextID();
		_title = title;
		_borrowedBy = null;
		_dueDate = LocalDate.now();
		_countExtensions = 0;
	}
	
	public int getProductID() {
		return _productID;
	}

	public String getTitle() {
		return _title;
	}

	public Borrower getBorrowedBy() {
		return _borrowedBy;
	}

	public void setBorrowedBy(Borrower borrowedBy) {
		_borrowedBy = borrowedBy;
	}

	public LocalDate getDueDate() {
		return _dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		_dueDate = dueDate;
	}
	
//	methods
	private int getNextID() {
		return _count += 1;
	}

	public String borrow(Borrower borrower, int lendingPeriod_Weeks) throws AlreadyBorrowedException, 
	LendingPeriodTooLongException, AlreadyReservedException, ExtensionLimitExceededException {
		_borrowedBy = borrower;
		borrower.getCurrentlyBorrowed().add(this);
		_dueDate = _dueDate.plusWeeks(lendingPeriod_Weeks);
		return "";
	}
	
	public String returnProduct() {
		_borrowedBy.getCurrentlyBorrowed().remove(this);
		_borrowedBy.getPastBorrowed().add(this);
		_borrowedBy = null;
		_dueDate = LocalDate.now();
		_countExtensions = 0;
		
		return "The product with the title " + _title + " has successfully been returned.";
	}
	
	public String extendBorrowing(int extension_Weeks) throws AlreadyReservedException, LendingPeriodTooLongException, ExtensionLimitExceededException {
		if (_countExtensions < _borrowedBy.getRole().getMaxExtensions()) {
			_dueDate = _dueDate.plusWeeks(extension_Weeks);
		}
		else {
			throw new ExtensionLimitExceededException("The extension limit has already been reached and the borrowing cannot be extended again.");
		}
		
		return "";
	}

}
