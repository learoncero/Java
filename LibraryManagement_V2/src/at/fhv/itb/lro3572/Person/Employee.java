package at.fhv.itb.lro3572.Person;

import at.fhv.itb.lro3572.Library.Library;
import at.fhv.itb.lro3572.Media.Media;

public class Employee {
	private String _name;
	private String _address;
	
	public Employee (String name, String address) {
		_name = name;
		_address = address;
	}

	public String getName() {
		return _name;
	}

	public String getAddress() {
		return _address;
	}
	
	public String getCurrInventoryString() {
		StringBuilder stock = new StringBuilder();
		stock.append("-----------------------------------------------------------------------\n");
		stock.append("Current inventory:\n");
		for (Media media: Library.getInstance().getStock()) {
			stock.append("  - " + media.getClass().getSimpleName() + " ID " + media.getMediaID() + ", " + media.getTitle() + "\n");
		}
		stock.append("-----------------------------------------------------------------------");
		return stock.toString();
	}
	
	public String checkForMedia(int mediaID) {
		StringBuilder mediaInformation = new StringBuilder();
		for (Media media: Library.getInstance().getStock()) {
			if (media.getMediaID() == mediaID) {
				mediaInformation.append(media.getMediaInformationString());
			}
		}
		return mediaInformation.toString();
	}
}
