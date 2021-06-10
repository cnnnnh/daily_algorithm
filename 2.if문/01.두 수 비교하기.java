import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        if (a > b) {
            bw.append(">");
        }
        else if (a < b) {
            bw.append("<");
        }
        else {
            bw.append("==");
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}