//Check redundant brackets
//Given a string mathematical expression, return true if 
//redundant brackets are present in the expression. Brackets are redundant 
//if there is nothing inside the bracket or more than one pair of brackets are present.
//Assume the given string expression is balanced and contains only one type of bracket i.e. ().

package StackAndQueue;

import java.util.Stack;

public class checkRedundantBrackets {

	public static void main(String[] args) {

		String input = "(a+(b+c))";
		System.out.println(checkRedundantBrackets(input));

	}

	public static boolean checkRedundantBrackets(String input) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '(') {
				stack.push(input.charAt(i));
			}

			else if (input.charAt(i) == ')') {
				int count = 0;
				if (stack.peek() != '(') {
					char ch = stack.pop();
					count++;
				} else {
					if (count > 0) {
						char ch = stack.pop();
					} else {
						return true;
					}
				}
			} else {
				stack.push(input.charAt(i));
			}

		}
		return false;
	}
}