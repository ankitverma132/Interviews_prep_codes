package Recursion;

public class RemoveDuplicates {

	public static void main(String[] args) {

		String s = "aabbcdd";
		System.out.println( removeConsecutiveDuplicates( s ) );
		
	}

	public static String removeConsecutiveDuplicates(String s) {
		
		if( s.length() == 1 ) {
			return s;			
		}
		
		String Ans = "";
		
		if( s.charAt(0) != s.charAt(1) ) {
			Ans = Ans + s.charAt(0);
		}
				
		String smallAns =  removeConsecutiveDuplicates( s.substring(1) );
		return Ans + smallAns;

		
       // return helper( s, 0 );
	}
    
//    public static String helper( String s, int i ){
//        
//        if( i == s.length()-1 ){
//              return Character.toString( s.charAt(i) );         
//            
//        }
//                
//       String smallAns = helper( s, i+1 );
//        
//        if( s.charAt(i) != smallAns.charAt(0)){
//           return s.charAt(i) + smallAns ;
//            
//        }
//        else{
//            return smallAns ; 
//            
//        }
//    }

}
