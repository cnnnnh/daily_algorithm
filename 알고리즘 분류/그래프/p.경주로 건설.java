import java.util.*;

/*
 * 알고리즘 고수님에게 한 수 배웠다..
 * 진짜로 끝까지 갈 때까지 최솟값이 변경될 가능성이 있으면 3차원 배열을 써야 한다!
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
        
        // memo 배열 초기화
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
    	// 최솟값보다 현재 금액이 클 때
    	if(r.cost > min) return;
    	// 이미 돌아본 값보다 현재 금액이 클 때
    	if(r.dir != -1 && r.cost > memo[r.dir][r.x][r.y]) return;
    	// 도착점에 왔을 때 최솟값 갱신
    	if(r.x == n-1 && r.y == n-1) {
    		min = Math.min(min, r.cost);
    		return;
    	}
        
    	int nx, ny;
    	for(int i = 0; i < 4; i++) {
    		nx = r.x + dx[i];
    		ny = r.y + dy[i];
    		// 배열 밖이거나 벽일 때
    		if(!isIn(nx, ny)) continue;
    		if(map[nx][ny] == 1) continue;
    		// 원점이거나 방향이 같을 때
    		if(r.dir == i || r.dir == -1) {
    			if(memo[i][nx][ny] > r.cost + 100) {
                    memo[i][nx][ny] = r.cost + 100;
        			dfs(new Road(nx, ny, i, r.cost + 100));
    			}
    		}
    		// 방향이 다를 때
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