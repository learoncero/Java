package at.fhv.itb.lro3572;

public class StartField extends Field {
	private static StartField _instance;
	
//	start constructor
	private StartField(String shortDescription, String detailedDescription) {
		super(shortDescription, detailedDescription);
	}
	
	private StartField(String shortDescription, String detailedDescription, Cell neighbourNorth, Cell neighbourEast, Cell neighbourSouth, Cell neighbourWest) {
		super(shortDescription, detailedDescription, neighbourNorth, neighbourEast, neighbourSouth, neighbourWest);
	}
	
//	start methods
	public static StartField instance(String shortDescription, String detailedDescription, Cell neighbourNorth, Cell neighbourEast, Cell neighbourSouth, Cell neighbourWest) {
		if (_instance == null) {
			_instance = new StartField(shortDescription, detailedDescription, neighbourNorth, neighbourEast, neighbourSouth, neighbourWest);
		}
		return _instance;
	}
	
	public static StartField instance(String shortDescription, String detailedDescription) {
		if (_instance == null) {
			_instance = new StartField(shortDescription, detailedDescription);
		}
		return _instance;
	}
}
