import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                list.add(name);
            }
        }
        list.sort(String::compareTo);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
