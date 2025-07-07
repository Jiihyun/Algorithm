import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        board = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recul(0, 0, size);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void recul(int row, int col, int currentSize) {
        if (checkColor(row, col, currentSize)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int newSize = currentSize / 2;
        recul(row + newSize, col + newSize, newSize); // 1사분면
        recul(row, col + newSize, newSize); // 2사분면
        recul(row, col, newSize); // 3사분면
        recul(row + newSize, col, newSize); // 4사분면
    }

    private static boolean checkColor(int row, int col, int currentSize) {
        int color = board[row][col];

        for (int i = row; i < row + currentSize; i++) {
            for (int j = col; j < col + currentSize; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

