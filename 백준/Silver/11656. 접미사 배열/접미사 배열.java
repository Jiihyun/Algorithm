import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int len = line.length();
        String[] arr = new String[len];

        for(int i = 0; i < len; i++) {
            arr[i] = line.substring(i, len);
        }

        Arrays.sort(arr);

        for (String str : arr) {
            System.out.println(str);
        }
    }
}