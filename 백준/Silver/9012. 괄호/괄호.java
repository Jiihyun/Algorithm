import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            if (isEven(br)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isEven(final BufferedReader br) throws IOException {
        Stack<Character> st = new Stack<>();
        String line = br.readLine();
        for (int j = 0; j < line.length(); j++) {
            if (line.charAt(j) == '(') {
                st.push(line.charAt(j));
            } else if (line.charAt(j) == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
