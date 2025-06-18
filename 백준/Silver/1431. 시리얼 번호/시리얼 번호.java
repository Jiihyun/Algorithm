import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        list.sort((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            int aNum = 0;
            int bNum = 0;
            for (int i = 0; i < a.length(); i++) {
                int a1 = a.charAt(i) - '0';
                int b1 = b.charAt(i) - '0';
                if (a1 >= 0 && a1 < 10) {
                    aNum += a1;
                }
                if (b1 >= 0 && b1 < 10) {
                    bNum += b1;
                }
            }
            if (aNum == bNum) {
                return a.compareToIgnoreCase(b);
            }
            return aNum - bNum;
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}

