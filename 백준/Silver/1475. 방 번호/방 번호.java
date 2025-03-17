import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] arr = new int[10]; // 0 ~ 9
        for (int i = 0; i < input.length(); i++) {
            int num = Integer.parseInt(input.split("")[i]);
            arr[num]++;
        }
        int sixNineCount = arr[6] + arr[9];
        arr[6] = (sixNineCount + 1) / 2;
        arr[9] = 0;
        int set = 0;
        for (int i : arr) {
            set = Math.max(set, i);
        }
        System.out.println(set);
    }
}
