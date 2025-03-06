import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        double[] arr = new double[L];
        int pow = 0;

        for (int i = 0; i < str.length(); i++) {
            int num = (str.charAt(i) - 'a') + 1;
            arr[i] = num * Math.pow(31, pow);
            pow += 1;
        }
        int sum = 0;
        for (int i = 0; i < L; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
