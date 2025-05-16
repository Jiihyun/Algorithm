import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Map<String, Integer> answer = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String[] split = br.readLine().split("\\.");
            String name = split[1];
            if (answer.containsKey(name)) {
                answer.put(name, answer.get(name) + 1);
            } else {
                answer.put(name, 1);
            }
        }
        Map<String, Integer> sortedMap = new TreeMap<>(answer);
        sortedMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
}

