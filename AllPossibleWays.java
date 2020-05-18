//All possible ways
//Given two integers a and b. You need to find and return the count of 
//possible ways in which we can represent the number a as the
//sum of unique integers raise to the power b.
//For eg. if a = 10 and b = 2, only way to represent 10 as -
//10 = 1^2 + 3^2 
//Hence, answer is 1.
//Note : x^y represents x raise to the power y
//Sample Input 1 :
//10 2
//Sample Output 1 :
//1
//Sample Input 2 :
//100 2
//Sample Output 2 :
//3
package DP_2;

public class AllPossibleWays {
	//Using Recursion
	public static int allWays(int x, int n) {

		return allWays( x, n, 1 );
	}             

	private static int allWays(int x, int n, int num) {

		//Base case
		int val = (int)(x - Math.pow(num, n));
		
		if( val == 0 ) {
			return 1;
		}
		if( val < 0 ) {
			return 0;
		}
		// Consider two possibilities, num is 
        // included and num is not included.
		//If num not included
		int op1 = allWays( x, n, num + 1 );
		//if num is included
		int op2 = allWays( val, n, num + 1 );
		
		return op1 + op2;
	}
//-------------------------------
	//Using Memoization
	public static int allWaysM(int x, int n) {
		
		int[][] storage = new int[x+1][x+1];
		for( int i = 0; i < storage.length; i++ ) {
			for( int j = 0; j < storage[0].length; j++ ) {
				storage[i][j] = -1;
			}
		}
		return allWaysM( x, n, 1, storage );
	}

	private static int allWaysM(int x, int n, int num, int[][] storage ) {

		//Base case
		int val = (int)(x - Math.pow(num, n));
		
		if( val == 0 ) {
			storage[x][num] = 1;
			return storage[x][num];
		}
		if( val < 0 ) {
			storage[x][num] = 0;
			return storage[x][num];
		}
		if( storage[x][num] != -1 ) {
			return storage[x][num];
		}
		// Consider two possibilities, num is 
        // included and num is not included.
		//If num not included
		int op1 = allWaysM( x, n, num + 1, storage );
		//if num is included
		int op2 = allWaysM( val, n, num + 1, storage );
		
		storage[x][num] = op1 + op2;;
		return storage[x][num];
	}

//--------------------------------
	public static void main(String[] args) {
		System.out.println(allWays( 100, 2 ));
		System.out.println(allWaysM( 100, 2 ));
	}
}