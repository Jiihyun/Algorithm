import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        char[] arr = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isOpen = false;

        for (char ch : arr) {
            if (ch == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isOpen = true;
                sb.append(ch);
            } else if (isOpen) {
                sb.append(ch);
                if (ch == '>') {
                    isOpen = false;
                }
            } else if (ch == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
            } else {
                stack.add(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}

