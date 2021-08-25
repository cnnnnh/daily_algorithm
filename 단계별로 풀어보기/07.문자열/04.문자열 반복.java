import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int TC = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();
            
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < n; k++) {
                    bw.append(String.valueOf(arr[j]));
                }
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}