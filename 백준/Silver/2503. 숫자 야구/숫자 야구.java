import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] questions = new String[size];
        int[] strikes = new int[size];
        int[] balls = new int[size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            questions[i] = st.nextToken();
            strikes[i] = Integer.parseInt(st.nextToken());
            balls[i] = Integer.parseInt(st.nextToken());
        }

        List<String> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (j == k || i == k) {
                        continue;
                    }
                    nums.add("" + i + j + k);
                }
            }
        }
        for (String num : new ArrayList<>(nums)) {
            boolean isValid = true;

            for (int i = 0; i < size; i++) {
                int[] result = calculate(num, questions[i]);
                if (result[0] != strikes[i] || result[1] != balls[i]) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                nums.remove(num);
            }
        }
        System.out.println(nums.size());
    }

    private static int[] calculate(String randomNum, String question) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNum.charAt(i) == question.charAt(i)) {
                strike++;
            } else if (question.contains(String.valueOf(randomNum.charAt(i)))) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }
}

