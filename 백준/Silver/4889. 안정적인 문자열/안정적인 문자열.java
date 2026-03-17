import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 1;
        while (true) {
            String data = br.readLine();
            if (data.contains("-")) {
                break;
            }
            Deque<Character> stack = new ArrayDeque<>();
            int count = 0;
            for (char c : data.toCharArray()) {
                if (c == '{') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        count++;
                        stack.push('{');
                    }
                }
            }
            count += stack.size() / 2;
            System.out.println(caseNum + ". " + count);
            caseNum++;
        }
    }
}
