//Maximum Distance
//Level EASY
//Given an array that might contain duplicate elements, 
//find the maximum possible distance between occurrences of two repeating elements
//i.e. elements having same value. If there are no duplicate elements in the array, return 0.
//Sample Input :
//9
//1  3  1  4  5  6  4  8  3
//Sample Output :
//7
//Sample Output Explanation :
//arr = [1, 3, 1, 4, 5, 6, 4, 8, 3];
//    index0 = 1
//    index1 = 3
//    index2 = 1
//    index3 = 4
//    index4 = 5
//    index5 = 6
//    index6 = 4
//    index7 = 8
//    index8 = 3
//
//    In the above array, the repeating elements are :- (1, 3, 4)
//    - Distance bw first and last occurence of 1 = 2(index2 - index0)
//    - Distance bw first and last occurence of 3 = 7(index8 - index1)
//    - Distance bw first and last occurence of 4 = 3(index6 - index3)
//
//    So, for the above array you must return 7, as this is maximum possible d
package Maps;
import java.util.HashMap;

public class maxDiffBettweenTwoEqlElem {

	 static int maxDistSance(int[] arr) {
		
		 int maxD = -1;
		 
		 HashMap<Integer, Integer> map = new HashMap<>();
		 for( int i = 0; i < arr.length; i++ ) {
			 
			 if(  map.containsKey(arr[i]) ) {
				 if( maxD < i - map.get(arr[i])) {
					 maxD = i - map.get(arr[i]);
				 }
			 }
			 else {
				 map.put(arr[i], i );
			 }
		 }
		 return maxD;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,5,4,6,5,3,6};
		System.out.println(maxDistSance(arr));
	}
}