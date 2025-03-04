import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<String> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                q.add(command.split(" ")[1]);
            }
            if (command.equals("pop")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.poll());
                }
            }
            if (command.equals("size")) {
                System.out.println(q.size());
            }
            if (command.equals("empty")) {
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            if (command.equals("front")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.getFirst());
                }
            }
            if (command.equals("back")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.getLast());
                }
            }
        }

    }
}
