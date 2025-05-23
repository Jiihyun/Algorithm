import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'E' && chars[i + 1] == 'W') {
                count++;
            }
        }
        System.out.println(count);
    }
}
