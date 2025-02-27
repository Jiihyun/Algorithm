import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            sb.append(getAnswer(line)).append("\n");
        }
        System.out.println(sb);
    }

    private static String getAnswer(final String line) {
        char[] charArr = line.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(' || charArr[i] == '[') {
                stack.push(charArr[i]);
            } else if (charArr[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }
                stack.pop();
            } else if (charArr[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return "no";
        }
        return "yes";
    }
}
