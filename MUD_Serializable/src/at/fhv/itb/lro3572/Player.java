package at.fhv.itb.lro3572;

import java.io.Serializable;
import java.util.LinkedList;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private String _name;
	private Field _position;
	private int _health;
	private LinkedList<Item> _inventory;
	
	public Player(String name) {
		_name = name;
		_health = 5;
		_inventory = new LinkedList<>();
	}

//	start getter and setter
	public String getName() {
		return _name;
	}

	public Field getPosition() {
		return _position;
	}

	public void setPosition(Field position) {
		_position = position;
	}

	public int getHealth() {
		return _health;
	}

	public void setHealth(int health) {
		_health = health;
	}
	
	public LinkedList<Item> getInventory() {
		return _inventory;
	}

	//	start methods
	public String move(Direction destination) throws NeighbourNullException {
		if (_position.getNeighbours()[destination.ordinal()] == null) {
			throw new NeighbourNullException("In diese Richtung kannst du nicht gehen!");
		}
		try {
			switch (destination) {
				case North:
					_position.getNeighbours()[Direction.North.ordinal()].enter(this);
					return(GameController.getCurrPosString(this));
				case East:
					_position.getNeighbours()[Direction.East.ordinal()].enter(this);
					return(GameController.getCurrPosString(this));
				case South:
					_position.getNeighbours()[Direction.South.ordinal()].enter(this);
					return(GameController.getCurrPosString(this));
				default:
					_position.getNeighbours()[Direction.West.ordinal()].enter(this);
					return(GameController.getCurrPosString(this));
			}
		}
		catch (NotEnterableException e) {
			return("Fehler beim Betreten. " + e.getMessage());
		}
	}
	
	public void pickUpItem(String name) {
		for(Item item: _position.getItemsOnField()) {
			if (item.getName().equals(name)) {
				_inventory.add(item);
				_position.removeItem(item);
			}
		}
	}
	
	public void addItemInventory(Item item) {
		_inventory.add(item);
	}
	
	public void deleteItemInventory(Item item) {
		_inventory.remove(item);
	}
	
	@Override
	public String toString() {
		return "Player [_name=" + _name + ", _position=" + _position + ", _health=" + _health + ", _items=" + _inventory
				+ "]";
	}
}
