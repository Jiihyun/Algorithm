import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            String command = br.readLine();
            if (command.startsWith("1")) {
                dq.addFirst(Integer.parseInt(command.split(" ")[1]));
            }
            if (command.startsWith("2")) {
                dq.addLast(Integer.parseInt(command.split(" ")[1]));
            }
            if (command.equals("3")) {
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dq.pollFirst()).append("\n");
                }
            }
            if (command.equals("4")) {
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dq.pollLast()).append("\n");
                }
            }
            if (command.equals("5")) {
                sb.append(dq.size()).append("\n");
            }
            if (command.equals("6")) {
                if (dq.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            if (command.equals("7")) {
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dq.peekFirst()).append("\n");
                }
            }
            if (command.equals("8")) {
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dq.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
