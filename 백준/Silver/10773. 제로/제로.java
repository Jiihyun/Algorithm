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
            String num = br.readLine();
            if (num.equals("0")) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            count += Integer.parseInt(stack.pop());
        }
        System.out.println(count);
    }
}
