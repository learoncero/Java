package ArrayBunch;

public class ArrayBunch {
	private String[][] _arrays;
	private int _size; 
	private int _rows;
	
	public ArrayBunch(String[][] arrays) {
		_arrays = arrays;
		_rows = arrays.length;
		
		int size = 0;
		for (int i = 0; i < arrays.length; i += 1) {
			for (int j = 0; j < arrays[i].length; j += 1) {
				size += 1;
			}
		}
		_size = size;
	}
	
	public String get(int index) {
		int[] corrFields = findCorrectField(index);
		int row = corrFields[0];
		int column = corrFields[1];
		return _arrays[row][column];
	}
	
	public int size() {
		return _size;
	}
	
	public void set(int index, String value) {
		int[] corrFields = findCorrectField(index);
		int row = corrFields[0];
		int column = corrFields[1];
		
		_arrays[row][column] = value;
	}
	
	private int[] findCorrectField(int index) {
		int[] corrFields = new int[2];
		int entries = 0;
		int row;

		if (index > _size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if (index == 0) {
			corrFields[0] = 0;
			corrFields[1] = 0;
			return corrFields;
		}
		
		for (row = 0; ((row < _rows) && (entries < index)); row += 1) {
			entries += _arrays[row].length;
		}
		row -= 1;
		index -= (entries - _arrays[row].length);
		
		corrFields[0] = row;
		corrFields[1] = index;
		
		return corrFields;
	}
	
	public static void main(String[] args) {
		String[][] arrays = {{"a", "b", "c"}, {"d", "e", "f", "g", "h"}};
		ArrayBunch ab = new ArrayBunch(arrays);
		System.out.println(ab.size());
		ab.set(7, "z");
		System.out.println(ab.get(8));
		
	}
}
