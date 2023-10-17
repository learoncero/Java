package at.fhv.itb.lro3572.Media;

import at.fhv.itb.lro3572.Person.Role;

public class Reservation {
	private static int _count = 0;
	private int _reservationNumber;
	private ReservableMedia _media;
	private Role _role;
	
	public Reservation(ReservableMedia rMedia, Role role) {
		_reservationNumber = getNextReservationNumber();
		_media = rMedia;
		_role = role;
	}
	
	public int getReservationNumber() {
		return _reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		_reservationNumber = reservationNumber;
	}

	public ReservableMedia getMedia() {
		return _media;
	}

	public void setMedia(ReservableMedia media) {
		_media = media;
	}

	public Role getRole() {
		return _role;
	}

	public void setRole(Role role) {
		_role = role;
	}

	private int getNextReservationNumber() {
		return _count += 1;
	}
}
