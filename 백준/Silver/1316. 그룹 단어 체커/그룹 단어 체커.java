import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] arr = new String[count];

        int answer = 0;
        for (int i = 0; i < count; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < count; i++) {
            boolean[] collector = new boolean[26];
            if (isInARow(collector, arr[i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isInARow(final boolean[] collector, final String arr) {
        char compareCh = arr.charAt(0);
        collector[compareCh - 'a'] = true;

        for (int j = 1; j < arr.length(); j++) {
            char ch = arr.charAt(j);
            if (ch != compareCh) {
                if (collector[ch - 'a']) {
                    return false;
                }
                collector[ch - 'a'] = true;
                compareCh = ch;
            }
        }
        return true;
    }
}
