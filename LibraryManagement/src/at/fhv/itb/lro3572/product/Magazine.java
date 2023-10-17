package at.fhv.itb.lro3572.product;

import at.fhv.itb.lro3572.exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.person.Borrower;

public class Magazine extends ReservableProduct {
	private String _publisher;
	private String _category;
	
	public Magazine(String title, String publisher, String category) {
		super(title);
		_publisher = publisher;
		_category = category;
	}
	
	public String getPublisher() {
		return _publisher;
	}

	public String getCategory() {
		return _category;
	}

	@Override
	public String borrow(Borrower borrower, int lendingPeriod_Weeks) throws AlreadyBorrowedException, LendingPeriodTooLongException {
		if (lendingPeriod_Weeks > borrower.getRole().getMaxLendingPeriodBoMa_Weeks()) {
			throw new LendingPeriodTooLongException("The maximum lending period for magazines is" + borrower.getRole().getMaxLendingPeriodBoMa_Weeks() + "weeks.");
		}
		else if (_borrowedBy != null) {
			throw new AlreadyBorrowedException("This magazine is already borrowed by someone else. Due date: " + _dueDate);
		}
		else {
			try {
				super.borrow(borrower, lendingPeriod_Weeks);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
		return "The Magazine with the title " + _title + " has successfully been borrowed.";
	}
	
	@Override
	public String extendBorrowing(int extension_Weeks) throws AlreadyReservedException, LendingPeriodTooLongException, ExtensionLimitExceededException {
		if (extension_Weeks > this.getBorrowedBy().getRole().getMaxLendingPeriodBoMa_Weeks()) {
			throw new LendingPeriodTooLongException("The maximum extension period for magazines is " + this.getBorrowedBy().getRole().getMaxLendingPeriodBoMa_Weeks() + " weeks.");
		}
		else {
			return "The due date for the magazine " + _title + " has successfully been extended.";
		}
	}

}
