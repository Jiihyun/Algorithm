import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ASize = Integer.parseInt(st.nextToken());
        int BSize = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ASize; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> B = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < BSize; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        int commonCount = 0;
        for (Integer num : A) {
            if (B.contains(num)) {
                commonCount++;
            }
        }
        System.out.println((A.size() - commonCount) + (B.size() - commonCount));
    }
}
