import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] board = new boolean[n+1][n+1];
        
        // 직접적 경기
        for(int i = 0; i < results.length; i++) {
            board[results[i][0]][results[i][1]] = true;
        }
        
        // 간접적 경기 (거쳐가는 선수가 있음)
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j) continue;
                    if(board[i][k] && board[k][j]) board[i][j] = true;
                }
            }
        }
        
        int cnt = 0;
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            cnt = 0;
            for(int j = 1; j <= n; j++) {
                // 경기 결과 count
                if(board[i][j] || board[j][i]) cnt++;
            }
            // 경기 결과가 n-1이면 순위가 결정남
            if(cnt == (n-1)) answer++;
        }
        
        return answer;
    }
}