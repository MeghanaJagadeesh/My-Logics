package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Implement the average latency 
 * The program receives one letency 5
 * Example pings : 60, 78, 59, 108,18,1
 * Output Avarage value : 12, 26, 38, 1, 8, 9
 */
public class GoogleAverageLatency {

	public static void main(String[] args) {
		int[] arr = { 60, 78, 59, 108, 18, 1, 12, 45 };
		System.out.println("test");
		int k = 5;
		System.out.println(calculateAverageLatency(arr, k));

	}

//	private static List<Integer> calculateAverageLatency(int[] arr, int k) {
//		System.out.println(Arrays.toString(arr));
//		List<Integer> average = new ArrayList<Integer>();
//		int sum = 0;
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//			if (i > k - 1) {
//				System.out.println(i);
//				average.add((sum / k) / k);
//			}
//		}
//		return average;
//
//	}
	// { 60, 78, 59, 108, 18, 1, 12, 45 }
	private static List<Integer> calculateAverageLatency(int[] arr, int k) {
		List<Integer> average = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		average.add((sum/k)/k);
		int n=arr.length-k+1;
		for (int i = 1; i < n; i++) {
			sum = sum - arr[i - 1] + arr[i + k - 1];
			average.add((sum/k)/k);
		}
		return average;

	}
}
