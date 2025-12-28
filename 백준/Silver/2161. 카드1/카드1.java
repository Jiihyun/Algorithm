import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        List<Integer> list = new ArrayList<>();

        while (q.size() > 1) {
            list.add(q.poll());
            q.add(q.poll());
        }
        list.add(q.poll());
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }
}
