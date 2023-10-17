package at.fhv.itb.lro3572;

public class Triangle {
	private Point _pointT1 = new Point();
	private Point _pointT2 = new Point();
	private Point _pointT3 = new Point();
	
	public Triangle(Point p1, Point p2, Point p3) {
		_pointT1 = p1;
		_pointT2 = p2;
		_pointT3 = p3;		
	}

	public Point get_pointT1() {
		return _pointT1;
	}

	public void set_pointT1(Point pointT1) {
		_pointT1 = pointT1;
	}

	public Point get_pointT2() {
		return _pointT2;
	}

	public void set_pointT2(Point pointT2) {
		_pointT2 = pointT2;
	}

	public Point get_pointT3() {
		return _pointT3;
	}

	public void set_pointT3(Point pointT3) {
		_pointT3 = pointT3;
	}

	@Override
	public String toString() {
		return "Triangle [_pointT1=" + _pointT1 + ", _pointT2=" + _pointT2 + ", _pointT3=" + _pointT3
				+ ", get_pointT1()=" + get_pointT1() + ", get_pointT2()=" + get_pointT2() + ", get_pointT3()="
				+ get_pointT3() + "]";
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(7, 5);
		Point p3 = new Point(7, 2);
		Triangle t = new Triangle(p1, p2, p3);
		System.out.println("Triangle t: " + t);
	}
}
