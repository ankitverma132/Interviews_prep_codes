public class PalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String s = "aba";
		   int count = 0;
			
			for(int i=0; i<s.length(); i++) {
		 	    for(int j=i; j<s.length(); j++) {
				
		 		boolean flag = isPalindrome(s, i ,j);
		 		//System.out.println(flag);
		 		if(flag ==true) {
		 			count++;
		 		  }
		 	    }
			}
			System.out.print( count );
		}
	   public static boolean isPalindrome(String str, int a, int b) {
		   
		   boolean flag = true;
		   if (b-a==0) {
			   return true;
		   }
		   else {
			   int i=a, j=b;
			   while(i<j) {
				   if(str.charAt(i) != str.charAt(j)) {
					   flag = false;
					   break;
				     }
				   else {
					   i++;
					   j--;
				   }
			     }
		   }
		   return flag;
	}

}