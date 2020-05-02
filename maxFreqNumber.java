//Maximum Frequency Number
//You are given an array of integers that contain numbers in random order. 
//Write a program to find and return the number which occurs the maximum times in the given input.
//If two or more elements contend for the maximum frequency,
//return the element which occurs in the array first.
//Sample Input 1 :
//13
//2 12 2 11 12 2 1 2 2 11 12 2 6 
//Sample Output 1 :
//2
//Sample Input 2 :
//3
//1 4 5
//Sample Output 2 :
//1
package Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class maxFreqNumber {

	public static void main(String[] args) {
		
		int[] arr = {675, 28, -429, -290, 444, -949, 992, -850, 280, 810 };
		
		System.out.println( maxFrequencyNumber( arr ) );
	}
	public static int maxFrequencyNumber(int[] arr){
		
		HashMap<Integer, Integer> map = new HashMap<>();

		for( int i = 0; i < arr.length; i++ ) {
			
			if( map.containsKey(arr[i]) ) {
				map.put(arr[i], map.get(arr[i]) + 1 );
			}
			else {
				map.put(arr[i], 1);
			}
		}
		int maxVal = 0;
		int maxkey = -1;
//		Set<Integer> keys = map.keySet();
//		for(  int key : keys ){    
//			if( map.get(key) > maxVal ) {
//				maxVal =  map.get(key);
//				maxkey = key;
//			}
//		}  
		//because yha first element return krna hoga
		//agr max freq k 2 element hue or hasmap m 
		//keys ka order maintained nhi hoga
		for(  int i = 0; i < arr.length; i++ ){    
			if( map.get(arr[i]) > maxVal ) {
				maxVal =  map.get(arr[i]);
				maxkey = arr[i];
			}
		}  
		return maxkey;
	}
}