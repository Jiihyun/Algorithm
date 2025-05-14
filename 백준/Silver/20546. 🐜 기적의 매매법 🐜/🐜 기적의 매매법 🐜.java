import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] chart = new int[14];
        for (int i = 0; i < chart.length; i++) {
            chart[i] = Integer.parseInt(st.nextToken());
        }

        int jAsset = bnp(chart, money);
        int sAsset = timing(chart, money);

        if (jAsset > sAsset) {
            System.out.println("BNP");
        } else if (jAsset < sAsset) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int bnp(int[] chart, int money) {
        int count = 0;
        for (int price : chart) {
            if (money >= price) {
                int buyCount = money / price;
                count += buyCount;
                money -= buyCount * price;
            }
        }
        return money + count * chart[chart.length - 1];
    }

    private static int timing(int[] chart, int money) {
        int count = 0;

        int increasement = 0;
        int decreasement = 0;

        for (int i = 0; i < chart.length - 1; i++) {
            if (chart[i + 1] > chart[i]) {
                decreasement = 0;
                increasement++;
                if (increasement >= 3) {
                    money += count * chart[i + 1];
                    count = 0;
                    increasement = 0;
                }
            } else if (chart[i + 1] < chart[i]) {
                decreasement++;
                increasement = 0;
                if (decreasement >= 3) {
                    int buyCount = money / chart[i + 1];
                    count += buyCount;
                    money -= buyCount * chart[i + 1];
                    decreasement = 0;
                }
            } else {
                increasement = 0;
                decreasement = 0;
            }
        }
        return money + count * chart[chart.length - 1];
    }
}
