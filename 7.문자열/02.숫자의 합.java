import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int result = 0;
        
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            result += (arr[i] - '0');
        }
        
        bw.append(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
        
    }
}