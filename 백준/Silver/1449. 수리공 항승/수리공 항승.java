import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fixCount = Integer.parseInt(st.nextToken());
        int lengthOfTape = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[fixCount];
        for (int i = 0; i < fixCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int range = (int) (arr[0] - 0.5 + lengthOfTape);
        int neededTape = 1;

        for (int i = 1; i < fixCount; i++) {
            if (range < (int) (arr[i] + 0.5)) {
                range = (int) (arr[i] - 0.5 + lengthOfTape);
                neededTape++;
            }
        }
        System.out.println(neededTape);
    }
}
