import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int k = Integer.parseInt(br.readLine());
        k++;
        
        while(k != 0) {
            sb.append(k % 2);
            k /= 2;
        }
        
        for (int i = sb.toString().length()-2; i >= 0; i--) {
            if (sb.charAt(i) == '0') bw.append("4");
            else bw.append("7");
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}