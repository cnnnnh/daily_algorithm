import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            }
            else {
                map.put(str, 1);
            }
            if (map.get(str) > max) max = map.get(str);
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        
        Collections.sort(list);
        bw.append(list.get(0));
        br.close();
        bw.close();
        
    }
}