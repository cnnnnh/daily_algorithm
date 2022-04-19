import java.util.*;

/*
 * 백트래킹 문제
 * 1. 값을 준 다음, 다시 초기화해주는 것 잊지 말기!
 * 2. 문제 잘 읽기 ^^ (잘 풀어놓고 비기는 경우를 생각 안 했음 따흐흑...)
 */

class Solution {
    static int gap;
    static int[] answer;
    
    public int[] solution(int n, int[] info) {
        gap = -1;
        answer = new int[11];
        dfs(0, n, info, new int[11]);
        return (gap <= 0 ? new int[] {-1} : answer);
    }
    
    public static void dfs(int index, int cnt, int[] apeach, int[] lion) {
    	//  index를 모두 탐색 후, 화살이 남았을 때
        if(index > 10) {
            if(cnt > 0) {
            	// 0점에 화살을 쏨
                lion[10] = cnt;
                calculate(apeach, lion);
                lion[10] = 0;
            }
            return;
        }
        // 화살을 다 쐈을 때
        if(cnt == 0) {
            calculate(apeach, lion);
            return;
        }
        
        // 라이언이 점수를 얻을 수 있을 때
        if(cnt - (apeach[index] + 1) >= 0) {
            lion[index] = apeach[index] + 1;
            dfs(index+1, cnt - (apeach[index] + 1), apeach, lion);
            lion[index] = 0;
        }
        // 라이언이 점수를 얻지 못할 때
        dfs(index+1, cnt, apeach, lion);
        
    }
    
    public static void calculate(int[] apeach, int[] lion) {
        int lion_result = 0;
        int apeach_result = 0;
        // 점수 계산
        for(int i = 0; i <= 10; i++) {
            if(lion[i] > apeach[i]) lion_result += (10-i);
            else {
                if(apeach[i] != 0) apeach_result += (10-i);
            }
        }
        if((lion_result - apeach_result) > gap) {
            gap = (lion_result - apeach_result);
            answer = lion.clone();
        }
        // 차이의 최대값이랑 같은 점수를 얻었을 때
        else if ((lion_result - apeach_result) == gap) {
        	// 가장 낮은 점수를 더 많이 받은 경우 찾기
            for(int i = 10; i >= 0; i--) {
                if(lion[i] > answer[i]) {
                    answer = lion.clone();
                    break;
                }
                else if (lion[i] < answer[i]) {
                    break;
                }
            }
        }
    }
}