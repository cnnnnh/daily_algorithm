import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] list = new ArrayList[n+1];
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
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int answer = 0;
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            visited[x] = true;
            for (int i : list[x]) {
            	if (!visited[i]) {
                    visited[i] = true;
                    answer++;
                    q.offer(i);
            	}

            }
        }
        
        bw.append(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
        
    }
}