import java.util.*;

class Solution {
    
	static boolean[][] visited;
	static ArrayList<ArrayList<Point>> emptyList, blockList;
    
    public int solution(int[][] game_board, int[][] table) {
    	int len = game_board.length;
    	visited = new boolean[len][len];
    	emptyList = new ArrayList<>();
    	blockList = new ArrayList<>();
    	
    	// game_board의 빈 조각 리스트 채우기
    	for (int i = 0; i < len; i++) {
    		for (int j = 0; j < len; j++) {
    			if (!visited[i][j] && game_board[i][j] == 0) {
    				emptyList.add(piece(game_board, i, j, 0));
    			}
    		}
    	}
    	
    	visited = new boolean[len][len];
    	
    	// table의 조각 리스트 채우기
    	for (int i = 0; i < len; i++) {
    		for (int j = 0; j < len; j++) {
    			if (!visited[i][j] && table[i][j] == 1) {
    				blockList.add(piece(table, i, j, 1));
    			}
    		}
    	}
    	
    	int answer = 0;
    	boolean[] checked = new boolean[blockList.size()];
    	for (int i = 0; i < emptyList.size(); i++) {
    		for (int j = 0; j < blockList.size(); j++) {
    			// 두 조각의 크기가 같고, 아직 사용하지 않은 조각이고, 두 개가 딱 맞을 때
    			if (emptyList.get(i).size() == blockList.get(j).size() 
    					&& !checked[j] 
    					&& isFit(emptyList.get(i), blockList.get(j))) {
    				answer += emptyList.get(i).size();
    				checked[j] = true;
    				break;
    			}
    		}
    	}
    	
    	return answer;
    }
    
    // 조각 내기
    private static ArrayList<Point> piece(int[][] arr, int x, int y, int type) {
    	ArrayList<Point> list = new ArrayList<>();
    	Queue<Point> q = new LinkedList<>();
    	int[] dx = {-1, 0, 0, 1};
    	int[] dy = {0, -1, 1, 0};

    	list.add(new Point(x, y));
    	q.offer(new Point(x, y));
    	visited[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		
        	for (int i = 0; i < 4; i++) {
        		int nx = p.x + dx[i];
        		int ny = p.y + dy[i];
        		
        		if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr.length 
        				|| visited[nx][ny])
        			continue;
        		
        		// game_board, table에 따른 값 비교
        		if (arr[nx][ny] == type) {
        			visited[nx][ny] = true;
        			list.add(new Point(nx, ny));
        			q.offer(new Point(nx, ny));
        		}
        	}
    	}
        
    	// 조각 리스트를 정렬하여 return
    	Collections.sort(list);
        
    	return list;
    }
    
    // 조각을 돌려가며 맞는 조각인지 체크
    private static boolean isFit(ArrayList<Point> empty, ArrayList<Point> block) {
    	// 90도 회전으로 4가지 방법 모두 확인
    	for (int rotate = 0; rotate < 4; rotate++) {
    		// 두 조각 사이의 x, y값 차이
        	int gap_x = empty.get(0).x - block.get(0).x;
        	int gap_y = empty.get(0).y - block.get(0).y;
        	boolean flag = true;
        	
        	for (int i = 1; i < empty.size(); i++) {
        		// 조각이 맞지 않으면
        		if (empty.get(i).x - block.get(i).x != gap_x
        				|| empty.get(i).y - block.get(i).y != gap_y) {
        			flag = false;
        			break;
        		}
        	}
        	
        	if(!flag) {
        		// 90도 회전
        		for (int i = 0; i < block.size(); i++) {
        			int temp = block.get(i).x;
        			block.get(i).x = block.get(i).y;
        			block.get(i).y = -temp;
        		}
        		Collections.sort(block);
        	}
        	else {
        		return true;
        	}
    	}
    	
    	return false;
    }
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		
		public Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo (Point p) {
			if (this.x == p.x) {
				return this.y - p.y;
			}
			return this.x - p.x;
		}
	}
    
}