import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int length = 0;
        int start = 1;
        int digit = 1;
        while (start <= num) {
            int end = Math.min(num, start * 10 - 1);
            length += (end - start + 1) * digit;
            start *= 10;
            digit++;
        }
        System.out.println(length);
    }
}
