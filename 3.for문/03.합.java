import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine().trim());
        int result = 0;
        if (x % 2 == 0) {
            result = (1 + x) * (x / 2);
        }
        else {
            result = (1 + x) * (x / 2) + (x / 2) + 1;
        }
        
        bw.append(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}