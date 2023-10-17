package at.fhv.itb.lro3572;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CaesarWriter extends Writer {
	private int _shift;
	private Writer _writer;
	
	public CaesarWriter(int shift, Writer out) {
		_shift = shift;
		_writer = out;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for(int i = off; i < off + len; i += 1) {
			cbuf[i] = encode(cbuf[i]);
		}
		_writer.write(cbuf, off, len);
	}

	@Override
	public void flush() throws IOException {
		_writer.flush();
		
	}

	@Override
	public void close() throws IOException {
		_writer.close();
	}
	
	public char encode(char input) {
		char encodedChar = input;
		if ((input >= 'A') && (input <= 'Z')) {
			encodedChar = (char) (((input + _shift - 'A') % 26) + 'A');
		}
		else if ((input >= 'a') && (input <= 'z')) {
			encodedChar = (char)(((input + _shift - 'a') % 26) + 'a');
		}
		return encodedChar;
	}
	
	public static void main(String[] args) {
		String s = "1 2 3 a b c";
		
		try (BufferedWriter bw = new BufferedWriter(new CaesarWriter(2, new FileWriter("D:\\OneDrive - FH Vorarlberg\\Semester2\\Elementare_Algorithmen_ projektorientierte_Programmierung\\Uebungen\\Uebungsblatt8\\JavaIO.txt")));) {
			bw.write(s.toCharArray());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
