import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long result = 0;
        long pow = 1;
        final int MOD = 1234567891;

        for (int i = 0; i < str.length(); i++) {
            int num = (str.charAt(i) - 'a') + 1; 
            result = (result + (num * pow) % MOD) % MOD; 
            pow = (pow * 31) % MOD; 
        }

        System.out.println(result);
    }
}
