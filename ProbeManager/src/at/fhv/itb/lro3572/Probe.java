package at.fhv.itb.lro3572;

public class Probe {
	private double _temperature;
	private int _time; // in Stunden
	
	public Probe(double temperature, int time) {
		_temperature = temperature;
		_time = time;
	}
	
	public Probe() {
		this(0, 0);
	}
	
//	Start Getter and Setter
	public double getTemperature() {
		return _temperature;
	}

	public void setTemperature(double temperature) {
		_temperature = temperature;
	}

	public int getTime() {
		return _time;
	}

	public void setTime(int time) {
		_time = time;
	}
//	End Getter and Setter

	@Override
	public String toString() {
		return "Probe [_temperature=" + _temperature + ", _time=" + _time + "]";
	}

	public static void main(String[] args) {
		Probe m1 = new Probe(13.5, 13);
		System.out.println(m1);
	}
}
