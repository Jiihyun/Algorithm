import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] oilPrice = new int[n];
        for (int i = 0; i < n; i++) {
            oilPrice[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = oilPrice[0];
        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            minPrice = Math.min(minPrice, oilPrice[i]);
            answer += (long) minPrice * distance[i];
        }
        System.out.println(answer);
    }
}
