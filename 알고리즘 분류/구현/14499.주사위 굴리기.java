import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, x, y;
	static int[] dice;
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());   	
    	m = Integer.parseInt(st.nextToken());   	
    	x = Integer.parseInt(st.nextToken());   	
    	y = Integer.parseInt(st.nextToken());   	
    	int k = Integer.parseInt(st.nextToken());   
    	
    	int[][] board = new int[n][m];
    	dice = new int[6];
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < k; i++) {
    		int dir = Integer.parseInt(st.nextToken());
    		// 범위 내라면 x,y 이동
    		if(!isIn(dir)) continue;
    		// 방향대로 주사위 굴리기
    		move(dir);
    		// 바닥이 0일 때
    		if(board[x][y] == 0) {
    			board[x][y] = dice[3];
    		}
    		// 바닥이 0이 아닐 때
    		else {
    			dice[3] = board[x][y];
    			board[x][y] = 0;
    		}
    		System.out.println(dice[2]);
    	}
    	
    }
    
    public static boolean isIn(int dir) {
    	int temp_x = x;
    	int temp_y = y;
    	
    	switch(dir) {
    	case 1:
    		temp_y = y+1;
    		if(temp_y >= m) return false;
    		break;
    	case 2:
    		temp_y = y-1;
    		if(temp_y < 0) return false;
    		break;
    	case 3:
    		temp_x = x-1;
    		if(temp_x < 0) return false;
    		break;
    	case 4:
    		temp_x = x+1;
    		if(temp_x >= n) return false;
    		break;
		default:
			break;
    	}
    	x = temp_x;
    	y = temp_y;
    	return true;
    }
    
    public static void move(int dir) {
    	int[] temp = dice.clone();
    	
    	switch(dir) {
    	case 1:
    		dice[2] = temp[4];
    		dice[3] = temp[5];
    		dice[4] = temp[3];
    		dice[5] = temp[2];
    		break;
    	case 2:
    		dice[2] = temp[5];
    		dice[3] = temp[4];
    		dice[4] = temp[2];
    		dice[5] = temp[3];
    		break;
    	case 3:
    		dice[0] = temp[3];
    		dice[1] = temp[2];
    		dice[2] = temp[0];
    		dice[3] = temp[1];
    		break;
    	case 4:
    		dice[0] = temp[2];
    		dice[1] = temp[3];
    		dice[2] = temp[1];
    		dice[3] = temp[0];
    		break;
    	default:
    		break;
    	}
    	
    }
    
}