import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        int c = 0;
        if (n >= 300) {
            a += n / 300;
            n = n % 300;
            b += n / 60;
            n = n % 60;
            c += n / 10;
            if (n % 10 != 0) {
                System.out.println(-1);
                return;
            }
        } else if (n >= 60) {
            b += n / 60;
            n = n % 60;
            c += n / 10;
            if (n % 10 != 0) {
                System.out.println(-1);
                return;
            }
        } else {
            c += n / 10;
            if (n % 10 != 0) {
                System.out.println(-1);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" ").append(b).append(" ").append(c);
        System.out.println(sb);
    }
}
