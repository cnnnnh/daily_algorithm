import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int h = citations.length;
        for(int i = 0; i < citations.length; i++) {
            h = citations.length - i;
            if(citations[i] >= h) return h;
        }
        return answer;
    }
}