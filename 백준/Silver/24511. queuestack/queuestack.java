import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] queueOrStack = new int[N];
        int[] orgValues = new int[N];

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queueOrStack[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            orgValues[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] changeValues = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            changeValues[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (queueOrStack[i] == 0) {
                queue.addFirst(orgValues[i]); 
            }
        }
        for (int i = 0; i < M; i++) {
            queue.add(changeValues[i]);
            sb.append((queue.pollFirst() + " "));
        }

        System.out.println(sb);
    }
}