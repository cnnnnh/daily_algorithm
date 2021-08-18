import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		String str3 = st.nextToken();
		
		int start = Integer.parseInt(str1.substring(0, 2) + str1.substring(3, 5));
		int end = Integer.parseInt(str2.substring(0, 2) + str2.substring(3, 5));
		int streaming = Integer.parseInt(str3.substring(0, 2) + str3.substring(3, 5));

		String input = "";
		int cnt = 0;
		HashSet<String> set = new HashSet<>();
		
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			if (!st.hasMoreTokens()) break;
			String str = st.nextToken();
			int time = Integer.parseInt(str.substring(0, 2) + str.substring(3, 5));
			String id = st.nextToken();
			if (time <= start) {
				set.add(id);
			}
			if (time >= end && time <= streaming) {
				if (set.contains(id)) {
					set.remove(id);
					cnt++;
				}
			}
		}
		
		bw.append(String.valueOf(cnt));
		bw.flush();
		br.close();
		bw.close();
		
	}

} 
