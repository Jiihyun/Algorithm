class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;        // arr1 행 개수
        int m = arr1[0].length;     // arr1 열 개수 (= arr2 행 개수)
        int k = arr2[0].length;     // arr2 열 개수

        int[][] answer = new int[n][k]; 

        for (int i = 0; i < n; i++) {          // arr1의 행
            for (int j = 0; j < k; j++) {      // arr2의 열
                for (int x = 0; x < m; x++) {  // arr1의 열 = arr2의 행
                    answer[i][j] += arr1[i][x] * arr2[x][j];
                }
            }
        }
        return answer;
    }
}
