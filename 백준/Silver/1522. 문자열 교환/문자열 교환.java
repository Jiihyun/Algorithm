import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }

        String doubled = str + str;
        int min = count;

        for (int i = 0; i < str.length(); i++) {
            int bCount = 0;
            for (int j = i; j < i + count; j++) {
                if (doubled.charAt(j) == 'b') {
                    bCount++;
                }
            }
            min = Math.min(min, bCount);
        }
        System.out.println(min);
    }
}
