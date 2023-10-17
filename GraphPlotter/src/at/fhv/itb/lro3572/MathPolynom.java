package at.fhv.itb.lro3572;

public class MathPolynom {
	private double _a;
	private double _b;
	private double _c;
	
	public MathPolynom(double a, double b, double c) {
		_a = a; 
		_b = b; 
		_c = c;
	}

	public double getA() {
		return _a;
	}

	public void setA(double a) {
		_a = a;
	}

	public double getB() {
		return _b;
	}

	public void setB(double b) {
		_b = b;
	}

	public double getC() {
		return _c;
	}

	public void setC(double c) {
		_c = c;
	}
	
	public double calculateY(double x) {
		return _a*x*x + _b*x + _c;
	}
}
