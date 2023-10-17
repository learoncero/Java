package at.fhv.itb.lro3572;

import java.util.ArrayList;

public class Trolley {
	private final static int DEFAULT_SIZE = 10;
	private DistributionCenter _center;
	private ArrayList<Item> _trolley;
	private Position _currentPos;
	private int _maxWeight;
	private int _currWeight;
	
//	Start Constructor
	public Trolley(int maxWeight, DistributionCenter center) {
		_trolley = new ArrayList<>();
		_center = center;
		_maxWeight = maxWeight;
		_currentPos = new Position(0, 0);
		
	}
	
	public Trolley(DistributionCenter center) {
		this(DEFAULT_SIZE, center);
	}
//	End Constructor
	
//	Start Methods
	private void driveNorth() {
		if (_currentPos.getRow() < _center.getRows()) {
			_currentPos.setRow(_currentPos.getRow() + 1);			
		}
	}
	
	private void driveEast() { 
		if (_currentPos.getColumn() < _center.getColumns())
		_currentPos.setColumn(_currentPos.getColumn() + 1);
	}
	
	private void driveSouth() {
		if (_currentPos.getRow() > 0) {
			_currentPos.setRow(_currentPos.getRow() - 1);
		}
	}
	
	private void driveWest() {
		if (_currentPos.getColumn() > 0) {			
			_currentPos.setColumn(_currentPos.getColumn() - 1);
		}
	}
	
	public String loadItem(Item item) {
		if (_currWeight + item.getWeight() <= _maxWeight) {
			_trolley.add(item);
			_currWeight += item.getWeight();
			return "The item has successfully been loaded!";
		}
		else {
			return "The item is too heavy!";
		}
	}
	
	public void unloadAll() {
		System.out.println(_trolley.toString());
		_trolley.clear();
	}
	
	public void executeTransportOrder(TransportOrder order) {
		if ((order.getDestination().getColumn() - _currentPos.getColumn()) > 0) {
			while (order.getDestination().getColumn() != _currentPos.getColumn()) {
				driveEast();
			}
		}
		else {
			while (order.getDestination().getColumn() != _currentPos.getColumn()) {
				driveWest();
			}
		}
		if ((order.getDestination().getRow() - _currentPos.getRow()) > 0) {
			while (order.getDestination().getRow() != _currentPos.getRow()) {
				driveNorth();
			}
		}
		else {
			while (order.getDestination().getRow() != _currentPos.getRow()) {
				driveSouth();
			}
		}
		_center.setPosTrolley(_currentPos);
		unloadAll();
	}
//	End Methods
	
//	Start toString	
	@Override
	public String toString() {
		return "Trolley [_trolley=" + _trolley + ", _currentPos=" + _currentPos + ", _maxWeight=" + _maxWeight + "]";
	}
//	End toString
}
