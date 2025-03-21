import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int expense = Integer.parseInt(br.readLine());
        int change = 1000 - expense;
        int[] coins = new int[]{500, 100, 50, 10, 5, 1};

        int count = 0;
        for (int coin : coins) {
            if (change > 0) {
                int temp = change / coin;
                count += temp;
                change -= (coin * temp);
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
