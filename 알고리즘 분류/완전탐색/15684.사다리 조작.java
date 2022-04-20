import java.util.*;
import java.io.*;

/*
 * 사다리 방향을 넣은 배열을 안 만드는 방법은 없을까?
 * 오늘은 퇴근 전에 풀었따 ㅠ_ㅠ
 * 고생했어 나현...
 */

public class Main {
	
	static int n, m, h, min;
	static int[] count;
	static int[][] ladder;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	h = Integer.parseInt(st.nextToken());
    	min = Integer.MAX_VALUE;
    	int x, y;
    	count = new int[n-1];
    	ladder = new int[h][n-1];
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		x = Integer.parseInt(st.nextToken());
    		y = Integer.parseInt(st.nextToken());
    		ladder[x-1][y-1] = 1;
    		count[y-1]++;
    	}
    	
    	dfs(0, 0, 0);
    	System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    
    public static void dfs(int x, int y, int cnt) {
    	if(check()) {
    		min = Math.min(min, cnt);
    		return;
    	}
    	
    	if(cnt >= 3) {
    		return;
    	}
    	
    	int j = y;
    	for(int i = x; i < h; i++) {
    		for(; j < n-1; j++) {
    			if(ladder[i][j] >= 1) continue;
    			if(isPossible(i, j)) {
    				ladder[i][j] = cnt+2;
    				dfs(i, j, cnt+1);
    				ladder[i][j] = 0;
    			}
    		}
    		j = 0;
    	}
    	
    }
    
    public static boolean isPossible(int x, int y) {
    	if((y-1 >= 0 && ladder[x][y-1] != 0) 
    			|| (y+1 < n-1 && ladder[x][y+1] != 0)) {
    		return false;
    	}
    	return true;
    }
    
    public static boolean check() {
    	char[][] map = new char[h][n];
    	for(int i = 0; i < h; i++) {
    		for(int j = 0; j < n-1; j++) {
    			if(ladder[i][j] > 0) {
    				map[i][j] = 'R';
    				map[i][j+1] = 'L';
    			}
    		}
    	}
    	
    	int line = 0;
    	for(int i = 0; i < n; i++) {
    		line = i;
    		for(int j = 0; j < h; j++) {
    			if(map[j][line] == 'R') {
    				line++;
    			}
    			else if (map[j][line] == 'L') {
    				line--;
    			}
    		}
    		if(i != line) return false;
    	}
    	return true;
    }
    
}
