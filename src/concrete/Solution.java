package concrete;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		ExpressionValidator validator = new ExpressionValidator();
		if (validator.isValid(input)) {
			DoubleExpression expression = new DoubleExpression(input);
			System.out.println(expression.evaluate());
		} else {
			System.out.println("NO");
		}

		sc.close();
	}

}
