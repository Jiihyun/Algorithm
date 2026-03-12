import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            dfs(i);
        }
        Collections.sort(list);
        
        if (n >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(n));
        }
    }

    private static void dfs(long num) {
        list.add(num);
        long last = num % 10;
        for (int i = 0; i < last; i++) {
            dfs(num * 10 + i);
        }
    }
}
