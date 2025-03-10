import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int length = Integer.parseInt(br.readLine());
        int set = 0;
        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add": {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    set |= (1 << num);
                    break;
                }
                case "remove": {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    set &= ~(1 << num);
                    break;
                }
                case "check": {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    if ((set & (1 << num)) != 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                }
                case "toggle": {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    set ^= (1 << num);
                    break;
                }
                case "all":
                    set = (1 << 20) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
