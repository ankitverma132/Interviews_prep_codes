//Matrix Chain Multiplication
//Given a chain of matrices A1, A2, A3,.....An, you have to 
//figure out the most efficient way to multiply these matrices
//i.e. determine where to place parentheses to minimise
//the number of multiplications.
//You will be given an array p[] of size n + 1. 
//Dimension of matrix Ai is p[i - 1]*p[i]. You need to find
//minimum number of multiplications needed to multiply the chain.
//Sample Input 1 :
//3
//10 15 20 25
//Sample Output :
//8000
//Sample Output Explanation :
//There are two ways to multiply the chain - A1*(A2*A3) or (A1*A2)*A3.
//If multiply in order A1*(A2*A3) then number of multiplications required are 15000.
//If multiply in order (A1*A2)*A3 then number of multiplications required are 8000.
//Thus minimum number of multiplications required are 8000

package DP_2;

public class MatrixChainMultiplication {
	//Using Recursion
	//Time complexity O(n^2)
	public static int mcm(int[] p) {

		return mcm( p, 0, p.length - 1);
	}

	private static int mcm(int[] p, int s, int e) {

		if (s == e) {
			return 0;
		}
		if (s == e - 1) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		// place parenthesis at different places between first
		// and last matrix, recursively calculate count of
		// multiplications for each parenthesis placement and
		// return the minimum count
		for (int k = s + 1; k < e; k++) {
			int count = mcm(p, s, k) + mcm(p, k, e) + p[s] * p[k] * p[e];

			if (count < min) {
				min = count;
			}
		}
		return min;
	}
//---------------------------------------------------------------	
	//Using Memoization
	public static int mcmM(int[] p) {

		int storage[][] = new int[ p.length ][ p.length ];
		for( int i = 0; i < storage.length; i++ ) {
			for( int j = 0; j < storage[0].length; j++ ) {
				storage[i][j] = -1;
			}
		}
		return mcmM( p, 0, p.length - 1, storage);
	}

	private static int mcmM(int[] p, int s, int e, int[][] storage) {

		if (s == e) {
			storage[s][e] = 0;
			return storage[s][e];
		}
		if (s == e - 1) {
			storage[s][e-1] = 0;
			return storage[s][e-1];
		}
		if( storage[s][e] != -1 ) {
			return storage[s][e] ;
		}
		int min = Integer.MAX_VALUE;
		
		for (int k = s + 1; k < e; k++) {
			int count = mcmM(p, s, k, storage) + 
						mcmM(p, k, e, storage) + p[s] * p[k] * p[e];

			if (count < min) {
				min = count;
			}
		}
		storage[s][e] = min;
		return storage[s][e] ;
	}
//-----------------------------------------------------------------
	//Using DP
	public static int mcmDP(int[] p) {

		int storage[][] = new int[ p.length ][ p.length ];
		
		return mcmM( p, 0, p.length - 1, storage);
	}

//-----------------------------------------------------------------	
	public static void main(String[] args) {

		int[] p = { 10, 15, 20, 25 };
		System.out.println( mcmM(p) );
	}
}