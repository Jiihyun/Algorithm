import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Integer[] arrA = new Integer[length];
        Integer[] arrB = new Integer[length];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB, Comparator.reverseOrder());

        int sum = 0;
         for (int i = 0; i < length; i++) {
             sum += (arrA[i] * arrB[i]);
        }
        System.out.println(sum);
    }
}
