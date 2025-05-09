import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();
        int expected = 1;

        while (!queue.isEmpty() || !stack.isEmpty()) {
            if (!queue.isEmpty() && queue.peek() == expected) {
                queue.poll();
                expected++;
            } else if (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            } else if (!queue.isEmpty()) {
                stack.push(queue.poll());
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
