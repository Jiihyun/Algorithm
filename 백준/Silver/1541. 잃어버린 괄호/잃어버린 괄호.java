import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] minusSplit = example.split("-");
        int totalPlus = 0;
        for (int i = 1; i < minusSplit.length; i++) {
            totalPlus += getSum(minusSplit[i]);
        }
        if (minusSplit.length == 1) {
            System.out.println(getSum(minusSplit[0]));
        } else {
            System.out.println(getSum(minusSplit[0]) - totalPlus);
        }
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
