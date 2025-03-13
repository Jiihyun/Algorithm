import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int limit = 10000;
        Set<Integer> nonSelfNums = new HashSet<>();

        for (int i = 0; i <= limit; i++) {
            int num = getSum(i);
            if (num <= limit) {
                nonSelfNums.add(num);
            }
        }
        for (int i = 0; i <= limit; i++) {
            if (!nonSelfNums.contains(i)) {
                System.out.println(i);
            }
        }
    }

    private static int getSum(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
