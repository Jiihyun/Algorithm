import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                Integer polled = queue.poll();
                queue.add(polled);
            }
            Integer polled = queue.poll();
            list.add(polled);
        }

        String collect = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("<" + collect + ">");
    }
}
