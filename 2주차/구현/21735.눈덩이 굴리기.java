import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, max;
    static int[] arr;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Snow> q = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        max = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        q.offer(new Snow(-1, 1, 0, 1));
        q.offer(new Snow(-1, 1, 0, 2));
        
        while(!q.isEmpty()) {
        	Snow snow = q.poll();
        	if (snow.time == m) {
        		max = Math.max(max, snow.weight);
        		continue;
        	}
        	if (snow.index == n-1) {
        		max = Math.max(max, snow.weight);
        		continue;
        	}
        	int index = 0, weight = 0, time = 0;
        	time = snow.time + 1;
        	if (snow.type == 1) {
        		index = snow.index + 1;
        		if (index >= n) continue;
        		weight = snow.weight + arr[index];
        	}
        	else if (snow.type == 2) {
        		index = snow.index + 2;
        		if (index >= n) continue;
        		weight = (snow.weight / 2) + arr[index];
        	}

        	q.offer(new Snow(index, weight, time, 1));
        	q.offer(new Snow(index, weight, time, 2));
        }
        
        bw.append(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    static class Snow {
    	int index;
    	int weight;
    	int time;
    	int type;
    	
    	public Snow (int index, int weight, int time, int type) {
    		this.index = index;
    		this.weight = weight;
    		this.time = time;
    		this.type = type;
    	}
    }
    
} 