import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int TC = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int cnt = 1;
            String xx = null;
            String yy = null;
            
            while (n > h) {
                n -= h;
                cnt++;
            }
            if (cnt < 10) {
                xx = "0" + String.valueOf(cnt);
            }
            else {
                xx = String.valueOf(cnt);
            }
            yy = String.valueOf(n);
            
            bw.append(yy + xx);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}