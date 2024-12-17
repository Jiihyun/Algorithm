import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();

        double sum = Arrays.stream(arr)
                .mapToDouble(val -> (double) val / max * 100.0)
                .sum();
        System.out.println(sum / N);
    }
}
