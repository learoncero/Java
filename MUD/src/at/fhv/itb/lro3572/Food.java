package at.fhv.itb.lro3572;

public class Food extends Item {
	
	public Food(String name, String description) {
		super(name, description);
	}
	
	@Override
	public String use (Player player) throws PlayerDeadException {
		StringBuilder output = new StringBuilder();
		player.setHealth(player.getHealth() + 20);
		output.append("Dein Leben wurde um 20 erhöht.");
		player.deleteItemInventory(this);
		
		return output.toString();
	}
}
