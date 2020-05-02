package Maps;
import java.util.HashMap;
import java.util.Set;

public class unionOfTwoArrays {
	
	public static void union(int[] arr1, int[] arr2){
		
		HashMap<Integer, Integer> map1 = new HashMap<>();
		for( int i = 0; i < arr1.length; i++ ) {
			
			if( map1.containsKey(arr1[i]) ) {
				map1.put(arr1[i], map1.get(arr1[i]) + 1 );
			}
			else {
				map1.put(arr1[i], 1);
			}
		}
		HashMap< Integer, Integer > map2 = new HashMap<>();
		for( int i = 0; i < arr2.length; i++ ) {
			if( map2.containsKey(arr2[i]) ) {
				map2.put(arr2[i], map2.get(arr2[i]) + 1 );
			}
			else {
				map2.put(arr2[i], 1 );
			}
		}
		Set<Integer> keys = map1.keySet();
		for( int key : keys ) {
			if( map2.containsKey(key)) {
				for( int i = 0; i < Math.max(map1.get(key), map2.get(key)); i++) {
					System.out.println( key );
				}
				map1.put(key, 0);
				map2.put(key, 0);
			}
			else {
				for (int i = 0; i < map1.get(key); i++) {
					System.out.println(key);
				}
			}
		}
		Set<Integer> keys2 = map2.keySet();
		for (int key : keys2) {
			for (int i = 0; i < map2.get(key); i++) {
				System.out.println(key);
			}
			map2.put(key, 0);
		}
	}
	public static void main(String[] args) {
		int arr1[] = {2,6,1,2};
		int arr2[] = {1,2,3,4,2};
		union( arr1, arr2 );
	}
}