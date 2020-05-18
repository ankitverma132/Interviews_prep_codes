package DP_2;

public class minCostPath {
	
	//Recursive approach
	public static int minCostPath(int input[][]) {
		
		int i = 0;
		int j = 0;
		return minCostPath( input, i, j );
	}
	//Will give minCostPath from cell (i,j) to cell (m-1, n-1)
	private static int minCostPath(int[][] input, int i, int j) {

		int m = input.length;
		int n = input[0].length;
		if( i == m - 1 && j == n - 1 ) {
			return input[i][j];
		}
		if( i >= m || j >= n ) {
			return Integer.MAX_VALUE;
		}
		
		int op1 =  minCostPath( input, i+1, j);
		int op2 =  minCostPath( input, i, j+1);
		int op3 =  minCostPath( input, i+1, j+1);
		
		return input[i][j] + Math.min(op1, Math.min(op2, op3));
	}
//------------------------
	//Memoization approach
	public static int minCostPathM(int input[][]) {

		int[][] storage = new int[input.length][input[0].length];
		for( int i = 0; i < storage.length; i++ ) {
			for( int j = 0; j < storage[0].length; j++ ) {
				storage[i][j] = -1;
			}
		}
		int i = 0;
		int j = 0;
		return minCostPathM(input, storage, i, j);
	}

	private static int minCostPathM(int[][] input, int[][] storage, int i, int j) {
		
		int m = input.length;
		int n = input[0].length;
		
		if( i >= m || j >= n ) {
			return Integer.MAX_VALUE;
		}
		
		if( i == m - 1 && j == n - 1 ) {
			storage[i][j] = input[i][j];
			return storage[i][j];
		}
		
		if( storage[i][j] != -1 ) {
			return storage[i][j];
		}
		
		int op1 =  minCostPathM( input, storage, i+1, j);
		int op2 =  minCostPathM( input, storage, i, j+1);
		int op3 =  minCostPathM( input, storage, i+1, j+1);
		
		storage[i][j] = input[i][j] + Math.min(op1, Math.min(op2, op3));
		return storage[i][j];
	}
//-----------------------	
	//DP approach
	public static int minCostPathDP(int input[][]) {

		int m = input.length;
		int n = input[0].length;
		int[][] storage = new int[m][n];
		
		storage[m-1][n-1] = input[m-1][n-1];
		
		//For last row
		for( int j = n - 2; j >= 0; j-- ) {
			storage[m-1][j] = storage[m-1][j+1] + input[m-1][j];
		}
		//for last col
		for( int i = m - 2; i >= 0; i-- ) {
			storage[i][n-1] = storage[i+1][n-1] + input[i][n-1];
		}
		//for remaining cells
		for( int i = m - 2; i >= 0; i-- ) {
			for( int j = n-2; j >= 0; j-- ) {
				storage[i][j] = input[i][j] + Math.min(storage[i][j+1], 
							Math.min(storage[i+1][j+1], storage[i+1][j]));
			}
		}
		return storage[0][0];
	}

//--------------------------------		
	public static void main(String[] args) {

		int[][] arr = {{1,1,1},{4,5,2},{7,8,9}};
		System.out.println( minCostPath(arr) );
		System.out.println( minCostPathM(arr) );
		System.out.println( minCostPathDP(arr) );
	}
}