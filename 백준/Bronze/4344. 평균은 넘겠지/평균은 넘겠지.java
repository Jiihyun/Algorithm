import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            double sum = 0;
            int count = Integer.parseInt(st.nextToken());
            int[] scores = new int[count];
            for (int j = 0; j < count; j++) {
                int score = Integer.parseInt(st.nextToken());
                sum += score;
                scores[j] = score;
            }
            double avg = sum / count;
            double ppl = 0;
            for (int j = 0; j < count; j++) {
                if (scores[j] > avg) {
                    ppl++;
                }
            }
            double num = ppl / count * 100;
            System.out.println(Math.round(num * 1000) / 1000.0 + "%");
        }
    }
}
