//Check if frequency of all characters can become same by one removal
//Given a string which contains lower alphabetic characters,
//we need to remove at most one character from this string 
//in such a way that frequency of each distinct character
//becomes same in the string.
//Examples:
//Input: str = “xyyz”
//Output: Yes
//We can remove character ’y’ from above
//string to make the frequency of each
//character same.

package Maps;
import java.util.HashMap;
import java.util.Set;

public class sameFreqByRemoval {

	static boolean checkSameCharFreqByOneRemoval(String str) { 
		
		HashMap<Character,Integer> map = new HashMap<>();
		for( int i = 0; i < str.length(); i++ ) {
			
			if( map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1 );
			}
			else {
				map.put(str.charAt(i), 1);
			}	
		}

		if( isSameFreq( map ) == true ) {
			return true;
		}
		else {
			Set<Character> keys = map.keySet();
			for( char key : keys ) {
				map.put(key, map.get(key) - 1 );
			}
			return isSameFreq( map );
		}
    }
	public static boolean isSameFreq( HashMap<Character,Integer> map ){

		int value = 0;
		Set<Character> keys = map.keySet();
		for( char key : keys ) {
			if( map.get(key) > 0 ) {
				value = map.get(key);
			}
		}
		for( char key : keys ) {
			if( map.get(key) > 0 && map.get(key) != value ) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		String str = "xyyzz";
		if (checkSameCharFreqByOneRemoval(str))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}