import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> stringMap = new HashMap<>();
        Map<Integer, String> integerMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            stringMap.put(line, i);
            integerMap.put(i, line);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            if (line.charAt(0) >= 'A') {
                sb.append(stringMap.get(line)).append("\n");
            } else {
                sb.append(integerMap.get(Integer.parseInt(line)))
                        .append("\n");
            }
        }
        System.out.println(sb);
    }
}
