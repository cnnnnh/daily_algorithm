import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> list = new ArrayList<>();
        String str = br.readLine();
        
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, str.length());
            list.add(temp);
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            bw.append(list.get(i) + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}