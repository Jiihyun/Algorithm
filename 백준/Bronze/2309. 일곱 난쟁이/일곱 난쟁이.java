import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> heights = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            heights.add(Integer.parseInt(br.readLine()));
            sum += heights.get(i);
        }
        Collections.sort(heights);
        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                Integer h1 = heights.get(i);
                Integer h2 = heights.get(j);
                if (sum - h1 - h2 == 100) {
                    heights.remove(h1);
                    heights.remove(h2);
                    break outer;
                }
            }
        }
        for (int h : heights) {
            System.out.println(h);
        }
    }
}
