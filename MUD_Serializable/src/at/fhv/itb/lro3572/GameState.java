package at.fhv.itb.lro3572;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class GameState implements Serializable {
	private static final long serialVersionUID = 1L;
	private LinkedList<Field> _fields;
	private LinkedList<Player> _players;
	
	public GameState(LinkedList fields, LinkedList players) {
		_fields = fields;
		_players = players;
	}
	
	public LinkedList<Field> getFields() {
		return _fields;
	}

	public LinkedList<Player> getPlayers() {
		return _players;
	}

	public String save() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\OneDrive - FH Vorarlberg\\Semester2\\Elementare_Algorithmen_ projektorientierte_Programmierung\\Uebungen\\Uebungsblatt8\\GameState.bin"));) {
			out.writeObject(this);
			return "Spiel gespeichert!";
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return "Speichern fehlgeschlagen!";
		}
	}
	
	public static GameState load() {
		Object o = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\OneDrive - FH Vorarlberg\\Semester2\\Elementare_Algorithmen_ projektorientierte_Programmierung\\Uebungen\\Uebungsblatt8\\GameState.bin"));) {
			o = in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			return (GameState) o;
		}
	}
}
