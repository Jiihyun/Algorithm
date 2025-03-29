import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int neededString = Integer.parseInt(st.nextToken());
        int brand = Integer.parseInt(st.nextToken());

        int[] set = new int[brand];
        int[] nonSet = new int[brand];
        int minOfSet = 1000;
        int minOfNonSet = 1000;

        for (int i = 0; i < brand; i++) {
            st = new StringTokenizer(br.readLine());
            set[i] = Integer.parseInt(st.nextToken());
            if (set[i] < minOfSet) {
                minOfSet = set[i];
            }
            nonSet[i] = Integer.parseInt(st.nextToken());
            if (nonSet[i] < minOfNonSet) {
                minOfNonSet = nonSet[i];
            }
        }

        if (neededString <= 6) {
            System.out.println(Math.min(minOfSet, minOfNonSet * neededString));
        } else {
            int applySet = neededString / 6;
            int applyNonSet = neededString % 6;
            int mix = applySet * minOfSet + applyNonSet * minOfNonSet;
            int onlySet = (neededString / 6 + 1) * minOfSet;
            int onlyNonSet = neededString * minOfNonSet;

            System.out.println(Math.min(onlyNonSet, Math.min(onlySet, mix)));
        }
    }
}
