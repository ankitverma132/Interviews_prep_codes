//Extract Unique characters
//Given a string, you need to remove all the duplicates. That means, 
//the output string should contain each character only once.
//The respective order of characters should remain same.
//Sample Input 1 :
//ababacd
//Sample Output 1 :
//abcd
//Sample Input 2 :
//abcde
//Sample Output 2 :
//abcde
package Maps;
import java.util.HashMap;
import java.util.Set;

public class uniqueChar {
	
	public static String uniqueChar(String str){

		HashMap<Character,Boolean> map = new HashMap<>();
		String Output = "";
		for( int i = 0; i < str.length(); i++ ) {
			
			if( map.containsKey(str.charAt(i))) {
				continue;
			}
			else {
				Output += str.charAt(i);
				map.put(str.charAt(i), true );
			}
		}
		return Output;
	}
	public static void main(String[] args) {
		System.out.println( uniqueChar( "o&6nQ0DT$3"));
	}
}