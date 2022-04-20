import java.util.*;
import java.io.*;

public class Main {
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	int dir = Integer.parseInt(st.nextToken());

    	int[][] board = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 북 동 남 서 (시계방향)
    	int[] dx = {-1, 0, 1, 0};
    	int[] dy = {0, 1, 0, -1};
    	
    	// 2a번 실행 횟수, 청소한 칸
    	int cnt = 0, block = 1;
    	// 움직일 위치
    	int nx = 0, ny = 0;
    	
    	// 첫 칸 청소
    	board[x][y] = -1;
    	
    	while(true) {
    		// 2a번을 4번 실행했을 때
    		if(cnt == 4) {
    			// 뒤쪽 방향 구하기
    			int temp_dir = dir+2;
    			if(temp_dir >= 4) temp_dir -= 4;
    			nx = x + dx[temp_dir];
    			ny = y + dy[temp_dir];
    			// 뒤쪽이 벽이 아닐 때, 후진
    			if(board[nx][ny] != 1) {
    				x = nx;
    				y = ny;
    				cnt = 0;
    			}
    			// 뒤쪽이 벽일 때, 멈춤
    			else {
    				break;
    			}
    		}
    		// 왼쪽으로 회전
			dir = (dir == 0 ? 3 : dir-1);
			nx = x + dx[dir];
			ny = y + dy[dir];
    		cnt++;
    		
			// 범위를 벗어나거나, 청소할 수 있는 칸이 아닐 때
			if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] != 0) continue;
			
			// 이동 후 청소
			x = nx;
			y = ny;
			board[nx][ny] = -1;
			block++;
			cnt = 0;
    	}
    	
    	System.out.println(block);
    	
    }
    
}