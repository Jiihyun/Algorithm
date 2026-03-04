import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        int[] arrA = new int[sizeA];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        int[] arrB = new int[sizeB];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrB);

        List<Integer> result = new ArrayList<>();
        int pointerA = 0;
        int pointerB = 0;

        while (pointerA < sizeA && pointerB < sizeB) {
            if (arrA[pointerA] == arrB[pointerB]) {
                pointerA++;
                pointerB++;
            } else if (arrA[pointerA] < arrB[pointerB]) {
                result.add(arrA[pointerA]);
                pointerA++;
            } else {
                pointerB++;
            }
        }
        while (pointerA < sizeA) {
            result.add(arrA[pointerA++]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
