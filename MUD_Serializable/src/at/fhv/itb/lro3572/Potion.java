package at.fhv.itb.lro3572;

public class Potion extends Item {

	public Potion(String name, String description) {
		super(name, description);
	}
	
	@Override
	public String use(Player player) throws PlayerDeadException {
		StringBuilder output = new StringBuilder();
		player.setHealth(player.getHealth() + 35);
		player.deleteItemInventory(this);
		output.append("Du fühlst dich wie neu geboren. Leben + 35");
		
		return output.toString();
	}

}
