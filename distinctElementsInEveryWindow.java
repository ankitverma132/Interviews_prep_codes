//Count distinct elements in every window of size k
//Given an array of size n and an integer k, return the count of 
//distinct numbers in all windows of size k.
//Example:
//Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
//       k = 4
//Output: 3 4 4 3
//Explanation:
//First window is {1, 2, 1, 3}, count of distinct numbers is 3
//Second window is {2, 1, 3, 4} count of distinct numbers is 4
//Third window is {1, 3, 4, 2} count of distinct numbers is 4
//Fourth window is {3, 4, 2, 3} count of distinct numbers is 3
//
//Input: arr[] = {1, 2, 4, 4};
//       k = 2
//Output: 2 2 1
//Explanation:
//First window is {1, 2}, count of distinct numbers is 2
//First window is {2, 4}, count of distinct numbers is 2
//First window is {4, 4}, count of distinct numbers is 1
            //time complexity O(n)
package Maps;
import java.util.HashMap;

public class distinctElementsInEveryWindow {

	static void countWindowDistinct(int arr[], int k) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int distC = 0;
		for( int i = 0; i < k; i++) {
			if( map.containsKey(arr[i]) ) {
				map.put(arr[i], map.get( arr[i]) + 1 );
				
			}
			else {
				map.put(arr[i], 1);
				distC++;
			}
		}
		System.out.println( distC );
		 // Traverse through the remaining array 
		for( int i = k; i < arr.length; i++ ) {
			// Remove first element of previous window 
            // If there was only one occurrence, then 
            // reduce distinct count. 
			if( map.get(arr[i-k] ) == 1) {
				map.remove( arr[i-k] );
				distC--;
			}
			else {
				map.put(arr[i-k], map.get(arr[i-k]) - 1);
			}
			// Add new element of current window 
            // If this element appears first time, 
            // increment distinct element count 
			if( map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1 );
			}
			else{
				map.put(arr[i], 1);
				distC++;
			}
			System.out.println( distC );
		}		
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 1, 3, 4, 2, 3};
	    int  k = 4;
	    countWindowDistinct( arr, k );
	}
}