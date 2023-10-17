package at.fhv.itb.lro3572;

public class CaesarCoder {
	private int _shift;
	
	public CaesarCoder() {
		this(4);
	}
	
	public CaesarCoder(int shift) {
		_shift = shift;
	}
	
	public int get_shift() {
		return _shift;
	}

	public void set_shift(int shift) {
		this._shift = shift;
	}
	
	public String encode(String input) {
		StringBuilder manipulatedInput = new StringBuilder();
		for (int i = 0; i < input.length(); i += 1) {
			if ((input.charAt(i) >= 'A') && (input.charAt(i) <= 'Z')) {
				char encodedChar = (char)(((input.charAt(i) + _shift - 'A') % 26) + 'A');
				manipulatedInput.append(encodedChar);
			}
			else if ((input.charAt(i) >= 'a') && (input.charAt(i) <= 'z')) {
				char encodedChar = (char)(((input.charAt(i) + _shift - 'a') % 26) + 'a');
				manipulatedInput.append(encodedChar);
			}
		}
		return manipulatedInput.toString();
	}
	
	public String decode(String input) {
		StringBuilder manipulatedInput = new StringBuilder();
		for (int i = 0; i < input.length(); i += 1) {
			if ((input.charAt(i) >= 'A') && (input.charAt(i) <= 'Z')) {
				char encodedChar = (char)(((input.charAt(i) - _shift + 'A') % 26) + 'A');
				manipulatedInput.append(encodedChar);
			}
			else if ((input.charAt(i) >= 'a') && (input.charAt(i) <= 'z')) {
				char encodedChar = (char)(((input.charAt(i) - _shift + 'a') % 26) + 'a');
				manipulatedInput.append(encodedChar);
			}

		}
		return manipulatedInput.toString();
	}
	
	@Override
	public String toString() {
		return "CaesarCoder [_shift=" + _shift + "]";
	}

	public static void main(String[] args) {
		String s = "g";
//		String s1 = "bcd";
		CaesarCoder test = new CaesarCoder(0);
		
//		System.out.println("Encode: " + test.encode(s));
		System.out.println("Decode: " + test.decode(s));
	}

}
