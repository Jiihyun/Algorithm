import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int wordSize = Integer.parseInt(st.nextToken());
        int randomWordSize = Integer.parseInt(st.nextToken());
        Set<String> words = new HashSet<>();
        for (int i = 0; i < wordSize; i++) {
            words.add(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < randomWordSize; i++) {
            if (words.contains(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
