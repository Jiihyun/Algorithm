import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean isOpen = false;
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        String sentence = br.readLine();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (ch == '<') {
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
                queue.add(ch);
                isOpen = true;
            } else if (isOpen) {
                queue.add(ch);
                if (ch == '>') {
                    isOpen = false;
                }
            } else if (ch == ' ') {
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
                queue.add(' ');
            } else {
                stack.add(ch);
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        System.out.println(sb);
    }
}
