import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main (String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }
        
        visited = new boolean[n+1];
        dfs(v);
        bw.newLine();
        visited = new boolean[n+1];
        bfs(v);
        bw.newLine();
        
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    private static void dfs (int start) throws IOException {
        if (visited[start]) return;
        visited[start] = true;
        bw.append(String.valueOf(start) + " ");
        for (int i : list[start]) {
            if (!visited[i]) dfs(i);
        }
    }
    
    private static void bfs (int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            bw.append(String.valueOf(x) + " ");
            for (int i : list[x]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    
}