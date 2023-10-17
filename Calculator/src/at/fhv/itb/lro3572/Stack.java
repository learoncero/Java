package at.fhv.itb.lro3572;

public class Stack {

	public final static int DEFAULT_STACKSIZE = 128;
	private int[] _values;
	private int _sp;
	
	public Stack() {
		this (DEFAULT_STACKSIZE);
	}
	
	public Stack(int size) {
		_values = new int[size];
		_sp = 0; // number of items on stack
	}
	
	public void push(int value) {
		_values[_sp++] = value;
	}
	
	public int pop() {
		return _values[--_sp];		
	}
	
	public int top() {
		return _values[_sp - 1];
	}
	
	public boolean isEmpty() {
		return (_sp == 0);
	}
	
	public boolean isFull() {
		return (_sp == _values.length);
	}
	
	public static void main(String[] args) {
		System.out.println("Stack Tests");
		Stack testStack = new Stack(1000);
		testStack.push(12);
		testStack.push(20);
		testStack.push(1);
		if (testStack.isEmpty()) {
			System.out.println("Test failes, 1st isEmpty()!");
		}
		if (testStack.pop() != 1) {
			System.out.println("Test failes, 1st pop()!");
		}
		if (testStack.pop() != 20) {
			System.out.println("Test failes, 2nd pop()!");
		}
		if (testStack.pop() != 12) {
			System.out.println("Test failes, 3rd pop()!");
		}
		if (!testStack.isEmpty()) {
			System.out.println("Test failes, 2nd isEmpty()!");
		}
		testStack.push(15);
		System.out.println(testStack.top());
		
		System.out.println("Test finished");
	}
}
