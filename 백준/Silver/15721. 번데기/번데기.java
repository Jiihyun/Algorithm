import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ppl = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        String mark = Integer.parseInt(br.readLine()) == 0 ? "뻔" : "데기";

        int cnt = 0;
        int person = 0;
        int repetition = 1;

        while (true) {
            for (int i = 0; i < 4; i++) {
                boolean isBbun = (i % 2 == 0);
                if (mark.equals(isBbun ? "뻔" : "데기") && ++cnt == t) {
                    System.out.println(person);
                    return;
                }
                person = (person + 1) % ppl;
            }
            for (int i = 0; i <= repetition; i++) {
                if (mark.equals("뻔") && ++cnt == t) {
                    System.out.println(person);
                    return;
                }
                person = (person + 1) % ppl;
            }
            for (int i = 0; i <= repetition; i++) {
                if (mark.equals("데기") && ++cnt == t) {
                    System.out.println(person);
                    return;
                }
                person = (person + 1) % ppl;
            }
            repetition++;
        }
    }
}
