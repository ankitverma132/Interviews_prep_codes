	//Shortest Subsequence
//Gary has two string S and V. Now Gary wants to know the length 
//shortest subsequence in S such that it is not a subsequence in V.
//Note: input data will be such so there will always be a solution.
//Sample Input :
//babab
//babba
//Sample Output :
//3
package DP_2;

public class shortestSubsequence {

		static final int MAX = 1005; 
	//Using recursion
	public static int solve(String S,String V){
		
		if(S.length() == 0 ) {
			return MAX;
		}
		if( V.length() <= 0 ) {
			return 1;
		}
		
		//If shortest subsequence does't include
		//first character of string S
		int op1 = solve( S.substring(1), V );
		
		//If includes
		
		int index;
		for( index = 0; index < V.length(); index++ ) {
			if( V.charAt(index) == S.charAt(0) ) {
				break;
			}
		}
		int op2 = 1;
		if( index == V.length() ) {
			return 1;
		}
		else {
			//ie character found in V
			op2 = 1 +  solve( S.substring(1), V.substring(index+1));
		}
		return Math.min(op1, op2);
	}
//-----------------------------------
	//Using Memoization
	public static int solveM(String S,String V){
		
		int storage[][] = new int[S.length() + 1][V.length() + 1];
		for( int i = 0; i < S.length() + 1; i++ ) {
			for( int j = 0; j < V.length() + 1; j++ ) {
				storage[i][j] = -1;
			}
		}
		return solveM( S, V, storage );
	}

	private static int solveM(String s, String v, int[][] storage) {

		int m = s.length();
		int n = v.length();
		
		if(m == 0 ) {
			storage[m][n] =  MAX;
			return storage[m][n];
		}
		if( v.length() <= 0 ) {
			storage[m][n] =  1;
			
			return storage[m][n];
		}
		if( storage[m][n] != -1 ) {
			return storage[m][n];
		}
		//If shortest subsequence does't include
		//first character of string S
		int op1 = solveM( s.substring(1), v, storage );
		
		//If includes
		
		int index;
		for( index = 0; index < v.length(); index++ ) {
			if( v.charAt(index) == s.charAt(0) ) {
				break;
			}
		}
		int op2 = 1;
		if( index == v.length() ) {
			storage[m][n] =  1;
			return storage[m][n];
		}
		else {
			//ie character found in V
			op2 = 1 +  solveM( s.substring(1), v.substring(index+1),storage);
		}
		storage[m][n] =  Math.min(op1, op2);
		return storage[m][n];
	}
//-------------------------	
	//Using DP
	public static int solveDP(String S,String V){
		
		int m = S.length();
		int n = V.length();
		int storage[][] = new int[m + 1][n + 1];
		
		//When V is empty
		for( int i = 0; i <= m; i++ ) {
			storage[i][0] = 1;
		}
		//When S is empty
		for( int i = 0; i <= n; i++ ) {
			storage[0][i] = MAX;
		}			
		
		for( int i = 1; i <= m; i++ ) {
			for( int j = 1; j <= n; j++ ) {
				
				int op1 = storage[i - 1 ][j];
				char ch = S.charAt(i-1);
				int k;
				for( k = j - 1; k >= 0; k-- ) {
					if( V.charAt(k) == ch ) {
						break;
					}
				}
				int op2 = 1;
 				if( k == -1 ) {
					storage[i][j] = 1;
					
				}
				else{
					op2 = 1 + storage[i-1][k];
				}
				storage[i][j] = Math.min(op1, op2);
			}
		}
		
		if( storage[m][n] >= MAX ) {
			return -1;
		}
		else {
			return storage[m][n];
		}
	}
//-----------------------------------------	
	
	public static void main(String[] args) {

		String s = "babab";
		String v = "babba";
		
		System.out.println( solveDP(s,v) );
	}
}