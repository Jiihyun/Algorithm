import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int length = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            String[] split = br.readLine().split(" ");
            String command = split[0];
            int num = -1;
            if (split.length > 1) {
                num = Integer.parseInt(split[1]);
            }
            if (command.equals("add")) {
                set.add(num);
            } else if (command.equals("remove")) {
                set.remove(num);
            } else if (command.equals("check")) {
                if (set.contains(num)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (command.equals("toggle")) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (command.equals("all")) {
                set = new HashSet<>();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (command.equals("empty")) {
                set.clear();
            }
        }
        System.out.print(sb);
    }
}
