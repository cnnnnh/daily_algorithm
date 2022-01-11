import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int answer = 1;
		
		while(true) {
			int a = answer % 15;
			int b = answer % 28;
			int c = answer % 19;
			boolean flag_a = false;
			boolean flag_b = false;
			boolean flag_c = false;
			
			if ((a == 0 && e == 15) || (a == e)) {
				flag_a = true;
			}
			if ((b == 0 && s == 28) || (b == s)) {
				flag_b = true;
			}
			if ((c == 0 && m == 19) || (c == m)) {
				flag_c = true;
			}
			
			if (flag_a && flag_b && flag_c) break;
			
			answer++;
		}
		
		System.out.println(answer);
		
	}

}
