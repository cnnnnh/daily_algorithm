import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n, cnt;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    search(i, j);
                    list.add(cnt);
                }
            }
        }
        
        Collections.sort(list);
        bw.append(String.valueOf(list.size()) + "\n");
        
        for (int i : list) {
            bw.append(String.valueOf(i) + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    private static void search (int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
            	if (map[xx][yy] == 1 && !visited[xx][yy]) {
                    search(xx, yy);
                    cnt++;
            	}
            }
        }
    }
    
}