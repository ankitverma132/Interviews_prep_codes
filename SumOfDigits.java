package Recursion;
public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int input = 125;
      System.out.println(sumOfDigits(input));
	}
	
	public static int sumOfDigits(int input){
		// Write your code here

        if(input>0 && input<10){
            return input;
        }
        
       return input%10 + sumOfDigits(input/10);
	}

}
