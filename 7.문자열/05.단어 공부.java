import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] arr = br.readLine().toUpperCase().toCharArray();
        int[] result = new int[26];
        int max = 0;
        char c = ' ';
        boolean flag = false;
        
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] - 'A';
            result[x]++;
        }
        
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                c = (char) (i + 'A');
                flag = false;
            }
            else if (result[i] == max) {
                flag = true;
            }
        }
        if (flag) {
            bw.append("?");
        }
        else {
            bw.append(c);
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}