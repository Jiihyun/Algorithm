import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word.substring(i))) {
                answer = word.length() + i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean isPalindrome(String substring) {
        int left = 0;
        int right = substring.length() - 1;

        while (left < right) {
            if (substring.charAt(left) != substring.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
