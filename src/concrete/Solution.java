package concrete;

public class Solution {

	public static void main(String[] args) {
		ExpressionCalculator calculator = new ExpressionCalculator();
		String expression = "(123)(123)";
		
		// valid
		expression = "(123)";
		expression = "[(123)(123)]";
		expression = "[23(123)12(123)]";
		expression = "{123[123(123)123(123)]23[123]2}";
		expression = "[123]";
		expression = "{123}";		
		expression = "[123(145)38(37)812]";
		expression = "{125[2][(1)][3]125}";
		expression = "[125()125()125()125]";
		
		
		// invalid
		expression = "123(123)";
		expression = "(123[123])";
		expression = "[123(123])";
		expression = "[123{123}]";
		expression = "(123)(123)";
		expression = "{125()125}";
		expression = "{125[12]{125}[12]125}";
		expression = "{125[12(123]125}";
		

		System.out.println(calculator.isValid(expression));
	}

}
