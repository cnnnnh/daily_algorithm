import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[] arr = br.readLine().toCharArray();
        int result = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'c') {
                if ((i+1) < arr.length) {
                    if (arr[i+1] == '=' || arr[i+1] == '-') {
                        i++;
                    }
                }
            }
            else if (arr[i] == 'd') {
                if ((i+1) < arr.length) {
                    if (arr[i+1] == '-') {
                        i++;
                    }
                    else if (arr[i+1] == 'z') {
                        if ((i+2) < arr.length && arr[i+2] == '=') {
                            i += 2;
                        } 
                    }
                }
            }
            else if (arr[i] == 'l') {
                if ((i+1) < arr.length) {
                    if (arr[i+1] == 'j') {
                        i++;
                    }
                }
            }
            else if (arr[i] == 'n') {
                if ((i+1) < arr.length) {
                    if (arr[i+1] == 'j') {
                        i++;
                    }
                }
            }
            else if (arr[i] == 's') {
                if ((i+1) < arr.length) {
                    if (arr[i+1] == '=') {
                        i++;
                    }
                }
            }
            else if (arr[i] == 'z') {
                if ((i+1) < arr.length) {
                    if (arr[i+1] == '=') {
                        i++;
                    }
                }
            }
            result++;
        }
        
        bw.append(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}