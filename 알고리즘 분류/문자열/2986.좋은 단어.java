import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			Stack<Character> s = new Stack<>();
			
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (s.isEmpty()) {
					s.push(c);
				}
				else {
					if (s.peek() == c) {
						s.pop();
					}
					else {
						s.push(c);
					}
				}
			}
			
			if (s.isEmpty()) {
				cnt++;
			}
			
		}
		
		bw.append(String.valueOf(cnt));
		bw.flush();
		br.close();
		bw.close();
		
	}

} 
