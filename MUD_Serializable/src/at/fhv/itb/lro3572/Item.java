package at.fhv.itb.lro3572;

import java.io.Serializable;

public abstract class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String _name;
	protected String _description;
	
	public Item(String name, String description) {
		_name = name;
		_description = description;
	}

	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}
	
	public abstract String use(Player player) throws PlayerDeadException;
}