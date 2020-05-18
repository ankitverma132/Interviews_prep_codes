//Code: Knapsack(Memoization and DP)
//A thief robbing a store and can carry a maximal weight of W into his knapsack.
//There are N items and ith item weigh wi and is of value vi. 
//What is the maximum value V, that thief can take ?
//Space complexity should be O(W).
//Sample Input 1 :
//4
//1 2 4 5
//5 4 8 6
//5
//Sample Output :
//13
package DP_2;

public class zeroOneKnapsack {

	//Using Recursion
	public static int knapsack(int[] weight,int value[],int maxWeight, int n){
		
		return knapsack( weight, value, maxWeight, 0, n );
	}
	public static int knapsack(int[] weight,int value[],int maxWeight,int i, int n){
		
		if( i == weight.length || maxWeight == 0) {
			return 0;
		}
		if( weight[i] > maxWeight ) {
			return knapsack( weight, value, maxWeight, i+1, n );
		}
		else {
			//if included ith item
			int op1 = value[i] + knapsack( weight, value, maxWeight - weight[i], i+1, n );
			//if not included ith item
			int op2 = knapsack( weight, value, maxWeight, i+1, n );
			
			return Math.max(op1, op2);
		}
	}
//------------------------------
	//Using memoization
	//used number of items technnique from gfg
	
	public static int knapsackM(int[] weight, int value[], int maxWeight) {
		
		int storage[][] = new int[ weight.length + 1 ][maxWeight + 1];
		for( int i = 0; i < storage.length; i++ ) {
			for( int j = 0; j < storage[0].length; j++ ) {
				storage[i][j] = -1;
			}
		}
		return knapsackM( weight, value, storage, maxWeight, 0 );
	}
  	private static int knapsackM(int[] weight, int[] value, 
  								int[][] storage, int maxWeight, int i ) {
  		
  		if( i == weight.length || maxWeight == 0) {
			return 0;
		}
  		if( storage[i][maxWeight] != -1 ) {
			return storage[i][maxWeight];
		}		
  		if( weight[i] > maxWeight ) {
  			 storage[i][maxWeight] = knapsackM( weight, value, storage, maxWeight, i+1 ); 
  			 return  storage[i][maxWeight] ; 
  		}
  		else {
  			int op1 = value[i] + knapsackM( weight, value, storage,
  									    	maxWeight - weight[i], i+1 );
  			int op2 = knapsackM( weight, value, storage, maxWeight, i+1 );
  			
  			storage[i][maxWeight] = Math.max(op1, op2);
  			return storage[i][maxWeight];
  		}
  		
//  		if (i < 0) { //Base case
//  	        return 0; 
//  		}
////  		if( maxWeight == 0 ) {
////  			storage[i][maxWeight] = 0;
////  			return storage[i][maxWeight];
////  		}
//  		if( storage[i][maxWeight] != -1 ) {
//  			return storage[i][maxWeight];
//  		}
//  		
//  		if ( weight[i] > maxWeight) { 
//  		  
//  	        storage[i][maxWeight] = knapsackM( weight, value, storage, maxWeight, i-1 ); 
//  	        return  storage[i][maxWeight] ; 
//  	    } 
//  		else {
//  			//if item included
//  			int op1 = value[i] + knapsackM( weight, value, storage,
//  										maxWeight - weight[i], i-1 );
//  			//if item not included
//  			int op2 =  knapsackM( weight, value, storage, maxWeight, i-1 );
//  			
//  			storage[i][maxWeight] = Math.max(op1, op2);
//  			return  storage[i][maxWeight];
//  		}
}
//---------------------------------- 
	//Using DP
	//used number of items technnique from gfg
	
	public static int knapsackDP(int[] weight, int value[], int maxWeight) {
			
		int n = weight.length;
		
		int storage[][] = new int[ n + 1 ][maxWeight + 1];
		
		for( int i = 0; i <= n; i++ ) {
			storage[i][0] = 0;
		}
		for( int i = 0; i <= maxWeight; i++ ) {
			storage[0][i] = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= maxWeight; w++) {

				if( weight[i-1] > maxWeight ) {
					storage[i][w] = storage[i-1][w];
				}
				else {
					int op1 = value[i-1] + storage[i-1][w - weight[i-1]];
					int op2 = storage[i-1][w];
					storage[i][w] = Math.max(op1, op2);
				}
			}
		}
		return storage[n][maxWeight];
	}
//-------------------------------------------------------	
		
	public static void main(String[] args) {
		// TODO Auto-ge	nerated method stub
		int[] weight = { 6,1,2,4,5 };
		int[] value = { 10,5,4,8,6 };
		System.out.println( knapsackM(weight, value, 5 ));
	}
}