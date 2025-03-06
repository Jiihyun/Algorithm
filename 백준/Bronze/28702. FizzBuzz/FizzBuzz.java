import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        boolean passNumber = false;
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            if (!line.startsWith("F") && !line.startsWith("B")) {
                num = Integer.parseInt(line);
                passNumber = true;
            }
            if (passNumber) {
                num++;
            }
        }
        if (num % 3 == 0) {
            if (num % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }
}
