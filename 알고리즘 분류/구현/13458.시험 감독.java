import java.util.*;
import java.io.*;

/*
 * 자료형 문제
 * int 냐, long 이냐... 지긋지긋하다!
 */

public class Main {
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] room = new int[n];
    	ㅇ
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		room[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	long result = n;
    	
    	for(int i = 0; i < n; i++) {
    		room[i] -= b;
    		if(room[i] <= 0) continue;
    		result += Math.ceil((double)room[i] / (double)c);
    	}
    	
    	System.out.println(result);
    	
    }
    
}