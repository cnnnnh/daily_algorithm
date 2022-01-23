import java.io.*;
import java.util.*;

public class Main {
	
	static int n, max;
	static int[] input, number;
	static boolean[] selected;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        input = new int[n];
        number = new int[n];
        selected = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        permutation(0);
        
        System.out.println(max);
    }
    
    private static void permutation(int cnt) {
    	if (cnt == n) {
    		calculate();
    		return;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if (selected[i]) continue;
    		selected[i] = true;
    		number[cnt] = input[i];
    		permutation(cnt+1);
    		selected[i] = false;
    	}
    }
    
    private static void calculate() {
    	int sum = 0;
    	for(int i = 1; i < n; i++) {
    		sum += Math.abs(number[i-1] - number[i]);
    	}
    	max = Math.max(max, sum);
    }
}