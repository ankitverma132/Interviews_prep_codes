package TwoDArray;
public class ResetMatrix {

	public static void main(String[] args) {

		int input[][] = { {0,0,1},{1,1,1},{1,1,1} };
		int row = input.length;
		int col = input[0].length;
		
		int arr[][]=new int[row][col];
		for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
               arr[i][j]=input[i][j];
                
            }
		}		
		for(int i=0; i<row; i++){
	           
            for(int j=0; j<col; j++){
            	 
            	if(input[i][j]==0) {
            		
            		    int m=i;
                        for(int n=0; n<col; n++){
                        	arr[m][n]=0;
                        }
            		    int n=j;
                        for(m=0; m<row; m++){
                        	arr[m][n]=0;
                        }
                }
            		
            }
 
        }
		for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
               System.out.print(arr[i][j] + " ");
                
            }
            System.out.println();
        }
		
   }
}
