import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine().trim());
        int b = Integer.parseInt(br.readLine().trim());
        char[] arr = Integer.toString(b).toCharArray();
        
        for (int i = arr.length-1; i >= 0; i--) {
            bw.append(String.valueOf((a * (arr[i] - '0'))));
            bw.newLine();
        }
        
        bw.append(String.valueOf(a * b));
        bw.flush();
        br.close();
        bw.close();
        
    }
}