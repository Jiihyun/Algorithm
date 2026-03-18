import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int pivot = -1;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] < chars[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            System.out.println(0);
            return;
        }
        for (int j = chars.length - 1; j > pivot; j--) {
            if (chars[j] > chars[pivot]) {
                char temp = chars[pivot];
                chars[pivot] = chars[j];
                chars[j] = temp;
                break;
            }
        }
        int left = pivot + 1;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        System.out.println(new String(chars));
    }
}
