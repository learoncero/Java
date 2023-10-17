package at.fhv.itb.lro3572;

public class Drink implements ComparableType {
	private int _vC;
	
	public Drink(int vitamineC) {
		_vC = vitamineC;
	}

	public int getvC() {
		return _vC;
	}

	public void setvC(int vC) {
		_vC = vC;
	}

	@Override
	public boolean less(ComparableType c) {
		return _vC < ((Drink)c).getvC();
	}

	@Override
	public String toString() {
		return "Drink [_vC=" + _vC + "]";
	}
}
