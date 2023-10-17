package at.fhv.itb.lro3572;

public class Item {
	private static int _itemCount = 0;
	private int _itemID;
	private int _volume;
	private String _name;
	
//	Start Constructor
	public Item (String s) {
		_itemID = getNextID();
		_volume = 1;
		_name = s;
	}
//	End Constructor
	
//	Start Getter and Setter
	private static int getNextID() {
		return _itemCount += 1;
	}
	
	public static int get_itemCount() {
		return _itemCount;
	}
	
	
	public static void set_itemCount(int itemCount) {
		Item._itemCount = itemCount;
	}
	
	
	public int get_itemID() {
		return _itemID;
	}
	
	
	public void set_itemID(int itemID) {
		_itemID = itemID;
	}
	
	
	public int get_volume() {
		return _volume;
	}
	
	
	public void set_volume(int volume) {
		_volume = volume;
	}
	
	
	public String get_name() {
		return _name;
	}
	
	
	public void set_name(String name) {
		_name = name;
	}
//	End Getter and Setter
	
//	Start toString
	@Override
	public String toString() {
		return "Item [_itemID=" + _itemID + ", _volume=" + _volume + ", _name=" + _name + ", get_itemID()="
				+ get_itemID() + ", get_volume()=" + get_volume() + ", get_name()=" + get_name() + "]";
	}
//	End toString

	public static void main(String[] args) {
		Item item1 = new Item("Banane");
		Item item2 = new Item("Apfel");
		Item item3 = new Item("Birne");
		
		System.out.println("Item1: " + item1);
		System.out.println("Item2: " + item2);
		System.out.println("Item3: " + item3);

	}

}
