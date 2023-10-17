package at.fhv.itb.lro3572;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicIntArray implements Iterable<Integer> {
	private static final int _DEFAULT_SIZE = 8;
	private int[] _values;
	private int[] _initialArray;
	
//	constructors
	public DynamicIntArray(int size) {
		_values = new int[size];
		_initialArray = Arrays.copyOf(_values, _values.length);
	}
	
	public DynamicIntArray() {
		this(_DEFAULT_SIZE);
	}
	
	public DynamicIntArray(int[] values) {
		_values = values;
		_initialArray = Arrays.copyOf(_values, _values.length);
	}
	
//	methods
	public int getValue(int index) {
		if (index < _values.length) {
			return _values[index];
		}
		else {
			throw new IndexOutOfBoundsException(index);
		}
	}
	
	public void setValue(int index, int value) {
		if (index < _values.length) {
			_values[index] = value;
		}
		else {
			int[] newValues = new int[index + 1];
			for (int i = 0; i < _values.length; i += 1) {
				newValues[i] = _values[i];
			}
			newValues[index] = value;
			_values = newValues;
		}
	}
	
	public void setSize(int size) {
		int[] newValues = new int[size];
		
		for (int i = 0; ((i < newValues.length) && (i < _values.length)); i += 1) {
			newValues[i] = _values[i]; 
		}
		_values = newValues;
	}
	
	public int size() {
		return _values.length;
	}
	
	public void clear() {
		_values = Arrays.copyOf(_initialArray, _initialArray.length);
	}
	
	public void forEach(Applicable a) {
		for (int i = 0; i < _values.length; i += 1) {
			_values[i] = a.apply(_values[i]);
		}
	}
	
	public Iterator<Integer> iterator() {
		return new DyIntArrIterator();
	}
	
	private class DyIntArrIterator implements Iterator<Integer> {
		private int _index;
		
		private DyIntArrIterator() {
			_index = -1;
		}

		@Override
		public boolean hasNext() {
			return (_index < _values.length - 1);
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				_index += 1;
				return _values[_index];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] values = {3, 4, 5};
		DynamicIntArray dynamicIntArray = new DynamicIntArray(values);
		
		for(Integer i: dynamicIntArray) {
			System.out.println(i);
		}
		
		Iterator<Integer> iter = dynamicIntArray.iterator();
		while (iter.hasNext()) {
			Integer i = iter.next();
			System.out.println(i);
		}
		
		/*
		dynamicIntArray.forEach(new Applicable() {
			
			@Override
			public int apply(int i) {
				i *= 3;
				return i;
			}
		});
		
		dynamicIntArray.forEach(new PrintValue());
		 
		dynamicIntArray.forEach(new Applicable() {
			
			@Override
			public int apply(int i) {
				i += 5;
				return i;
			}
		});
		
		dynamicIntArray.forEach(x -> {return x * 3;});

		DyIntArrIterator itr = dynamicIntArray.iterator();
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		System.out.println(itr.hasNext());
		System.out.println(itr.next());
		System.out.println(itr.hasNext());
		System.out.println(itr.next());

		System.out.println("Initial Array: ");
		dynamicIntArray.forEach(new PrintIntValue());
		System.out.println("\n");
		
		dynamicIntArray.setValue(2, 100);
		System.out.println("Array after setValue(2, 100): ");
		dynamicIntArray.forEach(new PrintIntValue());
		System.out.println("\n");
		
		dynamicIntArray.clear();
		System.out.println("Array after clear(): ");
		dynamicIntArray.forEach(new PrintIntValue());
		System.out.println("\n");
		
		System.out.println("Size: " + dynamicIntArray.size());
		dynamicIntArray.forEach_itr(new PrintIntValue());
		System.out.println("\n");
		
		dynamicIntArray.setSize(8);
		System.out.println("Size after setSize(8): " + dynamicIntArray.size());
		dynamicIntArray.forEach_itr(new PrintIntValue());
		System.out.println("\n");
		
		dynamicIntArray.setSize(3);
		System.out.println("Size after setSize(3): " + dynamicIntArray.size());
		dynamicIntArray.forEach_itr(new PrintIntValue());
		System.out.println("\n");
		*/
	}
}
