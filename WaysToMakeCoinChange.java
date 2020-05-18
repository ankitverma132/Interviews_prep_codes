package DP_2;

public class WaysToMakeCoinChange {
	//Using Recursion
//	public static int countWaysToMakeChange(int denominations[], int value){
//
//		return countWaysToMakeChange( denominations, denominations.length, value );
//	}
//	
//	private static int countWaysToMakeChange(int[] denominations, int n, int value) {
//
//		//Base case
//		if( value == 0 ) {
//			return 1;
//		}
//		if( value < 0 ) {
//			return 0;
//		}
//		if( n <= 0 && value >= 1 ) {
//			return 0;
//		}
//		// If denominations[n-1]  not included
//		int op1 = countWaysToMakeChange( denominations, n-1, value );
//		// If denominations[n-1]  included
//		int op2 = countWaysToMakeChange( denominations, n, value - denominations[n-1] );
//		
//		return op1 + op2;
//	}
	public static int countWaysToMakeChange(int denominations[], int value){

		return countWaysToMakeChange( denominations, 0, value );
	}
	
	private static int countWaysToMakeChange(int[] denominations, int i, int value) {

		//Base case
		if( value == 0 ) {
			return 1;
		}
		if( value < 0 ) {
			return 0;
		}
		if( i >= denominations.length && value >= 1 ) {
			return 0;
		}
		// If denominations[n-1]  not included
		int op1 = countWaysToMakeChange( denominations, i+1 , value );
		// If denominations[n-1]  included
		int op2 = countWaysToMakeChange( denominations, i, value - denominations[i] );
		
		return op1 + op2;
	}
//------------------------------------------
	//USing Memoization
	public static int countWaysToMakeChangeM(int denominations[], int value){

		int storage[][] = new int[denominations.length + 1][value + 1];
		for( int i = 0; i < denominations.length + 1; i++ ) {
			for( int j = 0; j < value + 1; j++ ) {
				storage[i][j] = -1;
			}
		}
		return countWaysToMakeChangeM( denominations, 0, value, storage );
	}
	
	private static int countWaysToMakeChangeM(int[] denominations, int i, int value, int[][] storage) {

		//Base case
		if( value == 0 ) {
			storage[i][value] = 1;
			return storage[i][value] ;
		}
		if( value < 0 ) {
			return 0;
		}
		if( i >= denominations.length && value >= 1 ) {
			return 0;
		}
		if( storage[i][value] != -1 ) {
			return storage[i][value];
		}
		// If denominations[n-1]  not included
		int op1 = countWaysToMakeChangeM( denominations, i+1 , value , storage);
		// If denominations[n-1]  included
		int op2 = countWaysToMakeChangeM( denominations, i, value - denominations[i], storage );
		
		storage[i][value] =  op1 + op2;
		return storage[i][value] ;
	}
//---------------------------------
	// USing DP
	public static int countWaysToMakeChangeDP(int denominations[], int value) {

		int storage[][] = new int[denominations.length + 1][value + 1];
		
		for( int i = 0; i <= denominations.length; i++ ) {
			storage[i][0] = 1;
		}
		
		
		
		
		return countWaysToMakeChangeM(denominations, 0, value, storage);
	}
//-----------------------------		
	public static void main(String[] args) {
		
		int arr[] = { 1, 2, 3 };
		System.out.println( countWaysToMakeChangeM( arr, 5 ));
	}
}