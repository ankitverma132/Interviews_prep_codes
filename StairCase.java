package DP_1;

public class StairCase {

	//Recursive approach 
	public static long staircase(int n){
		
		if( n == 0 ){
	        return 1;
	    }
	    if( n == 1 || n == 2 ){
	        return n;
	    }
	    
	    return staircase( n-1 )+staircase( n-2 )+staircase( n-3 );
	}
	//Using Memoization
	public static long staircaseM(int n){
		
		long[] storage = new long[n+1];
		return staircaseM( n, storage );
	}
	
	private static long staircaseM(int n, long[] storage) {
		
		if( n == 0 ) {
			storage[n] = 1;
			return storage[n];
		}
		if( n == 1 || n == 2 ) {
			storage[n] = n;
			return storage[n];
		}
		if( storage[n] != 0 ) {
			return storage[n];
		}
		storage[n] = staircaseM( n-1, storage ) +  
				staircaseM( n-2, storage ) + staircaseM( n-3, storage );
		return storage[n];

	}
	// Using DP
	public static long staircaseDP(int n) {

		long[] storage = new long[n+1];
		storage[0] = 1;
		storage[1] = 1;
		storage[2] = 2;
		
		for( int i = 3; i <=n ; i++ ) {
			storage[i] = storage[i-1] + storage[i-2] +  storage[i-3];
		}
        return storage[n];	
	}
	
	public static void main(String[] args) {
		
		System.out.println( staircaseDP( 7 ));

	}

}
