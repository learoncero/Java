package at.fhv.itb.lro3572.Media;

import at.fhv.itb.lro3572.Library.Library;

public class Video extends ReservableMedia {
	private String _genre;
	private int _ageLimit;
	
	public Video(String title, String genre, int ageLimit) {
		super(title);
		_genre = genre;
		_ageLimit = ageLimit;
	}
	
	@Override
	public String getMediaInformationString() {
		boolean found = false;
		
		StringBuilder videoInformation = new StringBuilder();
		videoInformation.append(super.getMediaInformationString());
		videoInformation.append("Genre: " + _genre + "\n");
		videoInformation.append("Age Limit: " + _ageLimit + "\n");
		for (Lending l: Library.getInstance().getCurrLendings()) {
			if (l.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			videoInformation.append("Borrowed: True\n");
		}
		else {
			videoInformation.append("Borrowed: False\n");
		}
		
		found = false;
		
		for (Reservation r: Library.getInstance().getReservations()) {
			if (r.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			videoInformation.append("Reserved: True\n");
		}
		else {
			videoInformation.append("Reserved: False\n");
		}
		videoInformation.append("-----------------------------------------------------------------------");
		
		return videoInformation.toString();
	}
}
