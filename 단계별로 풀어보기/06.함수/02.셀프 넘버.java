import java.io.*;
import java.util.Arrays;

public class Main {
    
    static int[] arr = new int[10001];
    
    public static void main (String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int i = 1; i <= 10000; i++) {
            selfNumber(i);
        }
        
        for (int i = 1; i <= 10000; i++) {
            if (arr[i] == 0) {
                bw.append(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
    
    private static void selfNumber(int num) {
        if (arr[num] != 0) return;
        
        int result = num;
        char[] numArr = Integer.toString(num).toCharArray();
        
        for (int i = 0; i < numArr.length; i++) {
            result += (numArr[i] - '0');
        }
        
        if (result > 10000) return;
        selfNumber(result);
        arr[result]++;
    }
    
}