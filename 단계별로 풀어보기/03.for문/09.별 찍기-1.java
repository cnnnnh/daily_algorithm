import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                bw.append("*");
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}