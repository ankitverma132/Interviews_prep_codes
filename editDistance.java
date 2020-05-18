//Code: Edit Distance
//Send Feedback
//Given two strings s and t of lengths m and n respectively,
//find the Edit Distance between the strings. Edit Distance
//of two strings is minimum number of steps required to make
//one string equal to other. In order to do so you can perform 
//following three operations only :
//1. Delete a character
//
//2. Replace a character with another one
//
//3. Insert a character
//Note - Strings don't contain spaces
//Input Format :
//Line 1 : String s
//Line 2 : String t
//Output Format :
//Line 1 : Edit Distance value
//Constraints
//1<= m,n <= 10
//Sample Input 1 :
//abc
//dc
//Sample Output 1 :
//2
package DP_2;

public class editDistance {

	//Using Recursion
	public static int editDistance(String s1, String s2) {
  
		if( s1.length() == 0 ) {
			return s2.length();
		}
		if( s2.length() == 0 ) {
			return s1.length();
		}
		if( s1.charAt(0) == s2.charAt(0) ) {
			return editDistance( s1.substring(1), s2.substring(1));
		}
		else {
			//if insertion
			int op1 = editDistance( s1, s2.substring(1) );
			//if deletion
			int op2 = editDistance( s1.substring(1), s2 );
			//if substitute
			int op3 = editDistance( s1.substring(1), s2.substring(1));
		
			return 1 + Math.min(op1, Math.min(op2, op3));
		}
	}
//-------------------------------
	// Using Memoization
	public static int editDistanceM(String s1, String s2) {

		int storage[][] = new int[s1.length() + 1][s2.length() + 1];
		for( int i = 0; i < s1.length() + 1; i++ ) {
			for( int j = 0; j < s2.length() + 1; j++ ) {
				storage[i][j] = -1;
			}
		}
		return editDistanceM( s1, s2, storage );
	}

	private static int editDistanceM(String s1, String s2, int[][] storage) {

		int m = s1.length();
		int n = s2.length();
		if( m == 0 ) {
			storage[0][n] = n;
			return storage[0][n];
		}
		if( n == 0 ) {
			storage[m][0] = m;
			return storage[m][0];
		}
		if( storage[m][n] != -1 ) {
			return storage[m][n];
		}
		if( s1.charAt(0) == s2.charAt(0)) {
			storage[m][n] = editDistanceM( s1.substring(1), s2.substring(1), storage );
			
		}
		else {
			//if insertion
			int op1 = editDistanceM( s1, s2.substring(1), storage );
			//if deletion
			int op2 = editDistanceM( s1.substring(1), s2, storage );
			//if substitute
			int op3 = editDistanceM( s1.substring(1), s2.substring(1), storage);
		
			storage[m][n] =  1 + Math.min(op1, Math.min(op2, op3));
		}
		return storage[m][n];
		
	}
//-------------------------	
	// Using DP
	public static int editDistanceDP(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int storage[][] = new int[m + 1][n + 1];
		
		for( int i = 0; i <= n; i++ ) {
			storage[0][i] = i;
		}
		for( int i = 0; i <= m; i++ ) {
			storage[i][0] = i;
		}
		for( int i = 1; i <= m; i++ ) {
			for( int j = 1; j <= n; j++ ) {
				if( s1.charAt(m-i) == s2.charAt(n-j) ) {
					storage[i][j] = storage[i-1][j-1];
				}
				else {
					storage[i][j] = 1 + Math.min(storage[i][j-1], 
							Math.min(storage[i-1][j], storage[i-1][j-1] ));
				}
			}
		}
		return storage[m][n];
	}

//---------------------------------	
	public static void main(String[] args) {

		String s1 = "adefsdasfdasdfasfcacda";
		String s2 = "gdbeadsfafasdfafafddad";
		System.out.println(editDistanceM(s1, s2));
		System.out.println(editDistanceDP(s1, s2));
		System.out.println(editDistance(s1, s2));
	}
}