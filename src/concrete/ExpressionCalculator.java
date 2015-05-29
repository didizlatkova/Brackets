package concrete;

import java.util.Stack;

public class ExpressionCalculator {

	public boolean isValid(String expression) {
		// starts with digit
		if (Character.isDigit(expression.charAt(0))) {
			return false;
		}

		// ends with digit
		if (Character.isDigit(expression.charAt(expression.length() - 1))) {
			return false;
		}

		Stack<Integer> levelStack = new Stack<Integer>();
		levelStack.push(0);
		Stack<Character> bracketStack = new Stack<Character>();
		char opening;
		for (int i = 0; i < expression.length(); i++) {
			if (levelStack.isEmpty()) {
				return false;
			}
			
			int previousBracketLevel = levelStack.peek();
			switch (expression.charAt(i)) {
			case '{':
				if (previousBracketLevel != 0) {
					return false;
				}
				levelStack.push(3);
				bracketStack.push('{');
				break;
			case '[':
				if (previousBracketLevel != 0 && previousBracketLevel != 3) {
					return false;
				}
				levelStack.push(2);
				bracketStack.push('[');
				break;
			case '(':
				if (previousBracketLevel != 0 && previousBracketLevel != 2) {
					return false;
				}
				levelStack.push(1);
				bracketStack.push('(');
				break;
			case ')':
				opening = bracketStack.pop();
				if (opening != '(') {
					return false;
				}
				levelStack.pop();
				if (levelStack.peek() == 0) {
					levelStack.pop();
				}
				break;
			case ']':
				opening = bracketStack.pop();
				if (opening != '[') {
					return false;
				}
				levelStack.pop();
				if (levelStack.peek() == 0) {
					levelStack.pop();
				}
				break;
			case '}':
				opening = bracketStack.pop();
				if (opening != '{') {
					return false;
				}
				levelStack.pop();
				if (levelStack.peek() == 0) {
					levelStack.pop();
				}
				break;
			}
		}
		
		if (!bracketStack.isEmpty()) {
			return false;
		}
		
		return true;
	}
}
