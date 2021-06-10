import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine().trim());
        
        if (x % 4 == 0) {
            if (x % 400 == 0) {
                bw.append("1");
            } else {
                if (x % 100 == 0) {
                    bw.append("0");
                }
                else {
                    bw.append("1");
                }
            }
        }
        else {
            bw.append("0");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}