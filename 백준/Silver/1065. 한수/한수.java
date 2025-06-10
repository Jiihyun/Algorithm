import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        if (n < 100) {
            System.out.println(n);
        } else {
            count = 99;
            for (int i = 100; i <= n; i++) {
                int first = i/ 100;
                int second = (i/ 10) % 10;
                int third = i% 10;
                if ((first - second) == (second - third)) {
                    count++;
                }
            }
        System.out.println(count);
    }
}
}