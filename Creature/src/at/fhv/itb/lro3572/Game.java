package at.fhv.itb.lro3572;

import java.util.LinkedList;

public class Game {
	private LinkedList<Creature> _creatures;
	
	public Game(Creature creature) {
		_creatures.add(creature);
	}
	
	public Game() {
		_creatures = new LinkedList<>();
	}
	
	public LinkedList<Creature> getCreatures() {
		return _creatures;
	}

	public void setCreatures(LinkedList<Creature> creatures) {
		_creatures = creatures;
	}

	@Override
	public String toString() {
		return "Game [_creatures=" + _creatures + ", getCreatures()=" + getCreatures() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		Game game = new Game();
		Creature c1 = new Donkey();
		Creature c2 = new Cow();
		Creature c3 = new Player();
		Creature c4 = new Cow();
		game._creatures.add(c1);
		game._creatures.add(c2);
		game._creatures.add(c3);
		game._creatures.add(c4);
		
		for (Creature creature: game._creatures) {
			creature.speak();
		}
		
		System.out.println(game._creatures);
	}
}
