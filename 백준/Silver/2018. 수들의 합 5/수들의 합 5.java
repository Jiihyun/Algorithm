import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        while (endIndex != input) {
            if (sum == input) {
                count++;
                endIndex++;
                sum += endIndex;
            } else if (sum > input) {
                sum -= startIndex;
                startIndex++;
            } else if (sum < input) {
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.println(count);
    }
}

