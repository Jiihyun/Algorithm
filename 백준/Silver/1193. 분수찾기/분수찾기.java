import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        int crossCount = 1;
        int sumOfNumCount = 0;

        while (true) {
            if (inputNum <= sumOfNumCount + crossCount) {
                if (crossCount % 2 == 1) {
                    System.out.println((crossCount - (inputNum - sumOfNumCount - 1)) + "/" + (inputNum - sumOfNumCount));
                    break;
                } else {
                    System.out.println((inputNum - sumOfNumCount) + "/" + (crossCount - (inputNum - sumOfNumCount - 1)));
                    break;
                }
            } else {
                sumOfNumCount += crossCount;
                crossCount++;
            }
        }

    }
}
