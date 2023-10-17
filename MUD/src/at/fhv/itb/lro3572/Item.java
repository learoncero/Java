package at.fhv.itb.lro3572;

public abstract class Item {
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