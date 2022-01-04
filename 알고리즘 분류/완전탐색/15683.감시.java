import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, min, empty;
	static int[] limit, num;
	static int[][] map, temp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Camera> list;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	empty = 0;
    	map = new int[n][m];
    	list = new ArrayList<>();
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			// cctv를 list에 추가
    			if(map[i][j] != 0 && map[i][j] != 6)
    				list.add(new Camera(i, j, map[i][j]));
    			// 빈 칸 세기
    			if(map[i][j] == 0) empty++;
    		}
    	}
    	
    	// 최솟값을 빈 칸 개수로 초기화
    	min = empty;
    	
    	// 경우의 수를 담을 배열
    	num = new int[list.size()];
    	// cctv 유형에 따른 가지 수를 담을 배열
    	limit = new int[list.size()];
    	// limit 배열 초기화
    	setLimit();
    	// 경우의 수 만들기
    	permutation(0);
    	
    	System.out.println(min);
    }
    
    // 배열 복사
    private static int[][] copy(int[][] arr) {
    	int[][] temp = new int[arr.length][arr[0].length];
    	for(int i = 0; i < arr.length; i++ ) {
    		temp[i] = arr[i].clone();
    	} 	
    	return temp;
    }
     
    // 가지 수 세기
    private static void setLimit() {
    	for (int i = 0; i < list.size(); i++) {
    		int type = list.get(i).type;
    		if (type == 2) limit[i] = 2;
    		else if (type == 5) limit[i] = 1;
    		else limit[i] = 4;
    	}
    }
    
    // 경우의 수
    private static void permutation(int cnt) {
    	// 경우의 수를 다 만들었으면 감시
    	if (cnt == list.size()) {
    		watch();
    		return;
    	}
    	
    	for(int i = 0; i < limit[cnt]; i++) {
    		num[cnt] = i;
    		permutation(cnt+1);
    	}
    }
    
    // 감시
    private static void watch() {
    	// 감시한 칸
		int sum = 0;
		// map 복사
    	temp = copy(map);
    	
    	for(int i = 0; i < num.length; i++) {
    		int x = list.get(i).x;
    		int y = list.get(i).y;
    		int type = list.get(i).type;
    		int direction = num[i];
    		// cctv 유형에 따른 switch문
    		switch(type) {
    			// 상 / 우 / 하 / 좌
    			case 1:
    				sum += move(x, y, direction);
    				break;
    			// 좌우 / 상하
    			case 2:
    				if(direction == 0) {
    					sum += (move(x, y, 1) + move(x, y, 3));
    				}
    				else {
    					sum += (move(x, y, 0) + move(x, y, 2));
    				}
    				break;
    			// 상우 / 하우 / 상좌 / 하좌
    			case 3:
    				if(direction == 0) {
    					sum += (move(x, y, 0) + move(x, y, 1));
    				}
    				else if(direction == 1) {
    					sum += (move(x, y, 1) + move(x, y, 2));
    				}
    				else if(direction == 2) {
    					sum += (move(x, y, 0) + move(x, y, 3));
    				}
    				else {
    					sum += (move(x, y, 2) + move(x, y, 3));
    				}
    				break;
    			// 상좌우 / 상하우 / 하좌우 / 상하좌
    			case 4:
    				if(direction == 0) {
    					sum += (move(x, y, 0) + move(x, y, 1) + move(x, y, 3));
    				}
    				else if(direction == 1) {
    					sum += (move(x, y, 0) + move(x, y, 1) + move(x, y, 2));
    				}
    				else if(direction == 2) {
    					sum += (move(x, y, 1) + move(x, y, 2) + move(x, y, 3));
    				}
    				else {
    					sum += (move(x, y, 0) + move(x, y, 2) + move(x, y, 3));
    				}
    				break;
    			// 상하좌우
    			case 5:
    				sum += (move(x, y, 0) + move(x, y, 1) + move(x, y, 2) + move(x, y, 3));
    				break;
    		}
    	}
    	
    	// 최솟값 갱신
    	min = Math.min(empty - sum, min);
    }    
   
    // 방향대로 감시 시작
    private static int move(int x, int y, int direction) {
    	// 감시한 곳의 수
    	int cnt = 0;
    	while(true) {
    		x += dx[direction];
    		y += dy[direction];
    		
    		// 범위 밖이거나 벽일 때
    		if(x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 6) break;
    		
    		// 이미 감시한 곳일 때
    		if(temp[x][y] != 0) continue;
    		
    		temp[x][y] = 7;
    		cnt++;
    	}
    	
    	return cnt;
    }
    
    static class Camera {
    	int x, y, type;
    	
    	public Camera (int x, int y, int type) {
    		this.x = x;
    		this.y = y;
    		this.type = type;
    	}
    	
    }
    
}