import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int power = 1;
            for (int j = line.length() - 1; j >= 0; j--) {
                char alphabet = line.charAt(j);
                arr[alphabet - 'A'] += power;
                power *= 10;
            }
        }
        Arrays.sort(arr);

        int num = 9;
        int turn = 25;
        int sum = 0;
        while (arr[turn] > 0) {
            sum += arr[turn] * num;
            turn--;
            num--;
        }
        System.out.println(sum);
    }
}
