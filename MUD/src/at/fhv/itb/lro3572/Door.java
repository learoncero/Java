package at.fhv.itb.lro3572;

public class Door extends Cell {
	private Cell[] _corrFields;
	private boolean _locked;
	
	public Door(String name, String description, Cell f1, Cell f2, Boolean locked) {
		super(name, description);
		_corrFields = new Cell[2];
		_corrFields[0] = f1;
		_corrFields[1] = f2;
		_locked = locked;
	}
	
	public Cell[] getCorrFields() {
		return _corrFields;
	}

	public boolean getLocked() {
		return _locked;
	}

	public void setLocked(boolean locked) {
		_locked = locked;
	}

	@Override
	public void enter(Player player) throws NotEnterableException {
		if (_locked) {
			for (Item item: player.getInventory()) {
				if (item instanceof Key) {
					Key key = (Key) item;
					if (key.getCorrDoor().equals(this)) {
						key.openDoor(player);
					}
				}
			}
		}
		if (_locked == false) {
			if (player.getPosition().equals(_corrFields[0])) {
				player.getPosition().getPlayersOnField().remove(player);
				Field f = (Field) _corrFields[1];
				player.setPosition(f);
				f.addPlayer(player);		
			}
			else {
				player.getPosition().getPlayersOnField().remove(player);
				Field f = (Field) _corrFields[0];
				player.setPosition(f);
				f.addPlayer(player);	
			}
			return;
		}
		throw new NotEnterableException("Die Tür ist verschlossen. Du brauchst den passenden Schlüssel, um sie zu öffnen!");
	}
}
