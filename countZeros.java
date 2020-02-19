package Recursion;

public class countZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 20304;
		System.out.println( countZerosRec(input) );

	}
	public static int countZerosRec(int input){
		  
        if( input<10 ){
            
            if(input==0){
               return 1;
            }
            else
              return 0;
         }
        
        int smallAns = countZerosRec(input/10);
        
         if( input%10 == 0 ){
            return smallAns+1;
         }
         else{
            return smallAns;
         }
        
	}
}
