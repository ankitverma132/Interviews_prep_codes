//Make Unique Array
//Find number of elements to be removed to make an array of all distinct elements.
//Example:
//Ar = {2,1,4,2,1} 
//output = 2 (remove 2 and 1).
//Sample Input :
//5
//2 1 4 2 1
//Sample Output :
//2
package Maps;
import java.util.HashMap;

public class makeUniqueArray {

	
	public static int CountExtraElements(int arr[], int n) {
		int count = 0;
		HashMap< Integer, Integer > map = new HashMap<>();
		for( int i = 0; i < arr.length; i++ ) {
			if( map.containsKey(arr[i])) {
				count++;
			}
			else {
				map.put(arr[i], 1);
			}
		}
		return count;
	}
	public static void main(String[] args) {

		int[] arr = {2,1,4,2,1}; 
		System.out.println( CountExtraElements( arr, 5 ) );
	}
}