import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int k = Integer.parseInt(st.nextToken());
        
        for (int T = 0; T < k; T++) {
        	st = new StringTokenizer(br.readLine());
        	int v = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	ArrayList<Integer>[] list = new ArrayList[v+1];
        	
        	for (int i = 1; i <= v; i++) {
        		list[i] = new ArrayList<>();
        	}
        	
        	for (int i = 0; i < e; i++) {
            	st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	list[a].add(b);
            	list[b].add(a);
        	}
        	
        	Queue<Integer> q = new LinkedList<>();
        	int[] visited = new int[v+1];
        	boolean flag = false;
        	
        	for (int n = 1; n <= v; n++) {
        		if (visited[n] == 0) {
                	q.offer(n);
                	visited[n] = 1;
                	
                	label:
                	while(!q.isEmpty()) {
                		int x = q.poll();
                		for (int i : list[x]) {
                			if (visited[i] == 0) {
                				visited[i] = visited[x] * (-1);
                				q.offer(i);
                			}
                			else if (visited[i] == visited[x]) {
                				flag = true;
                				break label;
                			}
                		}
                	}
        		}
        	}
        	
        	bw.append(flag ? "NO\n" : "YES\n");
        	
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
    
}