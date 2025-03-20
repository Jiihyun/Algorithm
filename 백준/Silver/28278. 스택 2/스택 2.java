import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.startsWith("1")) {
                stack.add(command.split(" ")[1]);
            } else if (command.equals("2")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (command.equals("3")) {
                System.out.println(stack.size());
            } else if (command.equals("4")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("5")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
