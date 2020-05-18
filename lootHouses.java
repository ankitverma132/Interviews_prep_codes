//Loot Houses
//A thief wants to loot houses. He knows the amount of money in each house. 
//He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
//Sample Input :
//6
//5 5 10 100 10 5
//Sample Output 1 :
//110
package DP_2;

public class lootHouses {

	//Using recursion
	public static int getMaxMoney(int arr[], int n) {

		return getMaxMoney( arr, n, 0 );
	}

	private static int getMaxMoney(int[] arr, int n, int i) {

		if( i >= n ) {
			return 0;
		}
		int op1 = arr[i] + getMaxMoney( arr, n, i+2 );
		int op2 = getMaxMoney( arr, n, i+1 );
		
		return Math.max(op1, op2);
	}
//---------------------------------
	
	//Using memoization
	public static int getMaxMoneyM(int arr[], int n) {
		
		int[] storage = new int[n];
		for( int i = 0; i < storage.length; i++ ) {
				storage[i] = -1;
		}
		return getMaxMoneyM( arr, n, 0, storage );
	}

	private static int getMaxMoneyM(int[] arr, int n, int i, int[] storage ) {

	
		if( i >= n ) {
			return 0;
		}
		
		int op1 = arr[i] + getMaxMoneyM( arr, n, i+2, storage );
		int op2 = getMaxMoneyM( arr, n, i+1, storage );
		
		storage[n-1] =  Math.max(op1, op2);
		return storage[n-1];
	}
//--------------------------------	
	
	// Using Dp
	public static int getMaxMoneyDP(int arr[], int n) {

		int[] storage = new int[n];

		storage[0] = arr[0];
		storage[1] = Math.max(arr[0], arr[1]);
		
		for( int  i = 2; i < n; i++ ) {
			
			int op1 = arr[i] + storage[i-2];
			int op2 = storage[i-1];
			storage[i] = Math.max(op1, op2);
			
		}
		return storage[n-1];
	}
//--------------------------------	
	public static void main(String[] args) {

		int[] arr = {5,5,10,100,10,5};
		System.out.println( getMaxMoneyM( arr, 6 ) );
	}
}