import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            while(!s.isEmpty() && arr[s.peek()] < arr[i]) {
                arr[s.pop()] = arr[i];
            }
            s.push(i);
        }
        
        while(!s.isEmpty()) {
            arr[s.pop()] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            bw.append(String.valueOf(arr[i]) + " ");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}