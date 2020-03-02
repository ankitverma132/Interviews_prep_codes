package Recursion;
public class StringToInteger {

	public static void main(String[] args) {
		
		String input = "123";
		
		System.out.println(convertStringToInt(input));
		
	}
	
	public static int convertStringToInt(String input){
		
		int pow = Power ( 10, input.length()-1 );
		//System.out.println(pow);
		 
		return helper(input, 0, pow);
	}

	private static int helper(String input, int i, int pow) {

		if( i==input.length()-1 ) {
			return Integer.parseInt( String.valueOf( input.charAt(i) ) );
			
		}
		
		int smallAns =	helper(	input, i+1, pow/10);
		
		int temp = Integer.parseInt( String.valueOf( input.charAt(i) ) );
		
		int Ans = temp*pow + smallAns;
		
		return Ans;
	}
	
	private static int Power(int x, int n) {

		
		if(n==0) {
			return 1;
		}

		return x * Power(x, n-1);
	}

}