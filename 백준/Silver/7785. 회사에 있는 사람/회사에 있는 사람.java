import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            String[] split = br.readLine().split(" ");
            String name = split[0];
            String record = split[1];
            if (record.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());
        for (String name : list) {
            System.out.println(name);
        }
    }
}
