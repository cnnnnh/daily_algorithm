/*
 * StringTokenizer 사용법 익히기.
 * ex) hasMoreTokens(), split 하는 법
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, "-");
		int sum = Integer.MAX_VALUE;
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			StringTokenizer addition = new StringTokenizer(st.nextToken(), "+");
			
			while(addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			}
			else {
				sum -= temp;
			}
			
		}
		
		bw.append(String.valueOf(sum));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}