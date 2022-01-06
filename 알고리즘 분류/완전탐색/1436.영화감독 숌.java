import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	
    	int cnt = 0;
    	int number = 666;
    	
    	while(cnt < n) {
    		if (String.valueOf(number).contains("666")) {
    			cnt++;
    		}
    		number++;
    	}
    	
    	System.out.println(number-1);
    	
    }
    
}