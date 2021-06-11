import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            int score = 0;
            int result = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'O') {
                    score++;
                    result += score;
                }
                else {
                    score = 0;
                }
            }
            bw.append(String.valueOf(result));
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}