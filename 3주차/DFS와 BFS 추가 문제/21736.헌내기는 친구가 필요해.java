import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for (int i = 0; i < n; i++) {
        	String str = br.readLine();
        	for (int j = 0; j < m; j++) {
        		map[i][j] = str.charAt(j);
        		if (map[i][j] == 'I') {
        			// 도연이 위치
        			q.offer(new int[] {i, j, 0});
        			visited[i][j] = true;
        		}
        	}
        }
        
        int cnt = 0;
        while(!q.isEmpty()) {
        	int[] arr = q.poll();
        	
        	for (int i = 0; i < 4; i++) {
        		int nx = arr[0] + dx[i];
        		int ny = arr[1] + dy[i];
        		if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
        			// 들른 적 없을 때
        			if (!visited[nx][ny]) {
        				visited[nx][ny] = true;
        				// 아무 것도 없는 곳
            			if (map[nx][ny] == 'O') {
            				q.offer(new int[] {nx, ny});
            			}
            			// 사람이 있는 곳
            			else if (map[nx][ny] == 'P') {
            				cnt++;
            				q.offer(new int[] {nx, ny});
            			}
        			}
        		}
        	}
        }
        
        bw.append(cnt == 0 ? "TT" : String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
        
    }
    
}