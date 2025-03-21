import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long now = 0;
        long sum = 0;
        while (sum < num) {
            if (sum + now + 1 <= num) {
                sum += (now + 1);
                now += 1;
            } else {
                break;
            }
        }
        System.out.println(now);
    }
}
