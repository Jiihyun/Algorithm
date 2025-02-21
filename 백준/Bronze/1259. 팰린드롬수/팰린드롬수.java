import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String read = br.readLine();
            boolean answer = true;

            if (read.equals("0")) {
                break;
            }
            for (int i = 0; i < read.length() / 2; i++) {
                if (read.charAt(i) != read.charAt(read.length() - 1 - i)) {
                    answer = false;
                    break;
                }
            }
            if (answer) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
