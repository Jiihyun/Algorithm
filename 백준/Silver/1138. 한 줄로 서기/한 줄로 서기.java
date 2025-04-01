import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ppl = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[ppl];
        for (int i = 0; i < ppl; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[ppl];
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = arr[i];
            int num = ppl--;
            for (int j = arr.length - 1; j > pos; j--) {
                answer[j] = answer[j - 1];
            }
            answer[pos] = num;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
