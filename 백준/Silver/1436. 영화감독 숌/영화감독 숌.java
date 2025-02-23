import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int condition = 666;
        int count = 1;
        while (count != N) {
            condition++;
            if (String.valueOf(condition).contains("666")) {
                count++;
            }
        }
        System.out.println(condition);
    }
}
