import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (chars[i - 1] == '(') {
                    count += stack.size();
                } else {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
