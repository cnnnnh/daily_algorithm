import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine().trim());
        
        if (x >= 90) {
            bw.append("A");
        } else if (x >= 80) {
            bw.append("B");
        } else if (x >= 70) {
            bw.append("C");
        } else if (x >= 60) {
            bw.append("D");
        } else {
            bw.append("F");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}