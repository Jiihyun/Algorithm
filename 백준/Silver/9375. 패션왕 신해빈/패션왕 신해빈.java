import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testLength = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testLength-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int clothes = Integer.parseInt(br.readLine());

            while (clothes-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                st.nextToken();
                String kind = st.nextToken();

                if (map.containsKey(kind)) {
                    map.put(kind, map.get(kind) + 1);
                } else {
                    map.put(kind, 1);
                }
            }

            int result = 1;

            for (int val : map.values()) {
                result *= (val + 1);
            }
            sb.append(result - 1).append('\n');

        }
        System.out.println(sb);
    }
}
