import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][][] visited = new boolean[2][n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        visited[1][0][0] = true;
        boolean flag = false;
        
        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int count = q.peek()[2];
            int wall = q.peek()[3];
            q.poll();
            
            if (x == n-1 && y == m-1) {
            	flag = true;
            	bw.append(String.valueOf(count+1));
            	break;
            }
            
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                
                if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                    if (map[xx][yy] == 0) {
                    	if (!visited[wall][xx][yy]) {
                    		visited[wall][xx][yy] = true;
                    		q.offer(new int[] {xx, yy, count+1, wall});
                    	}
                    }
                    else {
                        if (wall == 0 && !visited[1][xx][yy]) {
                        	visited[1][xx][yy] = true;
                            q.offer(new int[] {xx, yy, count+1, 1});
                        }
                    }

                }
            }
        }
        
        if (!flag) {
        	bw.append("-1");
        }
        bw.flush();
        br.close();
        bw.close();
        
    }
}