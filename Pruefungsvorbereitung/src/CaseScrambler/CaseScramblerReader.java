package CaseScrambler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CaseScramblerReader extends FilterReader {
	private Reader _reader;
	private int _readChars;
	
	protected CaseScramblerReader(Reader in) {
		super(in);
		_reader = in;
		_readChars = 0;
	}
	
	@Override
	public int read(char[] cbuff, int off, int len) throws IOException {
		int count = _reader.read(cbuff, off, len);
		
		if (count == -1) {
			return -1;
		}
		
		for (int i = off; i < off + len; i += 1) {
			if ((cbuff[i] >= 'A') && (cbuff[i] <= 'Z') || (cbuff[i] >= 'a') && (cbuff[i] <= 'z')) {
				if ((cbuff[i] >= 'A') && (cbuff[i] <= 'Z') && (_readChars % 2 == 0)) {
					cbuff[i] = toLower(cbuff[i]);
				}
				else if ((cbuff[i] >= 'a') && (cbuff[i] <= 'z') && (_readChars % 2 == 1)) {
					cbuff[i] = toUpper(cbuff[i]);
				}
				_readChars += 1;
			}
		}
		return count;
	}
	
	private char toLower(char c) {
		return c += ('a' - 'A');
	}
	
	private char toUpper(char c) {
		return c -= ('a' - 'A');
	}
	
	public static void main(String[] args) {
		int c = 0;
		try (BufferedReader br = new BufferedReader(new CaseScramblerReader(new FileReader("D:\\OneDrive - FH Vorarlberg\\Altklausuren\\Test.txt")));) {
			while ((c = br.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
