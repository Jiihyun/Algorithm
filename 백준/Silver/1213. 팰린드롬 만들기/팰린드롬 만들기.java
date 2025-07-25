import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Map<Character, Integer> alphabets = new TreeMap<>();
        for (int i = 0; i < line.length(); i++) {
            alphabets.put(line.charAt(i), alphabets.getOrDefault(line.charAt(i), 0) + 1);
        }
        int oddCount = 0;
        Character mid = null;
        for (Map.Entry<Character, Integer> entry : alphabets.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddCount++;
                mid = entry.getKey();
            }
        }
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : alphabets.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue() / 2;
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(sb);
        if (mid != null) {
            result.append(mid);
        }
        result.append(new StringBuilder(sb).reverse());
        System.out.println(result);

    }
}
