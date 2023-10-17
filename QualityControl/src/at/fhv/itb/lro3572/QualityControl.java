/*
 *
 * Uebungsblatt 1
 * Aufgabe 2: Qualitaetskontrolle
 * 
 * Autor: Lea Roncero
 *
 * Datum: 20.03.2023 
 *
 */

package at.fhv.itb.lro3572;

import java.util.Arrays;

public class QualityControl {
	public final static int ROWS = 16; 
	public final static int COLUMNS = 16; 
	private char[][] _input;
	private boolean[][] _visited;
	private int _holeCounter;
	
	public QualityControl() {
		this(ROWS, COLUMNS);
	}
	
	public QualityControl(int rows, int columns) {
		_input = new char[rows][columns];
		_visited = new boolean[rows][columns];
		_holeCounter = 0;
	}
	
	public char[][] get_input() {
		return _input;
	}

	public void set_input(char[][] _input) {
		this._input = _input;
	}

	public boolean[][] get_visited() {
		return _visited;
	}

	public void set_visited(boolean[][] _visited) {
		this._visited = _visited;
	}

	public int get_holeCounter() {
		return _holeCounter;
	}

	public void set_holeCounter(int _holeCounter) {
		this._holeCounter = _holeCounter;
	}

	public int[] checkForHoles() {
		int i;
		int j;
		int size = 0;
		int max = 0;
		
		for (i = 1; i < _input.length - 1; i += 1) {
			for (j = 1; j < _input[0].length - 1; j+= 1) {
				if ((_input[i][j] == '*') && (_visited[i][j] == false)) {
					int iFound = i;
					int jFound = j;
					boolean found = true;
					while (found == true) {
						if ((_input[i][j + 1] == '*') && (_visited[i][j + 1] == false)) {
							_visited[i][j + 1] = true;
							j += 1;	
							size += 1;
						}
						else if ((_input[i + 1][j + 1] == '*') && (_visited[i + 1][j + 1] == false)) {
							_visited[i + 1][j + 1] = true;
							i += 1;
							j += 1;
							size += 1;
						}
						else if ((_input[i + 1][j] == '*') && (_visited[i + 1][j] == false)) {
							_visited[i + 1][j] = true;
							i += 1;
							size += 1;
						}
						else if ((_input[i + 1][j - 1] == '*') && (_visited[i + 1][j - 1] == false)) {
							_visited[i + 1][j - 1] = true;
							i += 1;
							j -= 1;
							size += 1;
						}
						else if ((_input[i][j - 1] == '*') && (_visited[i][j - 1] == false)) {
							_visited[i][j - 1] = true;
							j -= 1;
							size += 1;
						}
						else if ((_input[i - 1][j - 1] == '*') && (_visited[i - 1][j - 1] == false)) {
							_visited[i - 1][j - 1] = true;
							i -= 1;
							j -= 1;
							size += 1;
						}
						else if ((_input[i - 1][j] == '*') && (_visited[i - 1][j] == false)) {
							_visited[i - 1][j] = true;
							i -= 1;
							size += 1;
						}
						else if ((_input[i - 1][j + 1] == '*') && (_visited[i - 1][j + 1] == false)) {
							_visited[i - 1][j + 1] = true;
							i -= 1;
							j += 1;
							size += 1;
						} 
						else {
							if ((i == iFound) && (j == jFound)) {
								_holeCounter += 1;
								if (size == 0) {
									size += 1;
								}
								if (size > max) {
									max = size;									
								}
							}
							found = false;
							i = iFound;
							j = jFound + 1;
							size = 0;
						}
					}
				}
			}
		}
		
		int[] output = new int[] {_holeCounter, max};
		
		return output;
	}

	@Override
	public String toString() {
		return "QualityControl [_input=" + Arrays.toString(_input) + ", _visited=" + Arrays.toString(_visited)
				+ ", _holeCounter=" + _holeCounter + ", get_input()=" + Arrays.toString(get_input())
				+ ", get_visited()=" + Arrays.toString(get_visited()) + ", get_holeCounter()=" + get_holeCounter()
				+ ", checkForHoles()=" + Arrays.toString(checkForHoles()) + "]";
	}

	public static void main(String[] args) {
		QualityControl cheeseCheck = new QualityControl(7, 19);
		char[][] input = new char[][] {
//	j:	  0    1    2    3    4    5    6    7    8    9    0    1    2    3    4    5    6    7    8 
		{'+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '+'},
		{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
		{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
		{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
		{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
		{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
		{'+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '+'}	
										};
		cheeseCheck.set_input(input);
		int[] results = new int[2];
		results = cheeseCheck.checkForHoles();
		System.out.println("Anzahl der Loecher: " + results[0]);
		System.out.println("\nUmfang des groeßten Lochs: " + results[1]);
	}
}
