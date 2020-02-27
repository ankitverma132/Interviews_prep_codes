//Return Keypad Code
//Given an integer n, using phone keypad find out all the possible strings
//that can be made using digits of input n.
//Return empty string for numbers 0 and 1.

package Recursion;
public class returnKeypad {

	public static void main(String[] args) {

		int n = 234;
		String ans[] = keypad(n);
		
		for(int i =0; i < ans.length; i++) {
			System.out.println( ans[i] );
      }		
	}	
	
	public static String[] keypad(int n){
		
		if( n == 0) {
			String ans[] = {""};
			return ans;
		}
		
		String smallAns[] = keypad(n/10);
		String secondAns[] = helper(n%10);
		
		
		String ans[] = new String[secondAns.length*smallAns.length];
		
		int k = 0;
		for(int i =0; i < smallAns.length; i++) {
			
			for(int j =0; j < secondAns.length; j++) {
				ans[k] = smallAns[i] + secondAns[j];
				k++;
			}
					
		}

		return ans;

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
