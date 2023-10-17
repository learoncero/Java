package at.fhv.itb.lro3572;

public class Vector {
	private double _x;
	private double _y;
	
	public Vector(Point point) {
		_x = point.getX();
		_y = point.getY();
	}
	
	public Vector(Point point1, Point point2) {
		this(point2.getX() - point1.getX(), point2.getY() - point1.getY());
	}
	
	public Vector(double angle, double length) {
		_x = length * Math.cos(Math.toRadians(angle));
		_y = length * Math.sin(Math.toRadians(angle));
	}
	
	public void scalarMult(double scalar) {
		_x *= scalar;
		_y *= scalar;
	}
	
	public double getLength() {
		return Math.sqrt(_x*_x + _y*_y);
	}
	
	public Vector getNormalVector() {
		return new Vector(-_y, _x);		
	}
	
	public static String getLineEquation(Point point1, Point point2) {
        LineEquation lineEquation = new LineEquation(point1, point2);
        
        return lineEquation.toString();
    }
	
	@Override
	public String toString() {
		return "Vector [_x=" + _x + ", _y=" + _y + "]";
	}

	public static void main(String[] args) {
		Vector v = new Vector(new Point(3, 2), new Point(6, 8));
		System.out.println(v + "\n");
		System.out.println("Länge: " + v.getLength() + "\n");
		Vector norm = v.getNormalVector();
		System.out.println("Normalvektor: " + norm + "\n");
		
		String s = Vector.getLineEquation(new Point(2, 3), new Point(4, 1));
		System.out.println(s);
		
	}
}
