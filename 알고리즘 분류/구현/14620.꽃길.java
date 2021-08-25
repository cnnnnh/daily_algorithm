import java.util.*;
import java.io.*;

public class Main {
    static int n, answer;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        bw.append(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    private static void dfs(int flower, int cost) {
        if (flower == 3) {
            if (cost < answer) {
                answer = cost;
            }
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPossible(i, j)) {
                    setVisited(i, j, true);
                    dfs(flower + 1, cost + getSum(i, j));
                    setVisited(i, j, false);
                }
            }
        }
    }
    
    private static boolean isIn(int x, int y) {
    	if (x < 0 || y < 0 || x >= n || y >= n) return false;
        return true;
    }
    
    private static boolean isPossible(int x, int y) {
        if (!isIn(x, y)) return false;
        if (visited[x][y]) return false;
        
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (!isIn(xx, yy)) return false;
            if (visited[xx][yy]) return false;
        }
        
        return true;
    }
    
    private static void setVisited(int x, int y, boolean flag) {
        if (flag) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                visited[xx][yy] = true;
            }
        }
        else {
            visited[x][y] = false;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                visited[xx][yy] = false;
            }
        }
    }
    
    private static int getSum(int x, int y) {
        int result = map[x][y];
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            result += map[xx][yy];
        }
        return result;
    }
    
}