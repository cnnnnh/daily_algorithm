import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if (m >= 45) {
            m -= 45;
        }
        else {
            m -= 45;
            m += 60;
            if (h > 0) {
                h--;
            }
            else {
                h = 23;
            }
        }
        
        bw.append(String.valueOf(h) + " " + String.valueOf(m));
        bw.flush();
        br.close();
        bw.close();
        
    }
}