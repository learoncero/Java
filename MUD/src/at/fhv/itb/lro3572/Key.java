package at.fhv.itb.lro3572;

public class Key extends Item {
	private Door _corrDoor;
	
	public Key (String name, String description, Door correspondingDoor) {
		super(name, description);
		_corrDoor = correspondingDoor;
	}
	
	public Door getCorrDoor() {
		return _corrDoor;
	}
	
	public void openDoor(Player player) {
		_corrDoor.setLocked(false);
		player.deleteItemInventory(this);
	}
	
	@Override
	public String use(Player player) throws PlayerDeadException {
		return "Schlüssel kann nicht verwendet werden!";
	}
	
}
