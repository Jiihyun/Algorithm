import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int zeroCount = 0;
        int oneCount = 0;
        if (word.charAt(0) == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) != word.charAt(i + 1)) {
                if (word.charAt(i) == '1') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }
        System.out.println(Math.min(zeroCount, oneCount));
    }
}
