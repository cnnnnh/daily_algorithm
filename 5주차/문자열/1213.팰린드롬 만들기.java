import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int[] arr = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A']++;
		}
		
		StringBuilder sb = new StringBuilder();
		char mid = ' ';
		boolean result = false;
		boolean flag = false;
		if (str.length() % 2 == 0) flag = true;
		
		for (int i = 0; i < 26; i++) {
			while(arr[i] > 1) {
				sb.append((char)(i + 65));
				arr[i] -= 2;
			}
			if (arr[i] == 1) {
				if (flag) {
					bw.append("I'm Sorry Hansoo");
					result = true;
					break;
				}
				flag = true;
				mid = (char)(i + 65);
			}
		}
		
		if (!result) {
			String temp = sb.reverse().toString();
			sb.reverse();
			if (mid != ' ') sb.append(mid);
			sb.append(temp);
			bw.append(sb);
			bw.newLine();
		}
        
		bw.flush();
		br.close();
		bw.close();
		
	}

} 
