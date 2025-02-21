import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        while (true) {
            String read = br.readLine();
            if (read.equals("0")) {
                break;
            }
            list.add(read);
        }
        String[] answer = new String[list.size()];
        for (int l = 0; l < list.size(); l++) {
            char[] arr = list.get(l).toCharArray();
            int half = arr.length / 2;
            answer[l] = "yes";
            for (int i = 0; i < half; i++) {
                if (arr[i] != (arr[arr.length - 1 - i])) {
                    answer[l] = "no";
                    break;
                }
            }
        }
            for (int i = 0; i < answer.length; i++) {
                System.out.println(answer[i]);
            }
        
    }
}
