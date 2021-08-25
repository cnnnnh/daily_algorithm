import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        
        int tc = Integer.parseInt(st.nextToken());
        
        for (int T = 0; T < tc; T++) {
        	int n = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	boolean[][] visited = new boolean[n][n];
        	Queue<int[]> q = new LinkedList<>();
        	q.offer(new int[] {x1, y1, 0});
        	visited[x1][y1] = true;
        	
        	while(!q.isEmpty()) {
        		int[] arr = q.poll();
        		
        		if (arr[0] == x2 && arr[1] == y2) {
        			bw.append(String.valueOf(arr[2]) + "\n");
        			break;
        		}
        		
        		for (int i = 0; i < 8; i++) {
        			int nx = arr[0] + dx[i];
        			int ny = arr[1] + dy[i];
        			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        				if (!visited[nx][ny]) {
        					visited[nx][ny] = true;
        					q.offer(new int[] {nx, ny, arr[2]+1});
        				}
        			}
        		}
        	}
        	
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
    
}