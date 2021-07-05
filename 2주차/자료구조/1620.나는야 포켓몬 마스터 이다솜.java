import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String str = null;
        
        for (int i = 1; i <= n; i++) {
            str = br.readLine();
            map.put(str, Integer.toString(i));
            map.put(Integer.toString(i), str);
        }
        
        for (int i = 0; i < m; i++) {
            str = br.readLine();
            if (map.containsKey(str)) {
                bw.append(String.valueOf(map.get(str)));
                bw.newLine();
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}