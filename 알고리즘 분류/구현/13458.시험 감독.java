import java.util.*;
import java.io.*;

/*
 * �ڷ��� ����
 * int ��, long �̳�... ���������ϴ�!
 */

public class Main {
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] room = new int[n];
    	��
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