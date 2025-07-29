import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) {
                minus.add(num); // 음수 끼리 곱해서 양수 만들거나, 0과 곱해 0 만들어주기
            } else if (num == 1) {
                sum += 1; // 1은 다른 수와 곱하면 여전히 1이기 때문에, 바로 더해주기
            } else {
                plus.add(num);
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        for (int i = 0; i < plus.size(); i += 2) {
            if (i + 1 >= plus.size()) {
                sum += plus.get(i);
            } else {
                sum += plus.get(i) * plus.get(i + 1);
            }
        }

        for (int i = 0; i < minus.size(); i += 2) {
            if (i + 1 >= minus.size()) {
                sum += minus.get(i);
            } else {
                sum += minus.get(i) * minus.get(i + 1);
            }
        }
        System.out.println(sum);
    }
}
