import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        double sum = 0;

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int count = 0;
        int max = -1;

        int mod = arr[0];
        boolean check = false;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count = 0;
            }
            if (max < count) {
                max = count;
                mod = arr[i];
                check = true;
            } else if (max == count && check) {
                mod = arr[i];
                check = false;
            }
        }
        System.out.println(Math.round(sum / length));
        System.out.println(arr[arr.length / 2]);
        System.out.println(mod);
        System.out.println(arr[length - 1] - arr[0]);

    }
}
