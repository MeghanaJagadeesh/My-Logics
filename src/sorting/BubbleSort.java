package sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr= {5,2,20,1,0,10};
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length-1; j++) {
				if(arr[j-1]>arr[j]) {
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
