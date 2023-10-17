package at.fhv.itb.lro3572;

public class LineEquation {
	private double _slope;
	private double _intercept;
	
	public LineEquation(Point point1, Point point2) {
		_slope = (point2.getY() - point1.getY()) / (point2.getX() - point1.getX()); // Steigung k
		_intercept = point1.getY() - (_slope * point1.getX()); // d = y - k*x
	}
	
	@Override
	public String toString() {
		if (_intercept > 0) {
			return "Geradengleichung: " + _slope + "x + " + _intercept;
		}
		else {
			return "Geradengleichung: " + _slope + "x - " + _intercept * (-1);
		}
	}
}
