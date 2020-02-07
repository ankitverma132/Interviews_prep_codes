// Code to find max hamming distance after rotating the array
public class MaxHammingDist {

	public static void main(String[] args) {

		int[] arr= {1, 4, 6, 2};
		int[] arr2 = new int[arr.length];
		
		for(int i=0; i<arr.length;i++) {
		arr2[i]=arr[i];
		}
	
		int maxDist=Integer.MIN_VALUE;
		
		for(int d=0; d<arr2.length-1; d++) {
			
			int temp=arr2[0];
			for(int i=0; i<arr2.length-1; i++) {
				arr2[i]=arr2[i+1];
			}
			arr2[arr2.length-1]=temp;
			
			int count=0;
			for(int i=0; i<arr2.length; i++) {
				if(arr[i]!=arr2[i]) {
					count++;
				}
			}
			if(count>maxDist) {
				maxDist=count;
			}
			
		}

		System.out.println(maxDist);
	}
}