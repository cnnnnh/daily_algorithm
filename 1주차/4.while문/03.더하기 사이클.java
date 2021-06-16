import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        int result = x;
        int cnt = 0;
        
        do {
            result = (result % 10) * 10 + ((result / 10) + (result % 10)) % 10;
            cnt++;
        } while(x != result);
        
        bw.append(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
        
    }
}