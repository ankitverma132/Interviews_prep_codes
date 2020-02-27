package Recursion;
public class PrintKeypadCombinations {

	public static void main(String[] args) {

	   printKeypad(234);	
	}	
	
    public static void printKeypad(int n) {
		
		printKeypad( n, "" );
	}

	
	public static void printKeypad(int n, String outputSoFar) {

        if(n == 0) {
        	
        	System.out.println( outputSoFar );
        	return;
        }	
        
        String smallAns[] = helper(n%10);
        
        for(int i = 0; i<smallAns.length; i++) {
        	 printKeypad( n/10, smallAns[i] + outputSoFar );
        }
 
	}

    public static String[] helper(int n){
		
		switch(n)
		{
		case 2:
			String ans[] = {"a","b","c"};
		    return ans;
		case 3:
			String ans1[] = {"d","e","f"};
		    return ans1;
		case 4:
			String ans2[] = {"g","h","i"};
		    return ans2;
		case 5:
			String ans11[] = {"j","k","l"};
		    return ans11;
		case 6:
			String ans3[] = {"m","n","o"};
		    return ans3;
		case 7:
			String ans4[] = {"p","q","r","s"};
		    return ans4;
		case 8:
			String ans5[] = {"t","u","v"};
		    return ans5;
		case 9:
			String ans6[] = {"w","x","y","z"};
		    return ans6;
		default:
			String ans7[] = {""};
		    return ans7;
		    
		}	
		
	}

}