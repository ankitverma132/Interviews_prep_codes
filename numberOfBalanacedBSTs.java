//Code: Number of Balanced BTs Using DP
//Send Feedback
//Given an integer h, find the possible number of balanced 
//binary trees of height h. You just need to return the count 
//of possible binary trees which are balanced.
//This number can be huge, so return output modulus 10^9 + 7.
//Time complexity should be O(h).
//Input Format :
//Integer h
//Output Format :
//Count % 10^9 + 7
//Input Constraints :
//1 <= h <= 10^7
//Sample Input 1:
//3
//Sample Output 1:
//15
//Sample Input 2:
//4
//Sample Output 2:
//315
package DP_1;

public class numberOfBalanacedBSTs {

	//Recursive approach
	public static int balancedTreesOfHeightH(int height){
		
		int mod =  (int) (Math.pow( 10, 9 ) + 7);
		return balancedTreesOfHeightH( height, mod );
		
	}
	public static int balancedTreesOfHeightH(int height, int  mod ){
		
		if( height == 0 || height == 1 ) {  //base case
			return 1;
		}
		
		int x = balancedTreesOfHeightH( height -1 );
		int y = balancedTreesOfHeightH( height -2 );
		long res1 = (long)x * x;
		long res2 = (long)x * y * 2;
		int val1 = (int)( res1 % mod );//int k range m convert kr k int varible m dalege
		int val2 = (int)( res2 % mod );
		return (val1 + val2) % mod;
		
		//return x*x + 2*x*y;  //too big to be stored in integer for 
        //height 7 it will give negative count long krne pr b negative aaega
	}
//-------------------------------------------------	
	public static int balancedTreesOfHeightHM(int height){
		
		int[] storage = new int[height+1];
		int mod =  (int) (Math.pow( 10, 9 ) + 7);
		return balancedTreesOfHeightHM( height, storage, mod ); 
		
	}
	private static int balancedTreesOfHeightHM(int height, int[] storage, int mod) {

		if( height == 0 || height == 1 ) {  //base case
			storage[height] = 1;
			return storage[height];
		}
		if( storage[height] != 0 ) {
			return storage[height];
		}
		
		
		int x = balancedTreesOfHeightHM( height -1, storage, mod );
		int y = balancedTreesOfHeightHM( height -2, storage, mod );
		long res1 = (long)x * x;
		long res2 = (long)x * y * 2;
		int val1 = (int)( res1 % mod );//int k range m convert kr k int varible m dalege
		int val2 = (int)( res2 % mod );
		storage[height] = (val1 + val2) % mod;
		return storage[height];
	}
//----------------------------------------------	
	public static int balancedTreesOfHeightHDP(int height){
		
		int mod =  (int)(Math.pow( 10, 9 ) + 7);
		return balancedTreesOfHeightHDP( height, mod ); 
		
	}
    private static int balancedTreesOfHeightHDP(int height, int mod) {

    	int[] storage = new int[height+1];
    	storage[0] = 1;
    	storage[1] = 1;
    	
    	for( int i = 2; i <= height; i++ ) {
    		long res1 = (long)storage[i-1] * storage[i-1]; 
    		long res2 = (long)storage[i-1] * storage[i-2] * 2;
    		int val1 = (int)( res1 % mod );//int k range m convert kr k int varible m dalege
    		int val2 = (int)( res2 % mod );
    		storage[i] = (val1 + val2) % mod;
    	}
    	return storage[height];
	}
//---------------------------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( balancedTreesOfHeightH( 3 ));
		System.out.println( balancedTreesOfHeightHDP( 3 ));
	}
}