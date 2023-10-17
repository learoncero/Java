package at.fhv.itb.lro3572.Media;

import at.fhv.itb.lro3572.Library.Library;

public class Book extends ReservableMedia {
	private String _isbnNumber;
	private String _author;
	
	public Book(String title, String isbnNumber, String author) {
		super(title);
		_isbnNumber = isbnNumber;
		_author = author;
	}
	
	@Override
	public String getMediaInformationString() {
		boolean found = false;
		
		StringBuilder bookInformation = new StringBuilder();
		bookInformation.append(super.getMediaInformationString());
		bookInformation.append("ISBN number: " + _isbnNumber + "\n");
		bookInformation.append("Author: " + _author + "\n");
		for (Lending l: Library.getInstance().getCurrLendings()) {
			if (l.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			bookInformation.append("Borrowed: True\n");
		}
		else {
			bookInformation.append("Borrowed: False\n");
		}
		
		found = false;
		
		for (Reservation r: Library.getInstance().getReservations()) {
			if (r.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			bookInformation.append("Reserved: True\n");
		}
		else {
			bookInformation.append("Reserved: False\n");
		}
		bookInformation.append("-----------------------------------------------------------------------");
		
		return bookInformation.toString();
	}
}
