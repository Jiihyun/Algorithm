import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        for (int i = Math.max(1, n - 54); i < n; i++) {
            int sum = i; 
            int temp = i;
            
            while (temp > 0) {
                sum += temp % 10; 
                temp /= 10;
            }
            
            if (sum == n) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
    }
}
