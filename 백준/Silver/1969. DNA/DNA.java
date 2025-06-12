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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        StringBuilder newWord = new StringBuilder();
        int answer = 0;

        for (int i = 0; i < m; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                char ch = words[j].charAt(i);
                map.put(ch, map.getOrDefault(ch, 1) + 1);
            }
            char mostFrequentChar = 'A';
            int max = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max ||
                        (entry.getValue() == max && entry.getKey() < mostFrequentChar)) {
                    mostFrequentChar = entry.getKey();
                    max = entry.getValue();
                }
            }
            newWord.append(mostFrequentChar);

            for (int j = 0; j < n; j++) {
                if (words[j].charAt(i) != mostFrequentChar) {
                    answer++;
                }
            }
        }
        System.out.println(newWord);
        System.out.println(answer);
    }
}

