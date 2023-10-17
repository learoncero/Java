package at.fhv.itb.lro3572;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int _idCount = 0;
	private int _orderNumber;
	private List<String> _orderDetails;
	
	Order(List<String> orderDetails) {
		_orderNumber = nextID();
		_orderDetails = orderDetails;
	}
	
	private int nextID() {
		return _idCount += 1;
	}
	
	public int getOrderNumber() {
		return _orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		_orderNumber = orderNumber;
	}

	public List<String> getOrderDetails() {
		return _orderDetails;
	}

	public void setOrderDetails(List<String> orderDetails) {
		_orderDetails = orderDetails;
	}

	
}
