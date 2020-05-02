//Find whether an array is subset of another array | Added Method 3
//Given two arrays: arr1[0..m-1] and arr2[0..n-1].
//Find whether arr2[] is a subset of arr1[] or not. 
//Both the arrays are not in sorted order. 
//It may be assumed that elements in both array are distinct.
//Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
//Output: arr2[] is a subset of arr1[]
//
//Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
//Output: arr2[] is a subset of arr1[]
//
//Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
//Output: arr2[] is not a subset of arr1[]
package Maps;
import java.util.HashMap;

public class subsetOfAnotherArray {
	
	static boolean isSubset(int arr1[], int arr2[], int m, int n) {

		HashMap<Integer, Boolean> map = new HashMap<>();
		for( int  i = 0; i < m; i++ ) {
			map.put(arr1[i], true);
		}
		for( int i = 0; i < n; i++) {
			if( !map.containsKey(arr2[i])) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,5,6};
		int[] arr2 = {1,2,4,8};
		System.out.println( isSubset( arr1, arr2, 6, 4 ));
	}
}