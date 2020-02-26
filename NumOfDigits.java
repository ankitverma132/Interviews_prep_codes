package Recursion;
public class NumOfDigits {

	public static void main(String[] args) {

      int n = 156;
      System.out.println(count(n));

	}
	
	
	public static int count(int n){
		if(n >= 0 && n < 10){
			return 1;
		}
		
		return count(n / 10) + 1;
	}

}