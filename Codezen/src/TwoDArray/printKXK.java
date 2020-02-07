package TwoDArray;
import java.util.ArrayList;

public class printKXK {

	public static void main(String[] args) {
		
		int mat[][] = { {1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1} };
		int n=4;
		int k=2;
		ArrayList<Integer> A = new ArrayList<>();
		  
        int startR = 0;
        int startC = 0;
        for(int x=0; x<n; x++){
           for(int y=0; y<n; y++){
              startR = x;
              startC = y;
              
              int sum=0;
               if(n-startR>=k && n-startC>=k){
            
            for(int j=startR ; j<startR+k ; j++){
                 
                 for(int i=startC ; i<startC+k ; i++){
                     if( i < mat[0].length ){
                        sum = sum + mat[j][i];}
                   }
             }
                   A.add(sum);
              }                               
           }
        }
        int count=0;
        for(int i=0;i<A.size(); i++){
            System.out.print(A.get(i) + " ");
            count++;
            if(count==n-k+1){
                 System.out.println();
                 count=0;
            }
        }
    }
}