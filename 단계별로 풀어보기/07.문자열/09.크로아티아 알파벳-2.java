import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String cro[] = {"c=", "c-", "dz=", "d-", "lj", "nj","s=", "z="};
        String str = br.readLine();
        
        for (int i = 0; i < cro.length; i++) {
            str = str.replace(cro[i], "a");
        }
        
        bw.append(String.valueOf(str.length()));
        bw.flush();
        br.close();
        bw.close();
    }
}
