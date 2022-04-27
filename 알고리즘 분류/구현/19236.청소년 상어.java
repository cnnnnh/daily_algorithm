import java.util.*;
import java.io.*;

/*
 * ����Ⱑ ���� �� û�ҳ� ���...
 * 
 * �� ���� ���� �ϳ��ϳ� ä��� ������ ���.
 * �Ｚ ������ ��¿ �� ���ٴ� ���� �¸��� ����!
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
    	
    	// �� (0, 0)�� ���� ��
    	Fish shark = map.get(target);
    	board = moveFish(target, board, map, target);
    	
    	dfs(shark, board, map, target);
    	
    	System.out.println(answer);
    	
    }
    
    public static void dfs(Fish shark, int[][] board, HashMap<Integer, Fish> map, int result) {
    	// dfs �� board, map copy
    	int[][] newBoard = copyBoard(board);
    	HashMap<Integer, Fish> newMap = copyMap(map);
    	
    	int nx, ny, nd = shark.dir;
    	for(int i = 1; i <= 3; i++) {
    		nx = shark.x + (dx[nd] * i);
    		ny = shark.y + (dy[nd] * i);
    		
    		// �迭 ���̰ų� ����Ⱑ ���� ��
    		if(!isIn(nx, ny)) return;
    		if(board[nx][ny] <= 0) continue;
    		
    		// ���ο� ��� ����
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
    	// ��� ���� �����
    	Fish newShark = map.get(target);
    	Fish shark = new Fish(newShark.x, newShark.y, newShark.dir);
    	map.remove(target);
    	board[shark.x][shark.y] = -1;
    	
    	// �ִ밪 ����
    	answer = Math.max(answer, result);

    	int n = 0;
    	while(n++ <= 16) {
    		// �ش� ��ȣ �� ���� ��
    		if(!map.containsKey(n)) continue;
    		
    		Fish fish = map.get(n);
    		int nx, ny, nd;
    		int count = -1;
    		
    		// �ݽð� �������� ���鼭 �̵��� �� �ִ� ���� Ž��
    		while(count++ < 8) {
    			nd = fish.dir + count;
    			if(nd >= 8) nd -= 8;
    			
    			nx = fish.x + dx[nd];
    			ny = fish.y + dy[nd];
    			
    			// �迭 ���̰ų� ����� ��
    			if(!isIn(nx, ny) || (shark.x == nx && shark.y == ny)) continue;
    			
    			// ����Ⱑ ���� ��
    			if(board[nx][ny] <= 0) {
        			Fish newFish = new Fish(nx, ny, nd);
        			map.put(n, newFish);
        			board[fish.x][fish.y] = 0;
        			board[nx][ny] = n;
        			break;
    			}
    			
    			// ���� ��ġ ����
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
