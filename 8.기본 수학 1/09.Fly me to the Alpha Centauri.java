import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
		int TC = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
			
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
			
			int distance = y - x;
			
			int max = (int)Math.sqrt(distance);
            
			if(max == Math.sqrt(distance)) {
                bw.append(String.valueOf(max * 2 - 1));
			}
			else if(distance <= max * max + max) {
                bw.append(String.valueOf(max * 2));
			}
			else {
                bw.append(String.valueOf(max * 2 + 1));
			}
			bw.newLine();
		}
        
        bw.flush();
        br.close();
        bw.close();
	}
}