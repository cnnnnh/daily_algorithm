import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];
        
        for (int i = 0; i < 15; i++) {
            apt[i][1] = 1;
            apt[0][i] = i;
        }
        
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apt[i][j] = apt[i-1][j] + apt[i][j-1];
            }
        }
        
        for (int i = 0; i < TC; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(apt[a][b]));
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}