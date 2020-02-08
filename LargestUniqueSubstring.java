
public class LargestUniqueSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcdabed";
		
		int maxlen = Integer.MIN_VALUE;
			int sp = 0, ep = 0;
			
			for(int i=0; i<str.length()-1; i++) {
		 	    for(int j=i+1; j<str.length(); j++) {
				
		 		boolean flag = isUnique(str, i ,j);
		 		//System.out.println(flag);
		 		if(flag ==true) {
		 			if(j-i+1>maxlen) {
		 				//System.out.println(j + " " + i);
		 				sp=i;
		 				ep=j;
		 				maxlen = j-i+1;
		 			  }
		 		  }
			    }
			}
			System.out.print(str.substring(sp, ep+1));
		}
	   public static boolean isUnique(String str, int a, int b) {
		   
		   boolean flag = true;
		   for(int i=a; i<=b-1; i++) {
				
		 	    for(int j=i+1; j<=b; j++) {
		 	    	
		 	    	if(str.charAt(i)==str.charAt(j)) {
		 	    		//System.out.println(i + " " + j);
		 	    		flag = false;
		 	    		break;
		 	    	}
		 	    }
		   }
		   
		   return flag; 

	}

}
