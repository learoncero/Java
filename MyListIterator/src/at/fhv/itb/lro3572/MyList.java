package at.fhv.itb.lro3572;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T> {
	private T[] _values;
	
	public MyList(T[] values) {
		_values = values;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>();
	}
	
	private class MyIterator<E> implements Iterator<E> {
		private int _index;
		
		private MyIterator() {
			_index = -1;
		}

		@Override
		public boolean hasNext() {
			return (_index < _values.length - 1);
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				_index += 1;
				return (E) _values[_index];
			}
		}
	}
	public static void main(String[] args) {
		Double[] values = {1.0, 2.0, 3.0, 4.0, 5.0};
		MyList<Double> vals = new MyList<>(values);
		
		for(Double i: vals) {
			System.out.println(i);
		}
	}
}
