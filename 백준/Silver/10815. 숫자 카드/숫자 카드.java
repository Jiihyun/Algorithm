import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countOfMine = Integer.parseInt(br.readLine());
        HashSet<Integer> mineSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countOfMine; i++) {
            mineSet.add(Integer.parseInt(st.nextToken()));
        }
        int countOfSystem = Integer.parseInt(br.readLine());
        int[] arrOfSystem = new int[countOfSystem];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countOfSystem; i++) {
            arrOfSystem[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < countOfSystem; i++) {
            if (mineSet.contains(arrOfSystem[i])) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
