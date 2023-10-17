package at.fhv.itb.lro3572;

import java.io.Serializable;

public abstract class Cell implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String _name;
	protected String _description;
	
	public Cell(String shortDescription, String detailedDescription) {
		_name = shortDescription;
		_description = detailedDescription;
	}
	
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public abstract void enter(Player player) throws NotEnterableException;
}
