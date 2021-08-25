import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] temp = arr.clone();
        Arrays.sort(arr);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], cnt++);
            }
        }
        
        for (int i = 0; i < n; i++) {
            bw.append(String.valueOf(map.get(temp[i])) + " ");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}