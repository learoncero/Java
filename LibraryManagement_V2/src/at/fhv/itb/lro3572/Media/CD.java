package at.fhv.itb.lro3572.Media;

import at.fhv.itb.lro3572.Library.Library;

public class CD extends ReservableMedia {
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
	public String getMediaInformationString() {
		boolean found = false;
		
		StringBuilder cdInformation = new StringBuilder();
		cdInformation.append(super.getMediaInformationString());
		cdInformation.append("Artist: " + _artist + "\n");
		cdInformation.append("Genre: " + _genre + "\n");
		cdInformation.append("Label: " + _label + "\n");
		for (Lending l: Library.getInstance().getCurrLendings()) {
			if (l.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			cdInformation.append("Borrowed: True\n");
		}
		else {
			cdInformation.append("Borrowed: False\n");
		}
		
		found = false;
		
		for (Reservation r: Library.getInstance().getReservations()) {
			if (r.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			cdInformation.append("Reserved: True\n");
		}
		else {
			cdInformation.append("Reserved: False\n");
		}
		cdInformation.append("-----------------------------------------------------------------------");
		
		return cdInformation.toString();
	}
}
