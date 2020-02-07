package TwoDArray;
public class printXO {

	public static void main(String[] args) {

		int n=5;
		int m=6;
		char[][] matrix = new char[n][m];
		char x='X';
		char o='O';

	        int sr = 0;
	        int er = n-1;
	        int sc = 0;
	        int ec = m-1;
            boolean flag = true;
            
	        while(sc<=ec && sr<=er){
	        	
	            for(int i=sc;i<=ec;i++){
	            	if (flag==true) {
	                matrix[sr][i]=x;}
	            	else matrix[sr][i]=o;
	            	}
	            sr+=1;
	            
	            for(int i=sr;i<=er;i++){
	            	if (flag==true) {
	                matrix[i][ec]=x;}
	            	else matrix[i][ec]=o;
	            }
	            ec-=1;
	            
	            if(sr<=er){
	                for(int i=ec;i>=sc;i--){
	                	if (flag==true) {
	                	matrix[er][i]=x;}
	                	else matrix[er][i]=o;
	                }
	                er-=1;
	            }
	            
	            if(sc<=ec){
	                for(int i=er;i>=sr;i--){
	                	if (flag==true) { 
	                	matrix[i][sc]=x;}
	                	else matrix[i][sc]=o;
	                }
	                sc+=1;
	            }
	            
             flag = !flag;
	        }
	        
	        for(int i=0; i<n; i++){
	            for(int j=0; j<m; j++){
	               System.out.print(matrix[i][j] + " ");
	                
	            }
	            System.out.println();
	        }
   	}
}