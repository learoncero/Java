package at.fhv.itb.lro3572.product;

import at.fhv.itb.lro3572.exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.person.Borrower;

public abstract class ReservableProduct extends Product {
	private Borrower _reservedBy;
	
	public ReservableProduct(String title) {
		super(title);
		_reservedBy = null;
	}
	
//	getter and setter
	public Borrower getReservedBy() {
		return _reservedBy;
	}

	public void setReservedBy(Borrower reservedBy) {
		_reservedBy = reservedBy;
	}
	
//	methods
	@Override
	public String borrow(Borrower borrower, int lendingPeriod_Weeks) throws AlreadyBorrowedException, 
	LendingPeriodTooLongException, AlreadyReservedException, ExtensionLimitExceededException {
		if (_reservedBy != null) {
			if (!_reservedBy.equals(borrower)) {
				throw new AlreadyReservedException("This product is already reserved by someone else.");
			}
			else {
				_reservedBy = null;
			}
		}
		super.borrow(borrower, lendingPeriod_Weeks);
		return "";
	}
	
	@Override
	public String extendBorrowing(int extension_Weeks) throws AlreadyReservedException, LendingPeriodTooLongException, ExtensionLimitExceededException {
		if (_reservedBy != null) {
			throw new AlreadyReservedException("The borrowing cannot be extended because the product is reserved by someone else.");
		}
		else {
			super.extendBorrowing(extension_Weeks);
			return "";
		}
	}
	
	public String reserve(Borrower borrower) throws AlreadyReservedException {
		if (_reservedBy == null) {
			_reservedBy = borrower;
			return "The product with the title " + _title + " has successfully been reserved.";
		}
		else {
			throw new AlreadyReservedException("This product is already reserved by someone else.");
		}
	}
	
	public String deleteReservation() {
		_reservedBy = null;
		return "The reservation has been deleted.";
	}

}
