package at.fhv.itb.lro3572.Media;

import at.fhv.itb.lro3572.Library.Library;

public class Magazine extends ReservableMedia {
	private String _publisher;
	private String _category;
	
	public Magazine(String title, String publisher, String category) {
		super(title);
		_publisher = publisher;
		_category = category;
	}
	
	@Override
	public String getMediaInformationString() {
		boolean found = false;
		
		StringBuilder magazineInformation = new StringBuilder();
		magazineInformation.append(super.getMediaInformationString());
		magazineInformation.append("Publisher: " + _publisher + "\n");
		magazineInformation.append("Category: " + _category + "\n");
		for (Lending l: Library.getInstance().getCurrLendings()) {
			if (l.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			magazineInformation.append("Borrowed: True\n");
		}
		else {
			magazineInformation.append("Borrowed: False\n");
		}
		
		found = false;
		
		for (Reservation r: Library.getInstance().getReservations()) {
			if (r.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			magazineInformation.append("Reserved: True\n");
		}
		else {
			magazineInformation.append("Reserved: False\n");
		}
		magazineInformation.append("-----------------------------------------------------------------------");
		
		return magazineInformation.toString();
	}
}
