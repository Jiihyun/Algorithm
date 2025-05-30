import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Set<Character> used = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            String[] phrase = br.readLine().split(" ");
            boolean assigned = false;

            for (int j = 0; j < phrase.length; j++) {
                char ch = phrase[j].charAt(0);
                char lower = Character.toLowerCase(ch);
                if (!used.contains(lower)) {
                    used.add(lower);
                    phrase[j] = "[" + ch + "]" + phrase[j].substring(1);
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                outer:
                for (int j = 0; j < phrase.length; j++) {
                    for (int k = 0; k < phrase[j].length(); k++) {
                        char ch = phrase[j].charAt(k);
                        char lower = Character.toLowerCase(ch);
                        if (!used.contains(lower)) {
                            used.add(lower);
                            phrase[j] = phrase[j].substring(0, k) + "[" + ch + "]" + phrase[j].substring(k + 1);
                            break outer;
                        }
                    }
                }
            }
            for (int j = 0; j < phrase.length; j++) {
                result.append(phrase[j]);
                if (j != phrase.length - 1) {
                    result.append(" ");
                }
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}
