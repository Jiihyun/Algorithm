import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lengthOfNums = sc.nextInt();
        int count = sc.nextInt();
        int[] nums = new int[lengthOfNums];
        int[] sum = new int[lengthOfNums];
        for (int i = 0; i < lengthOfNums; i++) {
            nums[i] = sc.nextInt();
            if (i == 0) {
                sum[i] = nums[0];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        for (int i = 0; i < count; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (start < 2) {
                System.out.println(sum[end - 1]);
            } else {
                System.out.println(sum[end - 1] - sum[start - 2]);
            }
        }
    }
}