import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int totalSum = sc.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for (int s = 0; s < length - 1; s++) {
            for (int e = s+1; e < length; e++) {
                if (nums[s] + nums[e] == totalSum) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}