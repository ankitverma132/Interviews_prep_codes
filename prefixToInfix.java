//Prefix to Infix Conversion
//Example : *+AB-CD (Infix : (A+B) * (C-D) )
//Input :  Prefix :  *+AB-CD
//Output : Infix : ((A+B)*(C-D))
//
//Input :  Prefix :  *-A/BC-/AKL
//Output : Infix : ((A-(B/C))*((A/K)-L)) 
//Algorithm for Prefix to Infix:
//
//Read the Prefix expression in reverse order (from right to left)
//If the symbol is an operand, then push it onto the Stack
//If the symbol is an operator, then pop two operands from the Stack
//Create a string by concatenating the two operands and the operator between them.
//string = (operand1 + operator + operand2)
//And push the resultant string back to Stack
//Repeat the above steps until end of Prefix expression.

package StackAndQueue;
import java.util.Stack;

public class prefixToInfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prefix = "*-A/BC-/AKL";
		System.out.println( prefixToInfix(prefix) );
	}

    static String prefixToInfix(String str) {
    	
    	Stack<String> s = new Stack<>();
    	
    	for( int i = str.length()-1; i >= 0; i-- ) {
    		
    		char ch = str.charAt(i);
    		
    		if( ch > 64 && ch < 92 ) {
    			s.push( Character.toString(ch) );
    		}
    		else {
    			String s1 = s.pop();
    			String s2 = s.pop();
    			
    			String ans = "(" + s1 + Character.toString(ch) + s2 + ")";
    			s.push(ans);
    		}
    	}
		return s.pop();
	}
}