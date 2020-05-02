//using inbuilt map class in this class
package Maps;
import java.util.HashMap;
import java.util.Set;

public class MapUse {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();
		map.put("abc", 1);
		map.put("df", 2);
		map.put("abc1", 1);
		map.put("df1", 2);
		
		System.out.println( "size " +  map.size() );
		
		//-------check Presence
		if( map.containsKey("abc")) {
			System.out.println( "Has abc" );
		}
		if( map.containsKey("abc1")) {
			System.out.println( "Has abc1" );
		}
		if( map.containsValue(2)) {
			System.out.println( "Has 2" );
		}
		//---------
		
		//------get value
		//abc1 is not present it should give error
		//int v = map.get( "abc1" );        //rhs is null 
		//it will give null pointer exception as rhs m 
		//null hai or thn hm null ko acess krne ko try kr rhe
		//System.out.println( v );
		
		//So what should we do
		int v1 = 0;
		if( map.containsKey("abc1")) {
			v1 =  map.get("abc1");
		}
		System.out.println( v1 );	
		//---------
		
		//-----remove
		int s = map.remove("abc");
		System.out.println(s);
		//abc removed
		//------
		
		
		//----Iterate
		Set<String> keys = map.keySet(); //return all keys
		for( String str : keys ) {
			System.out.println( str ); //doesn't maintains order
		}
	
	}

}