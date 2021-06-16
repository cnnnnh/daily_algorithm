import java.util.*;
import java.io.*;

public class Main {
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (AP(i)) count++;
        }
        bw.append(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static boolean AP (int x) {
        if (x < 10) return true;
        char[] arr = Integer.toString(x).toCharArray();
        int dif = arr[0] - arr[1];
        for (int i = 1; i < arr.length-1; i++) {
            if (dif != (arr[i] - arr[i+1])) return false;
        }
        return true;
    }
}