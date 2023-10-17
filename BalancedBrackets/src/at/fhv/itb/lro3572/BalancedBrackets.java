package at.fhv.itb.lro3572;

public class BalancedBrackets {

	public boolean areBracketsBalanced(String expression) {
		Stack stack = new Stack(128);
		int i = 0;
		
		while (i < expression.length()) {
			char character = expression.charAt(i);

			if ((character == '(') || (character == '[') || (character == '{')) {
				stack.push(character);
			}
			
			else if ((character == ')') || (character == ']') || (character == '}')) {
				if (stack.isEmpty()) {
					return false;
				}
				
				int pop;
				
				switch(character) {
					case ')':
						pop = stack.pop();
						if ((pop == '[') || (pop == '{')) {
							return false;
						}
						break;
						
					case ']':
						pop = stack.pop();
						if ((pop == '(') || (pop == '{')) {
							return false;
						}
						break;
					
					case '}':
						pop = stack.pop();
						if ((pop == '(') || (pop == '[')) {
							return false;
						}
						break;
				}
			}
			i+= 1;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String expression = "[]{fhgj}hfgj{hg[fj(hgj)f(df)]}ds{(sad)}";
		BalancedBrackets check = new BalancedBrackets();
		
		boolean result = check.areBracketsBalanced(expression);
		
		if (result == true) {
			System.out.println("Brackets are balanced");
		}
		else {
			System.out.println("Brackets are not balanced");
		}

	}
}
