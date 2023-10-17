package at.fhv.itb.lro3572;

public enum Direction {
	North, East, South, West;
	
	public Direction opposite() {
		return Direction.values()[(ordinal() + 2) % Direction.values().length];
	}
}
