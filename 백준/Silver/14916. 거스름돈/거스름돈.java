import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        while (true) {
            if (n % 5 == 0) {
                sum += n / 5;
                System.out.println(sum);
                break;
            } else {
                n -= 2;
                sum++;
            }
            if (n < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
