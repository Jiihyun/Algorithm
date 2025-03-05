import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int targetPaperPosition = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                int importance = Integer.parseInt(st.nextToken());
                q.add(new int[]{j, importance});
            }
            int count = 0;
            while (true) {
                int[] qForCompare = q.poll();
                boolean isImportant = true;

                for (int[] nowQ : q) {
                    if (nowQ[1] > qForCompare[1]) {
                        isImportant = false;
                        break;
                    }
                }
                if (isImportant) {
                    count++;
                    if (qForCompare[0] == targetPaperPosition) {
                        break;
                    }
                } else {
                    q.add(qForCompare);
                }
            }
            System.out.println(count);
        }
    }
}
