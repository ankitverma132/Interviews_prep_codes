package Maps;
import java.util.HashMap;

public class firstNonRepeatingChar {

	public static char firstNonRepeatingChar(String str){

		HashMap<Character,Integer> map = new HashMap<>();
		for( int i = 0;  i < str.length(); i++ ) {
			
			if( map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1 );
			}
			else {
				map.put(str.charAt(i), 1);
			}
			
		}
		for (int i = 0; i < str.length(); i++) {

			if( map.get(str.charAt(i)) == 1 ) {
				return str.charAt(i);
			}
		}
		return str.charAt(0);
	}
	
	public static void main(String[] args) {
		System.out.println( firstNonRepeatingChar( "aDcadhc" ) );
	}

}
