package Maps;
public class OurMapUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer >  map = new Map<>();
		for( int i = 0; i < 20 ; i++ ) {
			//inserting key value 
			map.insert("abc" + i , 1 + i );
			System.out.println("i = " + i + " lf = " + map.loadFactor() );
			
		}
		//checking deletion
		map.removeKey("abc2");
		
		for( int i = 0; i < 20 ; i++ ) {
			//check insertion and search
			System.out.println("abc" + i + " : " + map.getValue("abc" + i));
			
		}
	}
}