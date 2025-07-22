import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            times[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // times 종료시간순 정렬
        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]); // 종료시간 같으면 시작시간 빠른 순
            }
            return Integer.compare(o1[1], o2[1]);
        });


        int count = 0;
        int endTime = 0;
        for (int i = 0; i < n; i++) {
            if (endTime <= times[i][0]) {
                endTime = times[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
