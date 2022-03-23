import java.io.*;
import java.util.*;

public class Main {
	
	static int n, l, r, num, sum;
	static boolean flag;
	static int[][] map, temp;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	l = Integer.parseInt(st.nextToken());
    	r = Integer.parseInt(st.nextToken());
    	
    	map = new int[n][n];
    	temp = new int[n][n];
    	
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}

    	int answer = 0;
    	flag = true;
    	
    	while(flag) {
    		// temp에 map 복사
    		copy(temp, map);
    		visited = new boolean[n][n];
			flag = false;
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < n; j++) {
        			if (visited[i][j]) continue;
        			visited[i][j] = true;
        			num = 1;
        			sum = map[i][j];
        			dfs(i, j);
        			// 인접한 국경 중 인구이동이 없으면 (나 혼자면)
        			if (num == 1) visited[i][j] = false;
        			// 인구이동이 있으면
        			else divide();
        		}
        	}
        	
        	// 모든 국경을 돌아봐도 인구이동이 없으면
        	if(!flag) break;
        	
        	// 인구이동 일수 ++
        	answer++;
        	// map에 temp 복사
        	copy(map, temp);
    	}
    	
		System.out.println(answer);
    }
    
    // 배열 복사 함수
    private static void copy(int[][] arr1, int[][] arr2) {
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr1[i][j] = arr2[i][j];
			}
		}
    }
    
    // 인구이동 함수
    private static void divide() {
    	flag = true;
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			if (visited[i][j]) {
    				temp[i][j] = (sum / num);
    				visited[i][j] = false;
    			}
    		}
    	}
    }
    
    // 인접하고 인구이동 가능한 국경 탐색
    private static void dfs(int x, int y) {
    	for (int i = 0; i < 4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		// 범위 밖이거나 방문한 곳이면 건너뛰기
    		if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
    		
    		// 인구 차이가 l 이상 r 이하일 때
    		if (Math.abs(map[nx][ny] - map[x][y]) >= l
    				&& Math.abs(map[nx][ny] - map[x][y]) <= r) {
    			visited[nx][ny] = true;
    			num++;
    			sum += map[nx][ny];
    			dfs(nx, ny);
    		}
    	}
    }
    
}