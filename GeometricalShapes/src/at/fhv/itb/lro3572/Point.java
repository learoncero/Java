package at.fhv.itb.lro3572;

public class Point {
	private int _x;
	private int _y;
	
	public Point(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public Point() {
		this(0, 0);
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	public void setX(int x) {
		_x = x;
	}
	
	public void setY(int y) {
		_y = y;
	}

	@Override
	public String toString() {
		return "Point [_x=" + _x + ", _y=" + _y + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}

	public static void main(String[] args) {
		Point test = new Point(1, 2);
		System.out.println("Funktionstest Klasse Point");
		System.out.println("X: " + test.getX() + "\tY: " + test.getY());
		test.setX(3);
		test.setY(6);
		System.out.println("X: " + test.getX() + "\tY: " + test.getY());
	}

}
