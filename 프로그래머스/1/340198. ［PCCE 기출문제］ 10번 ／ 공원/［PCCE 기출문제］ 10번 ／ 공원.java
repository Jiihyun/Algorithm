import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int size = mats[idx];

            for (int i = 0; i + size <= park.length; i++) {
                for (int j = 0; j + size <= park[0].length; j++) {
                    if (canPlace(i, j, size, park)) {
                        return size;
                    }
                }
            }
        }
        return -1;
    }

    private boolean canPlace(int row, int col, int size, String[][] park) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
