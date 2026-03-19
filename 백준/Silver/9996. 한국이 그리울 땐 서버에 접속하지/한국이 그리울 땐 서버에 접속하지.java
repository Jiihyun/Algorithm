import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] parts = pattern.split("\\*");

        String prefix = parts[0];
        String suffix = parts[1];

        for (int i = 0; i < n; i++) {
            String file = br.readLine();

            if (file.length() < prefix.length() + suffix.length()) {
                System.out.println("NE");
                continue;
            }

            if (file.startsWith(prefix) && file.endsWith(suffix)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}