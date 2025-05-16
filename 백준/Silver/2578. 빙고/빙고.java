import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int[][] board = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                answer++;
                erase(Integer.parseInt(st.nextToken()));
                check();
                if (count >= 3) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }

    private static void erase(final int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    board[i][j] = -1;
                    break;
                }
            }
        }
    }

    private static void check() {
        count = 0;

        for (int i = 0; i < 5; i++) {
            int row = 0;
            int col = 0;
            for (int j = 0; j < 5; j++) {
                row += board[i][j];
                col += board[j][i];
            }

            if (row == -5) {
                count++;
            }
            if (col == -5) {
                count++;
            }
        }
        int lr = 0;
        int rl = 0;

        for (int i = 0; i < 5; i++) {
            lr += board[i][i];
            rl += board[i][4 - i];
        }
        if (lr == -5) {
            count++;
        }
        if (rl == -5) {
            count++;
        }
    }
}

