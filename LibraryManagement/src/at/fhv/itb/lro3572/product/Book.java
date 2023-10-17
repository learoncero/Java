package at.fhv.itb.lro3572.product;

import at.fhv.itb.lro3572.exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.person.Borrower;

public class Book extends ReservableProduct {
	private String _isbnNumber;
	private String _author;
	
	
	public Book(String title, String isbnNumber, String author) {
		super(title);
		_isbnNumber = isbnNumber;
		_author = author;
	}
	
	public String getIsbnNumber() {
		return _isbnNumber;
	}

	public String getAuthor() {
		return _author;
	}

	@Override
	public String borrow(Borrower borrower, int lendingPeriod_Weeks) throws AlreadyBorrowedException, 
	LendingPeriodTooLongException, AlreadyReservedException {
		if (lendingPeriod_Weeks > borrower.getRole().getMaxLendingPeriodBoMa_Weeks()) {
			throw new LendingPeriodTooLongException("The maximum lending period for books is " + borrower.getRole().getMaxLendingPeriodBoMa_Weeks() + " weeks.");
		}
		else if (_borrowedBy != null) {
			throw new AlreadyBorrowedException("This book is already borrowed by someone else. Due date: " + _dueDate);
		}
		else {
			try {
				super.borrow(borrower, lendingPeriod_Weeks);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
		return "The book with the title " + _title + " has successfully been borrowed.";
	}
	
	@Override
	public String extendBorrowing(int extension_Weeks) throws AlreadyReservedException, LendingPeriodTooLongException, ExtensionLimitExceededException {
		if (extension_Weeks > this.getBorrowedBy().getRole().getMaxLendingPeriodBoMa_Weeks()) {
			throw new LendingPeriodTooLongException("The maximum extension period for books is " + this.getBorrowedBy().getRole().getMaxLendingPeriodBoMa_Weeks() + " weeks.");
		}
		else {
			super.extendBorrowing(extension_Weeks);
		}
		_countExtensions += 1;
		return "The due date for the book " + _title + " has successfully been extended.";
	}
}
