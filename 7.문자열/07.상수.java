import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String a = st.nextToken();
        StringBuffer sb = new StringBuffer(a);
        int x = Integer.parseInt(sb.reverse().toString());
        
        String b = st.nextToken();
        sb = new StringBuffer(b);
        int y = Integer.parseInt(sb.reverse().toString());
        
        if (x > y) {
            bw.append(String.valueOf(x));
        }
        else {
            bw.append(String.valueOf(y));
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}