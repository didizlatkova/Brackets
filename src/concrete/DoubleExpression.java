package concrete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import abstracts.Expression;

public class DoubleExpression implements Expression {

	private static HashMap<Character, Character> bracketTypes;

	private List<Expression> subexpressions;
	private String value;

	static {
		bracketTypes = new HashMap<Character, Character>();
		bracketTypes.put('{', '}');
		bracketTypes.put('[', ']');
		bracketTypes.put('(', ')');
	}

	public DoubleExpression(String value) {
		this.subexpressions = new ArrayList<Expression>();
		this.value = value;
		this.build();
	}

	@Override
	public int evaluate() {
		int sum = 0;
		for (Expression subExpression : subexpressions) {
			if (subExpression instanceof TerminalExpression) {
				sum += subExpression.evaluate();
			} else {
				sum += 2 * subExpression.evaluate();
			}
		}

		return sum;
	}

	public void build() {
		int i = 1;
		while (i < this.value.length() - 1) {
			if (Character.isDigit(this.value.charAt(i))) {
				Stack<Integer> digits = new Stack<Integer>();
				while (Character.isDigit(this.value.charAt(i))) {
					digits.push(Character.getNumericValue(this.value.charAt(i)));
					i++;
				}
				
				int multiplier = 1;
				int number = 0;
				while (!digits.isEmpty()) {
					number += multiplier * digits.pop();
					multiplier *= 10;
				}
				TerminalExpression terminal = new TerminalExpression(number);
				this.subexpressions.add(terminal);
			} else {
				int closingBracketIndex = this.value.indexOf(
						bracketTypes.get(this.value.charAt(i)), i);
				String doubleExpressionValue = this.value.substring(i,
						closingBracketIndex + 1);
				DoubleExpression doubleExpression = new DoubleExpression(
						doubleExpressionValue);
				this.subexpressions.add(doubleExpression);
				i += doubleExpressionValue.length();
			}
		}
	}

}