package Paypal;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Crashing stones
Description
Each day a quarry-worker is given a pile of stones and told to reduce the larger stones Into smaller ones. The worker must smashi the stones together to reduce them, and is told to always pick up the largest two stones and smash them together. If the stones are of equal weight, they both disintegrate entirely If one is larger, the smaller one is disintegrated and the larger one is reduced by the weight of the smaller one. Eventually, there is either one stone left that cannot be broken, or all of the stones have been smashed. Determine the weight of the last stone, or return Oif there is none.
Example
weights=[1,2,3,6,777
The worker always starts with the two largest

Example
weights = [1,2,3,6,7,7).
The worker always starts with the bas stones. In this case, the two largest sto have equal weights of 7 so they both disintegrate when smashed. Next the wor smashes weights 3 and 6. The smaller one destroyed and the larger weighs 6-3-3 units. Then, weights 3 and 2 are smashed together, which leaves a stone of weight This is smashed with the last remaining stone of weight 1. There are no stones left, so the remaining stone weight is a
Function Description
Complete the function lastStoneithin the editor below. The function must return an integer that denotes the weight of the last stone, or 0 if all stones shattered into dust
lastStoneWeight has the following
parameter(s)
Int weightsin an array of tears

indicating the weights
Constraints
• 1 sns 105
• 1 ≤ weights[i]s 10
▼Input Format for Custom Testing
The first line contains an integer indicating the size of the array weghes Each of the next in lines contains ange weights[i].
Sample Case 0
Sample Input
STRIN
 */
public class CrashingStone {
	
	public static void main(String[] args) {
		int[] arr= {1,2,3,6,7,7};
		int result=crashingStone(arr);
		System.out.println(result);
	}

	private static int crashingStone(int[] arr) {
		
		//Queue follows FIFO to get the max stone weight, so to order the element in a descending order we have used  Collections.reverseOrder()
		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int element:arr) {
			maxHeap.add(element);
		}
		// [7, 6, 7, 1, 3, 2]
		System.out.println(maxHeap);
		
		while(maxHeap.size()>1) {
			int stone1=maxHeap.poll();		// stone weight is fetched and removed from the original heap
			int stone2=maxHeap.poll();
			if(stone1!=stone2) {
				maxHeap.add(stone1-stone2);
			}
		}
		return maxHeap.isEmpty()?0:maxHeap.poll();
	}

}
