//Count the number of distinct elements with even and odd
//occurrences in the given array. Display odd count first and then even count.
//Sample Input :
//5
//1 5 5 9 1
//Sample Output :
//1 2
package Maps;

import java.util.HashMap;
import java.util.Set;

public class evenOddCount {

	public static void FindOccurance(int[] arr, int size) {
		
		HashMap<Integer,Integer> map1 = new HashMap<>();
		for( int i = 0; i < arr.length; i += 2 ) {
			if( map1.containsKey(arr[i])) {
				map1.put(arr[i], map1.get(arr[i]) + 1 );
			}
			else {
				map1.put(arr[i], 1);
			}
		}
		HashMap<Integer,Integer> map2 = new HashMap<>();
		for( int i = 1; i < arr.length; i += 2 ) {
			if( map2.containsKey(arr[i])) {
				map2.put(arr[i], map2.get(arr[i]) + 1 );
			}
			else {
				map2.put(arr[i], 1);
			}
		}
		Set<Integer> keys1 = map1.keySet();
		Set<Integer> keys2 = map2.keySet();
		int oddC = 0;
		int evenC = 0;
		for( int key : keys1 ) {
			if( map1.get(key) == 1 ) {
				oddC++;
			}
		}
		for( int key : keys2 ) {
			if( map2.get(key) == 1 ) {
				evenC++;
			}
		}
		System.out.println( oddC + " " + evenC );
		
	}
	
	public static void main(String[] args) {

		int arr[] = { 1, 5, 5, 9, 1 };
		FindOccurance( arr, 5 );
		
	}

}
