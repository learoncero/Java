package at.fhv.itb.lro3572;

public class Player extends Creature {
	public void speak() {
		System.out.println("Hello");
	}

	@Override
	public String toString() {
		return "Player []";
	}
}
