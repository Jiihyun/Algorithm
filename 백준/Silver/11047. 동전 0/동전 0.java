import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            value[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (value[i] <= K) {
                count += K / value[i];
                K = K % value[i];
            }
        }
        System.out.println(count);
    }
}
