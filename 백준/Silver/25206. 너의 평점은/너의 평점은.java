import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double sum1 = 0;
        for (int i = 0; i < 20; i++) {
            String[] arr = br.readLine().split(" ");
            double avgScore = Double.parseDouble(arr[1]);
            String grade = arr[2];
            if (!"P".equals(grade)) {
                double score = getScore(grade);
                sum1 += score * avgScore;
                sum += avgScore;
            }
        }
        System.out.println(sum1 / sum);

    }

    private static double getScore(final String input) {
        switch (input) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0.0;
        }
    }
}
