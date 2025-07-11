import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int row;
    static int col;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        recul(0, 0, size);
    }

    private static void recul(int cCol, int cRow, int size) {
        if (size == 1) {
            System.out.println(count);
            return;
        }
        int newSize = size / 2;
        if (row < cRow + newSize && col < cCol + newSize) {
            recul(cCol, cRow, newSize);
        }
        if (row < cRow + newSize && col >= cCol + newSize) {
            count += (size * size) / 4;
            recul(cCol + newSize, cRow, newSize);
        }
        if (row >= cRow + newSize && col < cCol + newSize) {
            count += ((size * size) / 4) * 2;
            recul(cCol, cRow + newSize, newSize);
        }
        if (row >= cRow + newSize && col >= cCol + newSize) {
            count += ((size * size) / 4) * 3;
            recul(cCol + newSize, cRow + newSize, newSize);
        }
    }
}

