package at.fhv.itb.lro3572;

public class Backpack {
	public final static int _SIZE = 10;
	private static int _itemCount = 0;
	private static Item[] _items;
	private static int _index = 0;
	
//	Start Constructors
	public Backpack() {
		this(_SIZE);
	}
	
	public Backpack(int volume) {
		_items = new Item[volume];
	}
//	End Constructors
	
//	Start Getter and Setter
	public static int get_itemCount() {
		return _itemCount;
	}

	public static void set_itemCount(int itemCount) {
		Backpack._itemCount = itemCount;
	}

	public static Item[] get_items() {
		return _items;
	}

	public static void set_items(Item[] items) {
		Backpack._items = items;
	}

	public static int get_index() {
		return _index;
	}

	public static void set_index(int index) {
		Backpack._index = index;
	}

	public static int getSize() {
		return _SIZE;
	}
//	End Getter and Setter
	
//	Start own Methods
	public String addItem(String itemName) {
		if (_itemCount < _items.length) {
			_items[_index] = new Item(itemName);
			_index += 1;
			_itemCount += 1;
			String notification = "The item with the item ID: " + _items[_index - 1].get_itemID() + " has successfully been added to the backpack!";
			return notification;
		}
		else {
			String notification = "The backpack is full. You have to drop one item first to add a new one!";
			return notification;
		}
	}

	public String dropItem(int itemID) {
		int i = 0;
		for (i = 0; ((i < _index) && (_items[i].get_itemID() != itemID)); i += 1);
		if (i == Backpack.get_index()) {
			String notification = "The item could not be found!";
			return notification;
		}
		else {
			_items[i] = _items[_index - 1];
			_items[_index - 1] = null;
			_itemCount -= 1;
			_index -= 1;
			String notification = "The item with the item ID: " + itemID + " has successfully been dropped!";
			return notification;
		}
	}
//	End own Methods
	
	@Override
	public String toString() {
		return "Backpack []";
	}

	public static void main(String[] args) {
		Backpack backpack = new Backpack(4);
		
		System.out.println("Add first: " + backpack.addItem("Map"));
		System.out.println("Add second: " + backpack.addItem("Knife"));
		System.out.println("Add third: " + backpack.addItem("Food"));
		System.out.println("Add fourth: " + backpack.addItem("Gun"));
		System.out.println("Drop Item ID 3: " + backpack.dropItem(3));
		System.out.println("Drop Item ID 10: " + backpack.dropItem(10));
		for (int i = 0; i < 4; i += 1) {
			System.out.println("Items after drop: " + _items[i] + " Index: " + i);			
		}
		System.out.println("Add fifth: " + backpack.addItem("Potion"));
		for (int i = 0; i < 4; i += 1) {
			System.out.println("Items after drop + add: " + _items[i] + " Index: " + i);			
		}
	}

}
