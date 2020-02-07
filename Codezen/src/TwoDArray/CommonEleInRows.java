package TwoDArray;
public class CommonEleInRows {

	public static void main(String[] args) {

		int[][] mat = { {6, 8, 9, 9}, {1, 2, 2, 9 }, {0, 1, 9, 10}};
		int row = 3;
		int col = 4;
		
		
		for(int j=0; j<col; j++) {
			int element = mat[0][j];
			int count = 0;
			
			for(int i=1; i<row; i++) {
				for(int k=0; k<col; k++) {
					
					if(mat[i][k] == element ) {
						count++;
						continue;
					}	
				}
			}
			if(count == row-1) {
				System.out.print(element);
			}
		}		
	}
}