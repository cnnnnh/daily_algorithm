import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(n);
        visited[n] = 1;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            if (x == m) break;
            int[] dx = {-1, 1, x};
            for (int i = 0; i < 3; i++) {
                int xx = x + dx[i];
                if (xx >= 0 && xx <= 100000) {
                    if (visited[xx] == 0) {
                        visited[xx] = visited[x] + 1;
                        q.offer(xx);
                    }
                }
            }
        }
        
        bw.append(String.valueOf(visited[m]-1));
        bw.flush();
        br.close();
        bw.close();
    }
}