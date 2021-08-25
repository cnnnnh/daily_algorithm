import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, cnt;
    static boolean[] visited;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[10];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            visited[Integer.parseInt(st.nextToken())] = true;
        }
        
        cnt = 0;
        backTracking(0, 0);
        
        bw.append(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void backTracking (int idx, int count) {
        if (idx == n) {
            if (count == m) {
                cnt++;
            }
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                visited[i] = false;
                backTracking(idx+1, count+1);
                visited[i] = true;
            }
            else {
                backTracking(idx+1, count);
            }
        }
    }
    
}