//Code: Minimum Count of Squares
//Given an integer N, find and return the count of minimum numbers,
//sum of whose squares is equal to N.
//That is, if N is 4, then we can represent it as :
//{1^2 + 1^2 + 1^2 + 1^2} and {2^2}. Output will be 1, as 1 is the
//minimum count of numbers required.
//Note : x^y represents x raise to the power y.
//Input Format :
//Integer N
//Output Format :
//Required minimum count
//Constraints :
//1 <= N <= 1000
//Sample Input 1 :
//12
//Sample Output 1 :
//3
//Sample Output 1 Explanation :
//12 can be represented as :
//1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1
//1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 2^2
//1^1 + 1^1 + 1^1 + 1^1 + 2^2 + 2^2
//2^2 + 2^2 + 2^2
//As we can see, the output should be 3.
//Sample Input 2 :
//9
//Sample Output 2 :
//1
package DP_1;

public class minCountOfSquares {
	
//------------------------------	
	//Recursive approach
	public static int minCount(int n) {

		if( n<=3 ) {
			return n;
		}
		
		int count = n;
		for( int i = 1; i <= Math.sqrt(n); i++ ) {
			
			int count1 = 1 + minCount( n - i*i );
			if( count1 < count ) {
				count = count1;
			}
		}
		return count;
	}
//------------------------------
	//Memoization approach
	public static int minCountM(int n) {

		int[] storage = new int[n+1];
		for( int i = 0; i < storage.length; i++ ) {
			storage[i] = -1;
		}
		return minCountM( n, storage );
	}

	private static int minCountM(int n, int[] storage) {

		if( n<=3 ) {
			storage[n] = n;
			return storage[n];
		}
		
		if( storage[n] != -1 ) {
			return storage[n];
		}
		storage[n] = n;
		for( int i = 1; i <= Math.sqrt(n); i++ ) {
			
			int count1 = 1 + minCountM( n - i*i, storage );
			if( count1 < storage[n] ) {
				storage[n] = count1;
			}
		}
		return storage[n];		
	}
//--------------------------------------
	//Using DP
	public static int minCountDP(int n) {
		
		if( n <= 3 ) {
			return n;
		}

		int[] storage = new int[n+1];
		storage[0] = 0;
		storage[1] = 1;
		storage[2] = 2;
		storage[3] = 3;
		
		
		for( int i = 4; i <= n; i++ ) {
			storage[i] = i;
			for( int j = 1; j <= Math.sqrt(i); j++ ) {
				storage[i] = Math.min( storage[i-j*j] + 1 , storage[i]);
			}
		}
		
		return storage[n];
	}
//------------------------------------
	public static void main(String[] args) {
		
		System.out.println( minCountDP(10));
	}
}