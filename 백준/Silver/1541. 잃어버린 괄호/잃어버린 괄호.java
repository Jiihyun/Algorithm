import java.util.Scanner;

public class Main {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] minusSplit = example.split("-");
        for (int i = 0; i < minusSplit.length; i++) {
            int totalPlus = getSum(minusSplit[i]);
            if (i == 0) {
                answer += totalPlus;
            } else {
                answer -= totalPlus;
            }
        }
        System.out.println(answer);
    }

    private static int getSum(final String minusSplit) {
        int sum = 0;
        String[] plusSplit = minusSplit.split("[+]");
        for (int j = 0; j < plusSplit.length; j++) {
            sum += Integer.parseInt(plusSplit[j]);
        }
        return sum;
    }
}
