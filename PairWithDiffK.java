//Pairs with difference K
//You are given with an array of integers and an integer K. 
//Write a program to find and print all pairs which have difference K.
//Take difference as absolute.
//Output format :
//Print pairs in different lines (pair elements separated by space). 
//In a pair, smaller element should be printed first.
//(Order of different pairs is not important)
//Sample Input 1 :
//4 
//5 1 2 4
//3
//Sample Output 1 :
//2 5
//1 4
//Sample Input 2 :
//4
//4 4 4 4 
//0
//Sample Output 2 :
//4 4
//4 4
//4 4
//4 4
//4 4
//4 4
package Maps;

import java.util.HashMap;
import java.util.Set;

public class PairWithDiffK {
	
	public static void findPairsDifferenceK(int[] input, int k){
		
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for( int i = 0; i < input.length; i++ ) {
			
			if( map.containsKey( input[i] )) {
				map.put(input[i], map.get(input[i])+1 );
			}
			else {
				map.put(input[i], 1);
			}
		}
		Set<Integer> keys = map.keySet();
		
	if( k == 0 ) {
		for( int key : keys ) {
			for( int i  = 0; i < ncr(map.get(key)); i++ ) {
				System.out.println( key + " " + key );
			}
		}
	}
		
	else {
		for( int key1 : keys ) {
			if( map.containsKey( key1 - k )) {
				int	key2 = key1 - k ;
				for( int i = 0; i < map.get(key1)*map.get(key2); i++ ) {
						System.out.println( Math.min(key1, key2) + " "
											+ Math.max(key1, key2 ));
				} 
			}
			if( map.containsKey( key1 + k )) {
				int	key3 = key1 + k ;
				for( int i = 0; i < map.get(key1)*map.get(key3); i++ ) {
							System.out.println( Math.min(key1, key3) + " "
												+ Math.max(key1, key3));
				} 
			}
			map.put( key1, 0 );
		}
	}
		//brute force method time complexity O(n^2)
//	 for( int i = 0; i < input.length - 1; i++ ){
//         for( int j = i + 1; j < input.length; j++ ){
//             if(Math.abs( input[i] - input[j] ) == k){
//                 System.out.println( Math.min(input[i], input[j] ) + " "
//                		 				+ Math.max(input[i], input[j] ));
//             	}
//         	}
//	 	}
     }   
	private static int ncr( int n ) {   //nC2

		return ( fact(n) / ( 2 * fact(n-2) ) );
	}
	
	private static int fact(int n) {
		if( n == 0 || n == 1 ) {
			return 1;
		}
		return n*fact(n-1);
	}
	
	public static void main(String[] args) {

		int arr[] = { 2, -1, 3 , 5, 6, 0, -1, 2 ,6 };
		findPairsDifferenceK( arr, 3 );
	}
}