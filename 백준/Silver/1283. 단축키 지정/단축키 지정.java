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
            String[] words = br.readLine().split(" ");
            boolean assigned = false;

            for (int j = 0; j < words.length; j++) {
                char firstChar = words[j].charAt(0);
                char lower = Character.toLowerCase(firstChar);
                if (!used.contains(lower)) {
                    used.add(lower);
                    words[j] = "[" + firstChar + "]" + words[j].substring(1);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                outer:
                for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char c = words[j].charAt(k);
                        char lower = Character.toLowerCase(c);
                        if (!used.contains(lower)) {
                            used.add(lower);
                            words[j] = words[j].substring(0, k) + "[" + c + "]" + words[j].substring(k + 1);
                            assigned = true;
                            break outer;
                        }
                    }
                }
            }

            for (int j = 0; j < words.length; j++) {
                result.append(words[j]);
                if (j != words.length - 1) {
                    result.append(" ");
                }
            }
            result.append("\n");
        }

        System.out.print(result);
    }
}
