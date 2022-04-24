import java.util.*;
import java.io.*;

/*
 * 정렬ㅈ어렬ㄹ저옂ㄹ엊러졀림저;정렬!!!!!!!!!!!!
 * 정렬!!!!!!!!!!!!!!
 * 정ㄹ렬정렬정렬!!!!!!!!!!!!!!!
 * 정신차리고 정렬 똑바로 하자...
 */

public class Main {
	
	static int row, col;
	static int[][] board;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[101][101];
        
        row = 3;
        col = 3;
        
        for(int i = 1; i <= 3; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= 3; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int time = 0;
        while(time++ <= 100) {
        	if(board[x][y] == k) {
        		break;
        	}
        	if(row >= col) orderRow();
        	else orderCol();
        }
        
        System.out.println(time > 101 ? -1 : time-1);
    	
    }
    
    public static void orderRow() {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int maxCol = Integer.MIN_VALUE;
    	
    	for(int i = 1; i <= row; i++) {
    		map.clear();
    		for(int j = 1; j <= col; j++) {
    			if(board[i][j] == 0) continue;
    			map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
    			board[i][j] = 0;
    		}
    		
    		ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
    		Collections.sort(keyList, (o1, o2) -> {
    			if(map.get(o1) == map.get(o2)) {
    				return o1 - o2;
    			}
    			return map.get(o1) - map.get(o2);
    			}
    		);

        	int index = 1;
    		for(int key : keyList) {
    			board[i][index++] = key;
    			board[i][index++] = map.get(key);
    		}
    		maxCol = Math.max(maxCol, index-1);
    	}
    	
    	col = maxCol;
    }
    
    public static void orderCol() {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int maxRow = Integer.MIN_VALUE;
    	
    	for(int i = 1; i <= col; i++) {
    		map.clear();
    		for(int j = 1; j <= row; j++) {
    			if(board[j][i] == 0) continue;
    			map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
    			board[j][i] = 0;
    		}
    		
    		ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
    		Collections.sort(keyList, (o1, o2) -> {
    			if(map.get(o1) == map.get(o2)) {
    				return o1 - o2;
    			}
    			return map.get(o1) - map.get(o2);
    			});
    		
        	int index = 1;
    		for(int key : keyList) {
    			board[index++][i] = key;
    			board[index++][i] = map.get(key);
    		}
    		maxRow = Math.max(maxRow, index-1);
    	}
    	
    	row = maxRow;
    }
    
}