import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[8001];
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        double average = 0;
        double sum = 0;
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            list.add(x);
            sum += x;
            arr[x + 4000]++;
            if (arr[x + 4000] > max) {
                max = arr[x + 4000];
            }
        }
        
        Collections.sort(list);
        
        average = sum / (double) n;
        
        bw.append(String.valueOf(Math.round(average)) + "\n");
        bw.append(String.valueOf(list.get(n/2)) + "\n");
        
        int maxResult = 0;
        boolean flag = false;
        for (int i = 0; i <= 8000; i++) {
            if (arr[i] == max) {
                maxResult = i - 4000;
                if (flag) {
                    break;
                }
                flag = true;
            }
        }
        
        bw.append(String.valueOf(maxResult) + "\n");
        bw.append(String.valueOf(list.get(n-1) - list.get(0)));
        
        bw.flush();
        br.close();
        bw.close();
    }
}