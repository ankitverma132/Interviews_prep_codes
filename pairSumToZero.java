package Maps;

import java.util.HashMap;
import java.util.Set;
public class pairSumToZero {

	
	public static void PairSum(int[] input, int size) {

		HashMap<Integer,Integer> map = new HashMap<>();
		for( int i = 0; i < size; i++ ) {
			
			if( map.containsKey( input[i] )) {
				map.put(input[i], map.get(input[i])+1 );
			}
			else {
				map.put(input[i], 1);
			}
		}
		Set<Integer> keys = map.keySet();
		for( int key1 : keys ) {
			if( map.containsKey(-key1)) {
				int	key2 = -key1;
				for( int i = 0; i < map.get(key1)*map.get(key2); i++ ) {
						System.out.println( Math.min(key1, key2) + " "
											+ Math.max(key1, key2 ));
				}
				map.put(key1, 0);
				map.put(key2, 0);
			}
		}
	}

	public static void main(String[] args) {
		int arr[]  = { -2, 2 ,6, -2, 2, -6, 3 };
		PairSum( arr, 7 );
	}
}