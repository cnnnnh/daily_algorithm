import java.util.*;
import java.io.*;

/*
 * 이 정돈 쉽지 ^^
 * (라고 하지만 memo 몰랐으면 틀렸을 수도...)
 */

public class Main {
	
	static int N, answer;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	static int[][] board, memo;
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	
    	int tc = Integer.parseInt(br.readLine());
    	
    	for(int T = 1; T <= tc; T++) {
        	N = Integer.parseInt(br.readLine());
        	board = new int[N][N];
        	memo = new int[N][N];
    		for(int i = 0; i < N; i++) {
    			char[] arr = br.readLine().toCharArray();
    			for(int j = 0; j < N; j++) {
    				board[i][j] = arr[j] - '0';
    				memo[i][j] = Integer.MAX_VALUE;
    			}
    		}
    		
    		dfs(0, 0, board[0][0]);
    		System.out.println("#" + T + " " + memo[N-1][N-1]);
    		
    	}

    }
    
    public static void dfs(int x, int y, int sum) {
    	if(memo[N-1][N-1] <= sum) return;
    	
    	if(x == N-1 && y == N-1) {
    		memo[N-1][N-1] = sum;
    		return;
    	}
    	
    	if(memo[x][y] > sum) memo[x][y] = sum;
    	else return;
    	
    	for(int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(!isIn(nx, ny)) continue;
    		dfs(nx, ny, sum + board[nx][ny]);
    	}
    	
    }
    
    public static boolean isIn(int x, int y) {
    	if(x < 0 || x >= N || y < 0 || y >= N) return false;
    	return true;
    }
    
}
