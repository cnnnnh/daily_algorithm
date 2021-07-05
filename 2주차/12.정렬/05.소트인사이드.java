import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i] - '0');
        }
        
        Collections.sort(list);
        Collections.reverse(list);
        
        for (int i = 0; i < list.size(); i++) {
            bw.append(String.valueOf(list.get(i)));
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}