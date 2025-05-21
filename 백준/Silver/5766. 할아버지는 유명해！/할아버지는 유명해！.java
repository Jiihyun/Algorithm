import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] score;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (x == 0 && y == 0) {
                break;
            }
            score = new int[10001];
            int first = 0;
            int second = 0;

            for (int i = 0; i < y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    int index = Integer.parseInt(st.nextToken());
                    score[index] += 1;
                }
            }
            for (int i = 0; i < score.length; i++) {
                first = Math.max(first, score[i]);
            }
            for (int i = 0; i < score.length; i++) {
                if (score[i] != first) {
                    second = Math.max(second, score[i]);
                }
            }
            for (int i = 0; i < score.length; i++) {
                if (score[i] == second) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
