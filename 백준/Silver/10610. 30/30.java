import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] arr = line.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }
        if (sum % 3 == 0 && arr[0] == '0') {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

    }
}
