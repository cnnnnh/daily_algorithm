import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        String line = null;
        while(true) {
            line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.append(String.valueOf(a + b));
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}