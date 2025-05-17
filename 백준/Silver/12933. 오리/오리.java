import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        char[] duck = {'q', 'u', 'a', 'c', 'k'};

        if (chars.length % 5 != 0) {
            System.out.println(-1);
            return;
        }
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'x') {
                continue;
            }
            int index = 0;
            List<Character> list = new ArrayList<>();

            for (int j = i; j < chars.length; j++) {
                if (chars[j] == duck[index]) {
                    index++;
                    list.add(chars[j]);
                    chars[j] = 'x';

                    if (index == 5) {
                        index = 0;
                    }
                }
            }
            if (list.isEmpty() || list.get(list.size() - 1) != 'k') {
                System.out.println(-1);
                return;
            }
            count++;
        }
        System.out.println(count);
    }
}

