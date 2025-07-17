import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < line.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == line.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(line.charAt(j));
                }
            }
            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
