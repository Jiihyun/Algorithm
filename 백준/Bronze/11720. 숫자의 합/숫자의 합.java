import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();

        int sum = 0;
        for (String num : sNum.split("")) {
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);
    }
}