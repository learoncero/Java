package at.fhv.itb.lro3572;

import java.util.Arrays;
import java.util.LinkedList;

public class Field extends Cell {
	private static int _count = 0;
	private int _fieldID;
	private Cell[] _neighbours;
	private LinkedList<Player> _playersOnField;
	private LinkedList<Item> _itemsOnField;
	
	public Field (String name, String description, Cell north, Cell east, Cell south, Cell west) {
		super(name, description);
		_fieldID = getNextID();
		_neighbours = new Cell[4];
		_neighbours[Direction.North.ordinal()] = north;
		_neighbours[Direction.East.ordinal()] = east;
		_neighbours[Direction.South.ordinal()] = south;
		_neighbours[Direction.West.ordinal()] = west;
		_playersOnField = new LinkedList<>();
		_itemsOnField = new LinkedList<>();
	}
	
	public Field (String name, String description) {
		this(name, description, null, null, null, null);
	}
	
//	getters and setters
	public int getFieldID() {
		return _fieldID;
	}

	public Cell[] getNeighbours() {
		return _neighbours;
	}

	public LinkedList<Player> getPlayersOnField() {
		return _playersOnField;
	}

	public LinkedList<Item> getItemsOnField() {
		return _itemsOnField;
	}

	//	methods
	private int getNextID() {
		return _count += 1;
	}
	
	public void defineSurrounding(Cell north, Cell east, Cell south, Cell west) {
		_neighbours[Direction.North.ordinal()] = north;
		_neighbours[Direction.East.ordinal()] = east;
		_neighbours[Direction.South.ordinal()] = south;
		_neighbours[Direction.West.ordinal()] = west;
	}
	
	public void addPlayer(Player player) {
		_playersOnField.add(player);
	}
	
	public void removePlayer(Player player) {
		_playersOnField.remove(player);
	}
	
	public void addItem(Item item) {
		_itemsOnField.add(item);
	}
	
	public void removeItem(Item item) {
		_itemsOnField.remove(item);
	}
	
	public String getFieldInformationString() {
		StringBuilder cellInformation = new StringBuilder();
		
		cellInformation.append("Field: " + _fieldID + ", " + _name + "\n");
		cellInformation.append("Description: " + _description + "\n\n");
		
		for (int i = 0; i < _neighbours.length; i += 1) {
			if (_neighbours[i] instanceof Field) {
				Field f = (Field) _neighbours[i];
				cellInformation.append("Neighbour " + Direction.values()[i] + ": Field " + f.getFieldID() + ", " +
				 f.getName() + "\n");
			}
			else if (_neighbours[i] instanceof Wall) {
				Wall w = (Wall) _neighbours[i];
				cellInformation.append("Neighbour " + Direction.values()[i] + ": Wall\n");
			}
			else if (_neighbours[i] instanceof Door) {
				Door d = (Door) _neighbours[i];
				if (this.equals(d.getCorrFields()[0])) {
					Field f1 = (Field) d.getCorrFields()[1];
					cellInformation.append("Neighbour " + Direction.values()[i] + ": Door to Field " + 
					f1.getFieldID() + ", " + f1.getName() + "\n");
				}
				else {
					Field f0 = (Field) d.getCorrFields()[0];
					cellInformation.append("Neighbour " + Direction.values()[i] + ": Door to Field " + 
					f0.getFieldID() + ", " + f0.getName() + "\n");
				}
			}
			else {
				cellInformation.append("Neighbour " + Direction.values()[i] + ": NONE\n");
			}
		}
		return cellInformation.toString();
	}
	
	@Override
	public void enter(Player player) throws NotEnterableException {
		player.getPosition().removePlayer(player);
		_playersOnField.add(player);
		player.setPosition(this);
	}

	@Override
	public String toString() {
		return "Field [_fieldID=" + _fieldID + ", _neighbours=" + Arrays.toString(_neighbours) + ", _playersOnField="
				+ _playersOnField + ", _itemsOnField=" + _itemsOnField + ", _name=" + _name + ", _description="
				+ _description + "]";
	}
}
