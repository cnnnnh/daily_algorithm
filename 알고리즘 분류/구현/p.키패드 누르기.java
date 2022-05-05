import java.util.*;

/*
 * 자존감 주유 중입니다
 * ~~~꼬록~~~꼬록~~~
 */

class Solution {
    public String solution(int[] numbers, String hand) {
        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(2, new int[] {0, 1});
        map.put(5, new int[] {1, 1});
        map.put(8, new int[] {2, 1});
        map.put(0, new int[] {3, 1});
        
        int[] left = new int[] {3, 0};
        int[] right = new int[] {3, 2};
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 3 == 2 || numbers[i] == 0) {
                int[] arr = map.get(numbers[i]);
                int disL = Math.abs(arr[0] - left[0]) + Math.abs(arr[1] - left[1]);
                int disR = Math.abs(arr[0] - right[0]) + Math.abs(arr[1] - right[1]);
                if(disL < disR) {
                    sb.append("L");
                    left[0] = arr[0];
                    left[1] = arr[1];
                }
                else if(disL > disR) {
                    sb.append("R");
                    right[0] = arr[0];
                    right[1] = arr[1]; 
                }
                else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        left[0] = arr[0];
                        left[1] = arr[1];
                    }
                    else {
                        sb.append("R");
                        right[0] = arr[0];
                        right[1] = arr[1]; 
                    }
                }
            }
            else if(numbers[i] % 3 == 1) {
                sb.append("L");
                left[0] = numbers[i] / 3;
                left[1] = 0;
            }
            else if(numbers[i] % 3 == 0) {
                sb.append("R");
                right[0] = numbers[i] / 3 - 1;
                right[1] = 2;
            }
        }
        
        return sb.toString();
    }
}