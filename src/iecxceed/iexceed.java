package iecxceed;

import java.util.HashMap;
import java.util.Map;

public class iexceed {
    public static void main(String[] args) {
//        Sample Input= aseahesa
//        Sample Output= 3
//  Explanation: The count of characters is 'a' is 3, 's' is 2, 'e' is 2, and 'h' is 1. So the maximum count is of 'a' and that is 3.

        System.out.println(getFreQuency("aseahesa"));


//        Input 30    Output 3
//  Explanation: You can perform the moves 3 times and decrease the integer by 1 every time to make it a perfect cube, which is 27 (perfect cube of 3) over here.
        System.out.println(perfectCube(30));
    }

    public static long perfectCube(long num){
        long cubeRoot=Math.round(Math.cbrt(num));
        long actualCubeRoort=cubeRoot*cubeRoot*cubeRoot;
        long step=0;
        for(int i=1; i<num; i++){
            if(num==actualCubeRoort){
                break;
            }
            num--;
            step++;
        }
        return step;
    }

    public static int getFreQuency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
    }
}
