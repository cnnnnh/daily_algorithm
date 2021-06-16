import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        
        while (st.hasMoreTokens()) {
            st.nextToken();
            result++;
        }
        
        bw.append(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}