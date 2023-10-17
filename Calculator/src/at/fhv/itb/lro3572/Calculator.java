package at.fhv.itb.lro3572;

public class Calculator {
		
	public int evaluate(String expression) {
		Stack stack = new Stack(128);
		String[] splitExpression = expression.split(" ");
		
		for (int i = 0; ((i < splitExpression.length) && (splitExpression[i] != "=")); i += 1) {
			int operand1;
			int operand2;
			
			switch (splitExpression[i]) {
			
				case "+": {
					operand1 = stack.pop();
					operand2 = stack.pop();
					stack.push(operand2 + operand1);
					break;
				}
				case "-": {
					operand1 = stack.pop();
					operand2= stack.pop();
					stack.push(operand2 - operand1);
					break;
				}
				case "*": {
					operand1 = stack.pop();
					operand2 = stack.pop();
					stack.push(operand2 * operand1);
					break;
				}
				case "/": {
					operand1 = stack.pop();
					operand2 = stack.pop();
					stack.push(operand2 / operand1);
					break;
				}
				case "=": {
					return stack.top();
				}
				default:
					int value = Integer.parseInt(splitExpression[i]);
					stack.push(value);
				}	
		}	
		return stack.top();
	}
	

	public static void main(String[] args) {
		System.out.println("Calculator\n");
		String expression = "14 3 * 4 * 12 3 - 5 * /";
		
		Calculator calc = new Calculator();
		int result = calc.evaluate(expression);
		System.out.println("Expression: " + expression + "\nResult: " + result);
	}
}
