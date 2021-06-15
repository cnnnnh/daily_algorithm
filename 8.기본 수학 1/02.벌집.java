import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        int answer = 1;
        int number = 1;
        
        while(true) {
            if (number >= x) break;
            number += (6 * answer);
            answer++;
        }
        
        bw.append(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
        
    }
}