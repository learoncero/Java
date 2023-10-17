package at.fhv.itb.lro3572;

public class Poison extends Item {
	
	public Poison(String name, String description) {
		super(name, description);
	}
	
	@Override
	public String use(Player player) throws PlayerDeadException {
		if ((player.getHealth() - 30) <= 0) {
			throw new PlayerDeadException("Du hast zu viel Leben verloren. Game Over!");
		}
		else {
			StringBuilder output = new StringBuilder();
			player.setHealth(player.getHealth() - 30);
			player.deleteItemInventory(this);
			output.append("Achtung Gift! Du hast 30 Leben verloren.");
			return output.toString();
		}
	}
}
