import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int TC = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];
        int pre = -1;
        int result = 0;
        boolean flag = false;
        
        for (int i = 0; i < TC; i++) {
            char[] arr = br.readLine().toCharArray();
            alpha = new int[26];
            pre = -1;
            flag = false;
            
            for (int j = 0; j < arr.length; j++) {
                int x = arr[j] - 'a';
                if (x == pre) continue;
                if (alpha[x] != 0) {
                    flag = true;
                    break;
                }
                alpha[x]++;
                pre = x;
            }
            if (!flag) {
                result++;
            }
        }
        
        bw.append(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}