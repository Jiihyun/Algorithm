import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        String[][] arr = new String[total][2];
        
        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, (s1, s2) ->
            Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}
