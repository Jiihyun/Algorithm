import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        char[][] room = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < n; i++) {
            int dotCount = 0;
            for (int j = 0; j < n; j++) {
                if (room[i][j] == '.') {
                    dotCount++;
                } else {
                    if (dotCount >= 2) {
                        horizontal++;
                    }
                    dotCount = 0;
                }
            }
            if (dotCount >= 2) {
                horizontal++;
            }
        }
        for (int j = 0; j < n; j++) {
            int dotCount = 0;
            for (int i = 0; i < n; i++) {
                if (room[i][j] == '.') {
                    dotCount++;
                } else {
                    if (dotCount >= 2) {
                        vertical++;
                    }
                    dotCount = 0;
                }
            }
            if (dotCount >= 2) {
                vertical++;
            }
        }

        System.out.println(horizontal + " " + vertical);
    }
}
