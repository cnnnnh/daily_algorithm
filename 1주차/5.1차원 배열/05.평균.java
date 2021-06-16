import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        double[] input = new double[n];
        double answer = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Double.parseDouble(st.nextToken());
        }
        
        Arrays.sort(input);
        
        for (int i = 0; i < n; i++) {
            input[i] = (input[i] / input[n-1]) * 100;
            answer += input[i];
        }
        
        bw.append(String.valueOf(answer/(double)n));
        bw.flush();
        br.close();
        bw.close();
        
    }
}