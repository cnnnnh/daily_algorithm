import java.util.*;
import java.io.*;

/*
 * 사춘기가 세게 온 청소년 상어...
 * 
 * 밑 빠진 독을 하나하나 채우는 느낌이 든다.
 * 삼성 문제는 어쩔 수 없다는 정신 승리를 하자!
 */

public class Main {
	
	static int answer;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;

    	int[][] board = new int[4][4];
    	HashMap<Integer, Fish> map = new HashMap<>();
    	answer = 0;
    	
    	int n, d, target = 0;
    	for(int i = 0; i < 4; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 4; j++) {
    			n = Integer.parseInt(st.nextToken());
    			d = Integer.parseInt(st.nextToken()) - 1;
    			if(i == 0 && j == 0) {
    				target = n;
    			}
    			map.put(n, new Fish(i, j, d));
    			board[i][j] = n;
    		}
    	}
    	
    	// 상어가 (0, 0)에 갔을 때
    	Fish shark = map.get(target);
    	board = moveFish(target, board, map, target);
    	
    	dfs(shark, board, map, target);
    	
    	System.out.println(answer);
    	
    }
    
    public static void dfs(Fish shark, int[][] board, HashMap<Integer, Fish> map, int result) {
    	// dfs 전 board, map copy
    	int[][] newBoard = copyBoard(board);
    	HashMap<Integer, Fish> newMap = copyMap(map);
    	
    	int nx, ny, nd = shark.dir;
    	for(int i = 1; i <= 3; i++) {
    		nx = shark.x + (dx[nd] * i);
    		ny = shark.y + (dy[nd] * i);
    		
    		// 배열 밖이거나 물고기가 없을 때
    		if(!isIn(nx, ny)) return;
    		if(board[nx][ny] <= 0) continue;
    		
    		// 새로운 상어 설정
    		int newSharkNum = board[nx][ny];
    		Fish newShark = newMap.get(newSharkNum);
    		result += newSharkNum;
    		board = moveFish(newSharkNum, board, map, result);
    		
    		dfs(new Fish(nx, ny, newShark.dir), board, map, result);
    		
        	newMap.put(newBoard[nx][ny], newShark);
    		board = copyBoard(newBoard);
    		map = copyMap(newMap);
    		result -= newSharkNum;
    	}
    	
    	
    }
    
    public static int[][] moveFish(int target, int[][] board, HashMap<Integer, Fish> map, int result) {
    	// 상어 새로 만들기
    	Fish newShark = map.get(target);
    	Fish shark = new Fish(newShark.x, newShark.y, newShark.dir);
    	map.remove(target);
    	board[shark.x][shark.y] = -1;
    	
    	// 최대값 갱신
    	answer = Math.max(answer, result);

    	int n = 0;
    	while(n++ <= 16) {
    		// 해당 번호 상어가 없을 때
    		if(!map.containsKey(n)) continue;
    		
    		Fish fish = map.get(n);
    		int nx, ny, nd;
    		int count = -1;
    		
    		// 반시계 방향으로 돌면서 이동할 수 있는 방향 탐색
    		while(count++ < 8) {
    			nd = fish.dir + count;
    			if(nd >= 8) nd -= 8;
    			
    			nx = fish.x + dx[nd];
    			ny = fish.y + dy[nd];
    			
    			// 배열 밖이거나 상어일 때
    			if(!isIn(nx, ny) || (shark.x == nx && shark.y == ny)) continue;
    			
    			// 물고기가 없을 때
    			if(board[nx][ny] <= 0) {
        			Fish newFish = new Fish(nx, ny, nd);
        			map.put(n, newFish);
        			board[fish.x][fish.y] = 0;
        			board[nx][ny] = n;
        			break;
    			}
    			
    			// 서로 위치 변경
    			Fish newFish = map.get(board[nx][ny]);
    			Fish temp = new Fish(newFish.x, newFish.y, nd);
    			newFish = new Fish(fish.x, fish.y, newFish.dir);
    			map.put(board[nx][ny], newFish);
    			map.put(n, temp);
    			board[fish.x][fish.y] = board[nx][ny];
    			board[nx][ny] = n;
    			
    			break;
    		}
    	}
    	
    	return board;
    	
    }
    
    public static int[][] copyBoard(int[][] board) {
    	int[][] newBoard = new int[4][4];
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			newBoard[i][j] = board[i][j];
    		}
    	}
    	return newBoard;
    }
    
    public static HashMap<Integer, Fish> copyMap(HashMap<Integer, Fish> map) {
    	HashMap<Integer, Fish> newMap = new HashMap<>();
    	for(int key : map.keySet()) {
    		newMap.put(key, map.get(key));
    	}
    	return newMap;
    }
    
    public static boolean isIn(int x, int y) {
    	if(x < 0 || x >= 4 || y < 0 || y >= 4) return false;
    	return true;
    }
    
    static class Fish {
    	int x, y, dir;
    	
    	public Fish(int x, int y, int dir) {
    		this.x = x;
    		this.y = y;
    		this.dir = dir;
    	}
    }
    
}
