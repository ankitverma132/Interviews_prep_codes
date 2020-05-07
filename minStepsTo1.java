//Code: Min Steps to One using DP
//Given a positive integer n, find the minimum number of steps s, 
//that takes n to 1. You can perform any one of the following 3 steps.
//1.) Subtract 1 from it. (n= n - ­1) ,
//2.) If its divisible by 2, divide by 2.( if n%2==0, then n= n/2 ) ,
//3.) If its divisible by 3, divide by 3. (if n%3 == 0, then n = n / 3 ). 
//The time complexity of your code should be O(n).
//Input format :
//Line 1 : A single integer i.e. n
//Output format :
//Line 1 : Single integer i.e number of steps
//Constraints :
//1 <= n <= 10^5
//Sample Input 1 :
//4
//Sample Output 1 :
//2 
//Sample Output 1 Explanation :
//For n = 4
//Step 1 : n = 4/2 = 2
//Step 2 : n = 2/2 = 1
//Sample Input 2 :
//7
//Sample Output 2 :
//3
//Sample Output 2 Explanation :
//For n = 7
//Step 1 : n = 7 ­ - 1 = 6
//Step 2 : n = 6 / 3 = 2
//Step 3 : n = 2 / 2 = 1
package DP_1;

public class minStepsTo1 {

	//Using brute-force method
	public static int countStepsTo1(int n){
		
		if( n == 1 ) {
			return 0;
		}
		int op1 = countStepsTo1( n -1 );
		int minSteps = op1;
		if( n%3 == 0 ) {
			int op2 = countStepsTo1( n/3 );
			if( op2 < minSteps ) {
				minSteps = op2;
			}
		}
		if( n%2 == 0 ) {
			int op3 = countStepsTo1( n/2 );
			if( op3 < minSteps ) {
				minSteps = op3;
			}
		}
		return 1 + minSteps;
	}
//-------------------------------------------
	
//	public static int countStepsTo1(int n){
//		
//		if( n == 1 ) {
//			return 0;
//		}
//		if( n == 2 || n == 3 ) {
//			return 1;
//		}
//		
//		int count1 = countStepsTo1( n - 1 );
//		int count2 = Integer.MAX_VALUE;
//		if( n%2 == 0 ) {
//			count2 = countStepsTo1( n/2 );
//		}
//		int count3 = Integer.MAX_VALUE;
//		if( n%3 == 0 ) {
//			count3 = countStepsTo1( n/3 );
//		}
//		return 1 + Math.min(count1, Math.min(count2, count3));
//	}
//---------------------------------------------
	
	//Using Memoization
	public static int countStepsTo1M(int n){
		int storage[] = new int[n+1];
		//by default entries are 0
        return countStepsTo1M( n, storage );
	}
	
	private static int countStepsTo1M(int n, int[] storage) {

		if( n == 1 ) {
			storage[n] = 0;
			return storage[n];
		}
		if( storage[n] != 0  ) {
			return storage[n];
		}
		int op1 = countStepsTo1M( n -1, storage );
		int minSteps = op1;
		if( n%3 == 0 ) {
			int op2 = countStepsTo1M( n/3, storage );
			if( op2 < minSteps ) {
				minSteps = op2;
			}
		}
		if( n%2 == 0 ) {
			int op3 = countStepsTo1M( n/2, storage );
			if( op3 < minSteps ) {
				minSteps = op3;
			}
		}
		storage[n] = 1 + minSteps;
		return storage[n];
	}
//-----------------------------------------
	
	//Using DP
	public static int countStepsTo1DP(int n){
		
		int storage[] = new int[n+1];
		storage[1] = 0;
		
		for( int i = 2; i <= n; i++ ) {
			int minSteps = storage[ i-1 ];
			if( i%3 == 0 ) {
				if( minSteps > storage[ i/3 ]) {
					minSteps  = storage[ i/3 ];
				}
			}
			if( i%2 == 0 ) {
				if( minSteps > storage[ i/2 ]) {
					minSteps  = storage[ i/2 ];
				}
			}
			storage[i] = 1 + minSteps;
		}
		return storage[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( countStepsTo1( 10 ));
		System.out.println( countStepsTo1M( 10 ));
		System.out.println( countStepsTo1DP( 10 ));
	}
}