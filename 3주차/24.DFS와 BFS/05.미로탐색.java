import java.util.*;
import java.io.*;

public class Main {
    static int n, m, min;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        visited[0][0] = true;
        bfs(0, 0);
        
        bw.append(String.valueOf(map[n-1][m-1]));
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    private static void bfs (int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        
        while(!q.isEmpty()) {
        	int a = q.peek()[0];
        	int b = q.peek()[1];
        	q.poll();
        	for (int i = 0; i < 4; i++) {
        		int xx = a + dx[i];
        		int yy = b + dy[i];
        		if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
        			if (map[xx][yy] == 1 && !visited[xx][yy]) {
        				visited[xx][yy] = true;
        				map[xx][yy] = map[a][b] + 1;
        				q.offer(new int[] {xx, yy});
        				
        			}
        		}
        	}
        }
    }
    
}