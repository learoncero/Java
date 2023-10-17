package at.fhv.itb.lro3572;

public class Position {
	private int _row;
	private int _column;
	
	public Position(int row, int column) {
		_row = row;
		_column = column;
	}
	
	public Position() {
		this(0, 0);
	}

	public int getRow() {
		return _row;
	}

	public void setRow(int row) {
		_row = row;
	}

	public int getColumn() {
		return _column;
	}

	public void setColumn(int column) {
		_column = column;
	}

	@Override
	public String toString() {
		return "Position [_row=" + _row + ", _column=" + _column + "]";
	}

	public static void main(String[] args) {
		Position test = new Position(1, 2);
		System.out.println("Funktionstest Klasse Position");
		System.out.println("Column: " + test.getColumn() + "\tRow: " + test.getRow());
		test.setColumn(3);
		test.setRow(6);
		System.out.println("Column: " + test.getColumn() + "\tRow: " + test.getRow());
	}

}
