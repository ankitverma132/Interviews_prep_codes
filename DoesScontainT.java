package Recursion;
public class DoesScontainT {

	public static void main(String[] args) {
		String a = "abchjsgsuohhdhyrikkknddg";
		String b = "coding";
		System.out.println(checkSequence( a, b ));

	}
   public static boolean checkSequence(String a, String b) {
		
        int i = a.length()-1;
        int j = b.length()-1;
        
        while( j>=0 ){   //time complexity -> O(m+n)   space complexity -> O(1)
            
            if(a.charAt(i) != b.charAt(j)){
                i--;
                if(i==-1){
                    return false;
                }
            }
            else if(a.charAt(i) == b.charAt(j)){
                i--;
                j--;
                if(i==-1){
                    return false;
                }                
            }    
        }
        return true;        
	}
}