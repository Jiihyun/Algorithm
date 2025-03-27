import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int count = 0;
        Set<String> names = new HashSet<>();
        for (int i = 0; i < size; i++) {
            String name = br.readLine();
            if (name.equals("ENTER")) {
                count += names.size();
                names.clear();
            } else {
                names.add(name);
                if (i == size - 1) {
                    count += names.size();
                }
            }
        }
        System.out.println(count);
    }
}
