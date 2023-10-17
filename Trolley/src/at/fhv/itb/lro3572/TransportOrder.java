package at.fhv.itb.lro3572;

public class TransportOrder {
	private static int _orderCount = 0;
	private int _orderID;
	private Position _destination;
	private DistributionCenter _center;
	
//	Start Constructor
	public TransportOrder(Position destination, DistributionCenter center) {
		if((destination.getColumn() <=  center.getColumns()) && (destination.getRow() <= center.getRows()) && 
			(destination.getColumn() >= 0) && (destination.getRow() >= 0)) {
			_orderID = getNextID();
			_destination = destination;
			_center = center;
		}
		else {
			System.out.println("The destination is outside the distribution centre!");
		}
	}
	
	public TransportOrder(DistributionCenter center) {
		this(new Position(0, 0), center);
	}
//	End Constructor
	
//	Start Getter and Setter
	public static int getOrderCount() {
		return _orderCount;
	}

	public static void setOrderCount(int orderCount) {
		TransportOrder._orderCount = orderCount;
	}

	public int getOrderID() {
		return _orderID;
	}

	public void setOrderID(int orderID) {
		_orderID = orderID;
	}

	public Position getDestination() {
		return _destination;
	}

	public void setDestination(Position destination) {
		_destination = destination;
	}
//	End Getter and Setter

	//	Start Methods
	private int getNextID() {
		return ++_orderCount;
	}
//	End Methods
	
//	Start toString
	@Override
	public String toString() {
		return "TransportOrder [_orderID=" + _orderID + ", _destination=" + _destination + ", getNextID()="
				+ getNextID() + "]";
	}
//	End toString
	
	public static void main(String[] args) {
		DistributionCenter testCenter = DistributionCenter.instance(3, 5);
		TransportOrder transportOrder1 = new TransportOrder(new Position(2, 3), testCenter);
		TransportOrder transportOrder2 = new TransportOrder(new Position(1, 7), testCenter);
		
		System.out.println(transportOrder1);
		System.out.println(transportOrder2);
	}
}
