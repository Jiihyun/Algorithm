import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            String command = commands[i];
            if (command.equals("pop")) {
                if (st.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(st.pop());
                }
            } else if ((command.equals("size"))) {
                System.out.println(st.size());
            } else if (command.equals("empty")) {
                if (st.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("top")) {
                if (st.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(st.peek());
                }
            } else {
                String[] split = command.split(" ");
                int num = Integer.parseInt(split[1]);
                st.push(num);
            }
        }
    }
}
