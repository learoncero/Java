package at.fhv.itb.lro3572;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends Reader {
	private int _shift;
	private Reader _reader;
	
	public CaesarReader(int shift, Reader in) {
		_shift = shift;
		_reader = in;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int count = _reader.read(cbuf, off, len);
		
		if (count == -1) {
			return -1; // end
		}
		
		for (int i = off; i < off + len; i += 1) {
			cbuf[i] = decode(cbuf[i]);
		}
		
		return count;
	}

	@Override
	public void close() throws IOException {
		_reader.close();		
	}

	public char decode(char input) {
		char encodedChar = input;
		if ((input >= 'A') && (input <= 'Z')) {
			encodedChar = (char)(((input - _shift - 'A' + 26) % 26) + 'A');
		}
		else if ((input >= 'a') && (input <= 'z')) {
			encodedChar = (char)(((input - _shift - 'a' + 26) % 26) + 'a');
		}
		return encodedChar;
	}
 
	public static void main(String[] args) {
		int c = 0;
		try (BufferedReader br = new BufferedReader(new CaesarReader(1, new FileReader("D:\\OneDrive - FH Vorarlberg\\Semester2\\Elementare_Algorithmen_ projektorientierte_Programmierung\\Uebungen\\Uebungsblatt8\\JavaIO.txt")));) {
			while ((c = br.read()) != -1) {
				System.out.print((char) c + "\t");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
