import java.io.*;

public class Main {
    public static void main (String[] arge) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
        
        int x = Integer.parseInt(br.readLine().trim());
        int y = Integer.parseInt(br.readLine().trim());
        
        if (x > 0) {
            if (y > 0) {
                bw.append("1");
            }
            else {
                bw.append("4");
            }
        }
        else {
            if (y > 0) {
                bw.append("2");
            }
            else {
                bw.append("3");
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}