import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                else {
                    return s1.length() - s2.length();
                }
            }
        });
        
        bw.append(arr[0] + "\n");
        String pre = arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i].equals(pre)) continue;
            bw.append(arr[i] + "\n");
            pre = arr[i];
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}