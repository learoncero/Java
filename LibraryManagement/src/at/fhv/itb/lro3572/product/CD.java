package at.fhv.itb.lro3572.product;

import at.fhv.itb.lro3572.exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.person.Borrower;

public class CD extends ReservableProduct {
	private String _artist;
	private String _genre;
	private String _label;
	
	public CD(String title, String artist, String genre, String label) {
		super(title);
		_artist = artist;
		_genre = genre;
		_label = label;
	}
	
	@Override
	public String borrow(Borrower borrower, int lendingPeriod_Weeks) throws AlreadyReservedException, LendingPeriodTooLongException, ExtensionLimitExceededException, AlreadyBorrowedException {
		if (lendingPeriod_Weeks > borrower.getRole().getMaxLendingPeriodOther_Weeks()) {
			throw new LendingPeriodTooLongException("The maximum lending period for CDs is" + borrower.getRole().getMaxLendingPeriodOther_Weeks() + " weeks.");
		}
		else if (_borrowedBy != null) {
			throw new AlreadyBorrowedException("This CD is already borrowed by someone else. Due date: " + _dueDate);
		}
		else {
			try {
				super.borrow(borrower, lendingPeriod_Weeks);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
		return "The CD with the title " + _title + " has successfully been borrowed.";
	}
	
	@Override
	public String extendBorrowing(int extension_Weeks) throws AlreadyReservedException, LendingPeriodTooLongException {
		if (extension_Weeks > this.getBorrowedBy().getRole().getMaxLendingPeriodBoMa_Weeks()) {
			throw new LendingPeriodTooLongException("The maximum extension period for CDs is " + this.getBorrowedBy().getRole().getMaxLendingPeriodBoMa_Weeks() + " weeks.");
		}
		else {
			return "The due date for the CD " + _title + " has successfully been extended.";
		}
	}
}
