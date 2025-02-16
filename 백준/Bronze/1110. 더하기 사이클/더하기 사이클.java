import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int copy = number;
        int cycle = 0;

        while (true) {
            copy = (copy % 10) * 10 + (copy / 10 + copy % 10) % 10;
            if (number == copy) {
                cycle++;
                break;
            }
            cycle++;
        }
        System.out.println(cycle);
    }
}
