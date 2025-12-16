import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String password = br.readLine();
            if (password.equals("end")) {
                break;
            }
            if (isAcceptable(password)) {
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }

    }

    public static boolean isAcceptable(String password) {
        List<Character> moList = List.of('a', 'e', 'i', 'o', 'u');
        if (!password.contains("a") && !password.contains("e") && !password.contains("i") &&
                !password.contains("o") && !password.contains("u")) {
            return false;
        }
        for (int i = 0; i < password.length() - 2; i++) {
            if ((moList.contains(password.charAt(i)) && moList.contains(password.charAt(i + 1)) && moList.contains(password.charAt(i + 2)))
                    || (!moList.contains(password.charAt(i)) && !moList.contains(password.charAt(i + 1)) && !moList.contains(password.charAt(i + 2)))) {
                return false;
            }
        }
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)
                    && password.charAt(i) != 'e'
                    && password.charAt(i) != 'o') {
                return false;
            }
        }
        return true;
    }
}
