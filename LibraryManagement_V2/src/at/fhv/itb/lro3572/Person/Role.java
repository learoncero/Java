package at.fhv.itb.lro3572.Person;

import java.time.LocalDate;
import java.util.LinkedList;

import at.fhv.itb.lro3572.Exceptions.AlreadyBorrowedException;
import at.fhv.itb.lro3572.Exceptions.AlreadyReservedException;
import at.fhv.itb.lro3572.Exceptions.ExtensionLimitExceededException;
import at.fhv.itb.lro3572.Exceptions.LendingNotFoundException;
import at.fhv.itb.lro3572.Exceptions.LendingPeriodTooLongException;
import at.fhv.itb.lro3572.Library.Library;
import at.fhv.itb.lro3572.Media.Book;
import at.fhv.itb.lro3572.Media.CD;
import at.fhv.itb.lro3572.Media.Lending;
import at.fhv.itb.lro3572.Media.Magazine;
import at.fhv.itb.lro3572.Media.Media;
import at.fhv.itb.lro3572.Media.ReservableMedia;
import at.fhv.itb.lro3572.Media.Reservation;
import at.fhv.itb.lro3572.Media.Video;
import at.fhv.itb.lro3572.Media.VideoGame;

public abstract class Role {
	private static int _count = 0;
	private int _userID;
	private String _name;
	private String _address;
	protected int _lendingPeriodPrintMedia_weeks;
	protected int _lendingPeriodOther_weeks;
	protected int _maxExtensions;
	protected LinkedList<Lending> _lendings;
	private LinkedList<Reservation> _reservations;
	
	public Role(String name, String address) {
		_userID = getNextID();
		_name = name;
		_address = address;
		_lendings = new LinkedList<>();
		_reservations = new LinkedList<>();
	}
	
//	getters and setters
	public int getUserID() {
		return _userID;
	}

	public String getName() {
		return _name;
	}

	public String getAddress() {
		return _address;
	}

	public int getLendingPeriodPrintMedia_weeks() {
		return _lendingPeriodPrintMedia_weeks;
	}

	public int getLendingPeriodOther_weeks() {
		return _lendingPeriodOther_weeks;
	}

	public int getMaxExtensions() {
		return _maxExtensions;
	}

	public LinkedList<Lending> getLendings() {
		return _lendings;
	}

	public LinkedList<Reservation> getReservations() {
		return _reservations;
	}

	
//	methods
	private int getNextID() {
		return _count += 1;
	}
	
	public Lending borrow(Media media, int lendingPeriod) throws AlreadyBorrowedException, LendingPeriodTooLongException {
		checkLendingPeriod(media, lendingPeriod);
		
		for (Lending lending: Library.getInstance().getCurrLendings()) {
			if (lending.getMedia().equals(media)) {
				throw new AlreadyBorrowedException("This media is already borrowed by someone else.");
			}
		}
		Lending lending = new Lending(this, media, lendingPeriod);
		_lendings.add(lending);
		return lending;
	}
	
	public String extendLending(Media media, int lendingPeriod_weeks) throws LendingPeriodTooLongException, LendingNotFoundException, ExtensionLimitExceededException, AlreadyReservedException {
		checkLendingPeriod(media, lendingPeriod_weeks);
		
		if (media instanceof ReservableMedia) {
			ReservableMedia rMedia = (ReservableMedia) media;
			checkForReservations(rMedia);
		}
		
		for (Lending lending: _lendings) {
			if (lending.getMedia().equals(media)) {
				if (lending.getExtensions() < _maxExtensions) {
					lending.setDueDate(lending.getDueDate().plusWeeks(lendingPeriod_weeks));
					lending.setExtensions(lending.getExtensions() + 1);
					return "Extension for the " + media.getClass().getSimpleName() + " " + media.getTitle() + " successful! New "
					+ "due date: " + lending.getDueDate();
				}
				else {
					throw new ExtensionLimitExceededException("The maximum number of extensions for this lending has already been reached.");
				}
			}
		}
		throw new LendingNotFoundException("No actual lending for this media.");
	}
	
	private void checkLendingPeriod (Media media, int lendingPeriod) throws LendingPeriodTooLongException {
		if (((media instanceof Book) | (media instanceof Magazine)) && (lendingPeriod > _lendingPeriodPrintMedia_weeks)) {
			throw new LendingPeriodTooLongException("The maximum lending period for books and magazines is " 
				+ _lendingPeriodPrintMedia_weeks + " weeks.");
		}
		else if (((media instanceof CD) | (media instanceof Video) | (media instanceof VideoGame)) && (lendingPeriod > _lendingPeriodOther_weeks)) {
			throw new LendingPeriodTooLongException("The maximum lending period for CDs, videos and video games is " 
					+ _lendingPeriodOther_weeks + " weeks.");
		}
	}
	
	private void checkForReservations(ReservableMedia rMedia) throws AlreadyReservedException {
		for (Reservation r: Library.getInstance().getReservations()) {
			if (r.getMedia().equals(rMedia)) {
				throw new AlreadyReservedException("The " + rMedia.getClass().getSimpleName() + " " + rMedia.getTitle() + " is already reserved by someone else.");
			}
		}
	}
	
	public String returnMedia(Media media) {
		for (Lending lending: _lendings) {
			if ((lending.getMedia().equals(media)) && (lending.getDueDate().isAfter(LocalDate.now()))) {
				lending.setDueDate(LocalDate.now());
				for (Lending l: Library.getInstance().getCurrLendings()) {
					if (l.getMedia().equals(media)) {
						l = null;
						return "Return successful.";
					}
				}
			}
		}
			
		return "Media is currently not borrowed.";
	}
	
	public Reservation reserve(ReservableMedia rMedia) throws AlreadyReservedException, AlreadyBorrowedException {
		checkForReservations(rMedia);
		
		Reservation r = new Reservation(rMedia, this);
		_reservations.add(r);
		return r;
	}
	
	public String deleteReservation(int reservationNumber) {
		for (Reservation r: _reservations) {
			if (r.getReservationNumber() == reservationNumber) {
				r = null;
			}
		}
		return "The reservation has successfully been deleted!";
	}
	
	public String getCurrLendingsString() {
		StringBuilder currLending = new StringBuilder();
		currLending.append("-----------------------------------------------------------------------\n");
		currLending.append("Current lendings from " + _name + ", user ID " + _userID + ":\n");
		for (Lending lending: _lendings) {
			if (lending.getDueDate().isAfter(LocalDate.now())) {
				currLending.append("  - " + lending.getMedia().getClass().getSimpleName() + ", " + lending.getMedia().getTitle() + "\n");
			}
		}
		currLending.append("-----------------------------------------------------------------------\n");
		return currLending.toString();
	}
	
	public String getPastLendingsString(LocalDate start, LocalDate end) {
		StringBuilder pastLendings = new StringBuilder();
		pastLendings.append("-----------------------------------------------------------------------\n");
		pastLendings.append("Past lendings: Period " + start + " - " + end + "\n");
		for (Lending lending: _lendings) {
			if ((lending.getStartDate().isAfter(start)) && (lending.getStartDate().isBefore(end))) {
				pastLendings.append("  - " + lending.getMedia().getClass().getSimpleName() + ", " + lending.getMedia().getTitle() + "\n");
			}
		}
		pastLendings.append("-----------------------------------------------------------------------\n");
		return pastLendings.toString();
	}
}
