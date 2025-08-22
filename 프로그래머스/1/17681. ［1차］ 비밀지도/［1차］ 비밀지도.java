import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int[] binary1 = getBinaryArr(arr1[i], n);
            int[] binary2 = getBinaryArr(arr2[i], n);
            for (int j = 0; j < n; j++) {
                if (binary1[j] == 1 || binary2[j] == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    public int[] getBinaryArr(int num, int n) {
        int[] binaryArr = new int[n];
        for(int i=n-1; i >= 0; i--) {
            binaryArr[i] = num % 2;
            num = num/2;
        }       
        return binaryArr;
    }
}