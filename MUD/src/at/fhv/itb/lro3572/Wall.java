package at.fhv.itb.lro3572;

public class Wall extends Cell {
	Cell _corrCell;
	
	public Wall(Cell corrCell) {
		super("Wall", null);
		_corrCell = corrCell;
	}
	
	public Cell getCorrCell() {
		return _corrCell;
	}

	@Override
	public void enter(Player player) throws NotEnterableException {
		throw new NotEnterableException("Dachtest du wirklich, du kannst in eine Wand hineingehen?");
	}

}
