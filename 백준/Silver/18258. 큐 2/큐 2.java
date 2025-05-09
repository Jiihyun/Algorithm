import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < size; i++) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                String[] split = command.split(" ");
                int num = Integer.parseInt(split[1]);
                q.add(num);
                last = num;
            } else if (command.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (command.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            } else {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(last).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
