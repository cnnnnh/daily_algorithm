import java.util.*;

class Solution {
    static int answer;
    static int[] pm = new int[] {-1, 1};
    static int[] arr;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        arr = new int[numbers.length];
        
        permutation(numbers, target, 0);
        
        return answer;
    }
    
    public static void permutation(int[] numbers, int target, int cnt) {
        if(numbers.length == cnt) {
            int result = 0;
            for(int i = 0; i < numbers.length; i++) {
                result += (arr[i] * numbers[i]);
            }
            if(result == target) answer++;
            return;
        }
        
        arr[cnt] = -1;
        permutation(numbers, target, cnt+1);
        arr[cnt] = 1;
        permutation(numbers, target, cnt+1);
        
    }
}