import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                count++;
                erase(Integer.parseInt(st.nextToken()));
                int bingo = checkBingo();
                if (bingo >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    private static void erase(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    board[i][j] = 0;
                    break;
                }
            }
        }
    }

    private static int checkBingo() {
        int bingo = 0;
        for (int i = 0; i < 5; i++) {
            int row = 0;
            int col = 0;
            for (int j = 0; j < 5; j++) {
                row += board[i][j];
                col += board[j][i];
            }
            if (row == 0) {
                bingo++;
            }
            if (col == 0) {
                bingo++;
            }
        }
        int rl = 0;
        int lr = 0;
        for (int i = 0; i < 5; i++) {
            lr += board[i][i];
            rl += board[i][4 - i];
        }
        if (rl == 0) {
            bingo++;
        }
        if (lr == 0) {
            bingo++;
        }
        return bingo;
    }
}
