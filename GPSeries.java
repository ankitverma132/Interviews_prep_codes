//Given k, find the geometric sum i.e.
//1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 

package Recursion;
public class GPSeries {

	public static void main(String[] args) {

		int k=3;
		System.out.println(findGeometricSum(k));

	}
    public static double findGeometricSum(int k){
		
        if(k==0){
            return 1;
        }
            
        double smallAns = findGeometricSum(k-1);
        return (1/(pow(k))) + smallAns ; 
        
        
	}
    private static double pow(int k){
        
        if(k==0){
            return 1;
        }
            
        return 2*pow(k-1);
    }

}
