import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Person> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Person(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < n; i++) {
            bw.append(String.valueOf(list.get(i).age) + " " + list.get(i).name + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    static class Person implements Comparable<Person> {
        int idx;
        int age;
        String name;
        
        public Person (int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }
        
        @Override
        public int compareTo(Person p) {
            if (p.age < this.age) {
                return 1;
            }
            else if (p.age > this.age) {
                return -1;
            }
            else {
                if (p.idx < this.idx) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        }
        
    }
}