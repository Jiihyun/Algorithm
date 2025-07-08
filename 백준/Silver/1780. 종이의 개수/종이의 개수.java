import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recul(0, 0, n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void recul(int row, int col, int n) {
        if (isSameNumber(row, col, n)) {
            int num = board[row][col];
            if (num == -1) {
                minusOne++;
            } else if (num == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        int newSize = n / 3;
        recul(row, col, newSize); // 왼쪽 위
        recul(row + newSize, col, newSize); // 왼쪽 중간
        recul(row + 2 * newSize, col, newSize); // 왼쪽 아래

        recul(row, col + newSize, newSize); // 가운데 위
        recul(row + newSize, col + newSize, newSize); // 가운데 중간
        recul(row + 2 * newSize, col + newSize, newSize); // 가운데 아래

        recul(row, col + 2 * newSize, newSize); // 오른쪽 위
        recul(row + newSize, col + 2 * newSize, newSize); // 오른쪽 중간
        recul(row + 2 * newSize, col + 2 * newSize, newSize); // 오른쪽 아래
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

