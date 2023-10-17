package at.fhv.itb.lro3572.Media;

public abstract class Media {
	private static int _count = 0;
	private int _mediaID;
	protected String _title;
	
	public Media(String title) {
		_mediaID = getNextID();
		_title = title;
	}
	
//	getters and setters
	public int getMediaID() {
		return _mediaID;
	}

	public void setMediaID(int mediaID) {
		_mediaID = mediaID;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}
	
//	methods
	private int getNextID() {
		return _count += 1;
	}
	
	public String getMediaInformationString() {
		StringBuilder mediaInformation = new StringBuilder();
		mediaInformation.append("-----------------------------------------------------------------------\n");
		mediaInformation.append("Media Type: " + getClass().getSimpleName() + "\n");
		mediaInformation.append("ID: " + _mediaID + "\n");
		mediaInformation.append("Title: " + _title + "\n");
		
		return mediaInformation.toString();
	}
}
