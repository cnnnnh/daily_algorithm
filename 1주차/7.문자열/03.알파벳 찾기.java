import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] arr = br.readLine().toCharArray();
        int[] result = new int[26];
        Arrays.fill(result, -1);
        
        for (int i = 0; i < arr.length; i++) {
            int x = (int) arr[i] - 97;
            if (result[x] != -1) continue;
            result[x] = i;
        }
        
        for (int i = 0; i < result.length; i++) {
            bw.append(String.valueOf(result[i]) + " ");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}