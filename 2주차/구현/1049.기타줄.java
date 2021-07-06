import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list_pack = new ArrayList<>();
        ArrayList<Integer> list_ea = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            list_pack.add(Integer.parseInt(st.nextToken()));
            list_ea.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list_pack);
        Collections.sort(list_ea);
        
        int pack = n / 6;
        int ea = n % 6;
        int a = (pack + 1) * list_pack.get(0);
        int b = ((pack) * list_pack.get(0)) + (ea * list_ea.get(0));
        int c = list_ea.get(0) * n;
        int min = Math.min(a, b);
        min = Math.min(min, c);
        
        bw.append(String.valueOf(min));
        bw.flush();
        br.close();
        bw.close();
        
    }
}