// 단순 수학 문제에 가까웠다...

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int sum = (brown + 4) / 2;
        int mul = (brown + yellow);
        int x = 0;
        int[] answer = new int[2];
        
        for(int y = 2; y <= sum/2; y++) {
            x = sum - y;
            if((x * y) == mul) {
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
        
        return answer;
    }
}