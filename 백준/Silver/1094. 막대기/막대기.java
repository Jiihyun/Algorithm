import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int stick = 64;
        int count = 0;
        while (length > 0) {
            if (stick > length) {
                stick /= 2;
            } else {
                length -= stick;
                count++;
            }
        }
        System.out.println(count);
    }
}
