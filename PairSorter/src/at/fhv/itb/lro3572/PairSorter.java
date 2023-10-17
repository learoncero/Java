package at.fhv.itb.lro3572;

public class PairSorter {

	public PairSorter() {
		System.out.println("Constructor");
	}
	
	private void sort() {
		System.out.println("sorting...");
	}
		
	public static void main(String[] args) {
		System.out.println("PairSorter");
		
		PairSorter pairSorter = new PairSorter();
		pairSorter.sort();

	}


}