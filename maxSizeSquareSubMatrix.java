//Maximum Square Matrix With All Zeros
//Given a n*m matrix which contains only 0s and 1s, find out the size of maximum 
//square sub-matrix with all 0s. You need to return the size of square with all 0s.
//Sample Input :
//3 3
//1 1 0
//1 1 1
//1 1 1
//Sample Output :
//1
package DP_2;

public class maxSizeSquareSubMatrix {
	
	//Using DP
	public static int findMaxSquareWithAllZeros(int[][] input){
		
		int m = input.length;
		int n = input[0].length;
		//This array will store length 
		//of squares ending at index i,j
		int storage[][] = new int[m][n];
		
		//Filling first row and first col
		for( int i = 0; i < m; i++ ) {
			if( input[i][0] == 0 ) {
				storage[i][0] = 1;
			}
			else {
				storage[i][0] = 0;
			}
		}
		for( int i = 0; i < n; i++ ) {
			if( input[0][i] == 0 ) {
				storage[0][i] = 1;
			}
			else {
				storage[0][i] = 0;
			}
		}
		
		for( int i = 1; i < m; i++ ) {
			for( int j = 1; j < n; j++ ) {
				
				if( input[i][j] == 1) {
					storage[i][j] = 0;
				}
				else {
					storage[i][j] = 1 + Math.min(storage[i-1][j-1],
							Math.min(storage[i-1][j], storage[i][j-1]) );
				}
			}
		}
		int maxSquare = Integer.MIN_VALUE;
		for( int i = 0; i < m; i++ ) {
			for( int j = 0; j < n; j++ ) {
				if( storage[i][j] > maxSquare ) {
					maxSquare = storage[i][j];
				}
				
			}
		}
		return maxSquare;
	}
	public static void main(String[] args) {

		
	}

}
