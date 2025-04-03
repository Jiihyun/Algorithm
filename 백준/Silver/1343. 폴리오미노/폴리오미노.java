import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        while (word.contains("XXXX")) {
            word = word.replace("XXXX", "AAAA");
        }

        while (word.contains("XX")) {
            word = word.replace("XX", "BB");
        }

        if (word.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(word);
        }
    }
}
