package TwoDArray;

public class waveprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[][] = { {1,2,3},{4,5,6,},{7,8,9,} };
		
		  int row = input.length;
	        int col = input[0].length;
	        
	         for(int j=0; j<col; j++){
	            if(j%2==0){
	               for(int i=0; i<row; i++){
	                   System.out.print(input[i][j] + " ");
	                  }
	               }
	             else{
	                 for(int i=row-1; i>=0; i--){
	                    System.out.print(input[i][j] + " ");
	                   }
	               }   
	           }
	}

}
