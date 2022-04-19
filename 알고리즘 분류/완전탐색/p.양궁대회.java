import java.util.*;

/*
 * ��Ʈ��ŷ ����
 * 1. ���� �� ����, �ٽ� �ʱ�ȭ���ִ� �� ���� ����!
 * 2. ���� �� �б� ^^ (�� Ǯ����� ���� ��츦 ���� �� ���� ������...)
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
    	//  index�� ��� Ž�� ��, ȭ���� ������ ��
        if(index > 10) {
            if(cnt > 0) {
            	// 0���� ȭ���� ��
                lion[10] = cnt;
                calculate(apeach, lion);
                lion[10] = 0;
            }
            return;
        }
        // ȭ���� �� ���� ��
        if(cnt == 0) {
            calculate(apeach, lion);
            return;
        }
        
        // ���̾��� ������ ���� �� ���� ��
        if(cnt - (apeach[index] + 1) >= 0) {
            lion[index] = apeach[index] + 1;
            dfs(index+1, cnt - (apeach[index] + 1), apeach, lion);
            lion[index] = 0;
        }
        // ���̾��� ������ ���� ���� ��
        dfs(index+1, cnt, apeach, lion);
        
    }
    
    public static void calculate(int[] apeach, int[] lion) {
        int lion_result = 0;
        int apeach_result = 0;
        // ���� ���
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
        // ������ �ִ밪�̶� ���� ������ ����� ��
        else if ((lion_result - apeach_result) == gap) {
        	// ���� ���� ������ �� ���� ���� ��� ã��
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