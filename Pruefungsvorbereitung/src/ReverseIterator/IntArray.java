package ReverseIterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntArray implements Collection<Integer> {
	private int[] _values;
	
	public IntArray(int size) {
		_values = new int[size];
	}
	
	public IntArray(int[] values) {
		_values = values;
	}
	
	public int getAt(int index) throws IndexOutOfBoundsException {
		if ((index >= 0) && (index < _values.length)) {
			return _values[index];
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new ReverseIterator();
	}
	
	private class ReverseIterator implements Iterator<Integer> {
		private int _off;
		
		private ReverseIterator() {
			_off = _values.length;
		}
		
		@Override
		public boolean hasNext() {
			return (_off > 0);
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			_off -= 1;
			return _values[_off];
		}
	}
	
	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4};
		IntArray arr = new IntArray(values);
		
		for(Integer i: arr) {
			System.out.println(i);
		}
	}

	@Override
	public boolean add(Integer e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
