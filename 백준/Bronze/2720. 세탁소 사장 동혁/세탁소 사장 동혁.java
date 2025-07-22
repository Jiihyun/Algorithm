import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            int change = Integer.parseInt(br.readLine());
            int q = change / 25;
            sb.append(q).append(" ");
            int d = change % 25 / 10;
            sb.append(d).append(" ");
            int n = change % 25 % 10 / 5;
            sb.append(n).append(" ");
            int p = change % 25 % 10 % 5;
            sb.append(p).append("\n");
        }
        System.out.println(sb);
    }
}
