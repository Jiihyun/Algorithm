import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> names = new HashSet<>();
        names.add("ChongChong");

        for (int i = 0; i < n; i++) {
            String[] list = br.readLine().split(" ");
            String name1 = list[0];
            String name2 = list[1];
            if (names.contains(name1) || names.contains(name2)) {
                names.add(name1);
                names.add(name2);
            }
        }
        System.out.println(names.size());
    }
}
