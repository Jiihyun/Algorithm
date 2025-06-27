import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int missingIndex = -1;
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '*') {
                missingIndex = i;
            } else {
                if (i % 2 == 0) {
                    sum += ch - '0';
                } else {
                    sum += 3 * (ch - '0');
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if (missingIndex % 2 == 0) {
                if ((sum + i) % 10 == 0) {
                    System.out.println(i);
                    return;
                }
            } else {
                if ((sum + 3 * i) % 10 == 0) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}

