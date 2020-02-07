public class Alternative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {2,-1,6,-9,-7,2,-6,28};
		rearrange(arr);
		for(int i=0;i<arr.length;i++){
			
			System.out.println(arr[i]);
		}
	}

	public static void rearrange(int[] arr) {

		int Output[]=new int[arr.length];
		int pos=0, neg=0, i=0;		
		
		while((pos<arr.length) && (neg<arr.length)) {
			
			if(arr[pos]<0)
				pos++;
			else if(arr[neg]>0)
				neg++;
			else {
				Output[i]=arr[pos];
				i++;
				pos++;
				Output[i]=arr[neg];
				i++;
				neg++;
			}
		}
			for(i=0; i<arr.length; i++){
				arr[i]= Output[i];
			}
	}
}