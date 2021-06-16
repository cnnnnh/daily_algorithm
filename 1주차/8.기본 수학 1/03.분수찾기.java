import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        int num = 0;
        int cnt = 0;
        int a = 0;
        int b = 0;
        
        while(x > num) {
            cnt++;
            num += cnt;
        }
        
        num -= x;
        
        if (cnt % 2 == 0) {
            a = cnt - num;
            b = 1 + num;
            
        }
        else {
            a = 1 + num;
            b = cnt - num;
        }
        
        bw.append(String.valueOf(a) + "/" + String.valueOf(b));
        bw.flush();
        br.close();
        bw.close();
        
    }
}