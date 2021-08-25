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
            int n = Integer.parseInt(st.nextToken());
            double[] arr = new double[n];
            double total = 0;
            double average = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Double.parseDouble(st.nextToken());
                total += arr[j];
            }
            
            average = total / n;
            int count = 0;
            
            for (int j = 0; j < n; j++) {
                if (arr[j] > average) count++;
            }
            
            double result = (double) count / (double) n * 100.0;
            
            bw.append(String.format("%.3f", result) + "%");
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}