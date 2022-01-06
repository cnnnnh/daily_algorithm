import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S, answer;
	static int[] input;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	
    	input = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		input[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	answer = 0;
    	
    	dfs(0, 0);
    	
    	System.out.println(S == 0 ? answer-1 : answer);
    }
    
    private static void dfs(int start, int sum) {
    	if (start == N) {
        	if(sum == S) {
        		answer++;
        	}
    		return;
    	}
    	
    	dfs(start+1, sum+input[start]);
    	dfs(start+1, sum);
    }
    
}