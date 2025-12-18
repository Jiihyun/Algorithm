import java.io.*;
import java.util.*;

public class Main {
    
    private static final List<String> word = List.of("zero", "one", "two", "three", "four",
                                                    "five", "six", "seven", "eight", "nine");
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        List<Item> list = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            list.add(new Item(i, toKey(i)));
        }
        list.sort(Comparator.comparing(item -> item.key));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).num);
            if ( (i+1) % 10 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }
    
    static String toKey(int num) {
        if (num < 10) {
            return word.get(num);
        }
        String a = word.get(num/10);
        String b = word.get(num%10);
        return a + " " + b;
    }
    
    static class Item {
        int num;
        String key;
        
        public Item(int num, String key) {
            this.num = num;
            this.key = key;
        }
    }
}