package at.fhv.itb.lro3572;

import java.util.Arrays;

public class MyArray {
	public final static int DEFAULT_SIZE = 32;
	private int[] _values;
	
	public MyArray() {
		this(DEFAULT_SIZE);
	}
	
	public MyArray(int size) { 
		_values = new int[size];
	}
	
	public int get(int index) {
		return _values[index];
	}
	
	public void put(int index, int value) {
		if (index < _values.length) {
			_values[index] = value;			
		}
		else {
			int[] newValues = new int[_values.length * 2];
			for (int i = 0; i < _values.length; i += 1) {
				newValues[i] = _values[i];
			}
			_values = newValues;
			_values[index] = value;
		}
	}
	
	public int length() {
		return _values.length;
	}
	
	public void compress(int value) {
		int i = 0;
		int count = 0;
		for (i = 0; i < _values.length; i += 1) {
			if (_values[i] != value) {
				count += 1;
			}
		}		
		int[] newValues = new int[count];
		int j = 0;
		for (i = 0; i < _values.length; i += 1) {
			if (_values[i] != value) {
				newValues[j] = _values[i];
				j += 1;
			}
		}	
		_values = newValues;
	}
	
	public void sort() {
		int len = _values.length;
		while (len > 1) {
			for (int i = 0; i < _values.length - 1; i += 1) {
				if (_values[i] > _values[i + 1]) {
					int swap = _values[i];
					_values[i] = _values[i + 1];
					_values[i + 1] = swap;
				}
			}
			len -= 1;
		}
	}

	@Override
	public String toString() {
		return "MyArray [_values=" + Arrays.toString(_values) + ", length()=" + length() + "]";
	}

	public static void main(String[] args) {
		MyArray testArray = new MyArray(4);
		testArray.put(0, 5);
		testArray.put(1, 4);
		testArray.put(2, 3);
		testArray.put(3, 2);
		testArray.put(4, 1);
		System.out.println("testArray: " + testArray);
		testArray.compress(0);
		System.out.println("testArray compress: " + testArray);
		testArray.sort();
		System.out.println("testArray sort: " + testArray);
	}
}

