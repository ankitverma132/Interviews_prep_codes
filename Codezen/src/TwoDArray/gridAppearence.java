package TwoDArray;
public class gridAppearence {
	
	public static void main(String[] args) {
		
		int n=10;
		int k=2;
		
       int[][] arr = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               
                arr[i][j] = (i+1)*(j+1);             
            }
        }
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//               
//            	 System.out.println(arr[i][j]);             
//            }
//        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               
               if(arr[i][j] == k){
                   count++;
               }             
            }
        }
        System.out.print(count);        
	}
}
