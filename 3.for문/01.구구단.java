import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= 9; i++) {
            bw.append(String.valueOf(x) + " * " + String.valueOf(i) + " = " + String.valueOf(x * i));
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}