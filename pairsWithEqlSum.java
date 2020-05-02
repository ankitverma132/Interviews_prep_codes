//Find four elements a, b, c and d in an array such that a+b = c+d
//Given an array of distinct integers, find if there are two pairs 
//(a, b) and (c, d) such that a+b = c+d, and a, b, c and d
//are distinct elements. If there are multiple answers, then print any of them.
//Input:   {3, 4, 7, 1, 2, 9, 8}
//Output:  (3, 8) and (4, 7)
//Explanation: 3+8 = 4+7
//
//Input:   {3, 4, 7, 1, 12, 9};
//Output:  (4, 12) and (7, 9)
//Explanation: 4+12 = 7+9
//
//Input:  {65, 30, 7, 90, 1, 9, 8};
//Output:  No pairs found
package Maps;
import java.util.HashMap;

class pair{
	int a;
	int b;
}

public class pairsWithEqlSum {

	static boolean findPairs(int arr[]) {   //time complexity o(n^2)
		
		HashMap<Integer, pair > map = new HashMap<>();
		for( int i = 0; i < arr.length -1; i++ ) {
			for( int j = i+1; j < arr.length; j++ ) {
				
				if( map.containsKey(arr[i] + arr[j])) {
					System.out.println( "(" + arr[map.get(arr[i] + arr[j]).a]
							+ "," + arr[map.get(arr[i] + arr[j]).b] + ") and" 
							+ "(" + arr[i] + "," + arr[j] + ")" );
							
					return true;
				}
				else {
					pair newPair = new pair();
					newPair.a = i;
					newPair.b = j;
					map.put(arr[i]+arr[j], newPair );
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] arr = {3,4,7,1,2,9,8};
		System.out.println( findPairs( arr ));
	}
} 