package at.fhv.itb.lro3572;

public class Item {
	private static int _itemCount = 0;
	private int _itemID;
	private int _weight;
	private String _name;
	
//	Start Constructor
	public Item (String s, int weight) {
		_itemID = getNextID();
		_weight = weight;
		_name = s;
	}
//	End Constructor
	
//	Start Getter and Setter
	private static int getNextID() {
		return _itemCount += 1;
	}
	
	public static int getItemCount() {
		return _itemCount;
	}
	
	
	public static void setItemCount(int itemCount) {
		Item._itemCount = itemCount;
	}
	
	
	public int getItemID() {
		return _itemID;
	}
	
	
	public void setItemID(int itemID) {
		_itemID = itemID;
	}
	
	
	public int getWeight() {
		return _weight;
	}
	
	
	public void setWeight(int weight) {
		_weight = weight;
	}
	
	
	public String getName() {
		return _name;
	}
	
	
	public void setName(String name) {
		_name = name;
	}
//	End Getter and Setter
	
//	Start toString
	@Override
	public String toString() {
		return "Item [_itemID=" + _itemID + ", _weight=" + _weight + ", _name=" + _name + ", getItemID()=" + getItemID()
		+ ", getWeight()=" + getWeight() + ", getName()=" + getName() + "]";
	}
//	End toString

	public static void main(String[] args) {
		Item item1 = new Item("Banane", 2);
		Item item2 = new Item("Apfel", 3);
		Item item3 = new Item("Birne", 1);
		
		System.out.println("Item1: " + item1);
		System.out.println("Item2: " + item2);
		System.out.println("Item3: " + item3);

	}

}
