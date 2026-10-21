import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        // 변경 1. 일의 자리만 처리하던 if문을 while문으로 변경
        // 모든 자릿수에 대해 올림/내림을 판단하도록 개선
        while (storey > 0) {

            // 기존 lastNumber와 동일
            // 매 반복마다 현재 일의 자리를 가져옴
            int lastNumber = storey % 10;

            // 변경 2. 5보다 큰 경우뿐 아니라
            // 5이면서 다음 자릿수가 5 이상인 경우도 올림
            if (lastNumber > 5 ||
                (lastNumber == 5 && (storey / 10) % 10 >= 5)) {

                answer += (10 - lastNumber);

                // 변경 3. 올림한 값을 다음 자릿수에 반영
                // 기존 storey += (10 - lastNumber) 대신 사용
                storey = storey / 10 + 1;

            } else {
                answer += lastNumber;

                // 변경 4. 처리한 일의 자리를 제거
                // 기존 storey -= lastNumber 대신 사용
                storey /= 10;
            }
        }

        // 변경 5. len, Math.pow()를 이용한 반복문 제거
        // 일의 자리부터 처리하므로 자릿수 계산이 필요 없음

        return answer;
    }
}