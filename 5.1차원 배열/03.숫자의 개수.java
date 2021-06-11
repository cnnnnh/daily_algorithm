import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int result = a * b * c;
        char[] arr = Integer.toString(result).toCharArray();
        int[] answer = new int[10];
        
        for (int i = 0; i < arr.length; i++) {
            answer[arr[i] - '0']++;
        }
        
        for (int i = 0; i < 10; i++) {
            bw.append(String.valueOf(answer[i]));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
	}
}