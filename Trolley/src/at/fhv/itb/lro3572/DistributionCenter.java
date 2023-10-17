package at.fhv.itb.lro3572;

public class DistributionCenter {
	private static DistributionCenter _instance;
	private int _rows;
	private int _columns;
	private Position _posTrolley;
	
//	Start Constructor
	private DistributionCenter(int rows, int columns) {
		_rows = rows; 
		_columns = columns;
		_posTrolley = new Position();
	}
//	End Constructor

//	Start Methods
	public static DistributionCenter instance(int rows, int columns) {
		if (_instance == null) {
			_instance = new DistributionCenter(columns, rows);
		}
		return _instance;
	}
//	End Methods
	
//	Start Getter and Setter
	public static DistributionCenter getInstance() {
		return _instance;
	}

	public static void setInstance(DistributionCenter _instance) {
		DistributionCenter._instance = _instance;
	}

	public int getRows() {
		return _rows;
	}

	public void setRows(int rows) {
		_rows = rows;
	}

	public int getColumns() {
		return _columns;
	}

	public void setColumns(int columns) {
		_columns = columns;
	}

	public Position getPosTrolley() {
		return _posTrolley;
	}

	public void setPosTrolley(Position posTrolley) {
		_posTrolley = posTrolley;
	}
//	End Getter and Setter

	@Override
	public String toString() {
		return "DistributionCenter [_rows=" + _rows + ", _columns=" + _columns + ", _posTrolley=" + _posTrolley
				+ ", getRows()=" + getRows() + ", getColumns()=" + getColumns() + ", getPosTrolley()=" + getPosTrolley()
				+ "]";
	}

	public static void main(String[] args) {
		DistributionCenter logistic = DistributionCenter.instance(5, 5);
		TransportOrder order = new TransportOrder(new Position(2, 3), logistic);
		TransportOrder order1 = new TransportOrder(new Position(-2, 1), logistic);
		Trolley trolley = new Trolley(5, logistic);
		
		System.out.println("Before executing the order: " + trolley);
		trolley.executeTransportOrder(order);
		System.out.println("After executing the order: " + trolley);
		
		System.out.println(trolley.loadItem(new Item("Box", 6)));
		System.out.println(trolley.loadItem(new Item("Banane", 1)));
		trolley.unloadAll();
		System.out.println("After unloading: " + trolley);
	
	}
}
