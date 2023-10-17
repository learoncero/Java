package at.fhv.itb.lro3572.product;

import at.fhv.itb.lro3572.exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.person.Borrower;

public class VideoGame extends Product {
	private GameConsole _corrGameConsole;
	private String _company;
	
	public VideoGame(String title, GameConsole corrGameConsole, String company) {
		super(title);
		_corrGameConsole = corrGameConsole;
		_company = company;
	}
	
	@Override
	public String borrow(Borrower borrower, int lendingPeriod_Weeks) throws AlreadyBorrowedException, LendingPeriodTooLongException {
		if (lendingPeriod_Weeks > borrower.getRole().getMaxLendingPeriodOther_Weeks()) {
			throw new LendingPeriodTooLongException("The maximum lending period for video games is " + borrower.getRole().getMaxLendingPeriodOther_Weeks() + " weeks.");
		}
		else if (_borrowedBy != null) {
			throw new AlreadyBorrowedException("This video game is already borrowed by someone else. Due date: " + _dueDate);
		}
		else {
			try {
				super.borrow(borrower, lendingPeriod_Weeks);
			} catch (Exception e) {
				return e.getMessage();
			}
		}
		return "The video game with the title " + _title + " has successfully been borrowed.";
	}
	
	@Override
	public String extendBorrowing(int extension_Weeks) throws AlreadyReservedException, LendingPeriodTooLongException, ExtensionLimitExceededException {
		if (extension_Weeks > this.getBorrowedBy().getRole().getMaxLendingPeriodBoMa_Weeks()) {
			throw new LendingPeriodTooLongException("The maximum extension period for video games is " + this.getBorrowedBy().getRole().getMaxLendingPeriodBoMa_Weeks() + " weeks.");
		}
		else {
			return "The due date for the video game " + _title + " has successfully been extended.";
		}
	}
}
