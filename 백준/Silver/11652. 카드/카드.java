import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < size; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            Integer temp = map.get(num);
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(findNumber(max, map));
    }

    private static long findNumber(final int max, final Map<Long, Integer> map) {
        return map.entrySet()
                .stream()
                .filter(num -> num.getValue() == max)
                .sorted(Comparator.comparingLong(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}
