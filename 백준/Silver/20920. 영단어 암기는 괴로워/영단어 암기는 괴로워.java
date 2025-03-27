import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int standard = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String word = br.readLine();
            if (word.length() >= standard) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            if (map.get(o1).compareTo(map.get(o2)) != 0) {
                return map.get(o2) - map.get(o1);
            }
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : list) {
            stringBuilder.append(word).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
