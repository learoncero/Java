package at.fhv.itb.lro3572;

public class Circle {
	private double _radius;
	private Point _center;
	
	public Circle(Point center, double radius) {
		_center = center;
		_radius = radius;
	}
	
	public double get_radius() {
		return _radius;
	}

	public void set_radius(double radius) {
		_radius = radius;
	}

	public Point get_center() {
		return _center;
	}

	public void set_center(Point center) {
		_center = center;
	}
	
	@Override
	public String toString() {
		return "Circle [_radius=" + _radius + ", _center=" + _center + ", get_radius()=" + get_radius()
				+ ", get_center()=" + get_center() + "]";
	}

	public static void main(String[] args) {
		Point p1 = new Point(4, 3);
		double radius = 6.708;
		Circle c = new Circle(p1, radius);
		
		System.out.println("Circle center: " + c._center);
		System.out.println("Circle radius: " + c._radius);
	}
}
