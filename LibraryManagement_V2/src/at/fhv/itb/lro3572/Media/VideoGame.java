package at.fhv.itb.lro3572.Media;

import at.fhv.itb.lro3572.Library.Library;

public class VideoGame extends Media {
	private GameConsole _corrGameConsole;
	private String _company;
	
	public VideoGame(String title, GameConsole corrGameConsole, String company) {
		super(title);
		_corrGameConsole = corrGameConsole;
		_company = company;
	}
	
	@Override
	public String getMediaInformationString() {
		boolean found = false;
		
		StringBuilder videoGameInformation = new StringBuilder();
		videoGameInformation.append(super.getMediaInformationString());
		videoGameInformation.append("Game Console: " + _corrGameConsole + "\n");
		videoGameInformation.append("Company: " + _company + "\n");
		for (Lending l: Library.getInstance().getCurrLendings()) {
			if (l.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			videoGameInformation.append("Borrowed: True\n");
		}
		else {
			videoGameInformation.append("Borrowed: False\n");
		}
		
		found = false;
		
		for (Reservation r: Library.getInstance().getReservations()) {
			if (r.getMedia().equals(this)) {
				found = true;
			}
		}
		if (found == true) {
			videoGameInformation.append("Reserved: True\n");
		}
		else {
			videoGameInformation.append("Reserved: False\n");
		}
		videoGameInformation.append("-----------------------------------------------------------------------");
		
		return videoGameInformation.toString();
	}
}
