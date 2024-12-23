import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] my;
    public static int[] min;
    public static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sLength = Integer.parseInt(st.nextToken());
        int pLength = Integer.parseInt(st.nextToken());
        int result = 0;
        check = 0;
        char[] inputPw = br.readLine().toCharArray();
        min = new int[4];
        my = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
            if (min[i] == 0) {
                check++;
            }
        }
        for (int i = 0; i < pLength; i++) {
            add(inputPw[i]);
        }
        if (check == 4) {
            result++;
        }
        for (int i = pLength; i < sLength; i++) {
            int j = i - pLength;
            add(inputPw[i]);
            remove(inputPw[j]);
            if (check == 4) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void add(char ch) {
        switch (ch) {
            case 'A':
                my[0]++;
                if (my[0] == min[0]) {
                    check++;
                }
                break;
            case 'C':
                my[1]++;
                if (my[1] == min[1]) {
                    check++;
                }
                break;

            case 'G':
                my[2]++;
                if (my[2] == min[2]) {
                    check++;
                }
                break;

            case 'T':
                my[3]++;
                if (my[3] == min[3]) {
                    check++;
                }
                break;
        }
    }

    private static void remove(char ch) {
        switch (ch) {
            case 'A':
                if (my[0] == min[0]) {
                    check--;
                }
                my[0]--;
                break;
            case 'C':
                if (my[1] == min[1]) {
                    check--;
                }
                my[1]--;
                break;

            case 'G':
                if (my[2] == min[2]) {
                    check--;
                }
                my[2]--;
                break;

            case 'T':
                if (my[3] == min[3]) {
                    check--;
                }
                my[3]--;
                break;
        }
    }
}
