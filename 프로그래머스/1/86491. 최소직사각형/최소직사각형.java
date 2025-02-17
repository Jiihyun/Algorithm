class Solution {
    public int solution(int[][] sizes) {
        int[][] arr = new int[sizes.length][2];
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                 arr[i][0] = sizes[i][0];
                 arr[i][1] = sizes[i][1];
            } else {
                 arr[i][0] = sizes[i][1];
                 arr[i][1] = sizes[i][0];
            }
        }
        int maxW = 0;
        int maxH = 0;
        for (int i = 0; i < sizes.length; i++) {
             maxW = Math.max(maxW, arr[i][0]);
             maxH = Math.max(maxH, arr[i][1]);
        }
        return maxW * maxH;
    }
}