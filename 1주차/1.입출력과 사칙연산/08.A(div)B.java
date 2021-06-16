import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        bw.append(String.valueOf(a/b));
        bw.flush();
        br.close();
        bw.close();
        
    }
}