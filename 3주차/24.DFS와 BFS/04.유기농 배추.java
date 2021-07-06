import java.util.*;
import java.io.*;

public class Main {
    static int m, n, k, cnt;
    static boolean[][] map, visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int TC = Integer.parseInt(st.nextToken());
        
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new boolean[m][n];
            visited = new boolean[m][n];
            cnt = 0;
            
            for (int i = 0; i < k; i++) {
            	st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	map[a][b] = true;
            }
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            bw.append(String.valueOf(cnt) + "\n");
        }
            bw.flush();
            br.close();
            bw.close();
    }
    
    private static void dfs (int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < m && yy < n) {
                if (map[xx][yy] && !visited[xx][yy]) {
                    dfs(xx, yy);
                }
            }
        }
    }
    
}