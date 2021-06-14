import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] arr = br.readLine().toCharArray();
        int result = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int x = (int) arr[i];
            if (x >= 'A' && x <= 'C') {
                result += 3;
            }
            else if (x >= 'D' && x <= 'F') {
                result += 4;
            }
            else if (x >= 'G' && x <= 'I') {
                result += 5;
            }
            else if (x >= 'J' && x <= 'L') {
                result += 6;
            }
            else if (x >= 'M' && x <= 'O') {
                result += 7;
            }
            else if (x >= 'P' && x <= 'S') {
                result += 8;
            }
            else if (x >= 'T' && x <= 'V') {
                result += 9;
            }
            else{
                result += 10;
            }
        }
        
        bw.append(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}