package Recursion;
public class StaircaseProblem {

	public static void main(String[] args) {

		  System.out.println( stairCase(7) );	
		}

	private static long stairCase(long n) {
		
		
		if( n <= 1) {
			return 1;
		}
		
		if( n == 2) {
			return 2;
		}
		
		return stairCase( n-3 ) + stairCase( n-2 ) + stairCase( n-1 );
		
	
	}	
	
}
