import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        c -= b;
        
        if (c <= 0) {
            bw.append("-1");
        }
        else {
            a /= c;
            bw.append(String.valueOf(a + 1));
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}