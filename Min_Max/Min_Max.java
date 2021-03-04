class Min_Max{
	public static void main(String ... args){
		int arr[] = {15,20,21,5,25,11,10,28,44,9};
		find_MinMax(arr);
	}
	static void find_MinMax(int arr[]){
		int max = 0, min = 999;
		for(int i = 0; i<arr.length; i++){
			if(max < arr[i])
				max = arr[i];
			if(min > arr[i])
				min = arr[i];
		}
		System.out.println("Min: "+min+", Max: "+max);
	}
}