//Largest subarray with equal number of 0s and 1s
//Given an array containing only 0s and 1s, 
//find the largest subarray which contain equal no of 0s and 1s.
//Expected time complexity is O(n).
//Examples:
//
//Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
//Output: 1 to 6 (Starting and Ending indexes of output subarray)
//
//Input: arr[] = {1, 1, 1, 1}
//Output: No such subarray
//
//Input: arr[] = {0, 0, 1, 1, 0}
//Output: 0 to 3 Or 1 to 4

package Maps;
import java.util.HashMap;

public class subarrayWithEqualZeroOne {
	//The concept of taking cumulative sum, taking 0’s as -1 
	static int maxLen(int arr[], int n) {   //time complexity O(n)

		int Sum = 0;
		int maxLen = 0;
		HashMap< Integer, Integer > map = new HashMap<>();
		for( int i = 0; i < n; i++ ) {
			
			if (arr[i] == 1) {
				Sum = Sum + 1;
			} else {
				Sum = Sum - 1;
			}
			if (Sum == 0) {
				maxLen = i + 1;
			} 
			else {
				if (map.containsKey(Sum)) {
					if (maxLen < i - map.get(Sum)) {
						maxLen = i - map.get(Sum);
					}
				} else {
					map.put(Sum, i);
				}

			}
		}
		return maxLen;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 0, 1, 1, 1, 0, 0 };
		System.out.println(maxLen(arr, 7));
	}
}