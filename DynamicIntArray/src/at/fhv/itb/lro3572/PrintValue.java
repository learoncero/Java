package at.fhv.itb.lro3572;

public class PrintValue implements Applicable {

	@Override
	public int apply(int i) {
		System.out.print(i + "\t");
		return i;
	}

}
