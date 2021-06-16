import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int w3 = 0;
        int w5 = 0;
        boolean flag = false;
        
        if (x % 5 == 0) {
            w5 = (x / 5);
            flag = true;
        }
        else {
           for (int i = 0; i <= (x / 5); i++) {
               int temp = x;
                w5 = (temp / 5) - i;
                temp -= (5 * w5);
                if (temp % 3 == 0) {
                    w3 = (temp / 3);
                    flag = true;
                    break;
                }
            }
        }
        
        if (flag) {
            bw.append(String.valueOf(w3 + w5));
        }
        else {
            bw.append("-1");
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}