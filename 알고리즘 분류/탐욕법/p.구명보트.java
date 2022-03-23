import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;
        int answer = 0;
        
        for(int max = people.length-1; max >= min; max--) {
            if(people[max] + people[min] <= limit) min++;
            answer++;
        }
        
        return answer;
    }
}