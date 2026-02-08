import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> nums = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums.put(num, nums.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedNums = nums.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : sortedNums) {
            Integer key = entry.getKey();
            for (int count = 0; count < entry.getValue(); count++) {
                sb.append(key).append(" ");
            }
        }
        System.out.println(sb);
    }
}
