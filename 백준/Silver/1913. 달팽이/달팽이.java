import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int spot = Integer.parseInt(br.readLine());

        int[][] board = new int[size][size];
        int value = 1;
        int movement = 1;
        int start = size / 2;
        int x = start, y = start;

        while (true) {
            for (int i = 0; i < movement; i++) {
                board[y--][x] = value++;
            }
            if (value == size * size + 1) {
                break;
            }
            for (int i = 0; i < movement; i++) {
                board[y][x++] = value++;
            }
            movement++;
            for (int i = 0; i < movement; i++) {
                board[y++][x] = value++;
            }
            for (int i = 0; i < movement; i++) {
                board[y][x--] = value++;
            }
            movement++;
        }
        StringBuilder sb = new StringBuilder();
        int spotA = 0, spotB = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(board[i][j]).append(" ");
                if (board[i][j] == spot) {
                    spotA = i + 1;
                    spotB = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(spotA).append(" ").append(spotB);
        System.out.println(sb);
    }
}

