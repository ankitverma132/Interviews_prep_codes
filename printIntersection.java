//Print Intersection
//Given two random integer arrays, print their intersection. 
//That is, print all the elements that are present in both the given arrays.
//Input arrays can contain duplicate elements.
//Sample Input 1 :
//6
//2 6 8 5 4 3
//4
//2 3 4 7 
//Sample Output 1 :
//2 
//4 
//3
//Sample Input 2 :
//4
//2 6 1 2
//5
//1 2 3 4 2
//Sample Output 2 :
//2 
//2
//1
package Maps;

import java.util.HashMap;
import java.util.Set;

public class printIntersection {
	
	public static void intersection(int[] arr1, int[] arr2){
		
		HashMap<Integer, Integer> map1 = new HashMap<>();
		for( int i = 0; i < arr1.length; i++ ) {
			
			if( map1.containsKey(arr1[i]) ) {
				map1.put(arr1[i], map1.get(arr1[i]) + 1 );
			}
			else {
				map1.put(arr1[i], 1);
			}
		}
		
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for( int i = 0; i < arr2.length; i++ ) {
			
			if( map2.containsKey(arr2[i]) ) {
				map2.put(arr2[i], map2.get(arr2[i]) + 1 );
			}
			else {
				map2.put(arr2[i], 1);
			}
		}
		
		Set<Integer> keys = map1.keySet();
		for( int key : keys ) {
			if( map2.containsKey(key) ) {
				for( int i = 0; i < Math.min(map1.get(key), map2.get(key)); i++ ) {
					System.out.println(key);
				}
			}
		}

	}	
	public static void main(String[] args) {
		
		int arr1[] = {2,6,1,2};
		int arr2[] = {1,2,3,4,2};
		intersection( arr1, arr2 );
	}
}