package TwoDArray;
public class Spiral {

	public static void main(String[] args) {
		int matrix[][] = { {1,2,3,4,11},{5,6,7,8,22},{9,10,11,12,33} };

        int n = matrix.length;
        int m = matrix[0].length;
        int sr = 0;
        int er = n-1;
        int sc = 0;
        int ec = m-1;

        while(sc<=ec && sr<=er){
            for(int i=sc;i<=ec;i++){
                System.out.print(matrix[sr][i]+" ");
            }
            sr+=1;
            for(int i=sr;i<=er;i++){
                System.out.print(matrix[i][ec]+" ");
            }
            ec-=1;
            if(sr<=er){
                for(int i=ec;i>=sc;i--){
                    System.out.print(matrix[er][i]+" ");
                }
                er-=1;
            }
            if(sc<=ec){
                for(int i=er;i>=sr;i--){
                    System.out.print(matrix[i][sc]+" ");
                }
                sc+=1;
            }
        }     
    }
}
