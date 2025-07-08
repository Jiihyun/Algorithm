import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        recul(0, 0, n);
        System.out.println(sb);
    }

    private static void recul(int row, int col, int n) {
        if (isSameNumber(row, col, n)) {
            sb.append(board[row][col]);
            return;
        }
        sb.append("(");
        int newSize = n / 2;
        recul(row, col, newSize);
        recul(row, col + newSize, newSize);
        recul(row + newSize, col, newSize);
        recul(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    private static boolean isSameNumber(int row, int col, int n) {
        int num = board[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (board[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}

