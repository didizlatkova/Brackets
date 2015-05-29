package concrete;

import abstracts.Expression;

public class TerminalExpression implements Expression {

	private int value;

	public TerminalExpression(int value) {
		this.value = value;
	}

	@Override
	public int evaluate() {
		return this.value;
	}
}
