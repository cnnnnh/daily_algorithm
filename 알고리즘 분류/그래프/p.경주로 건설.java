import java.util.*;

/*
 * �˰��� ����Կ��� �� �� �����..
 * ��¥�� ������ �� ������ �ּڰ��� ����� ���ɼ��� ������ 3���� �迭�� ��� �Ѵ�!
 */

class Solution {
    
    static int n, min;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int[][][] memo;
        
    public static int solution(int[][] board) {
        n = board.length;
        map = board.clone();
        memo = new int[4][n][n];
        
        // memo �迭 �ʱ�ȭ
        for(int k = 0; k < 4; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0 && j == 0) memo[k][i][j] = 0;
                    else memo[k][i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        min = Integer.MAX_VALUE;
        dfs(new Road(0, 0, -1, 0));
        
        return min;
    }
    
    public static void dfs(Road r) {
    	// �ּڰ����� ���� �ݾ��� Ŭ ��
    	if(r.cost > min) return;
    	// �̹� ���ƺ� ������ ���� �ݾ��� Ŭ ��
    	if(r.dir != -1 && r.cost > memo[r.dir][r.x][r.y]) return;
    	// �������� ���� �� �ּڰ� ����
    	if(r.x == n-1 && r.y == n-1) {
    		min = Math.min(min, r.cost);
    		return;
    	}
        
    	int nx, ny;
    	for(int i = 0; i < 4; i++) {
    		nx = r.x + dx[i];
    		ny = r.y + dy[i];
    		// �迭 ���̰ų� ���� ��
    		if(!isIn(nx, ny)) continue;
    		if(map[nx][ny] == 1) continue;
    		// �����̰ų� ������ ���� ��
    		if(r.dir == i || r.dir == -1) {
    			if(memo[i][nx][ny] > r.cost + 100) {
                    memo[i][nx][ny] = r.cost + 100;
        			dfs(new Road(nx, ny, i, r.cost + 100));
    			}
    		}
    		// ������ �ٸ� ��
    		else {
    			if(memo[i][nx][ny] > r.cost + 600) {
                    memo[i][nx][ny] = r.cost + 600;
        			dfs(new Road(nx, ny, i, r.cost + 600));
    			}
    		}
    	}
    }
    
    
    public static boolean isIn(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n) return false;
        return true;
    }
    
    static class Road {
        int x, y, dir, cost;
        
        public Road(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
}