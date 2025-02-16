import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (65 <= word.charAt(i) && word.charAt(i) <= 90) {
                arr[word.charAt(i) - 65]++;
            }
            if (97 <= word.charAt(i) && word.charAt(i) <= 122) {
                arr[word.charAt(i) - 97]++;
            }
        }
        int max = 0;
        char ch = '?';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 'A');
            } else if (arr[i] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
