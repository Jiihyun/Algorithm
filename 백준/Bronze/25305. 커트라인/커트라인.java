import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ppl = sc.nextInt();
        Integer[] scores = new Integer[ppl];
        int cutline = sc.nextInt();
        for (int i = 0; i < ppl; i++) {
            scores[i] = sc.nextInt();
        }
        Arrays.sort(scores, Collections.reverseOrder());
        System.out.println(scores[cutline-1]);
    }
}
