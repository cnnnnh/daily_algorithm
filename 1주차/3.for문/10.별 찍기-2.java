import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x-i-1; j++) {
                bw.append(" ");
            }
            for (int j = x-i-1; j < x; j++) {
                bw.append("*");
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}