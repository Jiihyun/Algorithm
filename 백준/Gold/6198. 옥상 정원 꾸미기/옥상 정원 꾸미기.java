import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        Deque<Integer> buildings = new ArrayDeque<>();
        for (int i : arr) {
            while (!buildings.isEmpty() && buildings.peek() <= i) {
                buildings.pop();
            }
            answer += buildings.size();
            buildings.push(i);
        }
        System.out.println(answer);
    }
}
