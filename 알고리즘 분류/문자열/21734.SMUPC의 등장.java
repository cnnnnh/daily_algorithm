import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        
        for (int i = 0; i < str.length(); i++) {
        	int c = str.charAt(i);
        	int n = 0;
            String num = Integer.toString(c);
            
            for (int j = 0; j < num.length(); j++) {
            	n += (num.charAt(j) - '0');
            }
            
            for (int j = 0; j < n; j++) {
                bw.append((char)c);
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}