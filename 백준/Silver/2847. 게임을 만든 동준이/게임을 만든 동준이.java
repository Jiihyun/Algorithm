import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = size - 2; i >= 0; i--) {
            if (arr[i + 1] <= arr[i]) {
                count += arr[i] - (arr[i + 1] - 1);
                arr[i] = arr[i + 1] - 1;
            }
        }
        System.out.println(count);
    }
}
