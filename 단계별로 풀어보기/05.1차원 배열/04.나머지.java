import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            int temp = Integer.parseInt(br.readLine());
            int x = temp % 42;
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == x) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(x);
            }
        }
        
        bw.append(String.valueOf(list.size()));
        bw.flush();
        br.close();
        bw.close();
        
    }
}