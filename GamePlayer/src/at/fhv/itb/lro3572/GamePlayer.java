package at.fhv.itb.lro3572;

public class GamePlayer {
	private int _health;
	private int _shield;
	private int _points;
	private int _level;
	private int _position;
	private Backpack _backpack;
	
	public GamePlayer() {
		_health = 95;
		_shield = 50;
		_points = 0;
		_level = 1;
		_position = 0;
	}	
	
//	Start Getter and Setter
	public int get_health() {
		return _health;
	}
	
	public void set_health(int health) {
		_health = health;
	}

	public int get_shield() {
		return _shield;
	}

	public void set_shield(int shield) {
		_shield = shield;
	}

	public int get_points() {
		return _points;
	}

	public void set_points(int points) {
		_points = points;
	}

	public int get_level() {
		return _level;
	}

	public void set_level(int level) {
		_level = level;
	}

	public int get_position() {
		return _position;
	}

	public void set_position(int position) {
		_position = position;
	}

	public Backpack get_backpack() {
		return _backpack;
	}

	public void set_backpack(Backpack backpack) {
		_backpack = backpack;
	}
//	End Getter and Setter
	
//	Start Methods
	public void heal() {
		if (_health + 10 < 100) {
			_health += 10;
		}
		else {
			_health = 100;
		}
	}
	
	public void takeDamage() {
		if (_shield - 20 > 0) {
			_shield -= 20;
		}
		else if (_shield - 20 < 0) {
			_shield = 0;
		}
		else {
			_health -= 10;			
		}
	}
	
	public void increaseShied() {
		if (_shield + 10 < 100) {
			_shield += 10;
		}
		else {
			_shield = 100;
		}
	}
	
	public void gainPoints() {
		_points += 10;
		if (_points >= 100) {
			levelUp();
			_points -= 100;
		}
	}
	
	public void losePoints() {
		if ((_points - 10) > 0) {
			_points -= 10;
		}
		else {
			_points = 0;
		}
	}
	
	private void levelUp() {
		_level += 1;
	}
	
	public void stepRight() {
		_position += 1;
	}
	
	public void stepLeft() {
		if (_position > 0) {
			_position -= 1;
		}
	}
	
	public void takeBackpack() {
		takeBackpack(Backpack._SIZE);

	}
	
	public void takeBackpack(int volume) {
		_backpack = new Backpack(volume);
	}
	
	public String addItemToBackpack(String itemName) {
		if (_backpack != null) {
			String notification = _backpack.addItem(itemName);			
			return notification;
		}
		else {
			return "You need to pick up a backpack first!";
		}
	}

	public String dropItemFromBackpack(int itemID) {
		if (_backpack != null) {
			String notification = _backpack.dropItem(itemID);
			return notification;
		}
		else {
			return "You don't have a backpack to drop items from";
		}
	}
//	End Methods
	
	@Override
	public String toString() {
		return "GamePlayer [_health=" + _health + ", _shield=" + _shield + ", _points=" + _points + ", _level=" + _level
				+ ", _position=" + _position + ", _backpack=" + _backpack + "]";
	}

	public static void main(String[] args) {
		GamePlayer player1 = new GamePlayer();
		
		System.out.println("Player player1: " + player1);
		player.
		player1.takeBackpack(2);
		System.out.println("Backpack player1: " + player1._backpack);
		System.out.println("Get 1: " + player1.addItemToBackpack("Knife"));
		System.out.println("Get 2: " + player1.addItemToBackpack("Map"));
		System.out.println("Get 2: " + player1.addItemToBackpack("Food"));
		System.out.println("Get 3: " + player1.addItemToBackpack("Gun"));
		System.out.println("Drop item ID 1: " + player1.dropItemFromBackpack(1));
		System.out.println("Backpack after drop: " + Backpack.get_items()[0] + Backpack.get_items()[1]);		
	}



}

