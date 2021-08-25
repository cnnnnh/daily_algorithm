import java.util.*;
import java.io.*;

public class Main {
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (map[i][j] == 1) {
        			q.offer(new int[] {i, j});
        		}
        	}
        }
        
        while(!q.isEmpty()) {
        	int x = q.peek()[0];
        	int y = q.peek()[1];
        	q.poll();
        	for (int i = 0; i < 4; i++) {
        		int xx = x + dx[i];
        		int yy = y + dy[i];
        		if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
        			if (map[xx][yy] == 0) {
        				map[xx][yy] = map[x][y] + 1;
        				q.add(new int[] {xx, yy});
        			}
        		}
        	}
        }

        int time = 0;
        boolean flag = false;
        label:
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (map[i][j] == 0) {
        			flag = true;
        			break label;
        		}
        		time = Math.max(time, map[i][j]);
        	}
        }
        
        if (flag) {
        	bw.append("-1");
        }
        else {
        	bw.append(String.valueOf(time-1));
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
    
}