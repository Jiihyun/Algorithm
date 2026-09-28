import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[numbers.length];
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            int now = numbers[i];
            while (!st.isEmpty() && st.peek() <= now) {
                st.pop();
            }
            if (!st.isEmpty() && st.peek() > now ) {
                answer[i] = st.peek();
            } else {
                answer[i] = -1;
            }
            st.push(numbers[i]);
        }
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        
        // for (int i = 0; i < numbers.length; i++) {
        //     for (int j = i + 1; j < numbers.length; j++) {
        //         if (numbers[j] > numbers[i]) {
        //             answer[i] = numbers[j];
        //             break;
        //         }
        //     }
        //     if (answer[i] == 0) {
        //         answer[i] = -1;
        //     }
        // }
        return answer;
    }
}

///뒷 큰수: 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수