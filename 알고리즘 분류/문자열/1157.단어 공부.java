import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine().toUpperCase();
		
		int[] arr = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A']++;
		}
		
		int max = -1;
		char c = ' ';
		
		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				c = (char) (i + 65);
			}
			else if (arr[i] == max) {
				c = '?';
			}
		}
		
		bw.append(c);
		bw.flush();
		br.close();
		bw.close();
		
	}

} 
