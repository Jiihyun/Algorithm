import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int condition = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            Iterator<Integer> iterator = list.iterator();
            Integer min = list.get(0);
            while (iterator.hasNext()) {
                Integer i = iterator.next();
                if (canRemove(i, min)) {
                    condition--;
                    iterator.remove();
                    if (condition == 0) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }

    private static boolean canRemove(final Integer num, final Integer min) {
        if (num % min == 0) {
            return true;
        }
        return false;
    }
}
