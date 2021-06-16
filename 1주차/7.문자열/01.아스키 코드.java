import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char x = br.readLine().charAt(0);
        
        bw.append(String.valueOf((int) x));
        bw.flush();
        br.close();
        bw.close();
    }
}